package com.fmont.mapa;

import com.fmont.graficos.Pantalla;
import com.fmont.mapa.cuadro.Tile;

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
	public void mostrar(final int dX, final int dY, final Pantalla pantalla) {

		pantalla.setDiferencia(dX, dY);

		int x0 = dX >> 5;
		int x1 = (dX + pantalla.getAncho() + Tile.TAMANIO_LADO) >> 5;
		int y0 = dY >> 5;
		int y1 = (dY + pantalla.getAlto() + Tile.TAMANIO_LADO) >> 5;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).mostrar(x, y, pantalla);
			}
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(final int x, final int y) {
		switch (tiles[Math.abs(x) + Math.abs(y) * this.ancho]) {
		case 0:
			return Tile.ASFALTO;
		default:
			return Tile.VACIO;
		}
	}

}
