import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class InputPage extends JFrame implements ActionListener{
	JTextField portInput;
	JButton jb;
	
	public InputPage() {
		setSize(300,100);
		setTitle("Create room");
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
		int portNum=Integer.parseInt(portInput.getText().trim());  //�Է¹��� ���� ���ڷ� ��ȯ
		if(e.getSource()==jb) {
			setVisible(false);        //���� ��ư ������ â �����
		}
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "�߸��� �Է°��Դϴ�.", "Error",JOptionPane.ERROR_MESSAGE);  //�Է°� �߸��Ǿ����� ���â
		}
		
	}

}
