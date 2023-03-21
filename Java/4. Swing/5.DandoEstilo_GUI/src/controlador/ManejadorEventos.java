package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPrincipal;

public class ManejadorEventos implements ActionListener{

	private VentanaPrincipal ventana;
	
	public ManejadorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		////BotonSaludar
		if(e.getSource() == ventana.getBoton())
			ventana.setTitle("Hola " + ventana.getCajaTexto().getText());
		
		//BotonReset
		if (e.getSource() == ventana.getBotonReset()) {
			ventana.getCajaTexto().setText("");
			ventana.getCajaTexto().requestFocus();//nos activara la caja de texto
		}
	}

}
