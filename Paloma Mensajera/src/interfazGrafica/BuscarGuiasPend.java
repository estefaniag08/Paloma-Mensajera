package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class BuscarGuiasPend extends JFrame {

	private JPanel contentPane;
	private JTable tablaGuias;
	private JScrollPane scrollPane;
	private Principal ventana;
	private DefaultTableModel modelGuia;

	public static void main(String[] args) {
		BuscarGuiasPend frame = new BuscarGuiasPend(null);
		frame.setVisible(true);
	}
	
	public BuscarGuiasPend(Principal ventana) {
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
		
		JLabel lblGuiasPendientes = new JLabel("Guias pendientes");
		lblGuiasPendientes.setForeground(new Color(25, 25, 112));
		lblGuiasPendientes.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblGuiasPendientes.setBounds(215, 11, 130, 20);
		panel.add(lblGuiasPendientes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 36, 490, 288);
		panel.add(scrollPane);
		
		String[] cabecera = { "ID", "EMBALAJE","ORDEN SERVICIO", "ITEM",
		"ASEGURADORA","FECHA", "DELICADO" };
		String[][] datos = {};
		modelGuia = new nonEditableTable(datos, cabecera);
		
		tablaGuias = new JTable();
		scrollPane.setViewportView(tablaGuias);
		tablaGuias.setModel(modelGuia);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BuscarGuiasPend.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		label_2.setBounds(0, 0, 567, 378);
		panel.add(label_2);
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
