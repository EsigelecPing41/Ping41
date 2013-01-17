package Modele;
import java.util.Date;


public class ActionAssemblage  extends Action
{

	    private int AA_A_ID;
	    private int AA_L_ID;
	    private int AA_ID;
	    

		public ActionAssemblage(int AA_A_IDDate, int AA_L_ID,int AA_ID,Date aA_Date, int aA_IDOperateur, int aA_IDOperation) {
			
			super(aA_Date, aA_IDOperateur, aA_IDOperation);
			
			this.AA_ID = AA_ID;
		    this.AA_L_ID=AA_L_ID;
		    this.AA_ID=AA_ID;
		}
	    
	    public int getAA_A_ID()
	    {
	        return this.AA_A_ID;
	    }
	    public void setAA_A_ID(final int value)
	    {
	        this.AA_A_ID = value;
	    }
	    
    
	    
	    public int getAA_ID()
	    {
	        return this.AA_ID;
	    }
	    public void setAA_ID(final int value)
	    {
	        this.AA_ID = value;
	    }
	    
	    public int getAA_L_ID()
	    {
	        return this.AA_L_ID;
	    }
	    public void setAA_L_ID(final int value)
	    {
	        this.AA_L_ID = value;
	    }
	       
	    
	    }



