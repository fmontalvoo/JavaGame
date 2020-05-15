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
public class Tile {

	public Sprite sprite;

	public static final int TAMANIO_LADO = 32;

//	Coleccion de tiles
	public static final Tile VACIO = new Tile(Sprite.VACIO);
	public static final Tile ASFALTO = new Tile(Sprite.ASFALTO);
	public static final Tile ARENA = new Tile(Sprite.ARENA);

	public static final Tile LINEA_ASFALTO = new Tile(Sprite.LINEA_ASFALTO);
	public static final Tile LINEA_ASFALTO_R90 = new Tile(Sprite.LINEA_ASFALTO_R90);

	public static final Tile CACTUS = new Tile(Sprite.CACTUS);

	public static final Tile BORDE_ASFALTO = new Tile(Sprite.BORDE_ASFALTO);
	public static final Tile BORDE_ASFALTO_X = new Tile(Sprite.BORDE_ASFALTO_X);
	public static final Tile BORDE_ASFALTO_R90D = new Tile(Sprite.BORDE_ASFALTO_R90D);
	public static final Tile BORDE_ASFALTO_R90I = new Tile(Sprite.BORDE_ASFALTO_R90I);

	public static final Tile ESQUINA_ASFALTO = new Tile(Sprite.ESQUINA_ASFALTO);
	public static final Tile ESQUINA_ASFALTO_X = new Tile(Sprite.ESQUINA_ASFALTO_X);
	public static final Tile ESQUINA_ASFALTO_Y = new Tile(Sprite.ESQUINA_ASFALTO_Y);
	public static final Tile ESQUINA_ASFALTO_XY = new Tile(Sprite.ESQUINA_ASFALTO_XY);

	public static final Tile PIEDRA = new Tile(Sprite.PIEDRA);
	public static final Tile OXIDO = new Tile(Sprite.OXIDO);

	public static final Tile BORDE_PUERTA = new Tile(Sprite.BORDE_PUERTA);
	public static final Tile BORDE_PUERTA_X = new Tile(Sprite.BORDE_PUERTA_X);

	public static final Tile ESQUINA_PUERTA = new Tile(Sprite.ESQUINA_PUERTA);
	public static final Tile ESQUINA_PUERTA_X = new Tile(Sprite.ESQUINA_PUERTA_X);

	public static final Tile ARCO_PUERTA = new Tile(Sprite.ARCO_PUERTA);
//	Fin coleccion

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Dibuja el tile en la pantalla de juego.
	 * 
	 * @param x
	 * @param y
	 * @param pantalla
	 */
	public void mostrar(int x, int y, Pantalla pantalla) {
//		System.out.println(x + " , " + y + " | " + (x << 5) + ", " + (y << 5));
		pantalla.mostrar(x << 5, y << 5, this);
	}

	/**
	 * Determina si el tile se puede atravesar o no por el jugador.
	 * 
	 * @return
	 */
	public boolean solido() {
		return false;
	}

}
