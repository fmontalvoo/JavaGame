package com.fmont.mapa;

import com.fmont.graficos.Pantalla;

/**
 * Clase abstracta encargada de la generacion y carga de los mapas para mostrar
 * en el juego.
 * 
 * @author fmont
 *
 */
public abstract class Mapa {

	protected int ancho;
	protected int alto;

	protected int[] tiles;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		tiles = new int[this.ancho * this.alto];
		this.generarMapa();
	}

	public Mapa(String url) {
		this.cargarMapa(url);
	}

	/**
	 * 
	 */
	protected void generarMapa() {

	}

	/**
	 * 
	 * @param url
	 */
	private void cargarMapa(String url) {

	}

	/**
	 * 
	 */
	public void actualizar() {

	}

	/**
	 * 
	 * @param dX
	 * @param dY
	 * @param pantalla
	 */
	public void mostrar(int dX, int dY, Pantalla pantalla) {
	}

}
