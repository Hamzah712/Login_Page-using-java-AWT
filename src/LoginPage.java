import java.awt.*;
import java.awt.event.*;

public class LoginPage extends WindowAdapter implements ActionListener {
	
		//declaring elements
	Frame loginFrame = new Frame();
	
	//Labels
	Label userIDLabel = new Label("UserID: ");
	Label userPasswordLabel = new Label("password: ");
	Label messageLabel = new Label();
	Label messageLabel2 = new Label();
	
	//TextFields
	TextField userIDField = new TextField();
	TextField userPasswordField = new TextField();
	
	//Buttons
	Button loginButton = new Button("login");
	Button resetButton = new Button("reset");
	
	LoginPage(){
		
		//Layout
		messageLabel.setText("Hello :)");
		messageLabel.setBounds(125,30,250,35);
		messageLabel.setFont(new Font(null, Font.PLAIN,25));
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		userPasswordField.setEchoChar('*');
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		
		//Adding Components
		loginFrame.add(messageLabel);
		loginFrame.add(messageLabel2);
		loginFrame.add(userIDLabel);
		loginFrame.add(userPasswordLabel);
		loginFrame.add(userIDField);
		loginFrame.add(userPasswordField);
		loginFrame.add(loginButton);
		loginFrame.add(resetButton);
		
		//frame specks
		loginFrame.setSize(400,300);
		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
		
		loginFrame.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource()== loginButton) {
			String userID = userIDField.getText();
			String userPassword = userPasswordField.getText();
			
			if(userID.equals("admin") && userPassword.equals("123")) {
				loginFrame.dispose();
				WelcomePage welcomePage = new WelcomePage(userID);
			}
			else if(userID.equals("") || userPassword.equals("")) {
				messageLabel.setBounds(100,250,250,25);
				messageLabel.setForeground(Color.RED);
				messageLabel.setFont(new Font(null, Font.PLAIN,12));
				messageLabel.setText("Error! Please make sure all fields are filled.");
				
				messageLabel2.setText("):");
				messageLabel2.setBounds(125,30,250,35);
				messageLabel2.setFont(new Font(null, Font.PLAIN,25));
				
				userIDField.setText("");
				userPasswordField.setText("");
			}
			else {
				messageLabel.setBounds(100,250,250,25);
				messageLabel.setForeground(Color.RED);
				messageLabel.setFont(new Font(null, Font.PLAIN,12));
				messageLabel.setText("Invalid input, please try again");
				
				messageLabel2.setText("):");
				messageLabel2.setBounds(125,30,250,35);
				messageLabel2.setFont(new Font(null, Font.PLAIN,25));
				
				userIDField.setText("");
				userPasswordField.setText("");
			}
		}
	}
	
	public void windowClosing(WindowEvent e) {
		loginFrame.dispose();
	}
}	