package nelsoncca;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CCAProject6 implements ActionListener {

	String name;
	static CCAProject6 cca6 = new CCAProject6();
	static CCAProject5 cca5 = new CCAProject5();
	JFrame frame;
	JTextField jtf;
	JButton button;
	JLabel title;
	JLabel text;
	ImageIcon image;

	public static void main(String[] args) {

		cca6.gui();

	}

	public void gui() {

		frame = new JFrame("Maximize");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocation(550, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		
		jtf = new JTextField();
		jtf.setBounds(675, 310, 150, 20);
		jtf.addActionListener(cca6);
		frame.add(jtf);
		
		button = new JButton("Start Game");
		button.setBounds(675, 600, 200, 50);
		button.addActionListener(cca6);
		frame.add(button);
		
		title = new JLabel("Nelson's Target Practice");
		title.setBounds(640, 25, 450, 150);
		title.setFont(new Font("ComicSans", Font.BOLD, 25));
		frame.add(title);
		
		text = new JLabel("Please enter your name");
		text.setBounds(640, 210, 450, 150);
		frame.add(text);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jtf) {
			name = jtf.getText();
		} else if (e.getSource()==button) {
			if ((jtf.getText().equals(""))==false) {
				System.out.println(name);
				frame.dispose();
				cca5.starter(name);
				cca5.start();
			}
		}
	}

}
