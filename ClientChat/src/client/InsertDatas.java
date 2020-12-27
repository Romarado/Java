/**@author Vlad_Kostyrya 
 * Данный класс создается для ввода данных пользователем, а так же проверки этих данных
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
/** Поля интерфеса
 *  * 
	     * Процедура создания модального окна для ввода данных {@link InsertDatas#newWindow}
	     * @param window - Stage главное окно для ввода данный
	     * @param ok- кнопка для проверки введенных данных
	     * @param exit- кнопка выхода из программы
	     * @param addres- Поле для ввода адреса
	     * @param addrLabel- Поле обычного текста Addres
	     * @param scene - Сцена для окна
	     * @param pane - Именно на нем размещаются элементы интерфейса
	     * @param nickname - поле заполнения имени пользователя  
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
		/** Поле IP адреса */		
		private String ip;
		/** Поле  порта */	
		private int port;
		private boolean correctData=false;
	
		
		/** 
		 * Новое окно
		 * @param client Передаем клиента для заполнения данных**/
		
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
	     * Процедура получения айпи-адреса {@link InsertDatas#getIp}
	     * @return Возвращает IP
	     */
		public String getIp() {
			return ip;
		}

		/**
	     * Процедура получения порта {@link InsertDatas#getPort}
	     * @return Возвращает port
	     */
		public int getPort() {
			return port;
		}
	
		/**
	     * Процедура получения имени пользователя {@link InsertDatas#getNickname}
	     * @return Возвращает Nickname Пользователя 
	     */
		public TextField getNickname() {
			return nickname;
		}

		/**
	     * Процедура определения имени пользователя {@link InsertDatas#setNickname}
	     * @param nickname  TextField с именем пользователя
	     */
		public void setNickname(TextField nickname) {
			this.nickname = nickname;
		}

		/**
	     * Процедура получения полного адреса {@link InsertDatas#getAddres}
	     * @return Возвращает TextField с содержимым адреса
	     */
		public TextField getAddres() {
			return addres;
		}

		/**
	     * Процедура определения полного адреса {@link InsertDatas#setAddres}
	     * @param addres - TextField с содержимым адреса
	     */
		public void setAddres(TextField addres) {
			this.addres = addres;
		}

		/**
	     * Определяет ip для ввода  {@link InsertDatas#setIp}
	     * @param ip - ip адрес
	     */
		public void setIp(String ip) {
			this.ip = ip;
		}

		/**
	     * Определяет порт для ввода {@link InsertDatas#setPort}
	     * @param port - порт для подключения к серверу
	     */
		public void setPort(int port) {
			this.port = port;
		}

		/**
	     * Показывает верны ли введенные данные {@link InsertDatas#isCorrectData}
	     * @return correcDate переменная которая показывает верны ли введенные данные
	     */
		public boolean isCorrectData() {
			return correctData;
		}

		/**
	     * Устанавливает верность данных {@link InsertDatas#setCorrectData}
	     * @param correctData - именно через нее передается верность данных
	     */
		public void setCorrectData(boolean correctData) {
			this.correctData = correctData;
		}

		/**
	     *  Получение окна для получения с него данных {@link InsertDatas#getWindow}
	     * @return window - возвращается главное окно этого класса
	     */
		public Stage getWindow() {
			return window;
		}

		/**
	     * Установка окна с данными {@link InsertDatas#setWindow}
	     * @param window - возвращается главное окно этого класса
	     */
		public void setWindow(Stage window) {
			this.window = window;
		}
		
		/**
	     * Возвращает клиента запустившего приложение {@link InsertDatas#getClient}
	     * @return client - возвращаемый клиент
	     */
		public Client getClient() {
			return client;
		}
		/**
	     * Устанавливает клиента запустившего приложение {@link InsertDatas#setClient}
	     * @param client - Клиент запустивший приложение
	     */
		public void setClient(Client client) {
			this.client = client;
		}
		
}


