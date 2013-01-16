package Modele;
import java.sql.Timestamp;
import java.util.Date;

public class Expedition 
{
    private Date Exp_Date;
    private int Exp_A_ID;
    private int Exp_BExp_ID;
    private int Exp_C_ID;
    private int Exp_ID;

    public Expedition( Timestamp Exp_Date, int Exp_C_ID ,int Exp_BExp_ID,int Exp_A_ID, int Exp_ID)//modif date to timeStamp
    {
    	this.Exp_Date=Exp_Date;
    	this.Exp_C_ID=Exp_C_ID;
    	this.Exp_BExp_ID=Exp_BExp_ID;
    	this.Exp_A_ID=Exp_A_ID;
    	this.Exp_ID=Exp_ID;
    }

    public Date getExp_Date() 
    {
        return this.Exp_Date;
    }

    public void setExp_Date(final Date value) 
    {
        this.Exp_Date = value;
    }
    
    
    public int getExp_ID()
    {
        return this.Exp_ID;
    }   
    public void setExp_ID (final int value)
    {
        this.Exp_ID = value;
    }
       
    public int getExp_A_ID()
    {
        return this.Exp_A_ID;
    }   
    public void setExp_A_ID(final int value)
    {
        this.Exp_A_ID = value;
    }
    
    
    
    public int getExp_C_ID()
    {
        return this.Exp_C_ID;
    }
    public void setExp_C_ID(final int value)
    {
        this.Exp_C_ID = value;
    }
    
    
    public int getExp_BExp_ID()
    {
        return this.Exp_BExp_ID;
    }
    public void setExp_BExp_ID(final int value)
    {
        this.Exp_BExp_ID = value;
    }
}

