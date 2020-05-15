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
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, 0, HojaSprites.desierto);
	public static final Sprite ARENA = new Sprite(32, 0, 1, 0, HojaSprites.desierto);

	public static final Sprite LINEA_ASFALTO = new Sprite(32, 0, 2, 0, HojaSprites.desierto);
	public static final Sprite LINEA_ASFALTO_R90 = new Sprite(32, 0, 2, 5, HojaSprites.desierto);

	public static final Sprite CACTUS = new Sprite(32, 0, 3, 0, HojaSprites.desierto);

	public static final Sprite BORDE_ASFALTO = new Sprite(32, 0, 4, 0, HojaSprites.desierto);
	public static final Sprite BORDE_ASFALTO_X = new Sprite(32, 0, 4, 1, HojaSprites.desierto);
	public static final Sprite BORDE_ASFALTO_R90D = new Sprite(32, 0, 4, 5, HojaSprites.desierto);
	public static final Sprite BORDE_ASFALTO_R90I = new Sprite(32, 0, 4, 6, HojaSprites.desierto);

	public static final Sprite ESQUINA_ASFALTO = new Sprite(32, 0, 5, 0, HojaSprites.desierto);
	public static final Sprite ESQUINA_ASFALTO_X = new Sprite(32, 0, 5, 1, HojaSprites.desierto);
	public static final Sprite ESQUINA_ASFALTO_Y = new Sprite(32, 0, 5, 2, HojaSprites.desierto);
	public static final Sprite ESQUINA_ASFALTO_XY = new Sprite(32, 0, 5, 3, HojaSprites.desierto);

	public static final Sprite PIEDRA = new Sprite(32, 0, 6, 0, HojaSprites.desierto);
	public static final Sprite OXIDO = new Sprite(32, 0, 7, 0, HojaSprites.desierto);

	public static final Sprite BORDE_PUERTA = new Sprite(32, 0, 8, 0, HojaSprites.desierto);
	public static final Sprite BORDE_PUERTA_X = new Sprite(32, 0, 8, 1, HojaSprites.desierto);

	public static final Sprite ESQUINA_PUERTA = new Sprite(32, 0, 9, 0, HojaSprites.desierto);
	public static final Sprite ESQUINA_PUERTA_X = new Sprite(32, 0, 9, 1, HojaSprites.desierto);

	public static final Sprite ARCO_PUERTA = new Sprite(32, 1, 0, 0, HojaSprites.desierto);
//	Fin coleccion

	public Sprite(final int tamanioLado, final int fila, final int columna, final int version,
			final HojaSprites hojaSprites) {
		this.tamanioLado = tamanioLado;
		this.hojaSprites = hojaSprites;

		pixels = new int[this.tamanioLado * this.tamanioLado];

		this.x = columna * this.tamanioLado;
		this.y = fila * this.tamanioLado;

		cargarSprite(version);
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

	public void cargarSprite(final int version) {
		switch (version) {
		case 0:
			cargaNormal();
			break;
		case 1:
			invertirX();
			break;
		case 2:
			invertirY();
			break;
		case 3:
			invertirXY();
			break;
		case 4:
			rotar90DerechaInvertirX();
			break;
		case 5:
			rotar90Derecha();
			break;
		case 6:
			rotar90Izquierda();
			break;
		case 7:
			rotar90IzquierdaInvertirX();
			break;
		}
	}

	private void cargaNormal() {
		for (int y = 0; y < this.tamanioLado; y++) {
			for (int x = 0; x < this.tamanioLado; x++) {
				this.pixels[x + y * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
//				System.out.println(x + "+" + y + "*" + this.tamanioLado + "=" + (x + y * this.tamanioLado));
			}
		}
	}

	private void invertirX() {
		for (int y = 0; y < this.tamanioLado; y++) {
			for (int x = this.tamanioLado - 1, x1 = 0; x >= 0; x--, x1++) {
				this.pixels[x1 + y * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

	private void invertirY() {
		for (int y = this.tamanioLado - 1, y1 = 0; y >= 0; y--, y1++) {
			for (int x = 0; x < this.tamanioLado; x++) {
				this.pixels[x + y1 * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

	private void invertirXY() {
		for (int y = this.tamanioLado - 1, y1 = 0; y >= 0; y--, y1++) {
			for (int x = this.tamanioLado - 1, x1 = 0; x >= 0; x--, x1++) {
				this.pixels[x1 + y1 * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

	private void rotar90DerechaInvertirX() {
		for (int x = 0; x < this.tamanioLado; x++) {
			for (int y = 0; y < this.tamanioLado; y++) {
				this.pixels[y + x * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

	private void rotar90Derecha() {
		for (int x = 0; x < this.tamanioLado; x++) {
			for (int y = this.tamanioLado - 1, y1 = 0; y >= 0; y--, y1++) {
				this.pixels[y1 + x * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

	private void rotar90Izquierda() {
		for (int x = this.tamanioLado - 1, x1 = 0; x >= 0; x--, x1++) {
			for (int y = 0; y < this.tamanioLado; y++) {
				this.pixels[y + x1 * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

	private void rotar90IzquierdaInvertirX() {
		for (int x = this.tamanioLado - 1, x1 = 0; x >= 0; x--, x1++) {
			for (int y = this.tamanioLado - 1, y1 = 0; y >= 0; y--, y1++) {
				this.pixels[y1 + x1 * this.tamanioLado] = this.hojaSprites.pixels[(x + this.x)
						+ (y + this.y) * hojaSprites.getAncho()];
			}
		}
	}

}
