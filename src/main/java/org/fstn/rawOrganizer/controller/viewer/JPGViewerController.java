package org.fstn.rawOrganizer.controller.viewer;

import java.io.File;
import java.util.Iterator;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.event.InitializedEvent;
import org.fstn.rawOrganizer.util.Cache;
import org.fstn.rawOrganizer.util.SessionConstante;
import org.fstn.rawOrganizer.util.Util;
import org.fuid.Session;
import org.fuid.event.FuidEvent;

public class JPGViewerController extends PicsViewerController {

	public void onEvent(FuidEvent event) {
		if (event.getType() == EventType.FILECHOOSE) {
			logger.info(this.getClass().getName() + ": Controller dossier choisi: " + event.getArg());
			if (event.getArg() != null) {
				File[] files = null;
				File directoryToScan = (File) event.getArg();
				files = directoryToScan.listFiles();

				// ArrayList<ImageDTO> sessionThumbs=new ArrayList<ImageDTO>();
				// Session.getInstance().getCurrent().put((String)
				// SessionConstante.THUMBS,sessionThumbs);
				String sessionSelectedType = (String) Session.getInstance().getCurrent().get(SessionConstante.SELECTED_FILE_TYPE);
				for (File file : files) {
					String fileName = file.getName();
					if (Util.isImage(fileName)) {
						String shortName = fileName.substring(1, fileName.lastIndexOf('.'));
						String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

						if (file.getName().toUpperCase().endsWith(".JPG") && sessionSelectedType.equals(SessionConstante.JPG)
								|| file.getName().toUpperCase().endsWith(".PNG") && sessionSelectedType.equals(SessionConstante.PNG)) {

							File miniature = Cache.getInstance().getMiniature(file);

							ImageDTO imageDTO = new ImageDTO(miniature, file);
							InitializedEvent addImageEvent = new InitializedEvent(EventType.ADD_IMAGE);
							addImageEvent.addImage(imageDTO);
							Session.getInstance().fireEvent(addImageEvent);
						}
					}
				}
			}
		}
	}

}
