package Frames;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class AdminLoginFrame extends JFrame {
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JPasswordField p1;
	JButton b2,b3,b4;
	
	public AdminLoginFrame() {
		super("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JCheckBox j1,j2;
		setSize(750,500);
		JLabel Background = new JLabel(new ImageIcon(new ImageIcon("E:\\Project\\adminLogin.png").getImage().getScaledInstance(750, 500, Image.SCALE_SMOOTH)));
		add(Background);
		setLocationRelativeTo(null);
		
		
		setLayout(null);
		Background.setBounds(0, 0, 750, 500);
		setUndecorated(true);
		//JLabel user = new JLabel( new ImageIcon(new ImageIcon("E:\\Project\\user.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		JPanel Middle = new JPanel();
		
		Middle.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 0; c.gridy = 0;
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");
		l1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		l2.setFont(new Font("Times New Roman",Font.PLAIN,15));
		
		t1 = new JTextField(11);
		//t1.setText("admin");
		//t1.setEditable(false);
		t1.setFont(new Font("Times New Roman",Font.PLAIN,17));
		t1.setOpaque(true);
		Border bord = BorderFactory.createLineBorder(Color.WHITE, 2,true);
		t1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));

		t1.setBorder(bord);
		p1 = new  JPasswordField(11);
		p1.setOpaque(true);
		p1.setFont(new Font("Times New Roman",Font.PLAIN,17));
		p1.setBorder(bord);

		j1 = new JCheckBox("Show Password");
		j1.setBorder(bord);
		j1.setOpaque(false);
		t1.setBorder(bord);
		t1.setBackground(Color.LIGHT_GRAY);
		p1.setBackground(Color.LIGHT_GRAY);
		j1.setBorder(null);
		
		Middle.add(l1,c);

		c.gridx = 1; c.gridy = 0;
		Middle.add(t1,c);
		
		c.gridx = 0; c.gridy = 1;
		Middle.add(l2,c);
		
		c.gridx = 1; c.gridy = 1;

		Middle.add(p1,c);
		
		c.gridx = 1; c.gridy = 2;
		Middle.add(j1,c);
		
		c.gridx = 2 ; c.gridy = 2;
		
		JPanel Butt = new JPanel(new FlowLayout(0,16,0));
		Butt.setBounds(240,300, 300, 50);
		Butt.setOpaque(false);
		
		b2 = new JButton();	        
		b2.setRolloverIcon(new ImageIcon(new ImageIcon("E:\\\\Project\\\\curved-grey-login.png").getImage().getScaledInstance(75,30, Image.SCALE_SMOOTH)));
		b2.setIcon(new ImageIcon(new ImageIcon("E:\\Project\\curved-black-login.png").getImage().getScaledInstance(75,30, Image.SCALE_SMOOTH)));
		b2.setBorderPainted(false); 
        b2.setContentAreaFilled(false); 
        b2.setFocusPainted(false); 
        b2.setOpaque(false);
        
        b4 = new JButton();	        
		b4.setRolloverIcon(new ImageIcon(new ImageIcon("E:\\\\Project\\\\curved-grey-register.png").getImage().getScaledInstance(75,30, Image.SCALE_SMOOTH)));
		b4.setIcon(new ImageIcon(new ImageIcon("E:\\Project\\curved-black-register.png").getImage().getScaledInstance(75,30, Image.SCALE_SMOOTH)));
		b4.setBorderPainted(false); 
        b4.setContentAreaFilled(false); 
        b4.setFocusPainted(false); 
        b4.setOpaque(false);
        
        Butt.add(b2); Butt.add(b4);
        Background.add(Butt);
        
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Admin> admins = AdminHelperClass.readAllData();
				boolean exists = false;
				
				for(int i=0; i<admins.size(); i++) {
					if(admins.get(i).getUsername().equalsIgnoreCase(t1.getText())) {
						exists = true;
						if(admins.get(i).getPassword().equals(p1.getText())) {
							new AdminSelectFrame(admins.get(i));
							AdminLoginFrame.this.dispose();
							break;
							
						}
						else JOptionPane.showMessageDialog(null, "Password incorrect", "Error Message", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(exists==false)
					JOptionPane.showMessageDialog(null, "Username doesn't exist or is incorrect", "Error Message", JOptionPane.ERROR_MESSAGE);
				
			}
		});
        
        b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String a = JOptionPane.showInputDialog("Enter the 6 digit verification code: ");
				if(a.equalsIgnoreCase("123456"))
					new RegistrationFrame("admin");
				else JOptionPane.showMessageDialog(null,"Incorrect Verification Code");
				
			}
		});
		
		JPanel close = new JPanel(new FlowLayout());
		b3 = new JButton();
		b3.setIcon(new ImageIcon(new ImageIcon("E:\\Project\\close.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH)));
		 b3.setBorderPainted(false); 
	        b3.setContentAreaFilled(false); 
	        b3.setFocusPainted(false); 
	        b3.setOpaque(false);
		close.add(b3);
		close.setOpaque(false);
		close.setBounds(650,10, 50, 50);
		Background.add(close);
//		
	//	Middle.add(user,c);

		
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminLoginFrame.this.dispose();
			}
		});
		
		
		
	
		Middle.setBounds(180,20, 400, 400);
		Middle.setOpaque(false);
		Background.add(Middle);
		
		
		
		j1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(j1.isSelected()) {
					p1.setEchoChar((char)0);
				}  
				else {
					p1.setEchoChar('*');
				}
			}
			
		});

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AdminLoginFrame();
	}

}


