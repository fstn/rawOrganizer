package org.fstn.rawOrganizer.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.fuid.annotation.CloseOn;
import org.fuid.annotation.OpenOn;
import org.fuid.annotation.Top;
import org.fuid.event.FuidEventType;
import org.fuid.view.design.TopElement;

@Top(1)
@OpenOn(event=FuidEventType.INIT)
@CloseOn(event=FuidEventType.CLOSE)
public class MenuCommand extends JPanel implements TopElement {

	public MenuCommand() {
		JButton jb=new JButton("coucou");
		this.add(jb);
		this.setVisible(true);		
	}

}
