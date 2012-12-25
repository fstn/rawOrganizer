package org.fstn.rawOrganizer.view.viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.controller.viewer.PicsViewerController;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.view.PicsThumb;
import org.fuid.Session;
import org.fuid.annotation.CloseOn;
import org.fuid.annotation.Controller;
import org.fuid.annotation.Location;
import org.fuid.annotation.OpenOn;
import org.fuid.constant.FuidSize;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;

public class PicsViewer extends FuidViewElement implements FuidListener {

	private static final long serialVersionUID = -892494811916202532L;
	private JScrollPane contentScrollImage;
	private JPanel content;

	public PicsViewer() {
		content = new JPanel();
		content.setLayout(new FlowLayout());
		contentScrollImage = new JScrollPane();
		this.setLayout(new BorderLayout());
		this.add(contentScrollImage, BorderLayout.CENTER);
		Session.getInstance().addListener(this);

		contentScrollImage.setViewportView(content);
	}

	public final void clean() {
		Session.getInstance().removeListener(this);
	}

	public final void onEvent(final FuidEvent event) {

		if (event.getType() == EventType.ADD_IMAGE) {
			ImageDTO imageDTO = (ImageDTO) event.getArg();
			PicsThumb picsThumb = new PicsThumb(imageDTO);
			content.add(picsThumb);
		}
	}

	@Override
	public final void onResize(final FuidResizeEvent fuidResizeEvent) {
		int width = (Integer) Session.getInstance().getCurrent()
				.get(FuidSize.WINDOW_WIDTH);
		System.out
				.println("----------------------------------------------------size "
						+ width);
		this.setPreferredSize(new Dimension(width, 400));
		contentScrollImage.setPreferredSize(new Dimension(width, 380));

	}
}
