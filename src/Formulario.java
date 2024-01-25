import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Formulario extends JFrame implements ActionListener{


    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1,mi2,mi3;

    private JTextArea textArea;
    public Formulario() {
        setLayout(null);
        mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Archivo");
        mb.add(menu1);
        mi1=new JMenuItem("Abrir");
        mi1.addActionListener(this);
        menu1.add(mi1);
        mi2=new JMenuItem("Guardar");
        mi2.addActionListener(this);
        menu1.add(mi2);
        mi3=new JMenuItem("Salir");
        mi3.addActionListener(this);
        menu1.add(mi3);
    }
    static JFrame lector = new JFrame("leer");
    public void actionPerformed(ActionEvent e) {
        Container f=this.getContentPane();
        if (e.getSource()==mi1) {

            lector.setContentPane(new lector().lector);
            lector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            lector.setSize(400, 400);
            lector.setVisible(true);
        }
        if (e.getSource()==mi2) {
            f.setBackground(new Color(0,255,0));
        }
        if (e.getSource()==mi3) {
            f.setBackground(new Color(0,0,255));
        }
        }
    }

