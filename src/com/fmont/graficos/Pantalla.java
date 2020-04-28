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

	private int diferenciaX;
	private int diferenciaY;

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
	 * @param tile
	 */

	public void mostrar(int dX, int dY, Tile tile) {
		dX -= diferenciaX;
		dY -= diferenciaY;
		for (int y = 0; y < tile.sprite.getTamanioLado(); y++) {
			int posicionY = y + dY;
			for (int x = 0; x < tile.sprite.getTamanioLado(); x++) {
				int posicionX = x + dX;

//				Condicion que evita dibujar cualquier objeto que se encuetre fuera de los limites de la pantalla del juego.
				if (posicionX < -tile.sprite.getTamanioLado() || posicionX >= this.ancho || posicionY < 0
						|| posicionY >= this.alto)
					break;

				if (posicionX < 0)
					posicionX = 0;

				pixels[posicionX + posicionY * this.ancho] = tile.sprite.pixels[x + y * tile.sprite.getTamanioLado()];
			}
		}
	}

	public void setDiferencia(final int diferenciaX, final int diferenciaY) {
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
