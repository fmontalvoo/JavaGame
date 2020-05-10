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
	protected Tile[] cuadros;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		tiles = new int[this.ancho * this.alto];
		this.generarMapa();
	}

	public Mapa(String url) {
		this.cargarMapa(url);
		this.generarMapa();
	}

	/**
	 * Genera el mapa al asignar cada tile de forma individual al array de tiles
	 * para luego mostrarlo en la pantalla.
	 */
	protected void generarMapa() {

	}

	/**
	 * Carga un archivo en el cual se encuentran las disposisiones de los tiles para
	 * crear el mapa.
	 * 
	 * @param url
	 */
	protected void cargarMapa(String url) {

	}

	/**
	 * 
	 */
	public void actualizar() {

	}

	/**
	 * Dibuja el mapa en la pantalla del juego.
	 * 
	 * @param dX
	 * @param dY
	 * @param pantalla
	 */
	public void mostrar(final int dX, final int dY, final Pantalla pantalla) {
//		System.out.println(dX + ", " + dY + " | " + (dX >> 5) + ", " + (dY >> 5));
		pantalla.setDiferencia(dX, dY);

		int x0 = dX >> 5;
		int x1 = (dX + pantalla.getAncho() + Tile.TAMANIO_LADO) >> 5;
		int y0 = dY >> 5;
		int y1 = (dY + pantalla.getAlto() + Tile.TAMANIO_LADO) >> 5;

//		System.out.println(x1 + " | " + y1);

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
//				getTile(x, y).mostrar(x, y, pantalla);
				if (x < 0 || y < 0 || x >= this.ancho || y >= this.alto)
					Tile.VACIO.mostrar(x, y, pantalla);
				else
					this.cuadros[x + y * this.ancho].mostrar(x, y, pantalla);
			}
		}
	}

	/**
	 * Retorna un tipo de tile segun la coordenada que le corresponda.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(final int x, final int y) {
		if (x < 0 || y < 0 || x >= this.ancho || y >= this.alto)
			return Tile.VACIO;

		switch (tiles[x + y * this.ancho]) {
		case 0:
			return Tile.ASFALTO;
		case 1:
			return Tile.ARENA;
		case 2:
			return Tile.LINEA_ASFALTO;
		case 3:
			return Tile.CACTUS;
		case 4:
			return Tile.BORDE_ASFALTO;
		case 5:
			return Tile.ESQUINA_ASFALTO;
		case 6:
			return Tile.PIEDRA;
		case 7:
			return Tile.OXIDO;
		case 8:
			return Tile.BORDE_PUERTA;
		case 9:
			return Tile.ESQUINA_PUERTA;
		case 10:
			return Tile.ARCO_PUERTA;
		default:
			return Tile.VACIO;
		}
	}

}
