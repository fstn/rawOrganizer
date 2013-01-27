package org.fstn.rawOrganizer.view.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import org.fstn.rawOrganizer.controller.dto.ImageDTO;
import org.fstn.rawOrganizer.event.EventType;
import org.fstn.rawOrganizer.view.component.PicsThumb;
import org.fuid.Session;
import org.fuid.constant.FuidSize;
import org.fuid.event.FuidEvent;
import org.fuid.event.FuidEventType;
import org.fuid.event.FuidListener;
import org.fuid.event.FuidResizeEvent;
import org.fuid.view.FuidViewElement;
import org.fuid.view.component.ImageButton;

public class PicsViewer extends JPanel implements FuidViewElement, FuidListener, MouseListener {

	private static final long	serialVersionUID	= -892494811916202532L;
	private JScrollPane			contentScrollImage;
	private JPanel				content;
	private ImageButton			next;
	private ImageButton			previous;
	private Timer				timer;

	public PicsViewer() {
		content = new JPanel();
		content.setLayout(new FlowLayout());
		content.setBackground(Color.BLACK);
		contentScrollImage = new JScrollPane();
		this.setLayout(new BorderLayout());
		previous = new ImageButton("/previous.png", "backScrollViewPanel");
		next = new ImageButton("/next.png", "nextScrollViewPanel");
		previous.addMouseListener(this);
		next.addMouseListener(this);
		this.add(previous, BorderLayout.WEST);
		this.add(next, BorderLayout.EAST);
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
			Session.getInstance().fireEvent(new FuidEvent(FuidEventType.REPACK, null));
			content.update(this.getGraphics());
		}
	}

	public final void onResize(final FuidResizeEvent fuidResizeEvent) {
		int width = (Integer) Session.getInstance().getCurrent().get(FuidSize.WINDOW_WIDTH);
		this.setPreferredSize(new Dimension(width - 20, 120));
		contentScrollImage.setPreferredSize(new Dimension(width - 120, 120));

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(next)) {
			timer = new Timer(50, new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int initValue = contentScrollImage.getHorizontalScrollBar().getValue();
					contentScrollImage.getHorizontalScrollBar().setValue(initValue + 25);
				}
			});
			timer.start();
		} else {
			timer = new Timer(50, new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int initValue = contentScrollImage.getHorizontalScrollBar().getValue();
					contentScrollImage.getHorizontalScrollBar().setValue(initValue - 25);
				}
			});
			timer.start();
		}
	}

	public void mouseExited(MouseEvent e) {
		timer.stop();
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
