package com.fmont.mapa;

import java.util.Random;

/**
 * Clase encargada de la construccion del mapa.
 * 
 * @author fmont
 *
 */
public class GenerarMapa extends Mapa {

	private static final Random aleatorio = new Random();

	public GenerarMapa(int ancho, int alto) {
		super(ancho, alto);
	}

	@Override
	protected void generarMapa() {
		for (int y = 0; y < this.alto; y++) {
			for (int x = 0; x < this.ancho; x++) {
				this.tiles[x + y * this.ancho] = aleatorio.nextInt(11);
			}
		}
	}

}
