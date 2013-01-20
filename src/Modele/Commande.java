package Modele;
import java.util.Date;


public class Commande 
{
    private Date Com_Date;
    private String Com_F_CodeFournisseur;
    private int Com_BCom_ID;
    private int Com_P_ID;
    private int Com_ID;


    public Commande(Date Com_Date,String Com_F_CodeFournisseur ,int Com_BCom_ID,int Com_P_ID, int Com_ID)
    {
    	this.Com_Date=Com_Date;
    	this.setCom_F_CodeFournisseur(Com_F_CodeFournisseur);
    	this.Com_BCom_ID=Com_BCom_ID;
    	this.Com_P_ID=Com_P_ID;
    	this.Com_ID=Com_ID;
    }
    
    public Commande(Date Com_Date,String Com_F_CodeFournisseur ,int Com_BCom_ID,int Com_P_ID)
    {
    	this.Com_Date=Com_Date;
    	this.setCom_F_CodeFournisseur(Com_F_CodeFournisseur);
    	this.Com_BCom_ID=Com_BCom_ID;
    	this.Com_P_ID=Com_P_ID;
    }
    
    public void setCom_ID(final int value) 
    {
        this.Com_ID = value;
    }

    public int getCom_ID()
    {
        return this.Com_ID;
    }

    public void setCom_Date(final Date value) 
    {
        this.Com_Date = value;
    }

    public Date getCom_Date()
    {
        return this.Com_Date;
    }
  
    public int getCom_P_ID()
    {
        return this.Com_P_ID;
    }
    public void setCom_P_ID(final int value)
    {
        this.Com_P_ID = value;
    }
    
    public int getCom_BCom_ID()
    {
        return this.Com_BCom_ID;
    }
    public void setCom_BCom_ID(final int value)
    {
        this.Com_BCom_ID = value;
    }

	public void setCom_F_CodeFournisseur(String com_F_CodeFournisseur) {
		Com_F_CodeFournisseur = com_F_CodeFournisseur;
	}

	public String getCom_F_CodeFournisseur() {
		return Com_F_CodeFournisseur;
	}
}
