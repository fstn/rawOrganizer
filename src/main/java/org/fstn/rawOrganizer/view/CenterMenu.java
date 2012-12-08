package org.fstn.rawOrganizer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.fstn.rawOrganizer.event.ViewEvent;
import org.fstn.rawOrganizer.util.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEventType;
import org.fuid.view.design.TopElement;

@Location(location = Location.CENTER, index = 1)
@OpenOn(event=FuidEventType.INIT)
@CloseOn(event=FuidEventType.CLOSE)
public class CenterMenu extends JPanel implements TopElement {

	public CenterMenu() {
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}
	FileChooser fileChooser;
	PicsViewer picsVIewer;
	public MainWindow() throws HeadlessException {
		Session.getInstance().addViewListener(this);
	}
	public void init(){
		picsVIewer=new PicsViewer();
		TopMenu topMenu=new TopMenu();
		fileChooser=new FileChooser();
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout mainLayout=new BorderLayout();
		this.setLayout(mainLayout);
		
		this.add(topMenu,BorderLayout.NORTH);
		this.add(fileChooser,BorderLayout.WEST);
		this.add(picsVIewer,BorderLayout.EAST);
		
		this.pack();
		// TODO Auto-generated method stub
	}
	
	@Override
	public void setVisible(boolean b) {
		
		super.setVisible(b);
	}
	@Override
	public void finalize(){
		Session.getInstance().removeViewListener(this);
	}
	@Override
	public void onEvent(ViewEvent event) {
		if(event.getType()==ViewEvent.ASK4RELOAD)
			this.pack();		
	}

}
