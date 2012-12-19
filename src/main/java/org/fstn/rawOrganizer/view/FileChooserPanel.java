package org.fstn.rawOrganizer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JPanel;

import org.fstn.rawOrganizer.controller.FileChooserController;
import org.fstn.rawOrganizer.event.EventType;
import org.fuid.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Controller;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;
import org.fuid.view.design.TopElement;

@Location(location = Location.EAST)
@OpenOn(event = {EventType.RAW_SELECTED,EventType.JPG_SELECTED})
@CloseOn(event = {FuidEventType.CLOSE})
@Controller(name = FileChooserController.class)
public class FileChooserPanel extends JPanel implements TopElement,
		FuidListener {

	FileChooser fileChooser;
	PicsViewer picsVIewer;

	public FileChooserPanel() throws HeadlessException {
		Session.getInstance().addListener(this);
		fileChooser = new FileChooser();
		this.setVisible(true);

		BorderLayout mainLayout = new BorderLayout();
		this.setLayout(mainLayout);
		this.setBackground(Color.BLACK);

		this.add(fileChooser, BorderLayout.WEST);
		Session.getInstance().fireEvent(new FuidEvent(FuidEventType.REPACK,null));
	}

	@Override
	public void setVisible(boolean b) {

		super.setVisible(b);
	}

	
	public void clean() {
		Session.getInstance().removeListener(this);
	}


	public void onEvent(FuidEvent event) {
		// TODO Auto-generated method stub
		
	}

}
