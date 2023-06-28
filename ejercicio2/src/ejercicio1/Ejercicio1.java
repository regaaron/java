package ejercicio1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ejercicio1 extends JComponent implements ActionListener {

    BufferedImage fondo, login;
    JTextField txtip, txtusuario, txtbase,txtCarpeta;
    JPasswordField password;
    JButton conectar;
    JFrame jf;
    Font fuente = new Font("URW Gothic", Font.PLAIN, 18);

    public static void main(String[] args) {
        JFrame jf = new JFrame("Ejercicio1");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Ejercicio1 demo1 = new Ejercicio1(jf);
        jf.getContentPane().add(demo1);
        jf.setResizable(false);
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        demo1.repaint();
    }
    
    Ejercicio1(JFrame jf) {
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
            fondo = ImageIO.read(getClass().getResourceAsStream("/ejercicio1/fondo.jpg"));
            login = ImageIO.read(getClass().getResourceAsStream("/ejercicio1/login.png"));
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
            String carpeta=txtCarpeta.getText();
            try {
                // Establecer la conexión con MySQL
                String url = "jdbc:mysql://" + Sip + "/";
                String usuario = Susuario;
                String contraseña = new String(Spass);
                Connection connection = DriverManager.getConnection(url, usuario, contraseña);

                // Obtener las tablas de la base de datos
                DatabaseMetaData metadata = connection.getMetaData();
                ResultSet resultSet = metadata.getTables(Sbase, null, null, null);

                // Crear la segunda ventana para seleccionar la tabla
                  JFrame jf2 = new JFrame("Ejercicio1");
                  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                SegundaPantalla demo2 = new SegundaPantalla(jf2,url, usuario, contraseña, Sbase, resultSet,carpeta);
                  jf2.getContentPane().add(demo2);
              jf2.setResizable(false);
              jf2.pack();
              jf2.setVisible(true);
              jf2.setLocationRelativeTo(null);
              demo2.repaint();
            
       
                // Cerrar la conexión
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error al conectar con la base de datos");
            }
        }
    }
}
