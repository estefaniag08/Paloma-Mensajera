package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.ScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.DefaultTableModel;

import persistencia.FacadeOrdenes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class BuscarOrdenes extends JFrame {

	private JPanel contentPane;

	private JTable tableOrdenes;
	private DefaultTableModel modelOrdenes;
	private DefaultTableModel modelDetalles;
	private JScrollPane scroll1;
	private JTable tableDetalles;
	private ResultSet rs=null;
	private Principal ventana;
	private String idOrden;
	private String item;
	private String cliente;
	
//	public static void main(String[] args) {
//		BuscarOrdenes b = new BuscarOrdenes(null);
//		b.setVisible(true);
//	}

	public BuscarOrdenes(Principal ventana) {
		this.ventana = ventana;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblrdenesDeServicio = new JLabel("\u00D3rdenes de Servicio");
		lblrdenesDeServicio.setForeground(new Color(25, 25, 112));
		lblrdenesDeServicio.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblrdenesDeServicio.setBounds(215, 11, 130, 20);
		contentPane.add(lblrdenesDeServicio);
		setLocationRelativeTo(null);

		// MODELO DE LA TABLA ORDENES
		String[] cabezera = { "ID", "CÉDULA DEL CLIENTE", "NOMBRE DEL CLIENTE", "DIRECCIÓN DE RECOLECCIÓN",
				"FECHA DE CREACIÓN" };
		String[][] datos = {};
		modelOrdenes = new nonEditableTable(datos, cabezera);

		// MODELO DE LA TABLA DETALLES
		String[] header = { "ITEM", "EMBALAJE", "PRECIO", "PESO" };
		String[][] data = {};
		modelDetalles = new nonEditableTable(data, header);

		JLabel lblDetallesDeLa = new JLabel("Detalles de la orden de servicio seleccionada");
		lblDetallesDeLa.setForeground(new Color(25, 25, 112));
		lblDetallesDeLa.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblDetallesDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesDeLa.setBounds(141, 202, 296, 27);
		contentPane.add(lblDetallesDeLa);

		tableOrdenes = new JTable();
		tableOrdenes.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				vaciarTabla(modelDetalles);
				JTable table = (JTable) me.getSource();
				Point point = me.getPoint();
				int row = table.rowAtPoint(point);
				String idOrden = (String) table.getValueAt(row, 0);
				cargarDetalles(idOrden);
				cliente= (String) table.getValueAt(row, 2);
				
			}
		});
		tableOrdenes.setBounds(39, 137, 497, 100);

		// Scroll pane para vista de la tabla
		scroll1 = new JScrollPane();
		scroll1.setBounds(10, 36, 545, 116);
		contentPane.add(scroll1);
		scroll1.setViewportView(tableOrdenes);
		tableOrdenes.setModel(modelOrdenes);

		tableDetalles = new JTable();
		tableDetalles.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JTable table = (JTable)e.getSource();
				Point point = e.getPoint();
				int row = table.rowAtPoint(point);
				if(e.getClickCount()==2) {
					String item = (String)table.getValueAt(row,0);
					String peso = (String)table.getValueAt(row,3);
					String precio = (String)table.getValueAt(row,2);
					cargarValor(item, peso, precio);
				}
			}
		});
		tableDetalles.setBounds(0, 0, 547, 100);

		JScrollPane scroll2 = new JScrollPane();
		scroll2.setBounds(10, 240, 547, 100);
		contentPane.add(scroll2);
		scroll2.setViewportView(tableDetalles);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(BuscarOrdenes.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		lblFondo.setBounds(0, 0, 567, 378);
		contentPane.add(lblFondo);

		// Se cargan las órdenes de servicio
		cargarOrdenes();
	}
	
	public void cargarValor(String item, String peso, String precio){
		this.item = item;
		this.ventana.getTxtItemOrden().setText(this.item);
		this.ventana.getTxtOrden().setText(this.idOrden);
		this.ventana.getPeso().setText(peso);
		this.ventana.getTxtPrecioPeso().setText(precio);
		this.ventana.getBtnCalcularPrecioSegun().setEnabled(false);
		this.ventana.getTxtCliente().setText(cliente);
		this.ventana.cargarBoxAseguradora();
		this.ventana.cargarBoxEmbalaje();
		
		int numeroGuia = (int) (Math.random() * (999 - 100) + 100);
		this.ventana.getTxtNumguia().setText(String.valueOf(numeroGuia));
		this.ventana.getBoxAseguradora().setEnabled(true);
		this.ventana.getBoxDelicado().setEnabled(true);
		this.ventana.getBoxEmbalaje().setEnabled(true);
		this.ventana.getBtnCalcularPrecioSegun().setEnabled(true);
		this.ventana.getBtnGenerarGuaPendiente().setEnabled(true);
		dispose();
	}

	public Boolean cargarOrdenes() {

		try {
			ResultSet rs;
			rs = FacadeOrdenes.consultarOrdenes();
			Boolean apuntador = rs.next();
			if (apuntador == false)
				return false;
			else {
				while (apuntador) {
					String[] fila = new String[5];
					for (int i = 0; i < 5; i++) {
						fila[i] = rs.getString(i + 1);
					}
					modelOrdenes.addRow(fila);
					apuntador = rs.next();
				}
				tableOrdenes.setModel(modelOrdenes);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return true;
	}

	public void cargarDetalles(String idOrden) {
		try {
			this.idOrden = idOrden;
			ResultSet rs = FacadeOrdenes.consultarDetalles(idOrden);
			Boolean apuntador = rs.next();
			if(apuntador==false) JOptionPane.showMessageDialog(null, "Todos los detalles de esta orden ser servicio han sido asignados en guías");
			while (apuntador) {
				String[] fila = new String[4];
				for (int i = 0; i < 4; i++) {
					fila[i] = rs.getString(i + 1);
				}
				modelDetalles.addRow(fila);
				apuntador = rs.next();
			}
			tableDetalles.setModel(modelDetalles);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private class nonEditableTable extends DefaultTableModel {
		nonEditableTable(Object[][] data, Object[] header) {
			super(data, header);
		}

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	public void vaciarTabla(DefaultTableModel model) {
		int j = model.getRowCount();
		for (int i = 0; i <j; i++)
			model.removeRow(0);
	}
}
