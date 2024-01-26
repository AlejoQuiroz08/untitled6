import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class form1 {
    private JButton ingresarButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    public JPanel login;
    private JLabel validacion;


    public form1() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String contra, usuario;
            usuario = textField1.getText();
            contra = String.valueOf(passwordField1.getPassword());
                try {

                    if (usuario.equals("admin")&&contra.equals("123")) {
                        Main.frame1.dispose();

//                        JFrame frame2 = new JFrame("Bienvenido");
//                        frame2.setContentPane(new form2().hola);
//                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                        frame2.setSize(400, 400);
//                        frame2.setVisible(true);

                        Formulario formulario1=new Formulario();
                        formulario1.setBounds(10,20,400,400);
                        formulario1.setVisible(true);
                        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }else {
                        validacion.setText("Ingrese credenciales correctas");
                    }

                }catch (Exception ex) {
                    System.out.println(ex);
                }


            }
        });
    }
}
