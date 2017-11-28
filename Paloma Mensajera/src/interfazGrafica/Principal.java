package interfazGrafica;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JPanel {
	
	private JTextField txtNumguia;
	private JTextField textField;
	private JTextField txtEmpleado;
	private JTextField textField_1;
	private JTextField txtCliente;
	private JTabbedPane tabbedPane;
	private JPanel panelGuia; 
	private JPanel subPanel;
	private JPanel panelZonificacion;
	private JPanel panelZonif;
	private JLabel lblNumeroGuia;
	private JLabel lblFecha;
	private JLabel lblItemOrden;
	private JLabel lblOrdenPendiente;
	private JLabel lblEncargado;
	private JLabel lblAseguradora;
	private JLabel lblTipoEmbalaje;
	private JLabel lblPeso;
	private JLabel lblDelicado;
	private JLabel lblCliente;
	private JLabel lblFondo;
	private JLabel lblGuiaPendiente;
	private JScrollPane scrollPane;
	
	private JButton btnSeleccionar;
	private JButton btnSeleccionar_1;
	private JButton btnGenerarGuaPendiente;
	private JButton btnGenerarGuiaEn;
	private JComboBox BoxItemOrden;
	private JComboBox BoxOrdenesPendientes;
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
	 
	public Principal() {
		generarPanel();
	}
	
	/**Metodo para generar limpiar elementos de la guia*/
	private void generarEnBlanco(){
		
	}
	/**Metodo que busca ordenes pendientes*/
	private void buscarOrdenServicio(){
		
	}
	/**Método que busca el ìtem especifico de la orden*/
	private void buscarItemOrdenServicio(){
		
	}
	/**Método que busca las guias pendientes por zonificar*/
	private void seleccionGuiaZonificacion(){
		
	}
	/**Método que zonifica la guía seleccionada*/
	private void zonificar(){
		
	}
	/**Método que genera la guia final con su precio y todo*/
	private void generarGuiaFinal(){
		GuiaFinal guiaF = new GuiaFinal();
		guiaF.main(null);
	}
	private void generarPanel(){
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
		subPanel.setBackground(new Color(230, 230, 250));
		subPanel.setBounds(27, 48, 644, 121);
		panelGuia.add(subPanel);
		subPanel.setLayout(null);
		
		lblNumeroGuia = new JLabel("N\u00FAmero gu\u00EDa");
		lblNumeroGuia.setForeground(new Color(72, 61, 139));
		lblNumeroGuia.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblNumeroGuia.setBounds(23, 11, 89, 23);
		subPanel.add(lblNumeroGuia);
		
		txtNumguia = new JTextField();
		txtNumguia.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtNumguia.setBounds(129, 16, 58, 20);
		subPanel.add(txtNumguia);
		txtNumguia.setEditable(false);
		txtNumguia.setText("00");
		txtNumguia.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(72, 61, 139));
		lblFecha.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblFecha.setBounds(23, 52, 46, 20);
		subPanel.add(lblFecha);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		textField.setBounds(129, 52, 58, 20);
		subPanel.add(textField);
		textField.setEditable(false);
		textField.setColumns(10);
		
		lblOrdenPendiente = new JLabel("Orden Pendiente");
		lblOrdenPendiente.setForeground(new Color(72, 61, 139));
		lblOrdenPendiente.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblOrdenPendiente.setBounds(228, 13, 110, 20);
		subPanel.add(lblOrdenPendiente);
		
		BoxOrdenesPendientes = new JComboBox();
		BoxOrdenesPendientes.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxOrdenesPendientes.setBounds(358, 14, 95, 20);
		subPanel.add(BoxOrdenesPendientes);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarOrdenServicio();
			}
		});
		btnSeleccionar.setForeground(new Color(0, 0, 0));
		btnSeleccionar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSeleccionar.setBounds(490, 13, 128, 23);
		subPanel.add(btnSeleccionar);
		
		BoxItemOrden = new JComboBox();
		BoxItemOrden.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxItemOrden.setEnabled(false);
		BoxItemOrden.setBounds(358, 50, 95, 20);
		subPanel.add(BoxItemOrden);
		
		lblItemOrden = new JLabel("Item Orden");
		lblItemOrden.setForeground(new Color(72, 61, 139));
		lblItemOrden.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblItemOrden.setBounds(228, 49, 81, 20);
		subPanel.add(lblItemOrden);
		
		btnSeleccionar_1 = new JButton("Seleccionar");
		btnSeleccionar_1.setForeground(new Color(0, 0, 0));
		btnSeleccionar_1.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSeleccionar_1.setEnabled(false);
		btnSeleccionar_1.setBounds(490, 49, 128, 23);
		subPanel.add(btnSeleccionar_1);
		
		lblEncargado = new JLabel("Encargado");
		lblEncargado.setForeground(new Color(72, 61, 139));
		lblEncargado.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblEncargado.setBounds(23, 84, 73, 23);
		subPanel.add(lblEncargado);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtEmpleado.setEditable(false);
		txtEmpleado.setBounds(129, 87, 110, 20);
		subPanel.add(txtEmpleado);
		txtEmpleado.setColumns(10);
		
		lblAseguradora = new JLabel("Aseguradora");
		lblAseguradora.setForeground(new Color(106, 90, 205));
		lblAseguradora.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblAseguradora.setBounds(97, 191, 89, 23);
		panelGuia.add(lblAseguradora);
		
		BoxAseguradora = new JComboBox();
		BoxAseguradora.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxAseguradora.setBounds(186, 191, 151, 20);
		panelGuia.add(BoxAseguradora);
		
		lblTipoEmbalaje = new JLabel("Tipo embalaje");
		lblTipoEmbalaje.setForeground(new Color(106, 90, 205));
		lblTipoEmbalaje.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTipoEmbalaje.setBounds(376, 191, 89, 20);
		panelGuia.add(lblTipoEmbalaje);
		
		BoxEmbalaje = new JComboBox();
		BoxEmbalaje.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxEmbalaje.setBounds(465, 193, 151, 20);
		panelGuia.add(BoxEmbalaje);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setForeground(new Color(106, 90, 205));
		lblPeso.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblPeso.setBounds(97, 223, 46, 20);
		panelGuia.add(lblPeso);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		textField_1.setBounds(186, 223, 86, 20);
		panelGuia.add(textField_1);
		textField_1.setColumns(10);
		
		lblDelicado = new JLabel("Delicado");
		lblDelicado.setForeground(new Color(106, 90, 205));
		lblDelicado.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblDelicado.setBounds(376, 224, 79, 20);
		panelGuia.add(lblDelicado);
		
		BoxDelicado = new JComboBox();
		BoxDelicado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		BoxDelicado.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		BoxDelicado.setBounds(465, 225, 151, 20);
		panelGuia.add(BoxDelicado);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(106, 90, 205));
		lblCliente.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblCliente.setBounds(97, 254, 46, 20);
		panelGuia.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtCliente.setBounds(186, 254, 86, 20);
		panelGuia.add(txtCliente);
		txtCliente.setColumns(10);
		
		btnGenerarGuaPendiente = new JButton("Generar gu\u00EDa pendiente");
		btnGenerarGuaPendiente.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnGenerarGuaPendiente.setBounds(271, 300, 194, 33);
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
		
		panelZonificacion = new JPanel();
		panelZonificacion.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Zonificaci\u00F3n", null, panelZonificacion, null);
		tabbedPane.setEnabledAt(1, true);
		panelZonificacion.setLayout(null);
		
		panelZonif = new JPanel();
		panelZonif.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelZonif.setBackground(new Color(230, 230, 250));
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
		lblGuiaPendiente.setForeground(new Color(106, 90, 205));
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
		
		panelDistribucion = new JPanel();
		tabbedPane.addTab("Distribuci\u00F3n", null, panelDistribucion, null);
		tabbedPane.setEnabledAt(2, true);
		panelDistribucion.setLayout(null);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Principal.class.getResource("/RecursosInterfaz/Fondo.png")));
		lblFondo.setBounds(0, 0, 850, 530);
		add(lblFondo);
	}
}
