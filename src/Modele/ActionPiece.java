package Modele;

import java.sql.Date;


public class ActionPiece 
{
    private int AP_ID;
    private int AP_P_ID;
    private int AP_O_ID;
    private int AP_Op_ID;
    private int AP_L_ID;
    private Date AP_Date;

	public ActionPiece(int AP_ID,int AP_P_ID,int AP_O_ID,int AP_Op_ID,int AP_L_ID,Date AP_Date) 
	{
		this.AP_ID=AP_ID;
	    this.AP_P_ID=AP_P_ID;
	    this.AP_O_ID=AP_O_ID;
	    this.AP_Op_ID=AP_Op_ID;
	    this.AP_L_ID=AP_L_ID;
	    this.AP_Date=AP_Date;
	}
	
	public ActionPiece(int AP_P_ID,int AP_O_ID,int AP_Op_ID,int AP_L_ID,Date AP_Date)
	{
		 this.AP_P_ID=AP_P_ID;
		 this.AP_O_ID=AP_O_ID;
		 this.AP_Op_ID=AP_Op_ID;
		 this.AP_L_ID=AP_L_ID;
		 this.AP_Date=AP_Date;
	}

	public void setAP_ID(int aP_ID) {
		AP_ID = aP_ID;
	}

	public int getAP_ID() {
		return AP_ID;
	}

	public void setAP_P_ID(int aP_P_ID) {
		AP_P_ID = aP_P_ID;
	}

	public int getAP_P_ID() {
		return AP_P_ID;
	}

	public void setAP_O_ID(int aP_O_ID) {
		AP_O_ID = aP_O_ID;
	}

	public int getAP_O_ID() {
		return AP_O_ID;
	}

	public void setAP_Op_ID(int aP_Op_ID) {
		AP_Op_ID = aP_Op_ID;
	}

	public int getAP_Op_ID() {
		return AP_Op_ID;
	}

	public void setAP_L_ID(int aP_L_ID) {
		AP_L_ID = aP_L_ID;
	}

	public int getAP_L_ID() {
		return AP_L_ID;
	}

	public void setAP_Date(Date aP_Date) {
		AP_Date = aP_Date;
	}

	public Date getAP_Date() {
		return AP_Date;
	}
}

