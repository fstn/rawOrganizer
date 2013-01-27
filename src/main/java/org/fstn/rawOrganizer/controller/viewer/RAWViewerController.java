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
import org.fstn.rawOrganizer.util.SessionConstante;
import org.fstn.rawOrganizer.util.Util;
import org.fstn.rawOrganizer.view.viewer.PicsViewer;
import org.fuid.Session;
import org.fuid.controller.Controller;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidListener;

public class RAWViewerController implements FuidListener, Controller {

	Logger logger = Logger.getLogger(RAWViewerController.class
			.getCanonicalName());
	private PicsViewer picsViewer;

	public RAWViewerController() {
		Session.getInstance().addListener(this);
	}

	public PicsViewer getPicsViewer() {
		return picsViewer;
	}

	public void setPicsViewer(PicsViewer picsViewer) {
		this.picsViewer = picsViewer;
	}

	public void onEvent(FuidEvent event) {
		if (event.getType() == EventType.FILECHOOSE) {
			logger.info(this.getClass().getName()
					+ ": Controller dossier choisi: " + event.getArg());
			InitializedEvent initEvent = new InitializedEvent(
					EventType.SHOWFILES);
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
							ImageIO.scanForPlugins();
							String[] list = ImageIO.getReaderFormatNames();
							String sessionSelectedType = (String) Session
									.getInstance().getCurrent()
									.get(SessionConstante.SELECTED_FILE_TYPE);
							if (file.getName().toUpperCase().endsWith(".NEF")
									&& sessionSelectedType
											.equals(SessionConstante.RAW)) {
								logger.info("Processing %s...\n"
										+ file.getCanonicalPath());
								final ImageReader reader = (ImageReader) ImageIO
										.getImageReaders(file).next();
								reader.setInput(ImageIO
										.createImageInputStream(file));
								final IIOMetadata metadata = reader
										.getImageMetadata(0);
								BufferedImage image = reader
										.readThumbnail(0, 0);
								//initEvent.addImage(image, file.getName(),
									//	file.getAbsolutePath());
								/**
								 * final NEFMetadata nefMetadata = (NEFMetadata)
								 * metadata; final IFD exifIFD =
								 * nefMetadata.getExifIFD(); final TagRational
								 * focalLength = exifIFD.getFocalLength();
								 **/
								/**
								 * IFD exifIFD = nefMetadata.get .getExifIFD();
								 * exifIFD.getImageDescription(); TagRational
								 * focalLength = exifIFD.getFocalLength();
								 * System
								 * .out.println(focalLength.doubleValue());
								 */

							}
						} catch (StringIndexOutOfBoundsException e) {
							logger.log(Level.SEVERE, "", e);

						} catch (IOException e) {
							logger.log(Level.SEVERE, "", e);
						}
					}
				}
				Session.getInstance().fireEvent(initEvent);
			}
		}
	}

	public void clean() {
		Session.getInstance().removeListener(this);
	}

}
