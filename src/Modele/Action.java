package Modele;

import java.util.Date;

public class Action{
	private Date A_Date;
    private int A_IDOperateur;
    private int A_IDOperation;
    
	public Action(Date a_Date, int a_IDOperateur, int a_IDOperation) {
		super();
		A_Date = a_Date;
		A_IDOperateur = a_IDOperateur;
		A_IDOperation = a_IDOperation;
	}

	public Date getA_Date() {
		return A_Date;
	}

	public void setA_Date(Date a_Date) {
		A_Date = a_Date;
	}

	public int getA_IDOperateur() {
		return A_IDOperateur;
	}

	public void setAP_IDOperateur(int a_IDOperateur) {
		A_IDOperateur = a_IDOperateur;
	}

	public int getA_IDOperation() {
		return A_IDOperation;
	}

	public void setA_IDOperation(int a_IDOperation) {
		A_IDOperation = a_IDOperation;
	}
    
}
