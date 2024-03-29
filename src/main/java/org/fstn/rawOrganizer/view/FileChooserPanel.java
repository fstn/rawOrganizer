package org.fstn.rawOrganizer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fstn.rawOrganizer.controller.FileChooserController;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.view.component.FileChooser;
import org.fuid.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Construct;
import org.fuid.annotation.Controller;
import org.fuid.annotation.InsertContentPanel;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

@Location(location = Location.EAST)
@OpenOn(event = { EventType.RAW_SELECTED, EventType.JPG_SELECTED, EventType.PNG_SELECTED })
@CloseOn(event = { FuidEventType.CLOSE })
@Controller(name = FileChooserController.class)
public class FileChooserPanel extends JScrollPane implements FuidViewElement, FuidListener {

	private static final long	serialVersionUID	= 7351344948672669667L;
	private FileChooser			fileChooser;

	@InsertContentPanel(layout = BorderLayout.class)
	private JPanel				content;

	@Construct
	public void init() {
		Session.getInstance().addListener(this);
		fileChooser = new FileChooser();
		content.add(fileChooser, BorderLayout.WEST);
		Session.getInstance().fireEvent(new FuidEvent(FuidEventType.REPACK, null));
	}

	@Override
	public final void setVisible(final boolean b) {

		super.setVisible(b);
	}

	public final void clean() {
		Session.getInstance().removeListener(this);
	}

	public final void onEvent(final FuidEvent event) {
		// TODO Auto-generated method stub

	}

	public final void onResize(final FuidResizeEvent fuidResizeEvent) {
		// TODO Auto-generated method stub

	}

}
