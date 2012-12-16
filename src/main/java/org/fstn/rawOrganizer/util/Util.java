package org.fstn.rawOrganizer.util;

public class Util {
	public static boolean isImage(String fileName) {
		boolean retour = false;
		if (fileName.contains(".nef") || fileName.contains(".jpg")
				|| fileName.contains(".png") || fileName.contains(".NEF")
				|| fileName.contains(".JPG") || fileName.contains(".PNG")) {
			retour = true;
		}
		return retour;
	}
}
