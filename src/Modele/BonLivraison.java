package Modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BonLivraison extends Bon 
{

    public List<Piece> Bliv_Pieces  = new ArrayList<Piece> ();
    private int Bliv_ID;
    private String Bliv_Fournisseur;
    private Date Bliv_Date;

	public BonLivraison (int Bliv_ID,String Bliv_Fournisseur,Date Bliv_Date, String  bliv_Designation,  String bliv_Reference,  String  bliv_NumDossier, int bliv_Quantite  ) {
		// TODO Auto-generated constructor stub
		
		super( bliv_Designation, bliv_Reference,  bliv_NumDossier,  bliv_Quantite );
	    
    	this.Bliv_ID = Bliv_ID;
    	this.Bliv_Fournisseur=Bliv_Fournisseur;
    	this.Bliv_Date = Bliv_Date;
	}
	

    public int getBliv_ID()
    {
        return this.Bliv_ID;
    }

    public void setBliv_ID(final int value)
    {
        this.Bliv_ID = value;
    }


    public Date getBliv_Date()
    {
        return this.Bliv_Date;
    }

    public void setBliv_Date(final Date value)
    {
        this.Bliv_Date = value;
    }

    public String getBliv_Fournisseur()
    {
        return this.Bliv_Fournisseur;
    }

    public void setBliv_Fournisseur(final String value)
    {
        this.Bliv_Fournisseur = value;
    }
    public void CreerBon() 
    {
    }

    public void SupprimerBon()
    {
    }

    public void ModifierBon() 
    {
    }

    public void AfficherBon() 
    {
    }
}
