package ejercicio3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ejercicio3 extends JComponent implements ActionListener {

    BufferedImage fondo, login;
    JTextField txtip, txtusuario, txtbase, txtCarpeta;
    JPasswordField password;
    JButton conectar;
    JFrame jf;
    Font fuente = new Font("URW Gothic", Font.PLAIN, 18);

    public static void main(String[] args) {
        JFrame jf = new JFrame("Ejercicio1");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Ejercicio3 demo1 = new Ejercicio3(jf);
        jf.getContentPane().add(demo1);
        jf.setResizable(false);
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        demo1.repaint();
    }

    Ejercicio3(JFrame jf) {
        setPreferredSize(new Dimension(600, 600));
        this.jf = jf;
        cargarImagenes();

        JLabel labelip = new JLabel("IP servidor");
        labelip.setBounds(600 / 2 - 60, 160, 120, 40);
        labelip.setFont(fuente);
        txtip = new JTextField();
        txtip.setBounds((600 / 2) - 70, 190, 120, 30);
        txtip.setFont(fuente);

        JLabel labelUsuario = new JLabel("Usuario");
        labelUsuario.setBounds(600 / 2 - 60, 230, 120, 40);
        labelUsuario.setFont(fuente);
        txtusuario = new JTextField();
        txtusuario.setBounds((600 / 2) - 70, 260, 120, 30);
        txtusuario.setFont(fuente);

        JLabel labelPass = new JLabel("Contraseña");
        labelPass.setBounds(600 / 2 - 70, 300, 120, 40);
        labelPass.setFont(fuente);
        password = new JPasswordField();
        password.setBounds(600 / 2 - 70, 330, 120, 30);
        password.setFont(fuente);

        JLabel labelBase = new JLabel("Base de datos");
        labelBase.setBounds(600 / 2 - 70, 370, 120, 40);
        labelBase.setFont(fuente);
        txtbase = new JTextField();
        txtbase.setBounds(600 / 2 - 70, 400, 120, 30);
        txtbase.setFont(fuente);

        JLabel labelCarpeta = new JLabel("Carpeta");
        labelCarpeta.setBounds(600 / 2 - 70, 440, 120, 40);
        labelCarpeta.setFont(fuente);
        txtCarpeta = new JTextField();
        txtCarpeta.setBounds(600 / 2 - 70, 480, 120, 30);
        txtCarpeta.setFont(fuente);

        conectar = new JButton("Conectar");
        conectar.setBounds(600 / 2 + 70, 260, 120, 40);
        conectar.setFont(fuente);

        conectar.addActionListener(this);
        add(labelip);
        add(txtip);
        add(labelUsuario);
        add(txtusuario);
        add(labelPass);
        add(password);
        add(labelBase);
        add(txtbase);
        add(conectar);
        add(labelCarpeta);
        add(txtCarpeta);

    }

    public void cargarImagenes() {
        try {
            fondo = ImageIO.read(getClass().getResourceAsStream("/ejercicio3/fondo.jpg"));
            login = ImageIO.read(getClass().getResourceAsStream("/ejercicio3/login.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Dibujar el fondo
        if (fondo != null) {
            g2.drawImage(fondo, 0, 0, 600, 600, null);
        }

        // Dibujar la imagen de login
        if (login != null) {
            g2.drawImage(login, 600 / 2 - 45, 60, 90, 90, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conectar) {
            String Sip = txtip.getText();
            String Susuario = txtusuario.getText();
            char[] Spass = password.getPassword();
            String Sbase = txtbase.getText();
            String carpeta = txtCarpeta.getText();

            try {
                // Establecer la conexión con MySQL
                String url = "jdbc:mysql://" + Sip + "/";
                String usuario = Susuario;
                String contraseña = new String(Spass);
                Connection connection = DriverManager.getConnection(url, usuario, contraseña);
                // Crear la base de datos
                createDatabase(connection, Sbase);
                try {
                    // Crear la tabla y almacenar los registros
                    createTableAndInsertData(connection, Sbase, carpeta);
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Cerrar la conexión
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error al conectar con la base de datos");
            }
        }
    }

    private void createDatabase(Connection connection, String databaseName) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE " + databaseName);
        statement.close();
    }

    private void createTableAndInsertData(Connection connection, String databaseName, String carpeta) throws SQLException, IOException {
        Statement statement = connection.createStatement();

        // Crear la tabla
        String createTableQuery = "CREATE TABLE " + databaseName + ".restaurant_platillos ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "nombre VARCHAR(60) NOT NULL,"
                + "precio FLOAT NOT NULL,"
                + "disponible TINYINT(1) NOT NULL,"
                + "categoriaId INT NOT NULL,"
                + "PRIMARY KEY (id)"
                + ")";
        statement.executeUpdate(createTableQuery);

        // Obtener la ubicación de la carpeta en el escritorio
   String desktopPath = System.getProperty("user.home") + "/Desktop/" + carpeta;


        // Leer el archivo de estructura
        String estructuraFilePath = desktopPath + "/restaurant_platillos_estructura.txt";
        Path estructuraPath = Path.of(estructuraFilePath);
        String estructuraContent = Files.readString(estructuraPath);

        // Insertar los registros desde el archivo de info
        String infoFilePath = desktopPath + "/restaurant_platillos_info.txt";
        Path infoPath = Path.of(infoFilePath);
        String infoContent = Files.readString(infoPath);
        String[] registros = infoContent.split("\n");
        for (String registro : registros) {
            String[] campos = registro.split("\t");
            String insertQuery = "INSERT INTO " + databaseName + ".restaurant_platillos "
                    + "(id, nombre, precio, disponible, categoriaId) "
                    + "VALUES (" + campos[0] + ", '" + campos[1] + "', " + campos[2] + ", " + campos[3] + ", " + campos[4] + ")";
            statement.executeUpdate(insertQuery);
        }

        statement.close();
    }
}
