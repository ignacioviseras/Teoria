package base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//hacemos que extienda de JFrame
public class VentanaPrincipal extends JFrame{

	private JLabel imagen;
	private JButton boton;
	private JCheckBox checkbox;
	
	//creamos un constructor
	public VentanaPrincipal() {
		//el orden de creacion de la ventana da igual lo unico 
		//importante es que la indicacion de que sea visible se ubique al final.
		
		setSize(650,270);//indicamos el tamaño
		setLocationRelativeTo(null);//al ser null aparecera en el centro de la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cierra la pestaña estera
		
		setLayout(null);//desactivamos el layout
		inicalizarComponentes();//llamada a la funcion
		setVisible(true);//hacemos que sea visible
	}
	
	//Como es una funcion interna la ponemos privada
	private void inicalizarComponentes() {
		getContentPane().setBackground(Color.WHITE);//Color de fondo blanco
		
		//el JLaberl en vez de contener una cadena de texto que seria lo normal
		//contendra una imagen -> para eso tendremos q crear un objeto el cual le indicaremos la ruta.
		imagen = new JLabel(new ImageIcon("src/imagenes/gato1.jpg"));
		imagen.setBounds(0, 0, 300, 270);//cordenadas 0x 0y / y tamaño width 300 height 270
		add(imagen);//añadimos la imagen
		
		//Cuando creamos un objeto de MouseListener
		//tendremos que implementar toda la interfaz de este.
		//utilizaremos solo el que necesitemos-> mouseEntered
		imagen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//Se ejecutara cuando ente el raton encima de la foto
			@Override
			public void mouseEntered(MouseEvent e) {
				imagen.setIcon(new ImageIcon("src/imagenes/gato2.jpg"));
				
			}
			
			//Se ejecutara cuando salga el raton encima de la foto
			@Override
			public void mouseExited(MouseEvent e) {
				imagen.setIcon(new ImageIcon("src/imagenes/gato1.jpg"));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		checkbox = new JCheckBox("Aceptar términos");//declaramos el checkbox
		checkbox.setBounds(350, 50, 150, 30);//tamaño y pos
		checkbox.setBackground(Color.WHITE);//color de fondo
		checkbox.addChangeListener(new ChangeListener() {//Mismo caso que con la imagen añadimos una interfaz
			//aqui indicamos que ocurrira cuando cambie el estado del checkbox.
			@Override
			public void stateChanged(ChangeEvent e) {
				if(checkbox.isSelected()) {//si esta seleccionado
					boton.setEnabled(true);//activamos el boton
				}else {//si NO esta activado
					boton.setEnabled(false);//desactivamos el boton
				}
			}
		});
		add(checkbox);//lo añadimos
		
		boton = new JButton("Continuar");//declaramos el boton
		boton.setBounds(350, 100, 145, 30);//tamaño y pos
		boton.setEnabled(false);//este boton no se podra usar hasta que se acepten las condiciones
		boton.addActionListener(new ActionListener() {//Añadimos la interfaz de ActioListener
			//Esto se accionara cuando el boton sea clicado
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "POP", "Esto es el titulo", JOptionPane.PLAIN_MESSAGE);//esto es una "ventana emergente"
			}
		});
		add(boton);//lo añadimos
	}
	
	public static void main(String[] args) {
		//Para crear la ventana la tenemos que instanciar VentanaPrincipal en el main
		//como no vamos a hacer nada mas con ella podemos crearla y no asignarle valor
		//de tal manera que cuando se ejecute nos la mostrara y no se guardara.
		new VentanaPrincipal();

	}

}
