package interfazGrafica;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import logica.EmpleadoLoggeado;
import logica.Guia;
import logica.OrdenServicio;
import persistencia.FacadeAseguradora;
import persistencia.FacadeEmbalaje;
import persistencia.FacadeEmpleado;
import persistencia.FacadeGuia;
import persistencia.FacadeOrdenes;
import persistencia.FacadeZona;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class Principal extends JPanel {

	private Frame frameContainer;

	private JTextField txtNumguia;
	private JTextField peso;
	private JTextField txtCliente;
	private JTabbedPane tabbedPane;
	private JPanel panelGuia;
	private JPanel subPanel;
	private JPanel panelZonificacion;
	private JPanel panelZonif;
	private JLabel lblNumeroGuia;
	private JLabel lblItemOrden;
	private JLabel lblOrdenPendiente;
	private JLabel lblAseguradora;
	private JLabel lblTipoEmbalaje;
	private JLabel lblPeso;
	private JLabel lblDelicado;
	private JLabel lblCliente;
	private JLabel lblFondo;
	private JLabel lblGuiaPendiente;
	private JScrollPane scrollPane;

	private JButton btnSeleccionarItem;
	private JButton btnGenerarGuaPendiente;
	private JButton btnGenerarGuiaEn;
	private JComboBox BoxAseguradora;
	private JComboBox BoxEmbalaje;
	private JComboBox BoxDelicado;
	private JButton btnSeleccionar_2;
	private JButton btnCrearZona;
	private JButton btnGenerarGuiaFinal;
	private JLabel lblGuia;
	private JTextField txtNumeroGuia;
	private JPanel panelDistribucion;
	private JLabel lblFondo_1;
	private JLabel fondo3;
	private JLabel lblFondo_2;
	private JLabel lblFiltrarGuiasPor;
	private JButton btnSeleccionar_3;
	private JLabel lblSeleccionarGua;
	private JScrollPane scrollPane_2;
	private JButton btnSeleccionar_4;
	private JButton btnActualizar;
	private JPanel panelSeg;
	private JLabel lblId;
	private JLabel lblAgente;
	private JLabel lblTipoProceso;
	private JLabel lblResultado;
	private JLabel lblEstadoSeguimiento;
	private JTextField txtIdSeg;
	private JTextField txtAgente;
	private JTextField txtResultado;
	private JTextField txtEstadoSeguimiento;
	private JTextField txtProceso;
	private JButton btnCalcularPrecioSegun;
	private JTextField txtPrecioPeso;
	private JTextField txtOrden;
	private JTextField txtItemOrden;

	private JTable table;

	private JTable tableZonas;
	private DefaultTableModel modelZonas;


	public Principal(Frame container) {
		generarPanel();
		this.frameContainer = container;
		String[] header = { "ID", "TIPO", "NOMBRE", "RURAL/URBANO", "LATITUD", "LONGITUD", "REGIÓN" };
		String[][] data = {};
		modelZonas = new nonEditableModel(header, data);
		tableZonas.setModel(modelZonas);
	}

	/** Metodo para generar limpiar elementos de la guia */
	private void generarEnBlanco() {
		txtNumguia.setText("");
		peso.setText("");
		txtCliente.setText("");
		txtPrecioPeso.setText("");
		txtOrden.setText(""); 
		txtItemOrden.setText("");
	}

	/** Metodo que busca ordenes pendientes */
	private void buscarOrdenServicio() {
		BuscarOrdenes ventana = new BuscarOrdenes(this);
		ventana.setVisible(true);
	}

	/** Método que busca el ìtem especifico de la orden */
	private void buscarItemOrdenServicio() {

	}

	/** Método que genera una guia pendiente de zonificación */
	private void generarGuiaPendiente() {
		String aseguradora = BoxAseguradora.getSelectedItem().toString();
		String embalaje = BoxEmbalaje.getSelectedItem().toString();
		String precio = txtPrecioPeso.getText();
		String delicado = BoxDelicado.getSelectedItem().toString();
		if (enBlanco(aseguradora) && enBlanco(embalaje) && enBlanco(precio) && enBlanco(delicado)) {
			switch (delicado) {
			case "Si":
				delicado = "true";
				break;
			case "No":
				delicado = "false";
				break;
			}
			// Acción de ingreso en base de datos
			Guia guia = new Guia();
			guia.setId(txtNumguia.getText());
			guia.setIdEmbalaje(embalaje.split(" - ")[0]);
			OrdenServicio orden = new OrdenServicio();
			orden.setId(Integer.parseInt(txtOrden.getText()));
			guia.setOrden(orden);
			guia.setItem(txtItemOrden.getText());
			guia.setAseguradora(aseguradora.split(" - ")[0]);
			guia.setempleado(EmpleadoLoggeado.getInstance().getId());
			guia.setPrecioTotal(precio);
			guia.setDelicado(delicado);

			try {
				FacadeGuia.insertarGuia(guia);
				JOptionPane.showMessageDialog(null, "Guía creada con éxito");
				this.frameContainer.remove(this);
				Principal nuevaVentana = new Principal(frameContainer);
				frameContainer.add(nuevaVentana);
				nuevaVentana.setBounds(0, 0, 850, 530);

			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Digite la totalidad de los datos de la guía");
		}
	}

	// Verifica si el campo está en blanco
	private boolean enBlanco(String valor) {
		if (valor.isEmpty()) {
			return false;
		}
		return true;
	}

	/** Método que busca las guias pendientes por zonificar */
	private void seleccionGuiaZonificacion() {
		BuscarGuiasZonificar ventana = new BuscarGuiasZonificar(this);
		ventana.setVisible(true);
	}

	/** Método que genera la guia final con su precio y todo */
	private void generarGuiaFinal() {
		int row = tableZonas.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una zona");
		} else {
			String idZona = (String) tableZonas.getValueAt(row, 0);
			String idGuia = txtNumeroGuia.getText();
			try {
				FacadeGuia.zonificarGuia(idGuia, idZona);
				JOptionPane.showMessageDialog(null,"La guía ha sido zonificada");
				this.frameContainer.remove(this);
				Principal nuevaVentana = new Principal(frameContainer);
				frameContainer.add(nuevaVentana);
				nuevaVentana.setBounds(0, 0, 850, 530);
				GuiaFinal guiaF = new GuiaFinal(FacadeGuia.getGuia(idGuia));
				guiaF.setVisible(true);
			} catch (SQLException e) {
				System.out.println("Error: "+e.getMessage());;
			}
			
		}

	}

	/** Método que filtra las guias segun la ciudad */
	private void filtrarGuiasDistribucion() {

	}

	/** Método que genera la lista de distribucion */
	private void generarPdfDistribucion() {
		String ruta=txtRuta.getText();
		
		
		try{
			FileOutputStream archivo = new FileOutputStream(ruta+".PDF");
			Document doc = new Document();
			PdfWriter.getInstance(doc, archivo);
			
			doc.open();
			 PdfPTable pdfTable = new PdfPTable(tablaDist.getColumnCount());
	            
	            for (int i = 0; i < tablaDist.getColumnCount(); i++) {
	                pdfTable.addCell(tablaDist.getColumnName(i));
	            }
	           
	            for (int rows = 0; rows < tablaDist.getRowCount() - 1; rows++) {
	                for (int cols = 0; cols < tablaDist.getColumnCount(); cols++) {
	                    pdfTable.addCell(tablaDist.getModel().getValueAt(rows, cols).toString());

	                }
	            }
	            doc.add(pdfTable);
			doc.close();
			JOptionPane.showMessageDialog(null, "PDF creado");
			
		} catch (Exception e) {
			
		}
		

	}

	/** Método que genera la lista de guias */
	private void actualizarListaGuiasSeg() {

	}

	/** Método que seleccionar guia para ver su seguimiento */
	private void seleccionarGuia() {

	}

	public void cargarBoxAseguradora() {
		try {
			BoxAseguradora.addItem("");
			ResultSet rs = FacadeAseguradora.obtenerRegistros();
			while (rs.next()) {
				BoxAseguradora.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cargarBoxEmbalaje() {

		try {
			BoxEmbalaje.addItem("");
			ResultSet rs2 = FacadeEmbalaje.obtenerRegistros();
			while (rs2.next()) {
				BoxEmbalaje.addItem(rs2.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void buscarRuta(){
		JFileChooser dlg = new JFileChooser();
		int option = dlg.showSaveDialog(dlg);
		if(option == JFileChooser.APPROVE_OPTION){
			File f= dlg.getSelectedFile();
			txtRuta.setText(f.toString());
		}	
	}

	public void cargarZonas() {
		vaciarTablaZonas();
		try {
			ResultSet rs = FacadeZona.consultarZonas();
			Boolean apuntador = rs.next();
			while (apuntador) {
				String[] fila = new String[7];
				for (int i = 0; i < 7; i++) {
					fila[i] = rs.getString(i + 1);
				}
				modelZonas.addRow(fila);
				apuntador = rs.next();
			}
			tableZonas.setModel(modelZonas);

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void vaciarTablaZonas() {
		for (int i = 0; i < modelZonas.getRowCount(); i++) {
			modelZonas.removeRow(0);
		}
	}

	private void generarPanel() {
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(88, 23, 709, 403);
		add(tabbedPane);

		panelGuia = new JPanel();
		panelGuia.setBackground(new Color(248, 248, 255));
		panelGuia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.addTab("Gu\u00EDa pendiente", null, panelGuia, null);
		tabbedPane.setEnabledAt(0, true);
		panelGuia.setLayout(null);

		subPanel = new JPanel();
		subPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		subPanel.setBackground(new Color(240, 248, 255));
		subPanel.setBounds(27, 48, 644, 87);
		panelGuia.add(subPanel);
		subPanel.setLayout(null);

		lblNumeroGuia = new JLabel("N\u00FAmero gu\u00EDa");
		lblNumeroGuia.setForeground(new Color(25, 25, 112));
		lblNumeroGuia.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblNumeroGuia.setBounds(23, 11, 89, 23);
		subPanel.add(lblNumeroGuia);

		txtNumguia = new JTextField();
		txtNumguia.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtNumguia.setBounds(129, 16, 58, 20);
		subPanel.add(txtNumguia);
		txtNumguia.setEditable(false);
		txtNumguia.setColumns(10);

		lblOrdenPendiente = new JLabel("Orden Pendiente");
		lblOrdenPendiente.setForeground(new Color(25, 25, 112));
		lblOrdenPendiente.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblOrdenPendiente.setBounds(228, 13, 110, 20);
		subPanel.add(lblOrdenPendiente);

		btnSeleccionarItem = new JButton("Seleccionar");
		btnSeleccionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarOrdenServicio();
			}
		});
		btnSeleccionarItem.setForeground(new Color(0, 0, 0));
		btnSeleccionarItem.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSeleccionarItem.setBounds(490, 32, 128, 23);
		subPanel.add(btnSeleccionarItem);

		lblItemOrden = new JLabel("Item Orden");
		lblItemOrden.setForeground(new Color(25, 25, 112));
		lblItemOrden.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblItemOrden.setBounds(228, 49, 81, 20);
		subPanel.add(lblItemOrden);

		txtOrden = new JTextField();
		txtOrden.setEnabled(false);
		txtOrden.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtOrden.setEditable(false);
		txtOrden.setColumns(10);
		txtOrden.setBounds(350, 14, 122, 20);
		subPanel.add(txtOrden);

		txtItemOrden = new JTextField();
		txtItemOrden.setEnabled(false);
		txtItemOrden.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtItemOrden.setEditable(false);
		txtItemOrden.setColumns(10);
		txtItemOrden.setBounds(350, 50, 122, 20);
		subPanel.add(txtItemOrden);

		lblAseguradora = new JLabel("Aseguradora");
		lblAseguradora.setForeground(new Color(70, 130, 180));
		lblAseguradora.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblAseguradora.setBounds(72, 191, 89, 23);
		panelGuia.add(lblAseguradora);

		BoxAseguradora = new JComboBox();
		BoxAseguradora.setEnabled(false);
		BoxAseguradora.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxAseguradora.setBounds(160, 191, 177, 20);
		panelGuia.add(BoxAseguradora);

		lblTipoEmbalaje = new JLabel("Tipo embalaje");
		lblTipoEmbalaje.setForeground(new Color(70, 130, 180));
		lblTipoEmbalaje.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTipoEmbalaje.setBounds(376, 191, 89, 20);
		panelGuia.add(lblTipoEmbalaje);

		BoxEmbalaje = new JComboBox();
		BoxEmbalaje.setEnabled(false);
		BoxEmbalaje.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxEmbalaje.setBounds(465, 193, 151, 20);
		panelGuia.add(BoxEmbalaje);

		lblPeso = new JLabel("Peso");
		lblPeso.setForeground(new Color(70, 130, 180));
		lblPeso.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblPeso.setBounds(72, 223, 46, 20);
		panelGuia.add(lblPeso);

		peso = new JTextField();
		peso.setEnabled(false);
		peso.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		peso.setBounds(160, 225, 133, 20);
		panelGuia.add(peso);
		peso.setColumns(10);

		lblDelicado = new JLabel("Delicado");
		lblDelicado.setForeground(new Color(70, 130, 180));
		lblDelicado.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblDelicado.setBounds(376, 224, 79, 20);
		panelGuia.add(lblDelicado);

		BoxDelicado = new JComboBox();
		BoxDelicado.setEnabled(false);
		BoxDelicado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxDelicado.setModel(new DefaultComboBoxModel(new String[] { "", "Si", "No" }));
		BoxDelicado.setBounds(465, 225, 151, 20);
		panelGuia.add(BoxDelicado);

		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(70, 130, 180));
		lblCliente.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblCliente.setBounds(72, 254, 46, 20);
		panelGuia.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtCliente.setBounds(160, 254, 177, 20);
		panelGuia.add(txtCliente);
		txtCliente.setColumns(10);

		btnGenerarGuaPendiente = new JButton("Generar gu\u00EDa pendiente");
		btnGenerarGuaPendiente.setEnabled(false);
		btnGenerarGuaPendiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarGuiaPendiente();
			}
		});
		btnGenerarGuaPendiente.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnGenerarGuaPendiente.setBounds(271, 318, 194, 33);
		panelGuia.add(btnGenerarGuaPendiente);

		btnGenerarGuiaEn = new JButton("Generar guia en blanco");
		btnGenerarGuiaEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarEnBlanco();

			}
		});
		btnGenerarGuiaEn.setBounds(483, 11, 186, 27);
		panelGuia.add(btnGenerarGuiaEn);
		btnGenerarGuiaEn.setFont(new Font("Agency FB", Font.PLAIN, 20));

		btnCalcularPrecioSegun = new JButton("Calcular precio segun peso");
		btnCalcularPrecioSegun.setEnabled(false);
		btnCalcularPrecioSegun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float peso = Float.parseFloat(getPeso().getText());
				float pesoFinal = peso * 500;
				txtPrecioPeso.setText(String.valueOf(pesoFinal));
			}
		});
		btnCalcularPrecioSegun.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnCalcularPrecioSegun.setBounds(376, 257, 240, 23);
		panelGuia.add(btnCalcularPrecioSegun);

		txtPrecioPeso = new JTextField();
		txtPrecioPeso.setEnabled(false);
		txtPrecioPeso.setEditable(false);
		txtPrecioPeso.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtPrecioPeso.setBounds(451, 291, 86, 20);
		panelGuia.add(txtPrecioPeso);
		txtPrecioPeso.setColumns(10);

		lblFondo_1 = new JLabel("");
		lblFondo_1.setIcon(new ImageIcon(Principal.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		lblFondo_1.setBounds(0, 0, 704, 375);
		panelGuia.add(lblFondo_1);

		panelZonificacion = new JPanel();
		panelZonificacion.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Zonificaci\u00F3n", null, panelZonificacion, null);
		tabbedPane.setEnabledAt(1, true);
		panelZonificacion.setLayout(null);

		panelZonif = new JPanel();
		panelZonif.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelZonif.setBackground(new Color(240, 248, 255));
		panelZonif.setBounds(69, 78, 560, 245);
		panelZonificacion.add(panelZonif);
		panelZonif.setLayout(null);

		tableZonas = new JTable();
		tableZonas.setBounds(10, 39, 540, 195);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 540, 195);
		panelZonif.add(scrollPane);
		scrollPane.setViewportView(tableZonas);

		lblGuia = new JLabel("Guia");
		lblGuia.setForeground(new Color(0, 0, 128));
		lblGuia.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblGuia.setBounds(22, 5, 35, 23);
		panelZonif.add(lblGuia);

		txtNumeroGuia = new JTextField();
		txtNumeroGuia.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtNumeroGuia.setEditable(false);
		txtNumeroGuia.setBounds(77, 8, 86, 20);
		panelZonif.add(txtNumeroGuia);
		txtNumeroGuia.setColumns(10);

		lblGuiaPendiente = new JLabel("Guia pendiente de zonificaci\u00F3n");
		lblGuiaPendiente.setForeground(new Color(25, 25, 112));
		lblGuiaPendiente.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblGuiaPendiente.setBounds(166, 36, 176, 20);
		panelZonificacion.add(lblGuiaPendiente);

		btnSeleccionar_2 = new JButton("Seleccionar");
		btnSeleccionar_2.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSeleccionar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionGuiaZonificacion();
			}
		});
		btnSeleccionar_2.setBounds(380, 35, 117, 23);
		panelZonificacion.add(btnSeleccionar_2);

		btnCrearZona = new JButton("Crear Zona");
		btnCrearZona.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnCrearZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCrearZona.setBounds(265, 334, 109, 30);
		panelZonificacion.add(btnCrearZona);

		btnGenerarGuiaFinal = new JButton("Generar gu\u00EDa final");
		btnGenerarGuiaFinal.setEnabled(false);
		btnGenerarGuiaFinal.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnGenerarGuiaFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarGuiaFinal();
			}
		});
		btnGenerarGuiaFinal.setBounds(395, 334, 148, 30);
		panelZonificacion.add(btnGenerarGuiaFinal);

		fondo3 = new JLabel("");
		fondo3.setIcon(new ImageIcon(Principal.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		fondo3.setBounds(0, 0, 704, 375);
		panelZonificacion.add(fondo3);

		panelDistribucion = new JPanel();
		tabbedPane.addTab("Listas Distribuci\u00F3n", null, panelDistribucion, null);
		tabbedPane.setEnabledAt(2, true);
		panelDistribucion.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(189, 25, 123, 20);
		panelDistribucion.add(comboBox);

		lblFiltrarGuiasPor = new JLabel("Filtrar gu\u00EDas por");
		lblFiltrarGuiasPor.setForeground(new Color(25, 25, 112));
		lblFiltrarGuiasPor.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblFiltrarGuiasPor.setBounds(31, 22, 112, 23);
		panelDistribucion.add(lblFiltrarGuiasPor);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(57, 90, 581, 215);
		panelDistribucion.add(scrollPane_1);
		
		tablaDist = new JTable();
		tablaDist.setModel(new DefaultTableModel(
			new Object[][] {
				{"dd", "dd", "eeee"},
				{"dsdsdwew", "wew", null},
			},
			new String[] {
				"New ewe", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(tablaDist);

		btnSeleccionar_3 = new JButton("Seleccionar");
		btnSeleccionar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarGuiasDistribucion();
			}
		});
		btnSeleccionar_3.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSeleccionar_3.setBounds(378, 24, 123, 23);
		panelDistribucion.add(btnSeleccionar_3);

		JButton btnGenerarPdfDistribucion = new JButton("Generar PDF distribuci\u00F3n");
		btnGenerarPdfDistribucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPdfDistribucion();
			}
		});
		btnGenerarPdfDistribucion.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnGenerarPdfDistribucion.setBounds(427, 316, 211, 37);
		panelDistribucion.add(btnGenerarPdfDistribucion);
		
		JButton btnBuscarRuta = new JButton("Buscar ruta");
		btnBuscarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarRuta();
			}
		});
		btnBuscarRuta.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnBuscarRuta.setBounds(255, 327, 123, 23);
		panelDistribucion.add(btnBuscarRuta);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(57, 328, 176, 20);
		panelDistribucion.add(txtRuta);
		txtRuta.setColumns(10);

		lblFondo_2 = new JLabel("");
		lblFondo_2.setIcon(new ImageIcon(Principal.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		lblFondo_2.setBounds(0, 0, 704, 375);
		panelDistribucion.add(lblFondo_2);

		JPanel panelSeguimiento = new JPanel();
		tabbedPane.addTab("Seguimiento", null, panelSeguimiento, null);
		tabbedPane.setEnabledAt(3, true);
		panelSeguimiento.setLayout(null);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(23, 67, 213, 222);
		panelSeguimiento.add(scrollPane_2);

		table = new JTable();
		scrollPane_2.setViewportView(table);

		lblSeleccionarGua = new JLabel("Seleccionar gu\u00EDa");
		lblSeleccionarGua.setForeground(new Color(25, 25, 112));
		lblSeleccionarGua.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblSeleccionarGua.setBounds(78, 33, 112, 23);
		panelSeguimiento.add(lblSeleccionarGua);

		panelSeg = new JPanel();
		panelSeg.setBackground(new Color(240, 248, 255));
		panelSeg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelSeg.setBounds(299, 67, 339, 241);
		panelSeguimiento.add(panelSeg);
		panelSeg.setLayout(null);

		lblId = new JLabel("ID");
		lblId.setForeground(new Color(70, 130, 180));
		lblId.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblId.setBounds(23, 24, 89, 23);
		panelSeg.add(lblId);

		lblAgente = new JLabel("Agente");
		lblAgente.setForeground(new Color(70, 130, 180));
		lblAgente.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblAgente.setBounds(23, 62, 89, 23);
		panelSeg.add(lblAgente);

		lblTipoProceso = new JLabel("Proceso actual");
		lblTipoProceso.setForeground(new Color(70, 130, 180));
		lblTipoProceso.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTipoProceso.setBounds(23, 102, 102, 23);
		panelSeg.add(lblTipoProceso);

		lblResultado = new JLabel("Resultado");
		lblResultado.setForeground(new Color(70, 130, 180));
		lblResultado.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblResultado.setBounds(23, 146, 89, 23);
		panelSeg.add(lblResultado);

		lblEstadoSeguimiento = new JLabel("Estado seguimiento");
		lblEstadoSeguimiento.setForeground(new Color(70, 130, 180));
		lblEstadoSeguimiento.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblEstadoSeguimiento.setBounds(23, 192, 120, 23);
		panelSeg.add(lblEstadoSeguimiento);

		txtIdSeg = new JTextField();
		txtIdSeg.setEditable(false);
		txtIdSeg.setBounds(169, 24, 86, 20);
		panelSeg.add(txtIdSeg);
		txtIdSeg.setColumns(10);

		txtAgente = new JTextField();
		txtAgente.setEditable(false);
		txtAgente.setBounds(169, 62, 137, 20);
		panelSeg.add(txtAgente);
		txtAgente.setColumns(10);

		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setBounds(169, 146, 137, 20);
		panelSeg.add(txtResultado);
		txtResultado.setColumns(10);

		txtEstadoSeguimiento = new JTextField();
		txtEstadoSeguimiento.setEditable(false);
		txtEstadoSeguimiento.setBounds(169, 192, 137, 20);
		panelSeg.add(txtEstadoSeguimiento);
		txtEstadoSeguimiento.setColumns(10);

		txtProceso = new JTextField();
		txtProceso.setEditable(false);
		txtProceso.setBounds(169, 102, 137, 20);
		panelSeg.add(txtProceso);
		txtProceso.setColumns(10);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarListaGuiasSeg();
			}
		});
		btnActualizar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnActualizar.setBounds(78, 300, 119, 23);
		panelSeguimiento.add(btnActualizar);

		btnSeleccionar_4 = new JButton("Seleccionar");
		btnSeleccionar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarGuia();
			}
		});
		btnSeleccionar_4.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSeleccionar_4.setBounds(78, 327, 119, 23);
		panelSeguimiento.add(btnSeleccionar_4);

		JLabel lblFondo_3 = new JLabel("");
		lblFondo_3.setIcon(new ImageIcon(Principal.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		lblFondo_3.setBounds(0, 0, 704, 375);
		panelSeguimiento.add(lblFondo_3);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Principal.class.getResource("/RecursosInterfaz/Fondo.png")));
		lblFondo.setBounds(0, 0, 850, 530);
		add(lblFondo);
	}

	public JButton getBtnGenerarGuiaFinal() {
		return btnGenerarGuiaFinal;
	}

	public JButton getBtnGenerarGuaPendiente() {
		return btnGenerarGuaPendiente;
	}

	public void setBtnGenerarGuaPendiente(JButton btnGenerarGuaPendiente) {
		this.btnGenerarGuaPendiente = btnGenerarGuaPendiente;
	}

	public JComboBox getBoxAseguradora() {
		return BoxAseguradora;
	}

	public void setBoxAseguradora(JComboBox boxAseguradora) {
		BoxAseguradora = boxAseguradora;
	}

	public JComboBox getBoxEmbalaje() {
		return BoxEmbalaje;
	}

	public void setBoxEmbalaje(JComboBox boxEmbalaje) {
		BoxEmbalaje = boxEmbalaje;
	}

	public JComboBox getBoxDelicado() {
		return BoxDelicado;
	}

	public void setBoxDelicado(JComboBox boxDelicado) {
		BoxDelicado = boxDelicado;
	}

	public JTextField getTxtOrden() {
		return txtOrden;
	}

	public JTextField getTxtItemOrden() {
		return txtItemOrden;
	}

	public JTextField getTxtNumguia() {
		return txtNumguia;
	}

	public void setTxtNumguia(JTextField txtNumguia) {
		this.txtNumguia = txtNumguia;
	}

	public JTextField getPeso() {
		return peso;
	}

	public void setPeso(JTextField peso) {
		this.peso = peso;
	}

	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(JTextField txtCliente) {
		this.txtCliente = txtCliente;
	}

	public JTextField getTxtNumeroGuia() {
		return txtNumeroGuia;
	}

	public void setTxtNumeroGuia(JTextField txtNumeroGuia) {
		this.txtNumeroGuia = txtNumeroGuia;
	}

	public JTextField getTxtIdSeg() {
		return txtIdSeg;
	}

	public void setTxtIdSeg(JTextField txtIdSeg) {
		this.txtIdSeg = txtIdSeg;
	}

	public JTextField getTxtAgente() {
		return txtAgente;
	}

	public void setTxtAgente(JTextField txtAgente) {
		this.txtAgente = txtAgente;
	}

	public JTextField getTxtResultado() {
		return txtResultado;
	}

	public void setTxtResultado(JTextField txtResultado) {
		this.txtResultado = txtResultado;
	}

	public JTextField getTxtEstadoSeguimiento() {
		return txtEstadoSeguimiento;
	}

	public void setTxtEstadoSeguimiento(JTextField txtEstadoSeguimiento) {
		this.txtEstadoSeguimiento = txtEstadoSeguimiento;
	}

	public JTextField getTxtProceso() {
		return txtProceso;
	}

	public void setTxtProceso(JTextField txtProceso) {
		this.txtProceso = txtProceso;
	}

	public JTextField getTxtPrecioPeso() {
		return txtPrecioPeso;
	}

	public void setTxtPrecioPeso(JTextField txtPrecioPeso) {
		this.txtPrecioPeso = txtPrecioPeso;
	}

	public void setTxtOrden(JTextField txtOrden) {
		this.txtOrden = txtOrden;
	}

	public void setTxtItemOrden(JTextField txtItemOrden) {
		this.txtItemOrden = txtItemOrden;
	}

	public JButton getBtnCalcularPrecioSegun() {
		return btnCalcularPrecioSegun;
	}

	public void setBtnCalcularPrecioSegun(JButton btnCalcularPrecioSegun) {
		this.btnCalcularPrecioSegun = btnCalcularPrecioSegun;
	}

	private class nonEditableModel extends DefaultTableModel {
		public nonEditableModel(Object[] header, Object[][] data) {
			super(data, header);
		}

		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

}
