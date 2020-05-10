package com.fmont.mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.fmont.mapa.cuadro.Tile;

public class CargarMapa extends Mapa {

	private int[] pixels;

	public CargarMapa(String url) {
		super(url);
	}

	@Override
	protected void cargarMapa(String url) {
		try {
			BufferedImage imagen = ImageIO.read(CargarMapa.class.getResource(url));

			this.ancho = imagen.getWidth();
			this.alto = imagen.getHeight();

			this.cuadros = new Tile[this.ancho * this.alto];
			this.pixels = new int[this.ancho * this.alto];

//			Convierte la imagen en pixeles y los escribe en el array pixels.
			imagen.getRGB(0, 0, this.ancho, this.alto, pixels, 0, this.ancho);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void generarMapa() {
		for (int i = 0; i < pixels.length; i++) {
			switch (pixels[i]) {
			case 0xff575757:
				this.cuadros[i] = Tile.ASFALTO;
				continue;
			case 0xffa48964:
				this.cuadros[i] = Tile.ARENA;
				continue;
			case 0xffa8a8a8:
				this.cuadros[i] = Tile.LINEA_ASFALTO;
				continue;
			case 0xff84b750:
				this.cuadros[i] = Tile.CACTUS;
				continue;
			case 0xff696969:
				this.cuadros[i] = Tile.BORDE_ASFALTO;
				continue;
			case 0xffcdcdcd:
				this.cuadros[i] = Tile.ESQUINA_ASFALTO;
				continue;
			case 0xff9e9e9e:
				this.cuadros[i] = Tile.PIEDRA;
				continue;
			case 0xff712c1e:
				this.cuadros[i] = Tile.OXIDO;
				continue;
			case 0xffb56641:
				this.cuadros[i] = Tile.BORDE_PUERTA;
				continue;
			case 0xff8c3824:
				this.cuadros[i] = Tile.ESQUINA_PUERTA;
				continue;
			case 0xff672d27:
				this.cuadros[i] = Tile.ARCO_PUERTA;
				continue;
			default:
				this.cuadros[i] = Tile.VACIO;
				continue;
			}
		}
	}

}
