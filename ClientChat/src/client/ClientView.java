package client;
	/** 
	 * ����� ��������� ���� ����
	 * @author Kostyrya_Vlad
	 * **/
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class ClientView  extends Application{
	private Scene scene; 
	private TextArea chatArea;
	private Client connection;
	private InsertDatas insertdata;
	private String nickname;
	
	public static void main(String[] args) throws Exception {
		launch(args);

	}
	
	/**
	 * ����� ������� �������� ����� ����������
	 * @return root ���������� ������� Stage ��� ����� 
	 */
private Parent createContent() {
		
		chatArea.setPrefHeight(700);
		chatArea.setEditable(false);
		TextField inputMessage=new TextField("Input message");
		
		inputMessage.getStyleClass().add("message");
		chatArea.getStyleClass().add("chat");
;
		VBox root= new VBox(20, chatArea, inputMessage);
		root.setPrefSize(600,700);
		
		inputMessage.setOnAction(event ->{
			String message= insertdata.getNickname().getText().toString()+": ";
			message+= inputMessage.getText();
			inputMessage.clear();
			
			chatArea.appendText(message+"\n");
			try {
				connection.sendMsg(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				chatArea.appendText("Failed send \n");
			}
		});
		
		return root;
	}

/**
 * ����� ���������� ���� �� ������������� ������������ � ������
 * @throws IOException ������ �� newWindow
 */
public void initialConnection() throws IOException {
	
	insertdata=new InsertDatas();
	insertdata.newWindow(connection);
	
}


/**
 * ���������� ����� ���������
 * @param msg - ����� �������� �������
 */
public void newMessage(String msg) {
	
	chatArea.appendText(msg + "\n");
		
	
}

/**
 * ���������� ������� ������ ����������
 * @throws IOException ������ �� initialConnection
 */
public void connectionLost() throws IOException {
	Alert alert=new Alert(Alert.AlertType.WARNING);
	alert.initModality(Modality.APPLICATION_MODAL);
	alert.getResult();
	alert.setContentText("Correct max input for example 255.255.255.255!");
	if(alert.getResult()==ButtonType.YES)
	{	connection.closeConnection();
		return;
	}
	initialConnection();
}



/**
 * ���������� ������� ��� �����
 * @param client  ��������������� ������*/
public void setClient(Client client) {
	connection=client;
	
}
/**
 * ���������� ��� ������������
 * @return nickname  ��� ������������*/
public String getNickname() {
	return nickname;
}

/**
 * ���������� ��� ������������
 * @param nickname  ��� ������������*/
public void setNickname(String nickname) {
	this.nickname = nickname;
}


@Override
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	
		
			try {
				chatArea=new TextArea();
			 	primaryStage.setTitle("Client");
				scene=new Scene(createContent());
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				connection = new Client(ClientView.this);
				
				primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						System.out.println("Window closed...");
						connection.closeConnection();
					}
				});
				initialConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

	 	
}




}
