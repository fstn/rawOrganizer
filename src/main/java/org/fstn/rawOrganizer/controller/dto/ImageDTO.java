package org.fstn.rawOrganizer.controller.dto;

import java.awt.Image;

public class ImageDTO {

	private Image image;
	private String url;
	private String name;
	public ImageDTO(Image image, String url, String name) {
		super();
		this.image = image;
		this.url = url;
		this.name = name;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
