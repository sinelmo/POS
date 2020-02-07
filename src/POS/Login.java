package POS;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Login extends JFrame {
	JScrollPane scrollPane;
	ImageIcon icon;
	public Login(){
		icon = new ImageIcon("./image/cat.jpg");
		JPanel panel = new JPanel(){

			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponents(g);

			}
		};
		placeComponents(panel);
		scrollPane = new JScrollPane(panel);
		setContentPane(scrollPane);
	}
	static Login frame = new Login();

	public static void main(String[] args) {
		//Login2 frame = new Login2();
		frame.setTitle("POS");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 100, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 100, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 130, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 130, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(180, 170, 80, 25);
		panel.add(loginButton);

		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dbconn db = new dbconn();
				if(userText.getText().equals(db.id) && new String(passwordText.getPassword()).equals(db.pw)){
					posmain.main();
				} // new String 인코딩
				else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
			}

		});
	}
}
