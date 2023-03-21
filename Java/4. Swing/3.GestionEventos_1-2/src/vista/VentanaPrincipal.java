package vista;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ManejadorEventos;

public class VentanaPrincipal extends JFrame{

	private JLabel etiqueta;
	private JTextField cajaTexto;
	private JButton boton, botonReset;
	

	//--Creacion de ventana
	public VentanaPrincipal() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Peepo");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/fotos/fotoIcono.png"));
		
		setLayout(null);//desactivamos el layout
		inicializarComponentes();//llamada a la funcion
		
		setVisible(true);
	}
	
	private void inicializarComponentes() {
		/*
		 * pasos importantes creacion de componentes
		 * 	1 crear
		 * 	2 dar tamaño y posicion
		 * 	3 añadir 
		 */
		etiqueta = new JLabel("Nombre");
		etiqueta.setBounds(50, 30, 50, 30);
		add(etiqueta);
		
		cajaTexto = new JTextField();
		cajaTexto.setBounds(110, 30, 110, 30);
		add(cajaTexto);
		
		boton = new JButton("Saludar");
		boton.setBounds(50, 80, 170, 30);
		add(boton);
		
		botonReset = new JButton("Borrar");
		botonReset.setBounds(50, 120, 170, 30);
		add(botonReset);
	}

	public void establecerManejador(ManejadorEventos manejador){
		boton.addActionListener(manejador);
		botonReset.addActionListener(manejador);		
	}
	
	public JTextField getCajaTexto() {
		return cajaTexto;
	}
	
	public void setCajaTexto(JTextField cajaTexto) {
		this.cajaTexto = cajaTexto;
	}
	
	public JButton getBoton() {
		return boton;
	}

	public void setBoton(JButton boton) {
		this.boton = boton;
	}

	public JButton getBotonReset() {
		return botonReset;
	}

	public void setBotonReset(JButton botonReset) {
		this.botonReset = botonReset;
	}
	
	
}
