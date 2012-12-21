package org.fstn.rawOrganizer.controller;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.util.Util;
import org.fuid.FuidRunner;
import org.fuid.Session;
import org.fuid.controller.Controller;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidListener;

public class FileChooserController implements FuidListener,Controller {
	private static final long serialVersionUID = 1L;
	private PicsViewerController picsViewerController;

	Logger logger=Logger.getLogger(FileChooserController.class.getCanonicalName());

	public FileChooserController() {
		Session.getInstance().addListener(this);
		picsViewerController = new PicsViewerController();
	}

	public void onEvent(FuidEvent event) {
		if (event.getType() == EventType.FILECHOOSE) {
			logger.info(this.getClass().getName()+": Controller dossier choisi: " + event.getArg());			
			if (event.getArg() != null) {
				File[] files = null;
				File directoryToScan = (File) event.getArg();
				files = directoryToScan.listFiles();
				for (File file : files) {
					String fileName = file.getName();
					if (Util.isImage(fileName)) {
						try {
							String shortName = fileName.substring(1,
									fileName.lastIndexOf('.'));
							String extension = fileName.substring(fileName
									.lastIndexOf('.') + 1);
							if (extension.equals("NEF")) {
								if (!(fileName.contains(shortName + ".JPG") && fileName.contains(shortName + ".jpg"))) {
									logger.info("fichiers sans jpg: "
											+ file);
								}
							}
						} catch (StringIndexOutOfBoundsException e) {
							logger.log(Level.SEVERE,fileName,e);
						}
					}
				}
			}
		}
	}

	public void clean(){
		Session.getInstance().removeListener(this);		
	}
	@Override
	public void finalize() {
		picsViewerController = null;
	}
}
