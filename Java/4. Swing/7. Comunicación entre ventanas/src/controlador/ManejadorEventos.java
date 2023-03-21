package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;


public class ManejadorEventos implements ActionListener{

	private VentanaPrincipal ventana;
	private VentanaSecundaria ventana2;
	
	public ManejadorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		////Acceder
		if(e.getSource() == ventana.getBoton()) {
			ventana2 = new VentanaSecundaria(this);
			ventana2.establecerTexto("Bienvenid@ " + ventana.getCajaTexto().getText());
			ventana2.setVisible(true);//ponemos el set visible ya que en el constructor no esta
		}

		//BotonReset
		if (e.getSource() == ventana.getBotonReset()) {
			ventana.getCajaTexto().setText("");
			ventana.getCajaTexto().requestFocus();//nos activara la caja de texto
		}
		
		//BotonCerrar
		if (e.getSource() == ventana2.getBotonCerrar()) {
			ventana2.dispose();
		}
	}

}
