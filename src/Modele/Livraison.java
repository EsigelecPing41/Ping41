package Modele;
import java.util.Date;

public class Livraison 
{
    private Date Liv_Date;
    private int Liv_P_ID;
    private int Liv_Bliv_ID;
    private int Liv_F_ID;
    private int Liv_ID;

    
    public Livraison ( Date Liv_Date, int Liv_P_ID ,int Liv_Bliv_ID,int Liv_F_ID, int Liv_ID)
    {
    	this.Liv_Date=Liv_Date;
    	this.Liv_P_ID=Liv_P_ID;
    	this.Liv_Bliv_ID=Liv_Bliv_ID;
    	this.Liv_F_ID=Liv_F_ID;
    	this.Liv_ID=Liv_ID;
    }

    
    public Date getLiv_Date() 
    {
        return this.Liv_Date;
    }

    public void setLiv_Date(final Date value)
    {
        this.Liv_Date = value;
    }

    public int getLiv_ID()
    {
        return this.Liv_ID;
    }   
    public void setLiv_ID(final int value)
    {
        this.Liv_ID = value;
    }
       
    
    public int getLiv_P_ID()
    {
        return this.Liv_P_ID;
    }   
    public void setLiv_P_ID(final int value)
    {
        this.Liv_P_ID = value;
    }
    
    
    
    public int getLiv_F_ID()
    {
        return this.Liv_F_ID;
    }
    public void setLiv_F_ID(final int value)
    {
        this.Liv_F_ID = value;
    }
    
    
    public int getLiv_Bliv_ID()
    {
        return this.Liv_Bliv_ID;
    }
    public void setLiv_Bliv_ID(final int value)
    {
        this.Liv_Bliv_ID = value;
    }
}
