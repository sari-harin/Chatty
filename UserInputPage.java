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
		JLabel NameIn=new JLabel("�г���");
		NameIn.setHorizontalAlignment(JLabel.CENTER);
		userName=new JTextField();
		
		JLabel IPin=new JLabel("IP�ּ�");
		IPin.setHorizontalAlignment(JLabel.CENTER);
		IPadd=new JTextField();
		
		JLabel portIn=new JLabel("��Ʈ��ȣ");
		portIn.setHorizontalAlignment(JLabel.CENTER);
		portNum=new JTextField();
		
		JPanel jp=new JPanel();
		logIn=new JButton("�α���");
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
			int portNumber=Integer.parseInt(portNum.getText().trim());  //�Է¹��� ���� ���ڷ� ��ȯ
			if(e.getSource()==logIn) {
				setVisible(false);        //���� ��ư ������ â �����
			}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "�߸��� �Է°��Դϴ�.", "Error",JOptionPane.ERROR_MESSAGE);  //�Է°� �߸��Ǿ����� ���â
			}
		
	}
}
