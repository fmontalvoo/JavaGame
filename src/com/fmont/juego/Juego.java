package com.fmont.juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.fmont.control.Teclado;

/**
 * Clase que sirve como punto de ejecucion del juego.
 * 
 * @author fmont
 *
 */
public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
//*************************VARIABLES LOCALES DE LA CLASE*************************//
//	Dimensiones para la ventana del juego.
	private static final int ANCHO = 800;
	private static final int ALTO = 600;

//	Actualizaciones por segundo.
	private static int aps = 0;
//	Frames por segundo.
	private static int fps = 0;

//	Titulo para la ventana del juego.
	private static final String TITULO = "Juego";

//	Indica el estado del juego (iniciado, detenido).
	private static volatile boolean ejecutando = false;

//*************************INSTANCIAS DE OTRAS CLASES*************************//

//	Objeto que define la ventana del juego.
	private static JFrame ventana;

//	Therad encargado del procesamiento de los graficos del juego.
	private static Thread thread;

//	Objeto encargado de controlar el movimiento dentro del juego.	
	private static Teclado teclado;

	public Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		teclado = new Teclado();
		addKeyListener(teclado);

		ventana = new JFrame(TITULO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	/**
	 * Metodo que inicia la ejecucion del thread. Trabaja sincronamente con la
	 * variable `ejecutando`.
	 */
	private synchronized void iniciar() {
		ejecutando = true;
//		Inicia el thread. Recibe como parametros la clase a ejecutar y el nombre del thread
		thread = new Thread(this, "Graficos");
		thread.start();
	}

	/**
	 * Metodo que detiene la ejecucion del thread. Trabaja sincronamente con la
	 * variable `ejecutando`.
	 */
	private synchronized void detener() {
		ejecutando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza todas las variables del juego.
	 */
	private void actualizar() {
		teclado.actualizar();

		if (teclado.arriba) {
		}
		if (teclado.abajo) {
		}
		if (teclado.derecha) {
		}
		if (teclado.izquierda) {
		}

		aps++;
	}

	/**
	 * Dibuja y muestra los graficos del juego en la ventana.
	 */
	private void mostrar() {
		fps++;
	}

	@Override
	public void run() {
//		Cantidad de nanosengundos correspondientes a un segundo. 
		final int NS_POR_SEGUNDO = 1000000000;
//		Numero objetivo de actualizaciones por segundo.
		final byte APS = 60;
//		Cantidad de nanosegundos que transcurren por actualizacion.
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS;
//		Recupera el tiempo en nanosegundos en el momento exacto en el que se ejecuta esta linea.
		long referenciaActualizacion = System.nanoTime();
		long referenciaTiempo = System.nanoTime();

		double tiempoTrasncurrido;
//		Almacena la cantidad de tiempo que transcurre hasta realizar una actualizacion.
		double delta = 0;

//		Otorga el foco para el uso del teclado a esta ventana.
		requestFocus();

		while (ejecutando) {
//			Recupera el tiempo en nanosegundos en el momento en el que inicia el bucle.
			final long inicioBucle = System.nanoTime();

//			Calcula la diferencia en el tiempo entre la referencia de actualizacion y el inicio del bucle.
			tiempoTrasncurrido = inicioBucle - referenciaActualizacion;
//			Cambia la referencia de actualizacion.
			referenciaActualizacion = inicioBucle;

			delta += (tiempoTrasncurrido / NS_POR_ACTUALIZACION);

			while (delta >= 1) {
				actualizar();
				delta--;
			}

//			Condicion para verificar si ha transcurrido un segundo entre la referencia de tiempo y el momento actual.
			if ((System.nanoTime() - referenciaTiempo) > NS_POR_SEGUNDO) {
				ventana.setTitle(TITULO + " || APS: " + aps + " || FPS: " + fps);
				aps = 0;
				fps = 0;
				referenciaTiempo = System.nanoTime();
			}

			mostrar();

		}
	}

	public static void main(String... args) {
		Juego juego = new Juego();
		juego.iniciar();
	}
}
