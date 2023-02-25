import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class UserInputPage extends JFrame implements ActionListener{
	int IPNumList_num[]=new int[4];
	JTextField userName, IPadd, portNum;
	JButton logIn;
	
	public UserInputPage() {
		Toolkit tk=getToolkit();
		Dimension d=tk.getScreenSize();
		int ScreenHeight=d.height;
		int ScreenWidth=d.width;
		
		setSize(300,200);
		setTitle("Login");
		setLocation(ScreenWidth/2-this.getWidth()/2, ScreenHeight/2-this.getHeight()/2);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new GridLayout(3,0));
		JLabel NameIn=new JLabel("닉네임");
		NameIn.setHorizontalAlignment(JLabel.CENTER);
		userName=new JTextField();
		
		JLabel IPin=new JLabel("IP주소");
		IPin.setHorizontalAlignment(JLabel.CENTER);
		IPadd=new JTextField();
		
		JLabel portIn=new JLabel("포트번호");
		portIn.setHorizontalAlignment(JLabel.CENTER);
		portNum=new JTextField();
		
		JPanel jp=new JPanel();
		logIn=new JButton("로그인");
		logIn.addActionListener(this);
		jp.add(logIn);
		
		jp1.add(NameIn);
		jp1.add(userName);
		jp1.add(IPin);
		jp1.add(IPadd);
		jp1.add(portIn);
		jp1.add(portNum);
		add(jp1,BorderLayout.CENTER);
		add(jp,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int portNumber=Integer.parseInt(portNum.getText().trim());  //입력받은 값을 숫자로 변환
			if(e.getSource()==logIn) {
				setVisible(false);        //연결 버튼 누를시 창 사라짐
			}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "잘못된 입력값입니다.", "Error",JOptionPane.ERROR_MESSAGE);  //입력값 잘못되었을시 경고창
			}
		
	}
}
