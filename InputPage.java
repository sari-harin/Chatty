import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.*;
import javax.swing.*;

public class InputPage extends JFrame implements ActionListener{
	JTextField portInput;
	JButton jb;
	ServerChatPage serverWind;
	static public int portNum;
	boolean isConnected;
	ServerSocket serverSK=null;
	Socket sk=null;
	DataInputStream in;
	DataOutputStream out;
	
	public InputPage() {
		Toolkit tk=getToolkit();
		Dimension d=tk.getScreenSize();
		int ScreenHeight=d.height;
		int ScreenWidth=d.width;
		
		setSize(300,100);
		setTitle("Create room");
		setLocation(ScreenWidth/2-this.getWidth()/2, ScreenHeight/2-this.getHeight()/2);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jl=new JLabel("��Ʈ ��ȣ�� �Է��ϼ���.");
		jl.setHorizontalAlignment(JLabel.CENTER);
		portInput=new JTextField(10);
		jb=new JButton("����");
		jb.addActionListener(this);         //�׼Ǹ����� add
		
		JPanel jp=new JPanel();
		jp.add(portInput);
		jp.add(jb);
		
		add(jl, BorderLayout.NORTH);
		add(jp, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		portNum=Integer.parseInt(portInput.getText().trim());  //�Է¹��� ���� ���ڷ� ��ȯ
		if(e.getSource()==jb) {
			try {
				serverWind=new ServerChatPage("Server");
				serverSK=new ServerSocket(portNum);
				serverWind.chatLog.append("����� ���� �����...");
				startChat(serverWind, serverSK);
				
			} catch(Exception ex) {
				
			}
			setVisible(false);        //���� ��ư ������ â �����
		}
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "�߸��� �Է°��Դϴ�.", "Error",JOptionPane.ERROR_MESSAGE);  //�Է°� �߸��Ǿ����� ���â
			portInput.setText("");
		}
		
	}
	
	public void startChat(ServerChatPage serverWind, ServerSocket serverSK) {
		try{
			this.serverSK=serverSK;
			this.serverWind=serverWind;
			
			sk=serverSK.accept();
			serverWind.chatLog.append("����� ���� �Ϸ�!");
			Thread thread1=new SenderThread(sk, serverWind);
			thread1.start();
			
			
			
		} catch(Exception e) {
			e.getMessage();
		}
		try {
			serverSK.close();
		} catch(Exception e) {
			e.getMessage();
		}
	}
	

}
