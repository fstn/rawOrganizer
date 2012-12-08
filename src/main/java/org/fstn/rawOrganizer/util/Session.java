package org.fstn.rawOrganizer.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.fstn.rawOrganizer.event.InitializedEvent;
import org.fstn.rawOrganizer.event.InitializedListener;
import org.fstn.rawOrganizer.event.ViewEvent;
import org.fstn.rawOrganizer.event.ViewListener;

public class Session implements CDIElement {
	private static Session instance=new Session();
	private Session(){	
		construct();
	}
	
	public static  Session getInstance(){
		return instance;
	}
	private List<InitializedListener> initializedListeners;
	private List<ViewListener> viewListeners;

	public List<InitializedListener> getInitializedListeners() {
		return initializedListeners;
	}
	
	public void addInitializedListener(InitializedListener listener){
		initializedListeners.add(listener);
	}

	public void addViewListener(ViewListener listener){
		viewListeners.add(listener);
	}

	public void removeInitializedListener(InitializedListener listener){
		initializedListeners.remove(listener);
	}

	public void removeViewListener(ViewListener listener){
		viewListeners.remove(listener);
	}
	
	public void fireEvent(InitializedEvent event) {
		for (InitializedListener listener: initializedListeners){
			listener.onEvent(event);
		}
	}

	public void fireEvent(ViewEvent event) {
		for (ViewListener listener: viewListeners){
			listener.onEvent(event);
		}
	}
	
	@Override
	@PostConstruct
	public void construct() {
		initializedListeners = new ArrayList<>();
		viewListeners=new ArrayList<>();
	}

	@Override
	@PreDestroy
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
