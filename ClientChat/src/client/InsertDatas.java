/**@author Vlad_Kostyrya 
 * ������ ����� ��������� ��� ����� ������ �������������, � ��� �� �������� ���� ������
 * **/

package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InsertDatas {
/** ���� ���������
 *  * 
	     * ��������� �������� ���������� ���� ��� ����� ������ {@link InsertDatas#newWindow}
	     * @param window - Stage ������� ���� ��� ����� ������
	     * @param ok- ������ ��� �������� ��������� ������
	     * @param exit- ������ ������ �� ���������
	     * @param addres- ���� ��� ����� ������
	     * @param addrLabel- ���� �������� ������ Addres
	     * @param scene - ����� ��� ����
	     * @param pane - ������ �� ��� ����������� �������� ����������
	     * @param nickname - ���� ���������� ����� ������������  
	     */
		private TextField nickname=new TextField();
		private TextField addres=new TextField("127.0.0.1:5555");
		private Label nickLabel= new Label("Nickname");
		private Label addrLabel=new Label("Addres");
		private Stage window= new Stage();
		private Pane pane= new Pane();
		private Button ok= new Button("OK");
		private Button exit= new Button("Exit programm");
		private Scene scene = new Scene(pane, 400, 150);
		private Client client;
		/** ���� IP ������ */		
		private String ip;
		/** ����  ����� */	
		private int port;
		private boolean correctData=false;
	
		
		/** 
		 * ����� ����
		 * @param client �������� ������� ��� ���������� ������**/
		
		public void newWindow(Client client) {
			this.client=client;
			window.initModality(Modality.APPLICATION_MODAL);
			window.setScene(scene);
			window.setTitle("Insert Data");
			
			ok.setOnAction(event->InputController.checkDatas(this));
			exit.setOnAction(event->System.exit(0));
			
			nickname.setLayoutX(150);
			nickname.setLayoutY(10);
			nickLabel.setLayoutX(50);
			nickLabel.setLayoutY(15);
			
			addres.setLayoutX(150);
			addres.setLayoutY(50);
			addrLabel.setLayoutX(50);
			addrLabel.setLayoutY(50);
			
			ok.setLayoutX(100);
			ok.setLayoutY(100);
			ok.setMinWidth(50);
			
			exit.setLayoutX(150);
			exit.setLayoutY(100);
			exit.setMinWidth(50);
			
			pane.getChildren().add(nickname);
			pane.getChildren().add(nickLabel);
			pane.getChildren().add(addres);
			pane.getChildren().add(addrLabel);
			pane.getChildren().add(ok);
			pane.getChildren().add(exit);
		
			while(!correctData) {
				window.showAndWait();		
			}
			

		}		
	


		/**
	     * ��������� ��������� ����-������ {@link InsertDatas#getIp}
	     * @return ���������� IP
	     */
		public String getIp() {
			return ip;
		}

		/**
	     * ��������� ��������� ����� {@link InsertDatas#getPort}
	     * @return ���������� port
	     */
		public int getPort() {
			return port;
		}
	
		/**
	     * ��������� ��������� ����� ������������ {@link InsertDatas#getNickname}
	     * @return ���������� Nickname ������������ 
	     */
		public TextField getNickname() {
			return nickname;
		}

		/**
	     * ��������� ����������� ����� ������������ {@link InsertDatas#setNickname}
	     * @param nickname  TextField � ������ ������������
	     */
		public void setNickname(TextField nickname) {
			this.nickname = nickname;
		}

		/**
	     * ��������� ��������� ������� ������ {@link InsertDatas#getAddres}
	     * @return ���������� TextField � ���������� ������
	     */
		public TextField getAddres() {
			return addres;
		}

		/**
	     * ��������� ����������� ������� ������ {@link InsertDatas#setAddres}
	     * @param addres - TextField � ���������� ������
	     */
		public void setAddres(TextField addres) {
			this.addres = addres;
		}

		/**
	     * ���������� ip ��� �����  {@link InsertDatas#setIp}
	     * @param ip - ip �����
	     */
		public void setIp(String ip) {
			this.ip = ip;
		}

		/**
	     * ���������� ���� ��� ����� {@link InsertDatas#setPort}
	     * @param port - ���� ��� ����������� � �������
	     */
		public void setPort(int port) {
			this.port = port;
		}

		/**
	     * ���������� ����� �� ��������� ������ {@link InsertDatas#isCorrectData}
	     * @return correcDate ���������� ������� ���������� ����� �� ��������� ������
	     */
		public boolean isCorrectData() {
			return correctData;
		}

		/**
	     * ������������� �������� ������ {@link InsertDatas#setCorrectData}
	     * @param correctData - ������ ����� ��� ���������� �������� ������
	     */
		public void setCorrectData(boolean correctData) {
			this.correctData = correctData;
		}

		/**
	     *  ��������� ���� ��� ��������� � ���� ������ {@link InsertDatas#getWindow}
	     * @return window - ������������ ������� ���� ����� ������
	     */
		public Stage getWindow() {
			return window;
		}

		/**
	     * ��������� ���� � ������� {@link InsertDatas#setWindow}
	     * @param window - ������������ ������� ���� ����� ������
	     */
		public void setWindow(Stage window) {
			this.window = window;
		}
		
		/**
	     * ���������� ������� ������������ ���������� {@link InsertDatas#getClient}
	     * @return client - ������������ ������
	     */
		public Client getClient() {
			return client;
		}
		/**
	     * ������������� ������� ������������ ���������� {@link InsertDatas#setClient}
	     * @param client - ������ ����������� ����������
	     */
		public void setClient(Client client) {
			this.client = client;
		}
		
}


