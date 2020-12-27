package server;

import java.io.*;
import java.net.*;

/**
 * @author Kostyrya_Vladislav
 * Класс сервера
 */
public class Server {

	private ServerSocket socketofServer; // сокет сервера
	private Socket socketBindClient; //сокет для связи с клиентом
	private DataInputStream in; // поток вывода
	private DataOutputStream out; //поток ввода
	

	/**
     * для общения с клиентом необходим сокет (адресные данные)
     * 
     * @throws IOException Ошибка вызываемые потоками ввода и вывода
     */
	public Server() throws IOException {
		System.out.println("Waiting for connection");
		socketofServer = new ServerSocket(5555); // Вот это можно было сделать в отдельном методе
		socketBindClient = socketofServer.accept();
		in = new DataInputStream(socketBindClient.getInputStream());
		out = new DataOutputStream(socketBindClient.getOutputStream());
	}
	
	/** 
	 * Метод, в котором сервер ожидает сообщения от клиента, 
	 * и отправляющий ему обратное сообщение,
	 * которое показывает, что все дошло в сохранности
	 * @throws IOException ошибка в потоках ввода и вывода
	 * **/
	public void listenClient() throws IOException {
		System.out.println("Server started");
		out.writeUTF("Server: Connected!");
		String message = "";
		while (true) {
			message = in.readUTF();
			out.writeUTF("Server: I've got your message "+message);
			System.out.println("New msg: " + message);
		}
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		socketofServer.close();
		socketBindClient.close();
		in.close();
		out.close();
	}

	public static void main(String[] args) {
		while (true) {
			Server server = null;
			try {
				server = new Server();
				server.listenClient();			
			}
			catch (EOFException e) {
				System.out.println("Connecton failed");
				try {
					server.finalize();
				}
				catch (Throwable exc) {
					exc.printStackTrace();
					return;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				return;
			}			
		}
	}
}