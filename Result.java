 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Result extends JFrame implements ActionListener{
	
	Result(String username,int result){
		setBounds(600, 150,750,550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("ic/download (1).jfif"));
		JLabel I = new JLabel(i);
		I.setBounds(10, 10, 400, 100);
		add(I);
		
		JLabel l1 = new JLabel("Thanks for "+username+" attending quiz!");
		l1.setBounds(45, 350, 300, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Your score is "+ result);
		l2.setBounds(45, 150, 300, 30);
		l2.setFont(new Font("Times New Roman",Font.BOLD,27));
		add(l2);
		
		JButton b1 = new JButton("Start Again");
		b1.setBackground(Color.GREEN);
		b1.setForeground(Color.WHITE);
		b1.setBounds(400, 270, 120, 30);
		add(b1);
	} 
	
	public void actionPerformed(ActionEvent evt) {
		this.setVisible(false);
		new Main().setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Result("",0).setVisible(true);
	}

}
