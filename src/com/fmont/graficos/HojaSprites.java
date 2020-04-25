package com.fmont.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Clase que se encarga de leer los archivos de imagen que contienen los sprites
 * en forma de matriz.
 * 
 * @author fmont
 *
 */
public class HojaSprites {

	private final String url;
	private final int ancho;
	private final int alto;
	public final int[] pixels;

//	Coleccion de hojas de sprites
	public static HojaSprites desierto = new HojaSprites("/texturas/desierto.png", 320, 320);
//	Fin coleccion

	public HojaSprites(final String url, final int ancho, final int alto) {

		this.url = url;
		this.ancho = ancho;
		this.alto = alto;

		pixels = new int[this.ancho * this.alto];

		BufferedImage imagen;
		try {
			imagen = ImageIO.read(HojaSprites.class.getResource(this.url));
			imagen.getRGB(0, 0, this.ancho, this.alto, pixels, 0, this.ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
