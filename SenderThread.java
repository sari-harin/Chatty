import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class SenderThread extends Thread{
	Socket sk=null;
	ServerChatPage ChatWin;
	SenderThread(Socket sk, ServerChatPage ChatWin){
		this.sk=sk;
		this.ChatWin=ChatWin;
	}
	public void run() {
		try {
			DataOutputStream out=new DataOutputStream(sk.getOutputStream());
			
			while(true) {
				String chat=ChatWin.inputField.getText();
				ChatWin.chatLog.append(chat);
				
				if(chat.equalsIgnoreCase("Exit")) {
					break;
				}
				else{
					out.writeUTF(chat);
					ChatWin.inputField.setText("");
					ChatWin.inputField.requestFocus();
				}
				
			}
		} catch(Exception e) {
			e.getMessage();
		}
		try {
			sk.close();
		} catch(IOException e) {
			e.getMessage();
		}
	}
}
