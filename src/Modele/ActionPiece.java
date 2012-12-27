package Modele;
import java.util.Date;

public class ActionPiece  extends Action
{
    private int AP_P_ID;
    private int AP_L_ID;
    private int AP_ID;


	public ActionPiece(int AP_P_ID, int AP_L_ID,int AP_ID,Date aP_Date, int aP_IDOperateur, int aP_IDOperation) {
		
		super(aP_Date, aP_IDOperateur, aP_IDOperation);
		
		this.AP_P_ID= AP_P_ID;
	    this.AP_L_ID=AP_L_ID;
	    this.AP_ID=AP_ID;
	}

    
    
    
    public int getAP_P_ID()
    {
        return this.AP_P_ID;
    }
    public void setAP_P_ID(final int value)
    {
        this.AP_P_ID = value;
    }
    
  
    public int getAP_ID()
    {
        return this.AP_ID;
    }
    public void setAP_ID(final int value)
    {
        this.AP_ID = value;
    }
    
    public int getAP_L_ID()
    {
        return this.AP_L_ID;
    }
    public void setAP_L_ID(final int value)
    {
        this.AP_L_ID = value;
    }
     

}

