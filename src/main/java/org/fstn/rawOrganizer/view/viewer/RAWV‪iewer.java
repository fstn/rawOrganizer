package org.fstn.rawOrganizer.view.viewer;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.fstn.rawOrganizer.controller.viewer.JPGViewerController;
import org.fstn.rawOrganizer.controller.viewer.RAWViewerController;
import org.fstn.rawOrganizer.event.EventType;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Controller;
import org.fuid.annotation.InsertContentPanel;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.event.FuidEventType;

@Location(location = Location.SOUTH)
@OpenOn(event = { EventType.RAW_SELECTED })
@CloseOn(event = { FuidEventType.CLOSE, EventType.RAW_SELECTED, EventType.PNG_SELECTED, EventType.JPG_SELECTED })
@Controller(name = RAWViewerController.class)
public class RAWV‪iewer extends PicsViewer {
}
