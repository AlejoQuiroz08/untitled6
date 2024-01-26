import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Formulario extends JFrame implements ActionListener{
    private JButton guardarb;
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1,mi2,mi3;
    private JTable jTable;
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
        DefaultTableModel tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        tabla.addColumn("Nombre");
        tabla.addColumn("Edad");
        jTable = new JTable(tabla);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(10, 50, 300, 200);
        add(jScrollPane);
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
        guardarb = new JButton("Guardar");
        guardarb.setBounds(10, 260, 100, 30);
        guardarb.addActionListener(this);
        add(guardarb);
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
        if (e.getSource()==mi2 || e.getSource() == guardarb) {
            guardar("D://exam//tabla.txt");
            f.setBackground(new Color(0,255,0));
        }
        if (e.getSource()==mi3) {
            f.setBackground(new Color(0,0,255));
        }
        }

    private void guardar(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(archivo)))) {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();
            for (int i = 0; i < colCount; i++) {
                writer.write(model.getColumnName(i) + "\t");
            }
            writer.newLine();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    writer.write(model.getValueAt(i, j).toString() + "\t");
                }
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la tabla");
        }
    }
    }