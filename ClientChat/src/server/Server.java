package server;

import java.io.*;
import java.net.*;

/**
 * @author Kostyrya_Vladislav
 * ����� �������
 */
public class Server {

	private ServerSocket socketofServer; // ����� �������
	private Socket socketBindClient; //����� ��� ����� � ��������
	private DataInputStream in; // ����� ������
	private DataOutputStream out; //����� �����
	

	/**
     * ��� ������� � �������� ��������� ����� (�������� ������)
     * 
     * @throws IOException ������ ���������� �������� ����� � ������
     */
	public Server() throws IOException {
		System.out.println("Waiting for connection");
		socketofServer = new ServerSocket(5555); // ��� ��� ����� ���� ������� � ��������� ������
		socketBindClient = socketofServer.accept();
		in = new DataInputStream(socketBindClient.getInputStream());
		out = new DataOutputStream(socketBindClient.getOutputStream());
	}
	
	/** 
	 * �����, � ������� ������ ������� ��������� �� �������, 
	 * � ������������ ��� �������� ���������,
	 * ������� ����������, ��� ��� ����� � �����������
	 * @throws IOException ������ � ������� ����� � ������
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