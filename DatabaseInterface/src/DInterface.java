import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class DInterface extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DInterface window = new DInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 989, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 23));
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();              //creates the menu bar
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");               //Adds the menu File
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mAbout = new JMenuItem("About");     //Adds the about menu item in File
		mnFile.add(mAbout);
		mAbout.setMnemonic(KeyEvent.VK_A);
		mAbout.setToolTipText("Go to about page");
		
		mAbout.addActionListener((ActionEvent event) -> { //changes the main textview to display developer information
			textArea.setText("Application and Software Developers:" + "\nAustin Hobson and Kevin Richmond");
			//aboutFrame aFrame = new aboutFrame();
				//aFrame.setVisible(true);
		});
		
		JMenuItem mExit = new JMenuItem("Exit");         //Adds the menu item exit in File
		mnFile.add(mExit);
		mExit.setMnemonic(KeyEvent.VK_E);
		mExit.setToolTipText("Exit application");
		
	
		mExit.addActionListener((ActionEvent event) -> {   //Event listener to exit
            System.exit(0);
        });
		
		JMenu mDisplay = new JMenu("Display");           //Adds the menu Display
		mDisplay.setMnemonic(KeyEvent.VK_D);
		menuBar.add(mDisplay);
		
		JMenu mnAdd = new JMenu("Add");                  //Adds the menu Add
		menuBar.add(mnAdd);
		
		JMenu mnRemove = new JMenu("Remove");            //Adds the menu remove
		menuBar.add(mnRemove);
		
		
		JMenuItem mDisplayAllMembers = new JMenuItem("Display all members of the congregation");    //Adds the menu item display congregation in Display
		mDisplay.add(mDisplayAllMembers);
		mDisplayAllMembers.setMnemonic(KeyEvent.VK_G);
		mDisplayAllMembers.setToolTipText("Display all members of the congregation");               
		

		mDisplayAllMembers.addActionListener((ActionEvent event) -> {                               //Event listener to display congregation
			Connector.connect();
	       textArea.setText(Connector.printMembers());	
		});
		
	}


}
