package org.fstn.rawOrganizer.controller.dto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDTO {

	private BufferedImage	miniatureImage;
	private BufferedImage	originalImage;
	private File			miniature;
	private File			original;

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
				int originalImageWidth = originalImage.getWidth();
				int originalImageHeight = originalImage.getHeight();
				int[] originalRGB = new int[(originalImageWidth) * (originalImageHeight)];
				originalImage.getRGB(0, 0, originalImageWidth, originalImageHeight, originalRGB, 0, originalImageWidth);
				
				int finalImageWidth = originalImage.getWidth() + 400;
				int finalImageHeight = originalImage.getHeight() + 400;
				BufferedImage finalImage = new BufferedImage(finalImageWidth, finalImageHeight, BufferedImage.TYPE_INT_RGB);
				int[] finalRGB = new int[(finalImageWidth) * (finalImageHeight)];
				for (int i = 0; i < finalRGB.length; i++) {
					finalRGB[i] = 0;
				}

				for (int originalIndexY = 0; originalIndexY < originalImageHeight; originalIndexY++) {
					for (int originalIndexX = 0; originalIndexX < originalImageWidth; originalIndexX++) {
						int finalIndexX = 200 + originalIndexX;
						int finalIndexY = 200 + originalIndexY;

						int originalIndex = originalIndexY * originalImageWidth + originalIndexX;
						int finalIndex = finalIndexY * finalImageWidth + finalIndexX;
						finalRGB[finalIndex] = originalRGB[originalIndex];
					}
				}
				for (int finalIndexY = 0; finalIndexY < finalImageHeight; finalIndexY++) {
					for (int finalIndexX = 0; finalIndexX < finalImageWidth; finalIndexX++) {
						int finalIndex = finalIndexY * finalImageWidth + finalIndexX;
						finalImage.setRGB(finalIndexX, finalIndexY, finalRGB[finalIndex]);
					}
				}
				originalImage = finalImage;
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
