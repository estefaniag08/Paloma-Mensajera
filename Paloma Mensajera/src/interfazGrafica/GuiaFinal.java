package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
	private JTextField txtRuta;

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
		String ruta=txtRuta.getText();
		String contenido=txtPeso.getText();
		
		try{
			FileOutputStream archivo = new FileOutputStream(ruta+".PDF");
			Document doc = new Document();
			PdfWriter.getInstance(doc, archivo);
			
			doc.open();
			doc.add(new Paragraph("Numero Guia: " + txtNumGuia.getText()));
			List list = new List();
			List lista = new List();
			lista.setSymbolIndent(12);
			lista.setListSymbol("\u2022");
			list.add(new ListItem("Fecha: " + txtFecha.getText()));
			list.add(new ListItem("Peso: " + txtPeso.getText()));
			list.add(new ListItem("Cliente: " + txtCliente.getText()));
			list.add(new ListItem("Embalaje: " + txtEmbalaje.getText()));
			list.add(new ListItem("Aseguradora: " + txtAseguradora.getText()));
			list.add(new ListItem("Delicado: " + txtDelicado.getText()));
			list.add(new ListItem("Total x peso: " + txtTotalPeso.getText()));
			list.add(new ListItem("Total Final: " + txtTotalFinal.getText()));
			doc.add(list);
			doc.close();
			JOptionPane.showMessageDialog(null, "PDF creado");
			
		} catch (Exception e) {
			
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
	private void salirDeVentana(){
		frame.dispose();
	}
	public GuiaFinal() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 486, 472);
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
		label.setForeground(new Color(70, 130, 180));
		label.setFont(new Font("Agency FB", Font.BOLD, 20));
		label.setBounds(10, 108, 89, 23);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Peso");
		label_1.setForeground(new Color(70, 130, 180));
		label_1.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_1.setBounds(10, 140, 46, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Cliente");
		label_2.setForeground(new Color(70, 130, 180));
		label_2.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_2.setBounds(10, 173, 46, 20);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Tipo embalaje");
		label_3.setForeground(new Color(70, 130, 180));
		label_3.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_3.setBounds(10, 205, 89, 20);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Delicado");
		label_4.setForeground(new Color(70, 130, 180));
		label_4.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_4.setBounds(10, 236, 79, 20);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("N\u00FAmero gu\u00EDa");
		label_5.setForeground(new Color(25, 25, 112));
		label_5.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_5.setBounds(10, 6, 89, 23);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Fecha");
		label_6.setForeground(new Color(25, 25, 112));
		label_6.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_6.setBounds(10, 40, 46, 20);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Encargado");
		label_7.setForeground(new Color(25, 25, 112));
		label_7.setFont(new Font("Agency FB", Font.BOLD, 20));
		label_7.setBounds(10, 71, 73, 23);
		panel.add(label_7);
		
		JLabel lblTotalPorPeso = new JLabel("Total por peso");
		lblTotalPorPeso.setForeground(new Color(25, 25, 112));
		lblTotalPorPeso.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTotalPorPeso.setBounds(10, 265, 89, 23);
		panel.add(lblTotalPorPeso);
		
		JLabel lblTotalIva = new JLabel("Total + iva + distancia");
		lblTotalIva.setForeground(new Color(25, 25, 112));
		lblTotalIva.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblTotalIva.setBounds(10, 296, 145, 23);
		panel.add(lblTotalIva);
		
		txtNumGuia = new JTextField();
		txtNumGuia.setText("1");
		txtNumGuia.setEditable(false);
		txtNumGuia.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtNumGuia.setBounds(189, 7, 86, 20);
		panel.add(txtNumGuia);
		txtNumGuia.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setText("2");
		txtFecha.setEditable(false);
		txtFecha.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtFecha.setBounds(189, 41, 86, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setText("3");
		txtEmpleado.setEditable(false);
		txtEmpleado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtEmpleado.setBounds(189, 72, 86, 20);
		panel.add(txtEmpleado);
		txtEmpleado.setColumns(10);
		
		txtAseguradora = new JTextField();
		txtAseguradora.setText("4");
		txtAseguradora.setEditable(false);
		txtAseguradora.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtAseguradora.setBounds(189, 112, 86, 20);
		panel.add(txtAseguradora);
		txtAseguradora.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setText("5");
		txtPeso.setEditable(false);
		txtPeso.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtPeso.setBounds(189, 144, 86, 20);
		panel.add(txtPeso);
		txtPeso.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setText("6");
		txtCliente.setEditable(false);
		txtCliente.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtCliente.setBounds(189, 176, 86, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtEmbalaje = new JTextField();
		txtEmbalaje.setText("7");
		txtEmbalaje.setEditable(false);
		txtEmbalaje.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtEmbalaje.setBounds(189, 207, 86, 20);
		panel.add(txtEmbalaje);
		txtEmbalaje.setColumns(10);
		
		txtDelicado = new JTextField();
		txtDelicado.setText("8");
		txtDelicado.setEditable(false);
		txtDelicado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtDelicado.setBounds(189, 238, 86, 20);
		panel.add(txtDelicado);
		txtDelicado.setColumns(10);
		
		txtTotalPeso = new JTextField();
		txtTotalPeso.setText("9");
		txtTotalPeso.setEditable(false);
		txtTotalPeso.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtTotalPeso.setBounds(189, 269, 86, 20);
		panel.add(txtTotalPeso);
		txtTotalPeso.setColumns(10);
		
		txtTotalFinal = new JTextField();
		txtTotalFinal.setText("0");
		txtTotalFinal.setEditable(false);
		txtTotalFinal.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtTotalFinal.setBounds(189, 299, 86, 20);
		panel.add(txtTotalFinal);
		txtTotalFinal.setColumns(10);
		
		JLabel lblFondo_1 = new JLabel("");
		lblFondo_1.setIcon(new ImageIcon(GuiaFinal.class.getResource("/RecursosInterfaz/Fondo2v23.png")));
		lblFondo_1.setBounds(0, 0, 335, 326);
		panel.add(lblFondo_1);
		
		JButton btnNewButton = new JButton("Generar PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarPdf();
			}
		});
		
		txtRuta = new JTextField();
		txtRuta.setBounds(65, 368, 214, 20);
		contentPane.add(txtRuta);
		txtRuta.setColumns(10);
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnNewButton.setBounds(112, 399, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirDeVentana();
			}
		});
		btnSalir.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnSalir.setBounds(258, 399, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarRuta();
			}
		});
		btnBuscar.setBounds(289, 367, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(-182, -51, 693, 489);
		lblFondo.setIcon(new ImageIcon(GuiaFinal.class.getResource("/RecursosInterfaz/Fondo.png")));
		contentPane.add(lblFondo);
	}
}
