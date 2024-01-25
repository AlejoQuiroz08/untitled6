import javax.swing.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
    public class Main {
        static JFrame frame1 = new JFrame("Login");
        public static void main(String[] args) {
            frame1.setContentPane(new form1().login);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setSize(400, 400);
            frame1.setVisible(true);


        }
    }


