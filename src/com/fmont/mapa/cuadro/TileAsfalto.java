package com.fmont.mapa.cuadro;

import com.fmont.graficos.Pantalla;
import com.fmont.graficos.Sprite;

/**
 * Clase que genera el recuadro para el sprite del asfalto.
 * 
 * @author fmont
 *
 */
public class TileAsfalto extends Tile {

	public TileAsfalto(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrar(x, y, this);
	}

}
