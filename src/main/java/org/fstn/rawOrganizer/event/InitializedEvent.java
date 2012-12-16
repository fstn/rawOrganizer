package org.fstn.rawOrganizer.event;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fuid.event.FuidEvent;

public class InitializedEvent extends FuidEvent{
	public static int INIT = 1;

	public InitializedEvent(String type) {
		super(type,null);
		arg = new ArrayList<ImageDTO>();
		
	}

	public void addImage(BufferedImage image, String name, String url) {
		((ArrayList<ImageDTO>)arg).add(new ImageDTO(image, url, name));
	}
}
