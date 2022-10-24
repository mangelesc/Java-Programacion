package macgc_actividad08;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login_macgc extends JFrame {

    private JTextField textField_macgc;
    private JPasswordField passwordField_macgc;
    private JLabel lblDatosIncorrectos_macgc;

    public Login_macgc() {
        //Definimos la interfaz gráfica
        setResizable(false);
        setTitle("Login MACGC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblLogin_macgc = new JLabel("LOGIN");
        lblLogin_macgc.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblLogin_macgc.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin_macgc.setBounds(200, 34, 70, 20);
        getContentPane().add(lblLogin_macgc);

        JLabel lblUser_macgc = new JLabel("Usuario: ");
        lblUser_macgc.setBounds(120, 90, 90, 20);
        getContentPane().add(lblUser_macgc);

        textField_macgc = new JTextField();
        textField_macgc.setBounds(220, 90, 140, 20);
        getContentPane().add(textField_macgc);
        textField_macgc.setColumns(10);

        JLabel lblPassword_macgc = new JLabel("Contraseña: ");
        lblPassword_macgc.setBounds(120, 125, 89, 14);
        getContentPane().add(lblPassword_macgc);

        passwordField_macgc = new JPasswordField();
        passwordField_macgc.setBounds(220, 125, 139, 20);
        getContentPane().add(passwordField_macgc);

        JButton btnAceptar_macgc = new JButton("Aceptar");
        btnAceptar_macgc.addActionListener(new BtnAceptarActionListener());
        btnAceptar_macgc.setBounds(200, 193, 89, 25);
        getContentPane().add(btnAceptar_macgc);

        lblDatosIncorrectos_macgc = new JLabel("DATOS INCORRECTOS");
        lblDatosIncorrectos_macgc.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDatosIncorrectos_macgc.setForeground(Color.red);
        lblDatosIncorrectos_macgc.setHorizontalAlignment(SwingConstants.CENTER);
        lblDatosIncorrectos_macgc.setBounds(120, 158, 250, 14);
        lblDatosIncorrectos_macgc.setVisible(false);
        getContentPane().add(lblDatosIncorrectos_macgc);

        setSize(500, 300);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    private class BtnAceptarActionListener implements ActionListener {

        //Creamos un metodo para controlar los posibles errores
        public void actionPerformed(ActionEvent arg0) {
            String nombre_macgc = textField_macgc.getText();
            String password_macgc = new String(passwordField_macgc.getPassword());
            boolean loginCorrecto_macgc = false;
            if (nombre_macgc.length() == 0 || password_macgc.length() == 0) {
                lblDatosIncorrectos_macgc.setText("Ups, Ángeles debes introducir los datos");
                lblDatosIncorrectos_macgc.setVisible(true);
            } else {
                try {
                    loginCorrecto_macgc = comprobarLogin(nombre_macgc, password_macgc);
                    if (loginCorrecto_macgc) {
                        lblDatosIncorrectos_macgc.setVisible(false);
                        dispose();
                        new Bienvenida_macgc(nombre_macgc);
                    } else {
                        lblDatosIncorrectos_macgc.setText("Ups, Ángeles las credendiales son incorrectas");
                        lblDatosIncorrectos_macgc.setVisible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        }

        //Creamos el método para comprobar el login
        private boolean comprobarLogin(String nombre, String password) throws Exception {
            String separador = File.separator;
            String rutaProyecto = System.getProperty("user.dir");
            File f = new File(rutaProyecto + separador + "datos_login.txt");
            System.out.println(f.getAbsolutePath());
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals(nombre + " " + password)) {
                    fr.close();
                    return true;
                }
            }
            fr.close();
            return false;
        }
    }

}
