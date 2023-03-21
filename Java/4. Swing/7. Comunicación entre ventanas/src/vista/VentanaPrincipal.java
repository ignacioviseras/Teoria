package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ManejadorEventos;

public class VentanaPrincipal extends JFrame{

	private JLabel etiqueta, logo, nombreApp;
	private JTextField cajaTexto;
	private JButton boton, botonReset;
	

	//--Creacion de ventana
	public VentanaPrincipal() {
		setSize(285, 445);
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
		 * 	2 dar tamaño y posicion logo.gif
		 * 	3 añadir 
		 */
		Image img = new ImageIcon("src/fotos/perfil.png").getImage();//escalado de foto
		logo = new JLabel(new ImageIcon(img.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));//escalado de foto
		//logo = new JLabel(new ImageIcon("src/fotos/logo.gif"));peepo
		logo.setBounds(95, 20, 80, 80);
		add(logo);
		
		try {
			Font fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("../fuentes/space age.ttf"));//ubicacion de la fuente
			
			nombreApp = new JLabel("Mi App");//texto que tendra la label
			nombreApp.setHorizontalAlignment(SwingConstants.CENTER);//centramos el contenido
			nombreApp.setFont(fuente.deriveFont(Font.BOLD, 40f));//indicamos q fuente se usara ademas decimos q sea negrita y de tamaño 40 (la f es pq es float)
			nombreApp.setBounds(0, 120, 285, 30);//tamaño/posicionamiento
			nombreApp.setForeground(Color.WHITE);
			add(nombreApp);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		etiqueta = new JLabel(new ImageIcon("src/fotos/persona.png"));
		etiqueta.setBounds(45, 200, 50, 30);
		add(etiqueta);
		
		cajaTexto = new JTextField();
		cajaTexto.setBounds(100, 200, 120, 30);
		cajaTexto.setBorder(null);//quitamos el borde de la caja de texto
		cajaTexto.setFont(new Font("Dialog", Font.BOLD, 14));//idicamos la fuente del texto
		cajaTexto.setForeground(new Color(102, 0, 153));//color de las letras
		add(cajaTexto);
		
		boton = new JButton("Acceder");
		boton.setBounds(50, 250, 170, 30);
		boton.setFont(new Font("Dialog", Font.BOLD, 14));//idicamos la fuente del texto
		boton.setForeground(new Color(102, 0, 153));//color de las letras
		boton.setBackground(Color.WHITE);//color del boton
		add(boton);
		
		botonReset = new JButton("Borrar");
		botonReset.setBounds(50, 300, 170, 30);
		botonReset.setFont(new Font("Dialog", Font.BOLD, 14));//idicamos la fuente del texto
		botonReset.setForeground(new Color(102, 0, 153));//color de las letras
		botonReset.setBackground(Color.WHITE);//color del boton
		add(botonReset);
		
		getContentPane().setBackground(new Color(102, 0, 153));
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
