package my.code.forest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class msgLogging {
	private static ArrayList <Exception> ErrList;
	static int errCounter = 0;
	String FileName = "";
	public static Logger log;
	
	public void addLog(String message) {
		
		log.log(Level.INFO, message);
	}
	
	public msgLogging(){
		
		try {
			ErrList = new ArrayList();
			FileInputStream fis = new FileInputStream("src\\my\\code\\forest\\logging.properties");
			LogManager.getLogManager().readConfiguration(fis);
			log = Logger.getLogger(msgLogging.class.getName());
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	public void ErrMsgLog() throws IOException {
		ErrList = new ArrayList();
		FileInputStream fis = new FileInputStream("src/logging.properties");
		LogManager.getLogManager().readConfiguration(fis);
		log = Logger.getLogger(msgLogging.class.getName());
		
		fis.close();
		
		}
		
	//��������� ������ � ������ ������
	public int addErr(Exception e) {
		ErrList.add(e);
		return ErrList.size();
	}
	//��������� ������ � ������ ������ � � ���
	public int addErrWithLog(Exception e) {
		ErrList.add(e);
		//��� ������ ��������� � ���
		log.log(Level.FINE, e.getMessage());
		return ErrList.size();
	}
	//�������� ���������� ������
	public int getErrCount() {
		return ErrList.size();
	}
	//������� ���������� �� ������
	public void showErrText(Exception e) {
		System.err.println(e.getMessage());
	}
	//������� (������������ ������) � ��������� � ������ ������
	public Exception makeErr(Exception e) {
		addErr(e);
		return new Exception(e);
	}
}
