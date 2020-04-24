package com.fmont.game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Juego extends Canvas {

	private static final long serialVersionUID = 1L;

//	Dimensiones para la ventana del juego.
	private static final int ANCHO = 800;
	private static final int ALTO = 600;

//	Titulo para la ventana del juego.
	private static final String TITULO = "Juego";

//	Objeto que define la ventana del juego.
	private static JFrame ventana;

	public Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		ventana = new JFrame(TITULO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setLocationRelativeTo(null);
		ventana.pack();
		ventana.setVisible(true);
	}

	public static void main(String... args) {
		Juego juego = new Juego();
	}

}
