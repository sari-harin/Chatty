import java.awt.*;
import java.awt.event.*;
import java.net.ServerSocket;

import javax.swing.*;

public class ServerChatPage extends JFrame implements ActionListener{
	JTextArea chatLog;
	JTextField inputField;
	JButton chatInput;
	
	Toolkit tk=getToolkit();
	Dimension d=tk.getScreenSize();
	int ScreenHeight=d.height;
	int ScreenWidth=d.width;
	
	public ServerChatPage(String UserStat) {
		setSize(700,600);
		setTitle("Chatty_Server");
		setLocation(ScreenWidth/2-this.getWidth()/2, ScreenHeight/2-this.getHeight()/2);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new BorderLayout());
		JLabel jl=new JLabel(UserStat+"로 입장하셨습니다.");
		chatLog=new JTextArea(27,20);
		chatLog.setEditable(false);
		jp1.add(jl, BorderLayout.NORTH);
		jp1.add(chatLog, BorderLayout.SOUTH);
		
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputField=new JTextField(30);
		chatInput=new JButton("전송");
		chatInput.addActionListener(this);
		jp2.add(inputField);
		jp2.add(chatInput);
		
		add(jp1, BorderLayout.NORTH);
		add(jp2,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("전송")) {
			  
		}
		
	}


}


