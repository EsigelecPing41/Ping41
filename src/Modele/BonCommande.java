package Modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BonCommande extends Bon
{
    public List<Piece> BCom_Pieces  = new ArrayList<Piece> ();
    private int BCom_ID;
    private String BCom_Fournisseur;
    private Date BCom_Date;

	public BonCommande(int BCom_ID, String BCom_Fournisseur, Date BCom_Date, String bCom_Designation, String bCom_Reference, String bCom_NumDossier, int bCom_Quantite  ) {
		// TODO Auto-generated constructor stub
		super( bCom_Designation, bCom_Reference,  bCom_NumDossier,  bCom_Quantite );
	    
    	this.BCom_Fournisseur = BCom_Fournisseur;
    	this.BCom_Date=BCom_Date;
    	this.BCom_ID = BCom_ID;
	}
	

    public int getBCom_ID()
    {
        return this.BCom_ID;
    }

    public void setBCom_ID(final int value)
    {
        this.BCom_ID = value;
    }
    
    public Date getBCom_Date()
    {
        return this.BCom_Date;
    }

    public void setBCom_Date(final Date value)
    {
        this.BCom_Date = value;
    }

    public String getBCom_Fournisseur()
    {
        return this.BCom_Fournisseur;
    }

    public void setBCom_Fournisseur(final String value)
    {
        this.BCom_Fournisseur = value;
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
