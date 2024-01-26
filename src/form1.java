import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class form1 {
    private JButton ingresarButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    public JPanel login;
    private JLabel validacion;
    private JToggleButton cambiar_de_modo;
    private JLabel titulo_login;
    private JLabel texto_usuario;
    private JLabel texto_password;
    private JFormattedTextField formattedTextField1;
    private JCheckBox mostrar_password;
    private JLabel contra;


    public form1() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String contra1, usuario;
            usuario = textField1.getText();
            contra1 = String.valueOf(passwordField1.getPassword());
                try {

                    if (usuario.equals("admin")&&contra1.equals("123")) {
                        Main.frame1.dispose();

                        Formulario formulario1=new Formulario();
                        formulario1.setBounds(10,20,400,400);
                        formulario1.setVisible(true);
                        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }else {
                        //JOptionPane.showMessageDialog(this,"Ingrese credenciales correctas");
                       // validacion.setText("Ingrese credenciales correctas");
                        JOptionPane.showMessageDialog(null,"Ingrese credenciales correctas");
                    }

                }catch (Exception ex) {
                    System.out.println(ex);
                }


            }
        });
        ;
        cambiar_de_modo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cambiar_de_modo.isSelected()){
                    login.setBackground(Color.DARK_GRAY);
                    titulo_login.setForeground(Color.WHITE);
                    texto_usuario.setForeground(Color.WHITE);
                    texto_password.setForeground(Color.WHITE);
                    cambiar_de_modo.setText("OFF");
                }
                else{
                    login.setBackground(Color.WHITE);
                    titulo_login.setForeground(Color.DARK_GRAY);
                    texto_usuario.setForeground(Color.DARK_GRAY);
                    texto_password.setForeground(Color.DARK_GRAY);
                    cambiar_de_modo.setText("ON");
                }
            }
        });
        mostrar_password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (mostrar_password.isSelected()){
                    contra.setText(String.valueOf(passwordField1.getPassword()));
                }
            }
        });
    }
}
