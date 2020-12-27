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
		 *Конструктор клиента создает сам объект и его окно
		 * @param window Окно мессенджера с которым связан клент
		 */
		public Client(ClientView window) {
			win = window;
		}
		
		/**
		 * Метод отправляет сообщение на сервер
		 * @param msg сообщение которое нужно отправить
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
		 * Подключтся к серверу
		 * @param h адрес хоста
		 * @param p порт
		 * @return true, если успешно
		 * @throws IOException кидает ошибку с потоками ввода-вывода
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
		 * Функция основного потока приема сообщений от сервера
		 * @throws IOException Кидает ошибку при проблемах в считывании с сервера
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
		 * Метод закрывает потоки, при завершении работы
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
