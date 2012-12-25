package org.fstn.rawOrganizer.controller;

import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.view.SessionConstante;
import org.fuid.Session;
import org.fuid.controller.Controller;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidListener;

public class OpenController implements Controller,FuidListener {
	public OpenController(){
		Session.getInstance().addListener(this);
	}

	public void onEvent(FuidEvent event) {
		if(event.getType().equals(EventType.RAW_SELECTED)){
			Session.getInstance().getCurrent().put(SessionConstante.SELECTED_FILE_TYPE, SessionConstante.RAW);
		}else if(event.getType().equals(EventType.PNG_SELECTED)){
			Session.getInstance().getCurrent().put(SessionConstante.SELECTED_FILE_TYPE, SessionConstante.PNG);		
		}else if(event.getType().equals(EventType.JPG_SELECTED)){
			Session.getInstance().getCurrent().put(SessionConstante.SELECTED_FILE_TYPE, SessionConstante.JPG);			
			}
		
	}

	public void clean() {
		Session.getInstance().removeListener(this);
	}

}
