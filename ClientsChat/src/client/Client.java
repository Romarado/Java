package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;


	public class Client{

		private String host = null;
		private int port;
		private String nickname = "";
		private Socket socket;
		private DataInputStream inputData;
		private DataOutputStream outputData;
		Boolean isConnected = false;
		private  ClientView win;
		private Thread listner;
		private Runnable listRun;

		/**
		 *����������� ������� ������� ��� ������ � ��� ����
		 * @param window ���� ����������� � ������� ������ �����
		 */
		public Client(ClientView window) {
			win = window;
		}
		
		/**
		 * ����� ���������� ��������� �� ������
		 * @param msg ��������� ������� ����� ���������
		 */
		public void sendMsg(String msg) {
			if (isConnected)
				try {
					outputData.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		/**
		 * ���������� � �������
		 * @param h ����� �����
		 * @param p ����
		 * @return true, ���� �������
		 * @throws IOException ������ ������ � �������� �����-������
		 */
		public Boolean connect(String h, int p) throws IOException  {
			this.host = h;
			this.port = p;
			
				System.out.println(h+" "+p);
				socket = new Socket(host, port);			
			
				System.err.println("Connection failed");
				
			
			inputData = new DataInputStream(socket.getInputStream());
			outputData = new DataOutputStream(socket.getOutputStream());
			isConnected = true;
			System.out.println("Client successfully connected to server!");
			listenServer();
			return true;
		}

		/**
		 * @return the nickname
		 */
		public String getNickname() {
			return nickname;
		}

		/**
		 * @param nickname the nickname to set
		 */
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		
		/**
		 * ������� ��������� ������ ������ ��������� �� �������
		 * @throws IOException ������ ������ ��� ��������� � ���������� � �������
		 */
		public void listenServer() throws IOException {

        	listRun=new Runnable() {
    			public void run() {
    				String message = "";
    				setNickname(win.getNickname());
    				while (isConnected) {
					try {
						
						message = inputData.readUTF();
						
						win.newMessage(message);					
					}
					catch (EOFException e) {
						try {
							inputData.close();
							outputData.close();
							socket.close();
							win.connectionLost();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					catch (SocketException e) {
						isConnected = false;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				};
			}
    			};
    			listner=new Thread(listRun);
    			listner.start();
		}
		
		/**
		 * ����� ��������� ������, ��� ���������� ������
		 */
		public void closeConnection() {
			System.out.println("Client close everything");
			isConnected = false;
			try {
				inputData.close();
				outputData.close();
				socket.close();			
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		

	

}
