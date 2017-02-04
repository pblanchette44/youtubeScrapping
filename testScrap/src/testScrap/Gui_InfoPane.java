package testScrap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui_InfoPane {

	public JPanel infoPane ;
	public DefaultListModel listContent;
	public GUI topGui;
	
	private JLabel titleDisplay;
	private JLabel urlDisplay;
	private JLabel viewDisplay;
	private JLabel durationDisplay;
	
	
	Gui_InfoPane()
	{
		
		infoPane = initInfoPanel();
		initControlPanel(infoPane);
	}
	
	private JPanel initInfoPanel() {

		JPanel infoPane = new JPanel();
		infoPane.setPreferredSize(new Dimension(400, 200));
		infoPane.setBorder(BorderFactory.createLineBorder(Color.black));
		infoPane.setLayout(new BoxLayout(infoPane, BoxLayout.Y_AXIS));

		titleDisplay = new JLabel("Title: ");
		titleDisplay.setPreferredSize(new Dimension(400, 50));
		titleDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(titleDisplay);

		urlDisplay = new JLabel("url: ");
		urlDisplay.setPreferredSize(new Dimension(400, 50));
		urlDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(urlDisplay);

		viewDisplay = new JLabel("Views: ");
		viewDisplay.setPreferredSize(new Dimension(400, 50));
		viewDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(viewDisplay);

		durationDisplay = new JLabel("Duration: ");
		durationDisplay.setPreferredSize(new Dimension(400, 50));
		durationDisplay.setHorizontalTextPosition(JLabel.LEFT);
		infoPane.add(durationDisplay);
		return infoPane;

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
				topGui.scrapProcess(start, 3 );
			}
		});

		controlPanel.add(startScrapping);
	}

	public void updateDisplayedInfo(reference ref) {
		
		titleDisplay.setText(ref.title);
		urlDisplay.setText(ref.url);
		durationDisplay.setText(new String ("Duration: " + ref.duration));
		viewDisplay.setText("Views: " + ref.views);
		
	}
	
	
	
	
	
}
