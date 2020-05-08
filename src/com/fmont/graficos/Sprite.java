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
	public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.desierto);
	public static final Sprite ARENA = new Sprite(32, 0, 1, HojaSprites.desierto);
	public static final Sprite LINEA_ASFALTO = new Sprite(32, 0, 2, HojaSprites.desierto);
	public static final Sprite CACTUS = new Sprite(32, 0, 3, HojaSprites.desierto);
	public static final Sprite BORDE_ASFALTO = new Sprite(32, 0, 4, HojaSprites.desierto);
	public static final Sprite ESQUINA_ASFALTO = new Sprite(32, 0, 5, HojaSprites.desierto);
	public static final Sprite PIEDRA = new Sprite(32, 0, 6, HojaSprites.desierto);
	public static final Sprite OXIDO = new Sprite(32, 0, 7, HojaSprites.desierto);
	public static final Sprite BORDE_PUERTA = new Sprite(32, 0, 8, HojaSprites.desierto);
	public static final Sprite ESQUINA_PUERTA = new Sprite(32, 0, 9, HojaSprites.desierto);
	public static final Sprite ARCO_PUERTA = new Sprite(32, 1, 0, HojaSprites.desierto);
//	Fin coleccion

	public Sprite(final int tamanioLado, final int fila, final int columna, final HojaSprites hojaSprites) {
		this.tamanioLado = tamanioLado;
		this.hojaSprites = hojaSprites;

		pixels = new int[this.tamanioLado * this.tamanioLado];

		this.x = columna * this.tamanioLado;
		this.y = fila * this.tamanioLado;

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
