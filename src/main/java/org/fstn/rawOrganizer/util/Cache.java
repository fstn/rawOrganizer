package org.fstn.rawOrganizer.util;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

import org.apache.commons.io.IOUtils;

public class Cache {
	private static double cacheWidth = 100;
	private static double cacheHeight = 100;
	private static Cache instance = new Cache();

	private Cache() {

	}

	public static Cache getInstance() {
		return instance;
	}

	public static void setInstance(Cache instance) {
		Cache.instance = instance;
	}

	public File getMiniature(File file) {
		File miniature = null;
		try {
			int sep = file.getPath().lastIndexOf("/");
			String path = file.getCanonicalPath().substring(0, sep) + "/";
			File cachedDir = new File(path + "/fuidCache");
			if (!cachedDir.isDirectory()) {
				cachedDir.mkdir();
			}
			miniature = new File(cachedDir.getAbsolutePath() + "/"
					+ file.getName());
			if(!miniature.exists()){
				ImageInfo origInfo = new ImageInfo(file.getAbsolutePath());
				MagickImage image = new MagickImage(origInfo);
				Dimension newDim = getScale(image);
				MagickImage smaller = image.scaleImage(newDim.width, newDim.height);
				smaller.setFileName(miniature.getAbsolutePath());
				smaller.writeImage(new ImageInfo(miniature.getAbsolutePath()));
				System.out.println("save " + miniature.getAbsolutePath());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MagickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return miniature;

	}

	private Dimension getScale(MagickImage image) {
		double ratio = 0.0;
		double w=0.0;
		double h=0.0;
		try {
			w = image.getDimension().width;
			h = image.getDimension().height;
			if (cacheWidth / w > cacheHeight / h) {
				ratio = cacheWidth / w;
			} else {
				ratio = cacheHeight / h;
			}
		} catch (MagickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension newDim = new Dimension((int) (ratio * w), (int) (ratio * h));
		System.out.println(w+","+h+" scale to "+newDim.toString());
		return newDim;
	}

}
