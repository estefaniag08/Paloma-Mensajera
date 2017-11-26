package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Aplicacion {

	private JFrame frame;
	private InicioSesion panelInicio;
	
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
		frame.setBounds(100, 100, 850, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		setDetails();
		addToWindow();
		
	}
	
	private void setDetails(){
		panelInicio = new InicioSesion();
		panelInicio.setBounds(0, 0, 850, 530);
	}
	
	private void addToWindow(){
		frame.getContentPane().add(panelInicio);
	}
}
