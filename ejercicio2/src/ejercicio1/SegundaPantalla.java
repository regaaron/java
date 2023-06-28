package ejercicio1;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;

public class SegundaPantalla extends JPanel implements ActionListener {

    Font fuente = new Font("URW Gothic", Font.PLAIN, 18);
    String url;
    String usuario;
    String contraseña;
    String Sbase;
    BufferedImage fondo;
    JLabel labelSelectedBase;
    JComboBox<String> comboBox;
    JButton selectButton;
    ResultSet resultSet;
    JFrame jf;
    JTextArea textArea;
    JScrollPane scrollPane;
    String carpeta;

    public SegundaPantalla(JFrame jf, String url, String usuario, String contraseña, String Sbase, ResultSet resultSet, String carpeta) {
        this.jf = jf;
        this.url = url;
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.Sbase = Sbase;
        this.resultSet = resultSet;
        this.carpeta = carpeta;
        setPreferredSize(new Dimension(800, 600));
        conectar();
        cargarImagenes();

        setLayout(null);

        labelSelectedBase = new JLabel("Seleccione la tabla con la que quiera trabajar:");
        labelSelectedBase.setBounds(50, 20, 500, 30);
        labelSelectedBase.setFont(fuente);
        add(labelSelectedBase);

        comboBox = new JComboBox<String>();
        try {
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                comboBox.addItem(tableName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SegundaPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboBox.setBounds(50, 60, 500, 40);
        add(comboBox);

        selectButton = new JButton("Seleccionar");
        selectButton.setBounds(250, 120, 100, 40);
        selectButton.addActionListener(this);
        add(selectButton);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 180, 700, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }

    public void conectar() {
        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            if (connection != null) {
                Statement statement = connection.createStatement();
                String useDatabaseQuery = "USE " + Sbase;
                statement.executeUpdate(useDatabaseQuery);
                statement.close();
                connection.close();
            } else {
                System.out.println("Error al conectar con la base de datos");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos: " + ex.getMessage());
        }
        repaint();
    }
    
    public void crearCarpeta(String rutaCarpeta) {
    File carpeta = new File(rutaCarpeta);
    if (!carpeta.exists()) {
        if (carpeta.mkdirs()) {
            System.out.println("Carpeta creada correctamente en: " + rutaCarpeta);
        } else {
            System.out.println("Error al crear la carpeta: " + rutaCarpeta);
        }
    } else {
        System.out.println("La carpeta ya existe en: " + rutaCarpeta);
    }
}


    public void seleccionarTabla(String selectedTable) {
        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = connection.createStatement();
            // Seleccionar la base de datos
            String useDatabaseQuery = "USE " + Sbase;
            statement.executeUpdate(useDatabaseQuery);

            String query = "DESCRIBE " + selectedTable;
            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder description = new StringBuilder();
            while (resultSet.next()) {
                String fieldName = resultSet.getString("Field");
                String fieldType = resultSet.getString("Type");
                String fieldNull = resultSet.getString("Null");
                String fieldKey = resultSet.getString("Key");
                String fieldExtra = resultSet.getString("Extra");

                String fieldDescription = fieldName + "\t" + fieldType
                        + "\t" + fieldNull + "\t " + fieldKey + "\t " + fieldExtra;
                description.append(fieldDescription).append("\n");
            }
            textArea.setFont(fuente);
            textArea.setText(description.toString());

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar la tabla: " + ex.getMessage());
        }
    }

    public void guardarEstructuraTabla(String selectedTable, String estructura, String rutaCarpeta) {
        String nombreArchivo = Sbase+"_"+selectedTable + "_estructura.txt";
        String rutaArchivo = rutaCarpeta + "/" + nombreArchivo;

        try {
            FileWriter escritor = new FileWriter(rutaArchivo);
            escritor.write(estructura);
            escritor.close();
            System.out.println("Estructura de la tabla guardada correctamente en: " + rutaArchivo);
        } catch (IOException ex) {
            System.out.println("Error al guardar la estructura de la tabla: " + rutaArchivo);
            ex.printStackTrace();
        }
    }

    public void guardarRegistrosTabla(String selectedTable, String rutaCarpeta) {
        String nombreArchivo = Sbase +"_"+ selectedTable+ "_info.txt";
        String rutaArchivo = rutaCarpeta + "/" + nombreArchivo;

        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = connection.createStatement();

            // Seleccionar la base de datos
            String useDatabaseQuery = "USE " + Sbase;
            statement.executeUpdate(useDatabaseQuery);

            String query = "SELECT * FROM " + selectedTable;
            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder registros = new StringBuilder();
            while (resultSet.next()) {
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    registros.append(resultSet.getString(i)).append("\t");
                }
                registros.append("\n");
            }

            FileWriter escritor = new FileWriter(rutaArchivo);
            escritor.write(registros.toString());
            escritor.close();
            System.out.println("Registros de la tabla guardados correctamente en: " + rutaArchivo);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            System.out.println("Error al guardar los registros de la tabla: " + rutaArchivo);
            ex.printStackTrace();
        }
    }

    public void cargarImagenes() {
        try {
            fondo = ImageIO.read(getClass().getResource("/ejercicio1/fondo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            String selectedTable = (String) comboBox.getSelectedItem();
            System.out.println(selectedTable);
            seleccionarTabla(selectedTable);
            
            
            String carpeta = System.getProperty("user.home") + "/Desktop/"+this.carpeta;

            crearCarpeta(carpeta);
            guardarEstructuraTabla(selectedTable, textArea.getText(), carpeta);
            guardarRegistrosTabla(selectedTable, carpeta);
        }
    }

   
}
