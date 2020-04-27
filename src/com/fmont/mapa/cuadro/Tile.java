package com.fmont.mapa.cuadro;

import com.fmont.graficos.Pantalla;
import com.fmont.graficos.Sprite;

/**
 * 
 * @author fmont
 *
 */
public abstract class Tile {

	private Sprite sprite;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param pantalla
	 */
	public void mostrar(int x, int y, Pantalla pantalla) {
	}

	/**
	 * 
	 * @return
	 */
	public boolean solido() {
		return false;
	}

}
