import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends WindowAdapter implements ActionListener {
	
	Frame welcomeFrame = new Frame();
	
	//label
	Label welcomeLabel = new Label();
	
	//buttons
	Button logoutButton = new Button("logout");
	Button exitButton = new Button("Exit");
	
	public WelcomePage(String userID) {
		//Layout
		welcomeLabel.setText("Welcome "+ userID);
		welcomeLabel.setBounds(125,70,250,35);
		welcomeLabel.setForeground(Color.green);
		welcomeLabel.setFont(new Font(null, Font.ITALIC,25));
		
		logoutButton.setBounds(125,200,100,25);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(this);
		
		exitButton.setBounds(225,200,100,25);
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		
		//adding components
		welcomeFrame.add(welcomeLabel);
		welcomeFrame.add(logoutButton);
		welcomeFrame.add(exitButton);
		
		//frame specs
		welcomeFrame.setSize(400,300);
		welcomeFrame.setLayout(null);
		welcomeFrame.setVisible(true);
		
		welcomeFrame.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== logoutButton) {
			welcomeFrame.dispose();
	        LoginPage loginPage = new LoginPage();
			}
		else if(e.getSource()==exitButton) {
			welcomeFrame.dispose();
		}
	}
	public void windowClosing(WindowEvent e) {
		welcomeFrame.dispose();
	}
}
