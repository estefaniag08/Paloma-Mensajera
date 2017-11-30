package interfazGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logica.EmpleadoLoggeado;
import persistencia.FacadeEmpleado;

import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;

public class Aplicacion {

	private JFrame frame;
	private Principal panelPrincipal;
	private JLabel lblIdemp;
	private JLabel lblContrasena;
	private JLabel lblInicio;
	private JLabel lblFondoinicios;
	private JTextField txtIdempleado;
	private JPasswordField pwdContrasenaemp;
	private JButton btnIniciarSesin;
	private JPanel panelInicioS;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion window = new Aplicacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Aplicacion() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		panelPrincipal = new Principal(frame);
		panelInicioS = new JPanel();
		setDetails();
		addToWindow();	
		
	}
	
	private void addToWindow(){
		frame.getContentPane().add(panelInicioS);
		panelInicioS.add(txtIdempleado);
		panelInicioS.add(pwdContrasenaemp);
		panelInicioS.add(btnIniciarSesin);
		panelInicioS.add(lblIdemp);
		panelInicioS.add(lblContrasena);
		panelInicioS.add(lblInicio);
		panelInicioS.add(lblFondoinicios);
	}
	
	private void setDetails(){
		
		panelInicioS.setBounds(0, 0, 850, 530);
		panelInicioS.setLayout(null);
		lblIdemp = new JLabel("ID Empleado");
		lblIdemp.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIdemp.setBounds(312, 223, 89, 31);
		
		pwdContrasenaemp = new JPasswordField();
		pwdContrasenaemp.setBounds(411, 267, 150, 25);
		
		btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setBounds(383, 304, 113, 23);
		btnIniciarSesin.addActionListener(new ActionListener() {
			//Acción del botón ingresar
			public void actionPerformed(ActionEvent e) {
				inicioSesion();
			}
		});
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblContrasena.setBounds(312, 262, 89, 31);
		
		lblInicio = new JLabel("PALOMA MENSAJERA");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setForeground(new Color(0, 51, 102));
		lblInicio.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblInicio.setBounds(302, 181, 272, 31);
			
		lblFondoinicios = new JLabel("");
		lblFondoinicios.setIcon(new ImageIcon(Aplicacion.class.getResource("/RecursosInterfaz/FondoInicioSesion.png")));
		lblFondoinicios.setBounds(0, 0, 831, 531);
		
		txtIdempleado = new JTextField();
		txtIdempleado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtIdempleado.setBounds(411, 227, 150, 25);
		txtIdempleado.setColumns(10);	
	}
	
	private void inicioSesion(){
		String id = txtIdempleado.getText().trim();
		String contrasena = pwdContrasenaemp.getText().trim();
		try {
			if(FacadeEmpleado.login(id, contrasena)) {
				JOptionPane.showMessageDialog(null, "Login exitoso");
				EmpleadoLoggeado.getInstance().setId(txtIdempleado.getText());
				abrirPrincipal();
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos, revíselos por favor");
			}
		} catch (SQLException e1) {
			System.out.println("Error en la conexión a la base de datos");
			System.out.println("Error: " + e1.getMessage());
		}
	}
	
	private void abrirPrincipal(){
		frame.getContentPane().remove(panelInicioS);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setBounds(0, 0, 850, 530);
	}
	
	
}
