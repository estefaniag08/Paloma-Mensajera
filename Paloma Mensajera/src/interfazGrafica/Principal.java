package interfazGrafica;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListDataListener;

import persistencia.FacadeAseguradora;
import persistencia.FacadeEmpleado;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Principal extends JPanel {

	private JTextField txtNumguia;
	private JTextField textField_1;
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
	private JComboBox BoxGuiaPendZon;
	private JButton btnSeleccionar_2;
	private JButton btnZonificar;
	private JButton btnCrearZona;
	private JButton btnGenerarGuiaFinal;
	private JList listaZonas;
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
	private JList list;
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

	private int numeroGuia;

	public JTextField getTxtOrden() {
		return txtOrden;
	}

	public JTextField getTxtItemOrden() {
		return txtItemOrden;
	}

	public Principal() {
		this.numeroGuia = (int) (Math.random() * (999 - 100) + 100);
		generarPanel();

	}

	/** Metodo para generar limpiar elementos de la guia */
	private void generarEnBlanco() {

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

	}

	/** Método que busca las guias pendientes por zonificar */
	private void seleccionGuiaZonificacion() {

	}

	/** Método que zonifica la guía seleccionada */
	private void zonificar() {

	}

	/** Método que genera la guia final con su precio y todo */
	private void generarGuiaFinal() {
		GuiaFinal guiaF = new GuiaFinal();
		guiaF.main(null);
	}

	/** Método que filtra las guias segun la ciudad */
	private void filtrarGuiasDistribucion() {

	}

	/** Método que genera la lista de distribucion */
	private void generarPdfDistribucion() {

	}

	/** Método que genera la lista de guias */
	private void actualizarListaGuiasSeg() {

	}

	/** Método que seleccionar guia para ver su seguimiento */
	private void seleccionarGuia() {

	}
	
	private void cargarBoxAseguradora() {
		try {
			BoxAseguradora.addItem("");
			ResultSet rs = FacadeAseguradora.obtenerRegistros();
			while(rs.next()) {
				BoxAseguradora.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		txtNumguia.setText(String.valueOf(this.numeroGuia));

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
		lblAseguradora.setBounds(97, 191, 89, 23);
		panelGuia.add(lblAseguradora);


		BoxAseguradora = new JComboBox();
		BoxAseguradora.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxAseguradora.setBounds(186, 191, 151, 20);
		panelGuia.add(BoxAseguradora);
		cargarBoxAseguradora();

		lblTipoEmbalaje = new JLabel("Tipo embalaje");
		lblTipoEmbalaje.setForeground(new Color(70, 130, 180));
		lblTipoEmbalaje.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTipoEmbalaje.setBounds(376, 191, 89, 20);
		panelGuia.add(lblTipoEmbalaje);

		BoxEmbalaje = new JComboBox();
		BoxEmbalaje.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxEmbalaje.setBounds(465, 193, 151, 20);
		panelGuia.add(BoxEmbalaje);

		lblPeso = new JLabel("Peso");
		lblPeso.setForeground(new Color(70, 130, 180));
		lblPeso.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblPeso.setBounds(97, 223, 46, 20);
		panelGuia.add(lblPeso);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		textField_1.setBounds(186, 223, 86, 20);
		panelGuia.add(textField_1);
		textField_1.setColumns(10);

		lblDelicado = new JLabel("Delicado");
		lblDelicado.setForeground(new Color(70, 130, 180));
		lblDelicado.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblDelicado.setBounds(376, 224, 79, 20);
		panelGuia.add(lblDelicado);

		BoxDelicado = new JComboBox();
		BoxDelicado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxDelicado.setModel(new DefaultComboBoxModel(new String[] { "Si", "No" }));
		BoxDelicado.setBounds(465, 225, 151, 20);
		panelGuia.add(BoxDelicado);

		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(70, 130, 180));
		lblCliente.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblCliente.setBounds(97, 254, 46, 20);
		panelGuia.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtCliente.setBounds(186, 254, 86, 20);
		panelGuia.add(txtCliente);
		txtCliente.setColumns(10);

		btnGenerarGuaPendiente = new JButton("Generar gu\u00EDa pendiente");
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
		btnCalcularPrecioSegun.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnCalcularPrecioSegun.setBounds(376, 257, 240, 23);
		panelGuia.add(btnCalcularPrecioSegun);

		txtPrecioPeso = new JTextField();
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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 540, 195);
		panelZonif.add(scrollPane);

		listaZonas = new JList();
		listaZonas.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		scrollPane.setViewportView(listaZonas);

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
		lblGuiaPendiente.setBounds(69, 36, 176, 20);
		panelZonificacion.add(lblGuiaPendiente);

		BoxGuiaPendZon = new JComboBox();
		BoxGuiaPendZon.setBounds(255, 36, 197, 20);
		panelZonificacion.add(BoxGuiaPendZon);

		btnSeleccionar_2 = new JButton("Seleccionar");
		btnSeleccionar_2.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSeleccionar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionGuiaZonificacion();
			}
		});
		btnSeleccionar_2.setBounds(495, 35, 117, 23);
		panelZonificacion.add(btnSeleccionar_2);

		btnZonificar = new JButton("Zonificar");
		btnZonificar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnZonificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zonificar();
			}
		});
		btnZonificar.setBounds(155, 334, 89, 30);
		panelZonificacion.add(btnZonificar);

		btnCrearZona = new JButton("Crear Zona");
		btnCrearZona.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnCrearZona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCrearZona.setBounds(265, 334, 109, 30);
		panelZonificacion.add(btnCrearZona);

		btnGenerarGuiaFinal = new JButton("Generar gu\u00EDa final");
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

		JList listDistrib = new JList();
		scrollPane_1.setViewportView(listDistrib);

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
		btnGenerarPdfDistribucion.setBounds(268, 323, 179, 37);
		panelDistribucion.add(btnGenerarPdfDistribucion);

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

		list = new JList();
		scrollPane_2.setViewportView(list);

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
}
