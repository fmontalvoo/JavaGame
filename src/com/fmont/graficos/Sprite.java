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
	private HojaSprites hojaSprites;

	private int x;
	private int y;
	public int[] pixels;

//	Coleccion de sprites
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.desierto);
	public static final Sprite VACIO = new Sprite(32, 0);
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
//				System.out.println(x + "+" + y + "*" + this.tamanioLado + "=" + (x + y * this.tamanioLado));
			}
		}
	}

	public Sprite(final int tamanioLado, final int color) {
		this.tamanioLado = tamanioLado;

		pixels = new int[this.tamanioLado * this.tamanioLado];

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public int getTamanioLado() {
		return tamanioLado;
	}

}
