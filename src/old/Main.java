package fr.zambaux.picsSorting;


import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import fr.zambaux.picsSorting.controller.MainWindowController;
import fr.zambaux.picsSorting.view.MainWindow;

public class Main {
	private static MainWindow mainWindow;
	private static MainWindowController mainController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Document document = null;
		Element racine;
		String filename="src/META-INF/viewConfiguration.xml";
		 //On cr�e une instance de SAXBuilder
	      SAXBuilder sxb = new SAXBuilder();
	      try
	      {
	         //On cr�e un nouveau document JDOM avec en argument le fichier XML
	         //Le parsing est termin� ;)
	         document = sxb.build(new File(filename));
	         //On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
		      racine = document.getRootElement();
		      //On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
		      List menuPanels = racine.getChild("MenuPanel").getChildren();
		      
		      //On cr�e un Iterator sur notre liste
		      Iterator i = menuPanels.iterator();
		      while(i.hasNext())
		      {
		         //On recr�e l'Element courant � chaque tour de boucle afin de
		         //pouvoir utiliser les m�thodes propres aux Element comme :
		         //selectionner un noeud fils, modifier du texte, etc...
		         Element courant = (Element)i.next();
		         //On affiche le nom de l'element courant
		         System.out.println("courant "+courant.getAttributeValue("class"));
		      }
		   
			 
	      }
	      catch(Exception e){
	    	  
	    	  e.printStackTrace();
	      }

	     
		mainController = new MainWindowController();
		mainWindow = new MainWindow();
		mainWindow.init();
		mainWindow.setVisible(true);
	}

}
