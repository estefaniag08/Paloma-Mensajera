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

import persistencia.FacadeGuia;
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

public class BuscarGuiasZonificar extends JFrame {

	private JPanel contentPane;

	private JTable tableGuias;
	private DefaultTableModel modelGuias;
	private JScrollPane scroll1;
	private Principal ventana;

	// public static void main(String[] args) {
	// BuscarOrdenes b = new BuscarOrdenes(null);
	// b.setVisible(true);
	// }

	public BuscarGuiasZonificar(Principal ventana) {
		this.ventana = ventana;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblrdenesDeServicio = new JLabel("Gu\u00EDas de env\u00EDo");
		lblrdenesDeServicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblrdenesDeServicio.setForeground(new Color(25, 25, 112));
		lblrdenesDeServicio.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblrdenesDeServicio.setBounds(215, 11, 130, 20);
		contentPane.add(lblrdenesDeServicio);
		setLocationRelativeTo(null);

		// MODELO DE LA TABLA ORDENES
		String[] cabezera = { "ID", "EMBALAJE", "ITEM", "ASEGURADORA", "ID EMPLEADO", "NOMBRE EMPLEADO",
				"FECHA DE CREACIÓN" };
		String[][] datos = {};
		modelGuias = new nonEditableTable(datos, cabezera);

		tableGuias = new JTable();
		tableGuias.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getClickCount() == 2) {
					JTable table = (JTable) me.getSource();
					Point point = me.getPoint();
					int row = table.rowAtPoint(point);
					String numeroGuia = (String) table.getValueAt(row, 0);
					cargarValor(numeroGuia);
				}
			}

		});
		tableGuias.setBounds(39, 137, 497, 100);

		// Scroll pane para vista de la tabla
		scroll1 = new JScrollPane();
		scroll1.setBounds(10, 50, 545, 116);
		contentPane.add(scroll1);
		scroll1.setViewportView(tableGuias);
		tableGuias.setModel(modelGuias);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(BuscarGuiasZonificar.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		lblFondo.setBounds(0, 0, 567, 378);
		contentPane.add(lblFondo);

		// Se cargan las guias
		cargarGuias();
	}

	public void cargarValor(String guia) {
		this.ventana.getTxtNumeroGuia().setText(guia);
		this.ventana.cargarZonas();
		this.ventana.getBtnGenerarGuiaFinal().setEnabled(true);
		dispose();
	}

	public Boolean cargarGuias() {

		try {
			ResultSet rs;
			rs = FacadeGuia.consultarGuiaSinZona();
			Boolean apuntador = rs.next();
			if (apuntador == false)
				return false;
			else {
				while (apuntador) {
					String[] fila = new String[7];
					for (int i = 0; i < 7; i++) {
						fila[i] = rs.getString(i + 1);
					}
					modelGuias.addRow(fila);
					apuntador = rs.next();
				}
				tableGuias.setModel(modelGuias);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return true;
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
		for (int i = 0; i < j; i++)
			model.removeRow(0);
	}
}
