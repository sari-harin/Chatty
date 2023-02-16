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
		
		JLabel jl=new JLabel("포트 번호를 입력하세요.");
		jl.setHorizontalAlignment(JLabel.CENTER);
		portInput=new JTextField(10);
		jb=new JButton("연결");
		jb.addActionListener(this);         //액션리스너 add
		
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
		int portNum=Integer.parseInt(portInput.getText().trim());  //입력받은 값을 숫자로 변환
		if(e.getSource()==jb) {
			setVisible(false);        //연결 버튼 누를시 창 사라짐
		}
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "잘못된 입력값입니다.", "Error",JOptionPane.ERROR_MESSAGE);  //입력값 잘못되었을시 경고창
		}
		
	}

}
