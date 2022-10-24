package macgc_actividad08;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Bienvenida_macgc extends JFrame {

    private JTextField fieldNombre_macgc;
    private JComboBox comboBoxEdad_macgc;
    private JRadioButton rdbtnHombre_macgc;
    private JRadioButton rdbtnMujer_macgc;
    private ButtonGroup bGSexo_macgc;
    private JCheckBox chckbxProgramar_macgc;
    private JCheckBox chckbxDeportes_macgc;
    private JCheckBox chckbxCine_macgc;
    String separador = File.separator;
    String rutaProyecto = System.getProperty("user.dir");
    File archivo = new File(rutaProyecto + separador + "datos_empleados.txt");

    public Bienvenida_macgc(String nombre) {
        //Definimos la interfaz gráfica
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menú empleados MACGC");
        getContentPane().setLayout(null);

        JLabel lblWelcome_macgc = new JLabel("Welcome " + nombre + " !");
        lblWelcome_macgc.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome_macgc.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblWelcome_macgc.setBounds(100, 15, 289, 20);
        getContentPane().add(lblWelcome_macgc);

        JLabel lblNombre_macgc = new JLabel("Nombre: ");
        lblNombre_macgc.setBounds(90, 50, 59, 14);
        getContentPane().add(lblNombre_macgc);

        fieldNombre_macgc = new JTextField();
        fieldNombre_macgc.setBounds(160, 50, 180, 20);
        getContentPane().add(fieldNombre_macgc);
        fieldNombre_macgc.setColumns(10);

        JLabel lblEdad_macgc = new JLabel("Edad: ");
        lblEdad_macgc.setBounds(90, 90, 46, 14);
        getContentPane().add(lblEdad_macgc);

        comboBoxEdad_macgc = new JComboBox();
        comboBoxEdad_macgc.setModel(new DefaultComboBoxModel(new String[]{"10-15", "16-20", "21-25", "26-30", "31-35", "36-40", "41-45", "46-50", "50+"}));
        comboBoxEdad_macgc.setBounds(160, 90, 91, 20);
        getContentPane().add(comboBoxEdad_macgc);

        JLabel lblSexo_macgc = new JLabel("Sexo: ");
        lblSexo_macgc.setBounds(90, 130, 46, 14);
        getContentPane().add(lblSexo_macgc);

        rdbtnHombre_macgc = new JRadioButton("Hombre");
        rdbtnHombre_macgc.setBounds(160, 130, 75, 23);
        getContentPane().add(rdbtnHombre_macgc);

        rdbtnMujer_macgc = new JRadioButton("Mujer");
        rdbtnMujer_macgc.setBounds(245, 130, 64, 23);
        getContentPane().add(rdbtnMujer_macgc);

        bGSexo_macgc = new ButtonGroup();
        bGSexo_macgc.add(rdbtnHombre_macgc);
        bGSexo_macgc.add(rdbtnMujer_macgc);

        JLabel lblAfiniones_macgc = new JLabel("Aficiones");
        lblAfiniones_macgc.setBounds(90, 170, 59, 14);
        getContentPane().add(lblAfiniones_macgc);

        chckbxDeportes_macgc = new JCheckBox("Deportes");
        chckbxDeportes_macgc.setBounds(160, 170, 88, 23);
        getContentPane().add(chckbxDeportes_macgc);

        chckbxProgramar_macgc = new JCheckBox("Programar");
        chckbxProgramar_macgc.setBounds(250, 170, 88, 23);
        getContentPane().add(chckbxProgramar_macgc);
        
        chckbxCine_macgc = new JCheckBox("Cine");
        chckbxCine_macgc.setBounds(340, 170, 88, 23);
        getContentPane().add(chckbxCine_macgc);

        JButton btnAceptar_macgc = new JButton("Nuevo Empleado");
        btnAceptar_macgc.addActionListener(new BtnAceptarActionListener());
        btnAceptar_macgc.setBounds(90, 220, 150, 30);
        getContentPane().add(btnAceptar_macgc);

        JButton btnMostrar_macgc = new JButton("Mostar empleados");
        btnMostrar_macgc.addActionListener(new BtnMostrarActionListener());
        btnMostrar_macgc.setBounds(255, 220, 150, 30);
        getContentPane().add(btnMostrar_macgc);

        setSize(500, 320);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    //Creamos una clase que implementa ActionListener, para guardar los datos del nuevo empleado
    private class BtnAceptarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JDialog dialog_macgc = new JDialog();
            JLabel msg_macgc = null;
            ArrayList<Empleado_macgc> empleadosArray_macgc = new ArrayList<>();
            if (fieldNombre_macgc.getText().isEmpty() || comboBoxEdad_macgc.getSelectedItem().toString().length() == 0 || bGSexo_macgc.getSelection() == null
                    || (!chckbxProgramar_macgc.isSelected() && !chckbxCine_macgc.isSelected() && !chckbxDeportes_macgc.isSelected())) {
                msg_macgc = new JLabel("Ups, Ángeles debes introducir todos los datos");
                msg_macgc.setBounds(88, 148, 46, 14);
            } else {
                ObjectOutputStream oos_macgc;
                ObjectInputStream ois_macgc;
                try {
                    if (archivo.exists()) {
                        try {
                            ois_macgc = new ObjectInputStream(new FileInputStream(archivo));
                            empleadosArray_macgc = (ArrayList<Empleado_macgc>) ois_macgc.readObject();
                            ois_macgc.close();
                        } catch (Exception e) {
                            System.out.println("Ups, Angeles no se ha podido obtener la información sobre los empleados");
                        }
                    }
                    else{
                        archivo.createNewFile();
                    }

                    ArrayList<String> aficiones_macgc = new ArrayList<>();
                    if (chckbxCine_macgc.isSelected()) {
                        aficiones_macgc.add(chckbxCine_macgc.getText());
                    }
                    if (chckbxDeportes_macgc.isSelected()) {
                        aficiones_macgc.add(chckbxDeportes_macgc.getText());
                    }
                    if (chckbxProgramar_macgc.isSelected()) {
                        aficiones_macgc.add(chckbxProgramar_macgc.getText());
                    }
                    String sexo_macgc;
                    if (rdbtnHombre_macgc.isSelected()) {
                        sexo_macgc = rdbtnHombre_macgc.getText();
                    } else {
                        sexo_macgc = rdbtnMujer_macgc.getText();
                    }

                    //Añadimos los datos del nuevo empleado al arrayList
                    Empleado_macgc NewEmpleado_macgc = new Empleado_macgc(fieldNombre_macgc.getText(),
                            comboBoxEdad_macgc.getSelectedItem().toString(), sexo_macgc, aficiones_macgc);
                    empleadosArray_macgc.add(NewEmpleado_macgc);
                    System.out.println("Empleado: " + NewEmpleado_macgc);

                    oos_macgc = new ObjectOutputStream(new FileOutputStream(archivo));
                    oos_macgc.writeObject(empleadosArray_macgc);
                    oos_macgc.close();
                    msg_macgc = new JLabel("Ángeles, usuario guardado correctamente.\n Gracias por usar la aplicación.");
                    msg_macgc.setBounds(88, 148, 46, 14);
                    //msg = new JLabel("Añadido correctamente");

                } catch (Exception e1) {
                    msg_macgc = new JLabel("Ups, Ángeles ha habido un error al añadir al nuevo empleado");
                    msg_macgc.setBounds(88, 148, 46, 14);
                    dialog_macgc.getContentPane().add(msg_macgc);
                    dialog_macgc.setSize(300, 130);
                    dialog_macgc.setVisible(true);
                    e1.printStackTrace(System.out);
                }
            }
            
            dialog_macgc.getContentPane().add(msg_macgc);
            dialog_macgc.setSize(300, 130);
            dialog_macgc.setVisible(true);
        }
    }

    //Creamos una clase que implementa ACtionListener para mostrar los datos guardados de los trabajadores. 
    private class BtnMostrarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel msg_macgc;
            JDialog dialog_macgc = new JDialog();
            ArrayList<Empleado_macgc> mostrarEmpleados_macgc = new ArrayList<>();
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(new FileInputStream(archivo));
                mostrarEmpleados_macgc = (ArrayList<Empleado_macgc>) ois.readObject();
                ois.close();

                System.out.println(mostrarEmpleados_macgc.size() + " empleados añadidos.");
                String infoEmpleados_macgc = "";
                int index_macgc = 0;
                for (Empleado_macgc empRead : mostrarEmpleados_macgc) {
                    infoEmpleados_macgc += index_macgc++ + ". " + empRead + "<br>";
                }
                msg_macgc = new JLabel("<html><body><u>LISTA DE EMPLEADOS:</u> <br> " + infoEmpleados_macgc + "</body></html>");
            } catch (Exception e2) {
                msg_macgc = new JLabel("Ups, no se ha podido acceder a la información sobre los empleados");
                e2.printStackTrace(System.out);
            }

            msg_macgc.setBounds(88, 148, 46, 14);
            dialog_macgc.getContentPane().add(msg_macgc);
            dialog_macgc.pack();
            dialog_macgc.setVisible(true);
        }
    }
}
