package client;
/** 
 * Класс проверяющий введенные данные, и если все верно введено, подключающий клиента к серверу
 * **/
import java.io.IOException;
import java.net.Socket;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class InputController {
	
	/** Процедура проверки введенных данных вызываемые кнопкой ok {@link InputController#checkDatas}
	 * @param indata Данные введеные форму передаются контроллеру
	 * 
	 * **/
	public static void checkDatas(InsertDatas indata)
			{
		 Alert alert=new Alert(Alert.AlertType.ERROR);
		 alert.initModality(Modality.APPLICATION_MODAL);
		 alert.setTitle("Input Error");
		
		 try {		
			 
					String ip=indata.getAddres().getText().toString();
			        if ( ip == null || ip.isEmpty() ) {
			        	
						alert.setContentText("IP Empty! " + ip);
						alert.showAndWait();
						indata.setCorrectData(false);
						return;
			        }
			        
			        String[] partsIP= ip.split(":");
			        if ( partsIP.length != 2 ) {
						alert.setContentText("Correct input for example 127.0.0.0:5555!");
						alert.showAndWait();
						indata.setCorrectData(false);
						return;
			        }
			       
			        String[] partsAdd=partsIP[0].split(".");
			        for ( String s : partsAdd ) {
			            int i = Integer.parseInt( s );
			            if ( (i < 0) || (i > 255) ) {

							alert.setContentText("Correct max input for example 255.255.255.255!");
							alert.showAndWait();
							indata.setCorrectData(false);
							return;
			            }
			        }
			        
			        	int  port = Integer.parseInt(partsIP[1]);
			            if ( (port < 0) || (port > 65536) ) {

							alert.setContentText("Correct port positive number no more 65536");
							alert.showAndWait();
							indata.setCorrectData(false);
							return;
			            }
			            
			         
			            
			            
			          
			            	
			        	 try {		
			        		
			        		
			        		indata.setCorrectData(indata.getClient().connect(partsIP[0], port));			  
			        					 // indata.getClient().listenServer();
			        		} catch (IOException e) {
			  					alert.setContentText("This Ip addres doesn't exsit!!");
								alert.showAndWait();
								
								indata.setCorrectData(false);
								return;
			        	  }
			        				 
			            indata.getWindow().close();
			            
			 	} catch (NumberFormatException nfe) {
			 			alert.setContentText("Correct input for example 250.250.250.250:65536");
						alert.showAndWait();
						indata.setCorrectData(false);
						return;
			
		}
			
	}
}
