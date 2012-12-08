package fr.zambaux.picsSorting.view;

import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.fstn.rawOrganizer.event.ViewEvent;
import org.fstn.rawOrganizer.util.Session;

public class FileChooser extends Panel {

	public FileChooser() {
		super();
		JFileChooser jfChooser = new JFileChooser();
		this.add(jfChooser);
		jfChooser.setCurrentDirectory(new File("C:/"));
		jfChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfChooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Session.getInstance().fireEvent(new ViewEvent(ViewEvent.FILECHOOSE, ((JFileChooser)arg0.getSource()).getSelectedFile()));				
			}
		});
	}

	public FileChooser(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

}
