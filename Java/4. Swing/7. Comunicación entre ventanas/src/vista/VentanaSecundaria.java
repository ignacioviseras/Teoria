package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ManejadorEventos;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSecundaria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel etiquetaSaludo;
	private JButton botonCerrar;
	private ManejadorEventos controlador;

	/**
	 * Create the dialog.
	 */
	public VentanaSecundaria(ManejadorEventos controlador) {
		this.controlador = controlador;
		
		setBounds(100, 100, 285, 445);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 0, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		etiquetaSaludo = new JLabel("New label");
		etiquetaSaludo.setForeground(new Color(240, 240, 240));
		etiquetaSaludo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaSaludo.setFont(new Font("Tahoma", Font.BOLD, 18));
		etiquetaSaludo.setBounds(10, 74, 249, 46);
		contentPanel.add(etiquetaSaludo);
		
		botonCerrar = new JButton("Volver");
		botonCerrar.addActionListener(controlador);
		botonCerrar.setBackground(new Color(255, 255, 255));
		botonCerrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botonCerrar.setBounds(87, 194, 89, 23);
		contentPanel.add(botonCerrar);
	}
	
	public void establecerTexto(String nombreUsuario) {
		etiquetaSaludo.setText(nombreUsuario);
	}

	public JButton getBotonCerrar() {
		return botonCerrar;
	}
	
	
}
