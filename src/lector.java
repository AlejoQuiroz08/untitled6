import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class lector {
    private JTextArea textArea1;
    public JPanel lector;
    private JFileChooser fileChooser;

    public lector(){
        fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                FileReader fileReader = new FileReader(selectedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                bufferedReader.close();

                textArea1.setEditable(false);
                textArea1.setText(content.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }

}
}
