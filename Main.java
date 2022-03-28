import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
	JButton b1,b2;
	JTextField t1;
	Main(){
		setBounds(400, 200, 1200, 500);
		getContentPane().setBackground(Color.WHITE);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ic/login.jpeg"));
		setLayout(null);
		JLabel a = new JLabel(img);
		a.setBounds(0, 0, 600, 500);
		add(a);
		
		JLabel b = new JLabel("Quiz Game");
		b.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
		b.setForeground(Color.blue);
		b.setBounds(750, 40, 300, 45);
		add(b);
		
		JLabel c = new JLabel("Enter Your Name	");
		c.setFont(new Font("Raleway", Font.BOLD, 18));
		c.setForeground(Color.black);
		c.setBounds(800, 140, 300, 20);
		add(c);
		
		t1 = new JTextField();
		t1.setBounds(735, 180, 300, 25);
		t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(t1);
		
		b1 = new JButton("Rules");
		b1.setBounds(735, 250, 120, 25);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Exit");
		b2.setBounds(915, 250, 120, 25);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==b1) {
			String name = t1.getText();
			this.setVisible(false);
			new Rules(name);
		}
		else {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
