package Modele;

import java.sql.Date;


public class ActionAssemblage 
{
    private int AA_ID;
    private int AA_A_ID;
    private int AA_O_ID;
    private int AA_Op_ID;
    private int AA_L_ID;
    private Date AA_Date;

	public ActionAssemblage(int AA_ID,int AA_A_ID,int AA_O_ID,int AA_Op_ID,int AA_L_ID,Date AA_Date) 
	{
		this.AA_ID=AA_ID;
	    this.AA_A_ID=AA_A_ID;
	    this.AA_O_ID=AA_O_ID;
	    this.AA_Op_ID=AA_Op_ID;
	    this.AA_L_ID=AA_L_ID;
	    this.AA_Date=AA_Date;
	}

	public ActionAssemblage(int AA_A_ID,int AA_O_ID,int AA_Op_ID,int AA_L_ID,Date AA_Date)
	{
		 this.AA_A_ID=AA_A_ID;
		 this.AA_O_ID=AA_O_ID;
		 this.AA_Op_ID=AA_Op_ID;
		 this.AA_L_ID=AA_L_ID;
		 this.AA_Date=AA_Date;
	}
	
	public void setAA_ID(int aA_ID) {
		AA_ID = aA_ID;
	}

	public int getAA_ID() {
		return AA_ID;
	}

	public void setAA_A_ID(int aA_A_ID) {
		AA_A_ID = aA_A_ID;
	}

	public int getAA_A_ID() {
		return AA_A_ID;
	}

	public void setAA_O_ID(int aA_O_ID) {
		AA_O_ID = aA_O_ID;
	}

	public int getAA_O_ID() {
		return AA_O_ID;
	}

	public void setAA_Op_ID(int aA_Op_ID) {
		AA_Op_ID = aA_Op_ID;
	}

	public int getAA_Op_ID() {
		return AA_Op_ID;
	}

	public void setAA_L_ID(int aA_L_ID) {
		AA_L_ID = aA_L_ID;
	}

	public int getAA_L_ID() {
		return AA_L_ID;
	}

	public void setAA_Date(Date aA_Date) {
		AA_Date = aA_Date;
	}

	public Date getAA_Date() {
		return AA_Date;
	}


}

