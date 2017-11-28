package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiaFinal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumGuia;
	private JTextField txtFecha;
	private JTextField txtEmpleado;
	private JTextField txtAseguradora;
	private JTextField txtPeso;
	private JTextField txtCliente;
	private JTextField txtEmbalaje;
	private JTextField txtDelicado;
	private JTextField txtTotalPeso;
	private JTextField txtTotalFinal;
	private static GuiaFinal frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GuiaFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void generarPdf(){
		
	}
	
	private void salirDeVentana(){
		frame.dispose();
	}
	public GuiaFinal() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 486, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(65, 22, 335, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Aseguradora");
		label.setForeground(new Color(106, 90, 205));
		label.setFont(new Font("Agency FB", Font.BOLD, 20));
		label.setBounds(10, 108, 89, 23);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Peso");
		label_1.setForeground(new Color(106, 90, 205));
		label_1.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_1.setBounds(10, 140, 46, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Cliente");
		label_2.setForeground(new Color(106, 90, 205));
		label_2.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_2.setBounds(10, 173, 46, 20);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Tipo embalaje");
		label_3.setForeground(new Color(106, 90, 205));
		label_3.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_3.setBounds(10, 205, 89, 20);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Delicado");
		label_4.setForeground(new Color(106, 90, 205));
		label_4.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_4.setBounds(10, 236, 79, 20);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("N\u00FAmero gu\u00EDa");
		label_5.setForeground(new Color(72, 61, 139));
		label_5.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_5.setBounds(10, 6, 89, 23);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Fecha");
		label_6.setForeground(new Color(72, 61, 139));
		label_6.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_6.setBounds(10, 40, 46, 20);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Encargado");
		label_7.setForeground(new Color(72, 61, 139));
		label_7.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_7.setBounds(10, 71, 73, 23);
		panel.add(label_7);
		
		JLabel lblTotalPorPeso = new JLabel("Total por peso");
		lblTotalPorPeso.setForeground(new Color(72, 61, 139));
		lblTotalPorPeso.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTotalPorPeso.setBounds(10, 265, 89, 23);
		panel.add(lblTotalPorPeso);
		
		JLabel lblTotalIva = new JLabel("Total + iva + distancia");
		lblTotalIva.setForeground(new Color(72, 61, 139));
		lblTotalIva.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTotalIva.setBounds(10, 296, 145, 23);
		panel.add(lblTotalIva);
		
		txtNumGuia = new JTextField();
		txtNumGuia.setEditable(false);
		txtNumGuia.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtNumGuia.setBounds(189, 7, 86, 20);
		panel.add(txtNumGuia);
		txtNumGuia.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtFecha.setBounds(189, 41, 86, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setEditable(false);
		txtEmpleado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtEmpleado.setBounds(189, 72, 86, 20);
		panel.add(txtEmpleado);
		txtEmpleado.setColumns(10);
		
		txtAseguradora = new JTextField();
		txtAseguradora.setEditable(false);
		txtAseguradora.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtAseguradora.setBounds(189, 112, 86, 20);
		panel.add(txtAseguradora);
		txtAseguradora.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtPeso.setBounds(189, 144, 86, 20);
		panel.add(txtPeso);
		txtPeso.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtCliente.setBounds(189, 176, 86, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtEmbalaje = new JTextField();
		txtEmbalaje.setEditable(false);
		txtEmbalaje.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtEmbalaje.setBounds(189, 207, 86, 20);
		panel.add(txtEmbalaje);
		txtEmbalaje.setColumns(10);
		
		txtDelicado = new JTextField();
		txtDelicado.setEditable(false);
		txtDelicado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtDelicado.setBounds(189, 238, 86, 20);
		panel.add(txtDelicado);
		txtDelicado.setColumns(10);
		
		txtTotalPeso = new JTextField();
		txtTotalPeso.setEditable(false);
		txtTotalPeso.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtTotalPeso.setBounds(189, 269, 86, 20);
		panel.add(txtTotalPeso);
		txtTotalPeso.setColumns(10);
		
		txtTotalFinal = new JTextField();
		txtTotalFinal.setEditable(false);
		txtTotalFinal.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtTotalFinal.setBounds(189, 299, 86, 20);
		panel.add(txtTotalFinal);
		txtTotalFinal.setColumns(10);
		
		JButton btnNewButton = new JButton("Generar PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarPdf();
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnNewButton.setBounds(111, 359, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirDeVentana();
			}
		});
		btnSalir.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSalir.setBounds(257, 359, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(-182, -51, 693, 489);
		lblFondo.setIcon(new ImageIcon(GuiaFinal.class.getResource("/RecursosInterfaz/Fondo.png")));
		contentPane.add(lblFondo);
	}
}
