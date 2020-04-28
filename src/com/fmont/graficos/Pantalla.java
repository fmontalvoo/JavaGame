package com.fmont.graficos;

import com.fmont.mapa.cuadro.Tile;

/**
 * Clase encargada de dibujar y mostrar los graficos.
 * 
 * @author fmont
 *
 */
public final class Pantalla {

	private final int ancho;
	private final int alto;

	public final int[] pixels;

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixels = new int[this.ancho * this.alto];
	}

	/**
	 * Borra el contenido anterior del array y lo deja listo para dibujar una nueva
	 * imagen.
	 */
	public void limpiar() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	/**
	 * Dibuja en la pantalla los objetos que deseamos mostrar en la ventana del
	 * juego.
	 * 
	 * @param dX
	 * @param dY
	 */
	public void mostrar(final int dX, final int dY) {
		for (int y = 0; y < this.alto; y++) {
			int posicionY = y + dY;
			if (posicionY < 0 || posicionY >= this.alto)
				continue;
			for (int x = 0; x < this.ancho; x++) {
				int posicionX = x + dX;
				if (posicionX < 0 || posicionX >= this.ancho)
					continue;

				pixels[posicionX + posicionY * this.ancho] = Sprite.ASFALTO.pixels[(x & 31) + (y & 31) * 32];
			}
		}
	}

	public void mostrar(final int dX, final int dY, Tile tile) {
		for (int y = 0; y < tile.sprite.getTamanioLado(); y++) {
			int posicionY = y + dY;
			for (int x = 0; x < tile.sprite.getTamanioLado(); x++) {
				int posicionX = x + dX;
				if (posicionX < 0 || posicionX >= this.ancho || posicionY < 0 || posicionY >= this.alto)
					break;
				pixels[posicionX + posicionY * this.ancho] = tile.sprite.pixels[x + y * tile.sprite.getTamanioLado()];
			}
		}
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
