package org.fstn.rawOrganizer.controller.viewer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;

import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.event.InitializedEvent;
import org.fstn.rawOrganizer.util.Util;
import org.fstn.rawOrganizer.view.SessionConstante;
import org.fstn.rawOrganizer.view.viewer.PicsViewer;
import org.fuid.Session;
import org.fuid.controller.Controller;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidListener;

public abstract class PicsViewerController implements FuidListener, Controller {

	Logger logger = Logger.getLogger(PicsViewerController.class
			.getCanonicalName());
	private PicsViewer picsViewer;

	public PicsViewerController() {
		Session.getInstance().addListener(this);
	}

	public PicsViewer getPicsViewer() {
		return picsViewer;
	}

	public void setPicsViewer(PicsViewer picsViewer) {
		this.picsViewer = picsViewer;
	}

	public void onEvent(FuidEvent event) {
	}

	public void clean() {
		Session.getInstance().removeListener(this);
	}

}
