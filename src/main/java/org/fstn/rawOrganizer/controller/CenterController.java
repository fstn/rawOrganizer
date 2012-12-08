package org.fstn.rawOrganizer.controller;

import java.io.File;

import org.fstn.rawOrganizer.event.ViewEvent;
import org.fstn.rawOrganizer.event.ViewListener;
import org.fstn.rawOrganizer.util.Session;

public class CenterController implements ViewListener{
	private static final long serialVersionUID = 1L;
	private PicsViewerController picsViewerController;
	public CenterController() {
		Session.getInstance().addViewListener(this);
		picsViewerController =new PicsViewerController();
		
	}
	@Override
	public void onEvent( ViewEvent event){
		if(event.getType()==ViewEvent.FILECHOOSE){
			System.out.println("dossier choisi: "+event.getArg());	
			if(event.getArg()!=null){
				File[] files = null; 
				File directoryToScan = (File)event.getArg(); 
				files = directoryToScan.listFiles(); 
				for(File file: files){
					String fileName=file.getName();
					if(fileName.contains(".")){
						String shortName=fileName.substring(1, fileName.lastIndexOf('.') );
						String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
						if(extension.equals("NEF")){
							if(!fileName.contains(shortName+".JPG")){
								System.out.println("fichiers sans jpg: "+file);
							}
						}
					}
				}
			}
		}
	}
	@Override
	public void finalize(){
		Session.getInstance().removeViewListener(this);
		picsViewerController=null;
	}
}
