package com.fmont.mapa.cuadro;

import com.fmont.graficos.Pantalla;
import com.fmont.graficos.Sprite;

/**
 * Clase abstracta encargada de definir limites o marcos a los sprites para
 * mostrarlos en el juego en funcion de sus coordenadas con respecto a X e Y.
 * 
 * @author fmont
 *
 */
public abstract class Tile {

	public Sprite sprite;

//	Coleccion de tiles
	public static final Tile ASFALTO = new TileAsfalto(Sprite.ASFALTO);
	public static final Tile VACIO = new TileVacio(Sprite.VACIO);
//	Fin coleccion

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
		pantalla.mostrar(x << 5, y << 5, this);
	}

	/**
	 * 
	 * @return
	 */
	public boolean solido() {
		return false;
	}

}
