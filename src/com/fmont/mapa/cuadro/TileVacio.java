package com.fmont.mapa.cuadro;

import com.fmont.graficos.Pantalla;
import com.fmont.graficos.Sprite;

/**
 * Clase que genera el recuadro para un sprite vacio.
 * 
 * @author fmont
 *
 */
public class TileVacio extends Tile {

	public TileVacio(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrar(x, y, this);
	}

}
