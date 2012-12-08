package org.fstn.rawOrganizer.event;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;

public class InitializedEvent {
	public static int INIT = 1;
	private int type;
	private List<ImageDTO> listImages;

	public InitializedEvent(int type) {
		this.type = type;
		listImages = new ArrayList<ImageDTO>();
	}

	public List<ImageDTO> getListImages() {
		return listImages;
	}

	public void setListImages(List<ImageDTO> listImages) {
		this.listImages = listImages;
	}

	public void addImage(BufferedImage image, String name, String url) {
		listImages.add(new ImageDTO(image, url, name));
	}
}
