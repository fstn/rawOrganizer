package org.fstn.rawOrganizer.controller.viewer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.event.InitializedEvent;
import org.fstn.rawOrganizer.util.Cache;
import org.fstn.rawOrganizer.util.Util;
import org.fstn.rawOrganizer.view.SessionConstante;
import org.fuid.Session;
import org.fuid.event.FuidEvent;

public class JPGViewerController extends PicsViewerController {

	public void onEvent(FuidEvent event) {
		if (event.getType() == EventType.FILECHOOSE) {
			logger.info(this.getClass().getName()
					+ ": Controller dossier choisi: " + event.getArg());
			InitializedEvent initEvent = new InitializedEvent(
					EventType.SHOWFILES);

			Session.getInstance().fireEvent(initEvent);
			if (event.getArg() != null) {
				File[] files = null;
				File directoryToScan = (File) event.getArg();
				files = directoryToScan.listFiles();

				ArrayList<ImageDTO> sessionThumbs=new ArrayList<ImageDTO>();
				Session.getInstance().getCurrent().put((String) SessionConstante.THUMBS,sessionThumbs);
				
				for (File file : files) {
					String fileName = file.getName();
					if (Util.isImage(fileName) ) {

						try {
							String shortName = fileName.substring(1,
									fileName.lastIndexOf('.'));
							String extension = fileName.substring(fileName
									.lastIndexOf('.') + 1);
							String sessionSelectedType = (String) Session
									.getInstance().getCurrent()
									.get(SessionConstante.SELECTED_FILE_TYPE);

							if (file.getName().toUpperCase().endsWith(".JPG")
									&& sessionSelectedType
											.equals(SessionConstante.JPG) || file.getName().toUpperCase().endsWith(".PNG")
									&& sessionSelectedType
											.equals(SessionConstante.PNG)) {
								logger.info("Processing %s...\n"
										+ file.getCanonicalPath());
								File miniature=Cache.getInstance().getMiniature(file);

								ImageDTO imageDTO=new ImageDTO(miniature,file);
								sessionThumbs.add(imageDTO);
								InitializedEvent addImageEvent = new InitializedEvent(
										EventType.ADD_IMAGE);
								addImageEvent.addImage(imageDTO);

								Session.getInstance().fireEvent(addImageEvent);
							}
						} catch (StringIndexOutOfBoundsException e) {
							logger.log(Level.SEVERE, "", e);
						} catch (IOException e) {
							logger.log(Level.SEVERE, "", e);
						}
					}
				}
			}
		}
	}

}
