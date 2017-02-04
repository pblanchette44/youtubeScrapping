package testScrap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;

import com.jaunt.NotFound;
import com.jaunt.ResponseException;

public class GUI implements masterInterface {

	launchscrap theLaunchScrap;
	database guiDatabase;
	private Gui_list theList;
	private Gui_InfoPane theInfoPane;

	public void start() {

		JPanel content = initContentFrame();
		content.setBorder(BorderFactory.createLineBorder(Color.black));
		content.setBackground(Color.blue);
		
		theList = new Gui_list();
		theList.topGui = this;
		content.add(theList.listDisplay);

		
		theInfoPane = new Gui_InfoPane();
		theInfoPane.topGui = this;
		theInfoPane.listContent = theList.listContent;
		content.add(theInfoPane.infoPane);
		theList.theInfoPane = theInfoPane;
		
		/*
		JPanel infoPane = initInfoPanel();
		initControlPanel(infoPane);
		content.add(infoPane);
		*/
		
		JFrame frame = initFrame();
		frame.setContentPane(content);
		frame.pack();
		frame.setVisible(true);
	}

	private JPanel initContentFrame() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
		content.setPreferredSize(new Dimension(640, 480));
		return content;
	}

	private void initControlPanel(JPanel infoPane) {

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		controlPanel.setPreferredSize(new Dimension(400, 280));
		controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		controlPanel.setBackground(Color.white);
		infoPane.add(controlPanel);

		JTextField inputUrl = new JTextField();
		inputUrl.setPreferredSize(new Dimension(400, 10));
		inputUrl.setBorder(BorderFactory.createLineBorder(Color.black));
		inputUrl.setBackground(Color.white);
		inputUrl.setText("enter a youtube Url");
		controlPanel.add(inputUrl);

		JButton startScrapping = new JButton("Start");
		startScrapping.setPreferredSize(new Dimension(100, 100));
		startScrapping.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		startScrapping.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO fix the interface link to init variable
				ArrayList<reference> start = new ArrayList<reference>();
				reference temp = new reference(0,0,inputUrl.getText(),null);
				start.add(temp);
				scrapProcess(start, 2);
				
			}
		});

		controlPanel.add(startScrapping);
	}
	

	private JPanel initInfoPanel() {

		JPanel infoPane = new JPanel();
		infoPane.setPreferredSize(new Dimension(400, 200));
		infoPane.setBorder(BorderFactory.createLineBorder(Color.black));
		infoPane.setLayout(new BoxLayout(infoPane, BoxLayout.Y_AXIS));

		JLabel titleDisplay = new JLabel("Title: ");
		titleDisplay.setPreferredSize(new Dimension(400, 50));
		titleDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(titleDisplay);

		JLabel urlDisplay = new JLabel("url: ");
		urlDisplay.setPreferredSize(new Dimension(400, 50));
		urlDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(urlDisplay);

		JLabel viewDisplay = new JLabel("Views: ");
		viewDisplay.setPreferredSize(new Dimension(400, 50));
		viewDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(viewDisplay);

		JLabel durationDisplay = new JLabel("Duration: ");
		durationDisplay.setPreferredSize(new Dimension(400, 50));
		durationDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(durationDisplay);
		return infoPane;

	}

	

	private JFrame initFrame() {

		JFrame frame = new JFrame("Youtube Scraper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel mainLabel = new JLabel();
		mainLabel.setOpaque(true);
		mainLabel.setBackground(Color.BLUE);
		mainLabel.setPreferredSize(new Dimension(640, 480));
		return frame;
		
	}


	public void scrapProcess(ArrayList<reference> baseUrl, int recursion) {
		
		ArrayList<reference> thisGeneration = new ArrayList<reference>();
		HashSet<reference> bob;
		
		if (recursion > 0) {
			System.out.println("The size of the input list is " + baseUrl.size() + " for this generation");
			for (reference s : baseUrl) {
					try {
						theLaunchScrap = new launchscrap(s.url);
						theLaunchScrap.formatReference();
						guiDatabase.addListToDatabase(theLaunchScrap.outputReferences());
						thisGeneration.addAll(theLaunchScrap.outputReferences());
						bob = new HashSet<reference>(thisGeneration);
						thisGeneration.clear();
						thisGeneration.addAll(bob);
						theList.updateListDisplay(thisGeneration,recursion);
					} catch (NotFound e) {
						e.printStackTrace();
					} catch (ResponseException e) {
						e.printStackTrace();
					}
			}
			int temp = recursion - 1;
			System.out.println("The index of this generation is  " + recursion);
			scrapProcess(thisGeneration,temp);
			
		}	
	}
	
	

}
