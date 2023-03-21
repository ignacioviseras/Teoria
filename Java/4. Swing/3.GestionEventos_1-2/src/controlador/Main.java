package controlador;

import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincip = new VentanaPrincipal();
		ManejadorEventos manejador = new ManejadorEventos(ventanaPrincip);
		ventanaPrincip.establecerManejador(manejador);
	}

}
