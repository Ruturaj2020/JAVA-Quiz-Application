import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
	
	public static int count = 0;
	public static int timer = 15;
	public static int attempt = 0;
	public static int result = 0;
	JButton next,submit;
	JLabel qi,qn;
	String q[][] = new String[10][5];
	String ans[][] = new String[10][1];
	String calc[][] = new String[10][2];
	JRadioButton opt1,opt2,opt3,opt4;
	ButtonGroup options;
	String username;
	
	Quiz(String username){
		this.username = username;
		setBounds(250, 50,1440,950);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ic/quiz.jpg"));
		JLabel ii = new JLabel(i1);
		ii.setBounds(0,0,1440,392);
		add(ii);
		
		qn = new JLabel("1.");
		qn.setFont(new Font("Tahoma", Font.PLAIN,24));
		qn.setBounds(100, 450, 50, 30);
		add(qn);
		
		qi = new JLabel("");
		qi.setFont(new Font("Tahoma", Font.PLAIN,24));
		qi.setBounds(150, 450, 900, 30);
		add(qi);
		
		q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";
        
        calc[0][1] = "JDB";
        calc[1][1] = "int";
        calc[2][1] = "java.util package";
        calc[3][1] = "Marker Interface";
        calc[4][1] = "Heap memory";
        calc[5][1] = "Remote interface";
        calc[6][1] = "import";
        calc[7][1] = "Java Archive";
        calc[8][1] = "java.lang.StringBuilder";
        calc[9][1] = "Bytecode is executed by JVM";
		
		opt1 = new JRadioButton("");
		opt1.setFont(new Font("Dialog", Font.PLAIN,20));
		opt1.setBounds(170, 520, 700, 30);
		opt1.setBackground(Color.WHITE);
		add(opt1);
		
		opt2 = new JRadioButton("");
		opt2.setFont(new Font("Dialog", Font.PLAIN,20));
		opt2.setBounds(170, 560, 700, 30);
		opt2.setBackground(Color.WHITE);
		add(opt2);
		
		opt3 = new JRadioButton("");
		opt3.setFont(new Font("Dialog", Font.PLAIN,20));
		opt3.setBounds(170, 600, 700, 30);
		opt3.setBackground(Color.WHITE);
		add(opt3);
		
		opt4 = new JRadioButton("");
		opt4.setFont(new Font("Dialog", Font.PLAIN,20));
		opt4.setBounds(170, 640, 700, 30);
		opt4.setBackground(Color.WHITE);
		add(opt4);
		
		options  = new ButtonGroup();
		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);
		
		next = new JButton("Next");
		next.setFont(new Font("Tahoma",Font.PLAIN,22));
		next.setBackground(new Color(30,144,255));
		next.setForeground(Color.WHITE);
		next.setBounds(1100,550,200,40);
		next.addActionListener(this);
		add(next);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma",Font.PLAIN,22));
		submit.setBackground(new Color(30,144,255));
		submit.setForeground(Color.WHITE);
		submit.setBounds(1100,630,200,40);
		submit.setEnabled(false);
		submit.addActionListener(this);
		add(submit);
		
		start(0);
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==next) {
			repaint();
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			attempt = 1;
			if(options.getSelection()==null) {
				ans[count][0] = "";
			}else {
				ans[count][0] = options.getSelection().getActionCommand();
			}
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			count++;
			start(count);
		}
		else if(evt.getSource()==submit) {
			attempt=1;
			if(options.getSelection()==null) {
				ans[count][0] = "";
			}else {
				ans[count][0] = options.getSelection().getActionCommand();
			}
			
			for(int i=0;i<ans.length;i++) {
				if(ans[i][0].equals(calc[i][1])) {
					result+=10;
				}else {
					result+=0;
				}
			}
			this.setVisible(false);
			new Result(username, result).setVisible(true);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		String time = "Time Left : " + timer;
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma",Font.BOLD,20));
		
		if(timer>0) {
			g.drawString(time, 1100, 500);
		}
		else {
			g.drawString("Time Over!", 1100, 500);
		}
		timer--;
		
		try {
			Thread.sleep(1000);
			repaint();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(attempt == 1) {
			attempt=0; 
			timer = 15;
		}
		
		else if(timer < 0) {
			timer = 15;
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			if(count==8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			if(count==9) {
				if(options.getSelection()==null) {
					ans[count][0] = "";
				}else {
					ans[count][0] = options.getSelection().getActionCommand();
				}
				
				for(int i=0;i<ans.length;i++) {
					if(ans[i][0].equals(calc[i][1])) {
						result+=10;
					}else {
						result+=0;
					}
				}
				this.setVisible(false);
				new Result(username, result).setVisible(true);
			}
			else {
				if(options.getSelection()==null) {
					ans[count][0] = "";
				}else {
					ans[count][0] = options.getSelection().getActionCommand();
				}
				count++;
				start(count);
			}
		}
	}
	
	public void start(int count) {
		qn.setText(""+ (count+1) + ". ");
		qi.setText(q[count][0]);
		opt1.setLabel(q[count][1]);
		opt1.setActionCommand(q[count][1]);
		opt2.setLabel(q[count][2]);
		opt2.setActionCommand(q[count][2]);
		opt3.setLabel(q[count][3]);
		opt3.setActionCommand(q[count][3]);
		opt4.setLabel(q[count][4]);
		opt4.setActionCommand(q[count][4]);
		options.clearSelection();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Quiz("").setVisible(true);
	}

}
