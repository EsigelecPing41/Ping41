package Modele;
import java.sql.Date;

public class Expedition 
{
    private Date Exp_Date;
    private java.util.Date Exp_Date;
    private int Exp_A_ID;
    private int Exp_BExp_ID;
    private String Exp_C_CodeClient;
    private int Exp_ID;

    public Expedition(Date Exp_Date,String Exp_CodeClient ,int Exp_BExp_ID,int Exp_A_ID, int Exp_ID)
    public Expedition(java.util.Date dt,String Exp_CodeClient ,int Exp_BExp_ID,int Exp_A_ID, int Exp_ID)
    {
    	this.Exp_Date=Exp_Date;
    	this.Exp_Date=dt;
    	this.Exp_C_CodeClient=Exp_CodeClient;
    	this.Exp_BExp_ID=Exp_BExp_ID;
    	this.Exp_A_ID=Exp_A_ID;
    	this.Exp_ID=Exp_ID;
    }
    
    public Date getExp_Date() 
    public java.util.Date getExp_Date() 








    {
		return Exp_Date;
	}

	public void setExp_Date(Date exp_Date) 
	public void setExp_Date(java.util.Date exp_Date) 
	{
		Exp_Date = exp_Date;
	}

	public int getExp_ID()
    {
        return this.Exp_ID;
    }   
    public void setExp_ID (int value)
    {
        this.Exp_ID = value;
    }
       
    public int getExp_A_ID()
    {
        return this.Exp_A_ID;
    }   
    public void setExp_A_ID(int value)
    {
        this.Exp_A_ID = value;
    }    
    
    public int getExp_BExp_ID()
    {
        return this.Exp_BExp_ID;
    }
    public void setExp_BExp_ID(int value)
    {
        this.Exp_BExp_ID = value;
    }

	public void setExp_C_CodeClient(String exp_C_CodeClient)
	{
		Exp_C_CodeClient = exp_C_CodeClient;
	}

	public String getExp_C_CodeClient()
	{
		return Exp_C_CodeClient;
	}
}

