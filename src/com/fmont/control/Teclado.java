package com.fmont.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase encargada de leer los eventos del teclado.
 * 
 * @author fmont
 *
 */
public final class Teclado implements KeyListener {

//	Define el numero de teclas que contiene el teclado.
	private final static int NUMERO_TECLAS = 100;
//	Permite identificar cual tecla fue presionada.
	private final boolean[] TECLAS = new boolean[NUMERO_TECLAS];

//	Variables que corresponden a las teclas con los movimientos que puede realizar el usuario.
	public boolean arriba;
	public boolean abajo;
	public boolean derecha;
	public boolean izquierda;

//	Variable que corresponde a la tecla para cerrar el juego.
	public boolean cerrar;

	/**
	 * Actualiza las variables correspondientes al movimiento.
	 */
	public void actualizar() {
		arriba = TECLAS[KeyEvent.VK_W];
		abajo = TECLAS[KeyEvent.VK_S];
		derecha = TECLAS[KeyEvent.VK_D];
		izquierda = TECLAS[KeyEvent.VK_A];

		cerrar = TECLAS[KeyEvent.VK_ESCAPE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		TECLAS[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		TECLAS[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
