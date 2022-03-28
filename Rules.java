import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
	JButton b1,b2;
	String username;
	Rules(String username){
		this.username = username;
		setBounds(600,200,800,650);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Welcome " + username+ " to Quiz Game");
		l1.setForeground(new Color(30,144,255));
		l1.setFont(new Font("Times New Roman",Font.BOLD,28));
		l1.setBounds(50,20,700,30);
		add(l1);
		
		JLabel l2 = new JLabel("Welcome " + username+ " to Quiz Game");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Raleway",Font.PLAIN,20));
		l2.setBounds(20,90,600,300);
		l2.setText(
				"<html>"+
						"1) It is a mcq test in which only one option can be selected." + "<br><br>"+
						"2) Only one attempt is allowed." + "<br><br>"+
						"3) Cheating is not allowed." + "<br><br>"+
						"4) Exam must be finished whithin alloted time." + "<br><br>"+
						"5) You can't pause during examination." + "<br><br>"+
						"6) All questions are compulsory" + "<br><br>"+
				"<html>"
		);
		add(l2);
		
		b1 = new JButton("Back");
		b1.setBounds(250, 500, 100, 30);
		b1.setBackground(new Color(30,144,250));
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Start");
		b2.setBounds(400, 500, 100, 30);
		b2.setBackground(new Color(30,144,250));
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==b1) {
			this.setVisible(false);
			new Main().setVisible(true);
		}else if(evt.getSource()==b2) {
			this.setVisible(false);
			new Quiz(username).setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rules("");
	}

}
