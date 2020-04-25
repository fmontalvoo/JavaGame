package com.fmont.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {

	private final String url;
	private final int ancho;
	private final int alto;
	private final int[] pixels;

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

}
