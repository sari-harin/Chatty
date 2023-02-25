import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ServerChatPage extends JFrame implements ActionListener{
	JTextArea chatLog;
	JTextField inputField;
	JButton chatInput, userListOpen;
	
	Toolkit tk=getToolkit();
	Dimension d=tk.getScreenSize();
	int ScreenHeight=d.height;
	int ScreenWidth=d.width;
	
	public ServerChatPage(String whoLogin) {
		setSize(700,600);
		setTitle("Chatty_Server");
		setLocation(ScreenWidth/2-this.getWidth()/2, ScreenHeight/2-this.getHeight()/2);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new BorderLayout());
		JLabel jl=new JLabel(whoLogin+"로 입장하셨습니다.");
		chatLog=new JTextArea(27,20);
		chatLog.setEditable(false);
		jp1.add(jl, BorderLayout.NORTH);
		jp1.add(chatLog, BorderLayout.SOUTH);
		
		JPanel jp2=new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputField=new JTextField(30);
		chatInput=new JButton("전송");
		chatInput.addActionListener(this);
		userListOpen=new JButton("접속자 목록");
		userListOpen.addActionListener(this);
		jp2.add(inputField);
		jp2.add(chatInput);
		jp2.add(userListOpen);
		
		add(jp1, BorderLayout.NORTH);
		add(jp2,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("전송")) {
			inputField.setText("");        //연결 버튼 누를시 창 사라짐
		}
		else if(e.getActionCommand().equals("접속자 목록")) {
			new UserList();
		}
		
	}
	
	class UserList extends JFrame{
		public UserList() {
			setSize(200,600);
			setTitle("User List");
			setLocation(ScreenWidth/2+super.getWidth()+this.getWidth(), ScreenHeight/2-this.getHeight()/2);
			setResizable(false);
			setLayout(new BorderLayout());
			
			setVisible(true);
		}

	}


}


