package org.fstn.rawOrganizer.controller;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.fstn.rawOrganizer.controller.viewer.PicsViewerController;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.util.Util;
import org.fuid.FuidRunner;
import org.fuid.Session;
import org.fuid.controller.Controller;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidListener;

public class FileChooserController implements FuidListener, Controller {
	private static final long serialVersionUID = 1L;
	private PicsViewerController picsViewerController;

	Logger logger = Logger.getLogger(FileChooserController.class
			.getCanonicalName());

	public FileChooserController() {
		Session.getInstance().addListener(this);
	}

	public void onEvent(FuidEvent event) {
	}

	public void clean() {
		Session.getInstance().removeListener(this);
	}

	@Override
	public void finalize() {
		picsViewerController = null;
	}
}
