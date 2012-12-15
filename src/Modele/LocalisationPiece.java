package Modele;

import java.util.Date;


public class LocalisationPiece {
	private int LP_Id;
	private Date LP_Date;
	private int LP_O_ID;
	private int LP_L_ID;
	
	public LocalisationPiece(int lP_Id, Date lP_Date, int lP_O_ID, int lP_L_ID) {
		super();
		LP_Id = lP_Id;
		LP_Date = lP_Date;
		LP_O_ID = lP_O_ID;
		LP_L_ID = lP_L_ID;
	}
	
	public int getLP_Id() {
		return LP_Id;
	}
	public void setLP_Id(int lP_Id) {
		LP_Id = lP_Id;
	}
	public Date getLP_Date() {
		return LP_Date;
	}
	public void setLP_Date(Date lP_Date) {
		LP_Date = lP_Date;
	}
	public int getLP_O_ID() {
		return LP_O_ID;
	}
	public void setLP_O_ID(int lP_O_ID) {
		LP_O_ID = lP_O_ID;
	}
	public int getLP_L_ID() {
		return LP_L_ID;
	}
	public void setLP_L_ID(int lP_L_ID) {
		LP_L_ID = lP_L_ID;
	}
	
	
}
