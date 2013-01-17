package Modele;
import java.sql.Timestamp;


public class Livraison 
{
    private Timestamp Liv_Date;
    private int Liv_P_ID;
    private int Liv_Bliv_ID;
    private String Liv_F_CodeFournisseur;
    private int Liv_ID;

    
    public Livraison (Timestamp Liv_Date, int Liv_P_ID ,int Liv_Bliv_ID,String Liv_F_CodeFournisseur, int Liv_ID)
    {
    	this.Liv_Date=Liv_Date;
    	this.Liv_P_ID=Liv_P_ID;
    	this.Liv_Bliv_ID=Liv_Bliv_ID;
    	this.setLiv_F_CodeFournisseur(Liv_F_CodeFournisseur);
    	this.Liv_ID=Liv_ID;
    }

    public Timestamp getLiv_Date() 
    {
        return this.Liv_Date;
    }

    public void setLiv_Date(Timestamp value)
    {
        this.Liv_Date = value;
    }

    public int getLiv_ID()
    {
        return this.Liv_ID;
    }   
    public void setLiv_ID(int value)
    {
        this.Liv_ID = value;
    }
       
    public int getLiv_P_ID()
    {
        return this.Liv_P_ID;
    }   
    public void setLiv_P_ID(int value)
    {
        this.Liv_P_ID = value;
    }
    
    public int getLiv_Bliv_ID()
    {
        return this.Liv_Bliv_ID;
    }
    public void setLiv_Bliv_ID(int value)
    {
        this.Liv_Bliv_ID = value;
    }

	public void setLiv_F_CodeFournisseur(String liv_F_CodeFournisseur) {
		Liv_F_CodeFournisseur = liv_F_CodeFournisseur;
	}

	public String getLiv_F_CodeFournisseur() {
		return Liv_F_CodeFournisseur;
	}
}
