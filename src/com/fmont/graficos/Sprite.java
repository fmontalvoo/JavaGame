package com.fmont.graficos;

/**
 * Esta clase se encarga de extraer cada sprite de forma individual desde la
 * Hoja de Sprites.
 * 
 * @author fmont
 *
 */
public final class Sprite {

//	Variable que almacena el tamaño del lado en pixels de un sprite.
	private final int tamanioLado;
	private final HojaSprites hojaSprites;

	private int x;
	private int y;
	public int[] pixels;

//	Coleccion de sprites
	public static Sprite asfalto = new Sprite(32, 0, 0, HojaSprites.desierto);
//	Fin coleccion

	public Sprite(final int tamanioLado, final int fila, final int columna, final HojaSprites hojaSprites) {
		this.tamanioLado = tamanioLado;
		this.hojaSprites = hojaSprites;

		pixels = new int[this.tamanioLado * this.tamanioLado];

		this.x = fila * this.tamanioLado;
		this.y = columna * this.tamanioLado;

		for (int y = 0; y < this.tamanioLado; y++) {
			for (int x = 0; x < this.tamanioLado; x++) {
				this.pixels[x + y * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

}
