package testScrap;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui_list {

	public JList list;
	public DefaultListModel listContent;
	public JScrollPane listDisplay;
	public Gui_InfoPane theInfoPane;
	public GUI topGui;
	
	Gui_list()
	{
		
		list = new JList<reference>();
		listContent = new DefaultListModel();
		
		list.setModel(listContent);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		listDisplay = new JScrollPane(list);
		listDisplay.setPreferredSize(new Dimension(300, 450));
		listDisplay.setViewportBorder(BorderFactory.createLineBorder(Color.black));
		
		list.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent arg0) {
				
				//send the infos from the reference object to the gui_infoPane
				theInfoPane.updateDisplayedInfo(topGui.guiDatabase.getRef(list.getSelectedIndex()));
				//theInfoPane.updateDisplayedInfo(topGui.guiDatabase.getRef(list.getSelectedIndex(),listContent.get(list.getSelectedIndex()).toString().charAt(0)));
				
			}
			
		});
		
	}
	
	public void updateList(String inputName) {
				
		listContent.addElement(inputName);
		
	}

	public void cleanList() {
	
		listContent.clear();
	
	}
	
	public void updateListDisplay(ArrayList<reference> allTitle, int generation)
	{
		
		int count = 0;
		for(reference s: allTitle)
		{
			count++;
			
			String temp = new String(generation-1 +""+ count + "  " + s.title.trim());
			listContent.addElement(temp);
		}
		
	}
	
}
