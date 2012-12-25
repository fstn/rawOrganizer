package org.fstn.rawOrganizer.controller.dto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDTO {

	private BufferedImage miniatureImage;
	private BufferedImage originalImage;
	private File miniature;
	private File original;

	public ImageDTO(File miniature, File original) {
		super();
		this.miniature = miniature;
		this.original = original;
	}

	public BufferedImage getMiniature() {
		if (miniatureImage == null) {
			try {
				miniatureImage = ImageIO.read(miniature);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return miniatureImage;
	}

	public BufferedImage getOriginal() {
		if (originalImage == null) {
			try {
				originalImage = ImageIO.read(original);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return originalImage;

	}

	public void setImage(BufferedImage image) {
		this.miniatureImage = image;
	}

	public String getUrl() {
		return original.getAbsolutePath();
	}

	public String getName() {
		return original.getName();
	}
}
