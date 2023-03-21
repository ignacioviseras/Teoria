package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;


public class ManejadorEventos implements ActionListener{

	private VentanaPrincipal ventana;
	
	public ManejadorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		////Acceder
		if(e.getSource() == ventana.getBoton()) {
			VentanaSecundaria ventana2 = new VentanaSecundaria();
			ventana2.setVisible(true);//ponemos el set visible ya que en el constructor no esta
		}

		//BotonReset
		if (e.getSource() == ventana.getBotonReset()) {
			ventana.getCajaTexto().setText("");
			ventana.getCajaTexto().requestFocus();//nos activara la caja de texto
		}
	}

}
