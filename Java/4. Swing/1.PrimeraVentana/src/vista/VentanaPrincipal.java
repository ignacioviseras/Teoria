package vista;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal() {
		//--Creacion de ventana--
		setSize(300, 300);//dimensiones de la pestaña
		setLocationRelativeTo(null);//al colocarle un null dejamos la ventana en el centro de la pantalla
		/*setLocation(int x, int y); ubicariamos la esquina superior izq*/
		/*setBounds(int x, int y, WIDTH, HEIGHT); esta linea  indica el tamaño y la posicion de la ventana*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x para cerrar el programa
		
		
		
		//--Interaccion con el usuario--
		setResizable(false);//no deja redimensionar la ventana
		setTitle("Peepo");//Damos un titulo a la ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("fotoIcono.png"));//sin url tiene que estar al mismo nivel q src
		/*setIconImage(Toolkit.getDefaultToolkit().getImage("src/fotos/fotoIcono.png"));//con url*/
		
		
		setVisible(true);//Creo q hay q dejar esto al final siempre es para q la ventana sea visible
	}
}
