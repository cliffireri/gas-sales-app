import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class next extends JFrame implements ActionListener{

	
	private static String into="Enter username"; 
	private JPanel logPanel,firstPanel;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	private JTextField username,cName,contact,price,qty;
	private JTextArea dg,tr;
	private JPasswordField pass;
	private JMenu menu;
	private JMenuBar mb;
	private String start="Hello welcome to Gsoft.Please provide your authentication below.";
	private JRadioButton check1,check2,check3,check4;
	int count=0;
	private String gender;
	private ButtonGroup bg,bg2;
	private Image watermark;
	private JTable jt;
	private LocalDateTime time;
	public next(){
		setLayout(null);

		time=LocalDateTime.now();
		System.out.println(time);
		
		logPanel=new JPanel();
		logPanel.setLayout(null);
		logPanel.setBounds(10, 50, 500, 100);
		logPanel.setBackground(new Color(100,120,0));
		logPanel.setForeground(Color.PINK);
		logPanel.setBorder(BorderFactory.createEtchedBorder());
		
		firstPanel=new JPanel();
		firstPanel.setLayout(null);
		firstPanel.setBounds(10,170,500,400);
		firstPanel.setBorder(BorderFactory.createEtchedBorder());
		firstPanel.setBackground(new Color(100,100,100));
		
		b1=new JButton("Login");
		b2=new JButton("Exit");
		b7=new JButton("Reset");
		b8=new JButton("Register");
		
		b1.setBackground(Color.RED);
		b2.setBackground(Color.GREEN);
		b7.setBackground(Color.GREEN);
		b8.setBackground(Color.GREEN);
		
		Font font=new Font("Serif",Font.PLAIN,14);
		b1.setFont(font);
		b2.setFont(font);
		b7.setFont(font);
		b8.setFont(font);
		
		JLabel label2=new JLabel("Password: ");
		JLabel label1=new JLabel("User Name: ");
		
		pass=new JPasswordField(30);
		username=new JTextField(30);
		
		
		pass.setBounds(285,10,120,20);
		username.setBounds(80,10,120,20);
		b7.setBounds(260,50,80,25);
		b8.setBounds(350,50,90,25);
		b1.setBounds(80, 50, 80, 25);
		b2.setBounds(170,50,80,25);
		label1.setBounds(10,10,70,20);
		label2.setBounds(220,10,70,20);
		
		
		
		
		JLabel label3=new JLabel("Patient Name: ");
		JLabel label4=new JLabel("Contact Info");
		JLabel label5=new JLabel("Diagnosis:");
		JLabel labelnew =new JLabel("Treatment");
		
		cName=new JTextField(30);
		contact=new JTextField(30);
		dg=new JTextArea();
		tr=new JTextArea();
		
		
		label3.setBounds(2,10,90,20);
		label4.setBounds(2,270,70,20);
		label5.setBounds(2,110,90,20);
		labelnew.setBounds(2,190,90,20);
		
		
		dg.setBounds(95,110,160,60);
		cName.setBounds(95,10,160,20);
		contact.setBounds(95,270,160,20);
		tr.setBounds(95,190,160,60);
		
		
		check1=new JRadioButton("Male",false);
		check2=new JRadioButton("Female",false);
		check3=new JRadioButton("Cash",false);
		check4=new JRadioButton("Credit",true);
		
		check1.setBounds(95,60,65,20);
		check2.setBounds(174,60,80,20);
		check3.setBounds(55,100,69,20);
		check4.setBounds(120,100,60,20);
		
		b3=new JButton("Submit");
		b4=new JButton("Clear");
		b5=new JButton("Retrieve");
		b6=new JButton("LOG OFF");
		
		Font font1=new Font("Serif",Font.ITALIC,12);
		b6.setFont(font1);
		b6.setForeground(Color.RED);
		b6.setBackground(Color.GREEN);
		b3.setBounds(55,330, 80, 25);
		b3.setBackground(Color.GREEN);
		b3.setFont(font);
		b4.setBounds(145,330, 80, 25);
		b4.setBackground(Color.GREEN);
		b4.setFont(font);
		b5.setBounds(235,330, 100, 25);
		b5.setBackground(Color.GREEN);
		b5.setFont(font);
		b6.setBounds(345,330, 100, 25);
		b6.setBackground(Color.GREEN);
		
		
		bg=new ButtonGroup();
		bg2=new ButtonGroup();
		bg.add(check1);
		bg.add(check2);
		bg2.add(check3);
		bg2.add(check4);
		
		check1.addItemListener(new HandlerClass());
		check2.addItemListener(new HandlerClass());
		
		
		qty=new JTextField();
		qty.setBounds(274,40,120,20);
		
		
		
		
		
		
		
		//firstPanel.add(qty);
		firstPanel.add(b6);
		firstPanel.add(labelnew);
		firstPanel.add(tr);
		firstPanel.add(dg);
		firstPanel.add(label5);
		firstPanel.add(label3);
		firstPanel.add(cName);
		firstPanel.add(contact);
		firstPanel.add(label4);
		firstPanel.add(check1);
		firstPanel.add(check2);
		//firstPanel.add(check3);
		//firstPanel.add(check4);
		firstPanel.add(b3);
		firstPanel.add(b4);
		firstPanel.add(b5);
		b6.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b4.addActionListener(this);
		b3.addActionListener(this);
		b5.addActionListener(this);
		logPanel.add(pass);
		logPanel.add(username);
		logPanel.add(label2);
		logPanel.add(label1);
		logPanel.add(b8);
		logPanel.add(b1);
		logPanel.add(b2);
		logPanel.add(b7);

		add(logPanel);
		add(firstPanel);
		setEnabledAll(false);
		enableLogin(true);
	}
	private void enableLogin(boolean c) {
		username.setEditable(c);
		pass.setEditable(c);
		b7.setEnabled(c);
		b8.setEnabled(c);
		b1.setEnabled(c);
		b2.setEnabled(c);
		
	}
	private void setEnabledAll(boolean b) {
		check4.setEnabled(b);
		check3.setEnabled(b);
		check2.setEnabled(b);
		check1.setEnabled(b);
		b3.setEnabled(b);
		b4.setEnabled(b);
		b5.setEnabled(b);
		cName.setEditable(b);
		contact.setEditable(b);
		dg.setEditable(b);
		b6.setEnabled(b);
		tr.setEnabled(b);
		
	}
	private void creatNewWindow() {
		JFrame window=new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 600);
		window.setVisible(true);
		
	}

	private void loginAction() {
		String n=username.getText();
		String p=pass.getText();
		try {
			Connection con=db_connect.getConnection();
			Statement st=con.createStatement();
			ResultSet set=st.executeQuery("SELECT * FROM `users` WHERE `username`='"+n+"' AND `password`='"+p+"'");
			while(set.next()){
				count=count+1;
				String currentUserFirst=set.getString(3);
				String currentUserSecond=set.getString(4);
				JOptionPane.showMessageDialog(null,"Hello "+currentUserFirst+" "+currentUserSecond+",welcome to Gsoft.","login success",JOptionPane.PLAIN_MESSAGE);
			}
			
				if (count==0){
					JOptionPane.showMessageDialog(null,"You entered a wrong password","login error",JOptionPane.ERROR_MESSAGE);
					username.setText(null);
					pass.setText(null);
				}else if(count==1){
					enableLogin(false);
					username.setText(null);
					pass.setText(null);
					setEnabledAll(true);
				}
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,"Check your connection to the database","connection error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			loginAction();
		}else if(e.getSource()==b2){
			if(JOptionPane.showConfirmDialog(null, "Are you sure?","confirm exit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
				System.exit(0);
			}
		}else if(e.getSource()==b3){
			if(cName.getText().equals("") || contact.getText().equals("") || dg.getText().equals("")||tr.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Sorry,you need to make sure all fields are filled");
				
			}else{
				addToDatabase();
			}
		}else if(e.getSource()==b4){
			clearEverything();
		}else if(e.getSource()==b5){
			displayTable();
		}else if(e.getSource()==b6){
			enableLogin(true);
			count=0;
			setEnabledAll(false);
			clearEverything();
		}else if(e.getSource()==b7){
			username.setText(null);
			pass.setText(null);
		}else if(e.getSource()==b8){
			JOptionPane.showMessageDialog(null,"You currently cant add more users,contact your administarator","add users",JOptionPane.ERROR_MESSAGE);
		}else if(e.getSource()==b9){
			
		}
		}
	private void clearEverything() {
		bg.clearSelection();
		bg2.clearSelection();
		cName.setText("");
		contact.setText("");
		tr.setText("");
		dg.setText("");
		
		
	}
	private void addToDatabase() {
		String name=cName.getText();
		String number=contact.getText();
		//int nm=Integer.parseInt(number);
		String diag=dg.getText();
		//int sz=Integer.parseInt(size);
		String tret=tr.getText();
		//int rt=Integer.parseInt(retail);
		String mof=gender;
		String timeformat=time.toString();
		try{
			Connection con=db_connect.getConnection();
			PreparedStatement st=con.prepareStatement("INSERT INTO sales(name,gender,diagnosis,treatment,contact,time) VALUES('"+name+"','"+mof+"','"+diag+"','"+tret+"','"+number+"','"+timeformat+"')");
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Data entered successfully.");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Seems like there was an error connecting to the database,please try again later.");
		}finally{
			clearEverything();
		}
		
	}
	
	private class HandlerClass implements ItemListener{
		private HandlerClass(){
			
		}
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==check1){
				gender="Male";
			}else if(e.getSource()==check2){
				gender="Male";
			}else{
				gender="Null";
			}
			
		}
	}
	public void displayTable(){
		JFrame frame=new JFrame("Search result");
		frame.setLayout(new BorderLayout());
		frame.setSize(900, 400);
		frame.setVisible(true);
		String [] columnnames={"id","Name","Gender","Diagnosis","Treatment","Contact","Time"};
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columnnames);
		
		jt=new JTable();
		jt.setModel(model);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jt.setFillsViewportHeight(true);
		
		JScrollPane scroll=new JScrollPane(jt);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll);
		
		String name="";
		int id;
		String number;
		String diagno;
		String treat;
		String gender;
		String timefrom;

		
		
		try{
			Connection con=db_connect.getConnection();
			PreparedStatement st=con.prepareStatement("SELECT * FROM `sales`");
			ResultSet rs=st.executeQuery();
			int i=0;
			while(rs.next()){
				id=rs.getInt("id");
				name=rs.getString("name");
				number=rs.getString("contact");
				diagno=rs.getString("diagnosis");
				gender=rs.getString("gender");
				treat=rs.getString("treatment");
				timefrom=rs.getString("time");
				
				model.addRow(new Object[]{id,name,gender,diagno,treat,number,timefrom});
				i++;
				}
			if(i<1){
				JOptionPane.showMessageDialog(null, "No record(s) found in the database!","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, i+" Record(s) found","sweet",JOptionPane.INFORMATION_MESSAGE);
				frame=null;
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Seems like there was an error connecting to the database,please try again later.","Error",JOptionPane.ERROR_MESSAGE);
		}
		}
		
	}
	
	
		


