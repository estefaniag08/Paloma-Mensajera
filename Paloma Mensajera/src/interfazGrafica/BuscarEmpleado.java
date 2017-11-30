package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;



public class BuscarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTable tabla;
	private int a;
	private JScrollPane scrollPane;
	private Principal ventana;
	private DefaultTableModel modelGuia;
	
	public static void main(String[] args) {
		BuscarEmpleado frame = new BuscarEmpleado(null);
		frame.setVisible(true);
	}

	private boolean cargarEmpleados(){
		return true;
	}
	
	public BuscarEmpleado(Principal ventana) {
		this.ventana=ventana;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 413);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 567, 378);
		contentPane.add(panel);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setForeground(new Color(25, 25, 112));
		lblEmpleados.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblEmpleados.setBounds(246, 11, 130, 20);
		panel.add(lblEmpleados);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 36, 490, 288);
		panel.add(scrollPane);
		
		String[] cabecera = { "ID", "NOMBRE","APELLIDO", "CEDULA", "TELEFONO"};
		String[][] datos = {};
		modelGuia = new nonEditableTable(datos, cabecera);
		
		tabla = new JTable();
		tabla.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getClickCount() == 2) {
					JTable table = (JTable) me.getSource();
					Point point = me.getPoint();
					int row = table.rowAtPoint(point);
					
				}
			}

		});
		scrollPane.setViewportView(tabla);
		tabla.setModel(modelGuia);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BuscarGuiasPend.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		label_2.setBounds(0, 0, 567, 378);
		panel.add(label_2);
		
		cargarEmpleados();
	}
	
	private class nonEditableTable extends DefaultTableModel {
		nonEditableTable(Object[][] data, Object[] header) {
			super(data, header);
		}
	}
	public void vaciarTabla(DefaultTableModel model) {
		int j = model.getRowCount();
		for (int i = 0; i <j; i++)
			model.removeRow(0);
	}
}
