package com.fmont.graficos;

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
	 * 
	 */
	public void limpiar() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	/**
	 * 
	 * @param compesacionX
	 * @param compensacionY
	 */
	public void monstrar(final int compesacionX, final int compensacionY) {
		for (int y = 0; y < this.alto; y++) {
			int posicionY = y + compensacionY;
			if (posicionY < 0 || posicionY >= this.alto)
				continue;
			for (int x = 0; x < this.ancho; x++) {
				int posicionX = x + compesacionX;
				if (posicionX < 0 || posicionX >= this.ancho)
					continue;
			}
		}
	}

}
