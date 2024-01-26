import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Formulario extends JFrame implements ActionListener {
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1, mi2, mi3;
    private JTable jTable;
    private JToggleButton toggleButton;

    public Formulario() {
        setLayout(null);
        mb = new JMenuBar();
        setJMenuBar(mb);
        menu1 = new JMenu("Archivo");
        mb.add(menu1);
        mi1 = new JMenuItem("Nueva Tabla");
        mi1.addActionListener(this);
        menu1.add(mi1);
        mi2 = new JMenuItem("Guardar Tabla");
        mi2.addActionListener(this);
        menu1.add(mi2);
        mi3 = new JMenuItem("Salir");
        mi3.addActionListener(this);
        menu1.add(mi3);

        toggleButton = new JToggleButton("Modo Oscuro");
        toggleButton.setBounds(10, 10, 100, 100);
        toggleButton.addActionListener(this);
        add(toggleButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mi1) {
            abrirTabla();
        } else if (e.getSource() == mi2) {
            guardarTabla();
        } else if (e.getSource() == mi3) {
            dispose();
        } else if (e.getSource() == toggleButton) {
            cambiarModo();
        }
    }

    private void abrirTabla() {
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
        jScrollPane.setBounds(10, 50, 200, 150);
        add(jScrollPane);
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
        tabla.addRow(new Object[]{"", ""});
    }

    private void guardarTabla() {
        if (jTable != null) {
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
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
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Tabla guardada correctamente en " + archivo.getAbsolutePath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al guardar la tabla");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos para guardar.");
        }
    }

    private void cambiarModo() {
        if (toggleButton.isSelected()) {
            getContentPane().setBackground(Color.DARK_GRAY);
            toggleButton.setText("Modo Claro");
        } else {
            getContentPane().setBackground(Color.WHITE);
            toggleButton.setText("Modo Oscuro");
        }
    }

}
