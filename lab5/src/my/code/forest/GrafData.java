package my.code.forest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import my.code.forest.GrafDataTitle;



public class GrafData {
/**
 * ����� �������� ������ ��� ���������� �������
 */
	
	private String temp = "";
	private boolean Correct = false;
	private GrafDataTitle Title;
	/**
	 * �������� �������
	 */
	private Map <String, ArrayList> DataValues;
	/**
	 * ������ �������
	 */	
	
	GrafData() {
		this.Title = null;
		this.DataValues = null;
		this.Correct = false;
	}

	/**
	 * ������� ������ ������ ������� �� �������� � ���� ��������
	 * @param Title
	 * @param X
	 * @param Y
	 */
	GrafData(GrafDataTitle Title, ArrayList <Float> X, ArrayList <Float> Y) {
		
		if( checkTitle(Title) && !X.isEmpty() && !Y.isEmpty() && X.size() == Y.size() ) {
			this.Title = Title;
			this.DataValues = new HashMap <String, ArrayList>();
			DataValues.put("X", X);
			DataValues.put("Y", Y);
			makeTitleFromDataArray();
			this.Correct = true;
		}
	}
	
	
	//------------------ set ------------------

	/**
	 * ��������� ���������� �������� �������
	 * @param Title
	 * @return
	 */
	private boolean checkTitle(GrafDataTitle Title) {
		boolean Result = true;
			if(Title.getName().equals("") || Title.getName()==null) {
				Result = false;
			}
		return Result;
	}
	
	
	//------------------ get ------------------
	
	/**
	 * ���������� �������� ������ �������
	 * @return
	 */
	public GrafDataTitle getTitle() {
		return this.Title;
	}
	
	public ArrayList <Float> getGrafDataX() {
		return this.DataValues.get("X");
	}
	
	public ArrayList <Float> getGrafDataY() {
		return this.DataValues.get("Y");
	}
	
	public Map <String, ArrayList> getValues() {
		return this.DataValues;
	}
	
	
	
	//------------------ status ------------------
	
	boolean isCorrect() {
		return this.Correct;
	}
	
	
	
	//------------------ private ------------------
	
	/**
	 * ����� ������������� ������������ � ����������� �������� � title 
	 */
	private void makeTitleFromDataArray() {
		ArrayList <Float> X = this.DataValues.get("X");
		ArrayList <Float> Y = this.DataValues.get("Y");
		
		float min = X.get(0);
		float max = X.get(X.size()-1);
		
		for(float temp : X) {
			if( temp < min ) min = temp;
			if( temp > max ) max = temp;
		}
		
		this.Title.setMaxX(max);
		this.Title.setMinX(min);

		min = Y.get(0);
		max = Y.get(Y.size()-1);
		
		for(float temp : Y) {
			if( temp < min ) min = temp;
			if( temp > max ) max = temp;
		}		

		this.Title.setMaxY(max);
		this.Title.setMinY(min);		
	}
}

