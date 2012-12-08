package org.fstn.rawOrganizer.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;

import fr.zambaux.picsSorting.Session.Session;
import fr.zambaux.picsSorting.event.InitializedEvent;
import fr.zambaux.picsSorting.event.ViewEvent;
import fr.zambaux.picsSorting.event.ViewListener;
import fr.zambaux.picsSorting.view.PicsViewer;

public class PicsViewerController implements ViewListener {

	private PicsViewer picsViewer;

	public PicsViewerController() {
		Session.getInstance().addViewListener(this);
	}

	public PicsViewer getPicsViewer() {
		return picsViewer;
	}

	public void setPicsViewer(PicsViewer picsViewer) {
		this.picsViewer = picsViewer;
	}

	@Override
	public void onEvent(ViewEvent event) {
		if (event.getType() == ViewEvent.FILECHOOSE) {
			System.out.println("dossier choisis: " + event.getArg());
			InitializedEvent initEvent = new InitializedEvent(InitializedEvent.INIT);
			if (event.getArg() != null) {
				File[] files = null;
				File directoryToScan = (File) event.getArg();
				files = directoryToScan.listFiles();
				for (File file : files) {
					String fileName = file.getName();
					if (fileName.contains(".")) {

						try {
							String shortName = fileName.substring(1,
									fileName.lastIndexOf('.'));
							String extension = fileName.substring(fileName
									.lastIndexOf('.') + 1);
							ImageIO.scanForPlugins();
							String[] list = ImageIO.getReaderFormatNames();
							if (file.getName().toUpperCase().endsWith(".NEF")) {
								System.out.printf("Processing %s...\n",
										file.getCanonicalPath());
								final ImageReader reader = (ImageReader) ImageIO
										.getImageReaders(file).next();
								reader.setInput(ImageIO
										.createImageInputStream(file));
								final IIOMetadata metadata = reader
										.getImageMetadata(0);
								BufferedImage image = reader
										.readThumbnail(0, 0);
								initEvent.addImage(image, file.getName(),
										file.getAbsolutePath());
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
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				Session.getInstance().fireEvent(initEvent);
			}
		}
	}

	@Override
	public void finalize() {
		Session.getInstance().removeViewListener(this);
	}

}
