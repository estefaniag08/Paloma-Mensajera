package interfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.SwingConstants;

import persistencia.FacadeEmpleado;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class InicioSesion extends JPanel {
	
	private JLabel lblIdemp;
	private JLabel lblContrasena;
	private JLabel lblInicio;
	private JLabel lblFondoinicios;
	private JTextField txtIdempleado;
	private JPasswordField pwdContrasenaemp;
	private JButton btnIniciarSesin;
	
	public InicioSesion() {
		setLayout(null);
		setDetails();
		addToPanel();
		
	}
	private void setDetails(){
		lblIdemp = new JLabel("ID Empleado");
		lblIdemp.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIdemp.setBounds(312, 223, 89, 31);
		
		pwdContrasenaemp = new JPasswordField();
		pwdContrasenaemp.setBounds(411, 267, 150, 25);
		
		btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setBounds(383, 304, 113, 23);
		btnIniciarSesin.addActionListener(new ActionListener() {
			@Override
			//Acción del botón ingresar
			public void actionPerformed(ActionEvent e) {
				String id = txtIdempleado.getText().trim();
				String contrasena = pwdContrasenaemp.getText().trim();
				try {
					if(FacadeEmpleado.login(id, contrasena)) {
						JOptionPane.showMessageDialog(null, "Login exitoso");
					}
					else {
						JOptionPane.showMessageDialog(null, "Datos incorrectos, revíselos por favor");
					}
				} catch (SQLException e1) {
					System.out.println("Error en la conexión a la base de datos");
					System.out.println("Error: " + e1.getMessage());
				}
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
		lblFondoinicios.setIcon(new ImageIcon(InicioSesion.class.getResource("/RecursosInterfaz/FondoInicioSesion.png")));
		lblFondoinicios.setBounds(0, 0, 831, 531);
		
		txtIdempleado = new JTextField();
		txtIdempleado.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtIdempleado.setBounds(411, 227, 150, 25);
		txtIdempleado.setColumns(10);
		
		
	}
	private void addToPanel(){
		
		add(txtIdempleado);
		add(pwdContrasenaemp);
		add(btnIniciarSesin);
		add(lblIdemp);
		add(lblContrasena);
		add(lblInicio);
		add(lblFondoinicios);
	}
}
