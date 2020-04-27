package com.fmont.mapa;

import com.fmont.graficos.Pantalla;

/**
 * 
 * @author fmont
 *
 */
public abstract class Mapa {

	private int ancho;
	private int alto;

	private int[] tiles;

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
	private void generarMapa() {

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
