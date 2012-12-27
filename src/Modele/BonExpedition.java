package Modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BonExpedition extends Bon
{
    public List<Piece> BExp_Pieces  = new ArrayList<Piece> ();
    private int BExp_ID;
    private String BExp_Client;
    private Date BExp_Date;

	public BonExpedition (int BExp_ID, String BExp_Client, Date BExp_Date, String bExp_Designation, String bExp_Reference, String bExp_NumDossier, int bExp_Quantite ) {
		
		super( bExp_Designation, bExp_Reference, bExp_NumDossier, bExp_Quantite);
    
    	this.BExp_Client = BExp_Client;
    	this.BExp_Date =BExp_Date;
    	this.BExp_ID = BExp_ID;
	}
	
    public int getBExp_ID()
    {
        return this.BExp_ID;
    }

    public void setBExp_ID(final int value)
    {
        this.BExp_ID = value;
    }
   
    public Date getBExp_Date()
    {
        return this.BExp_Date;
    }

    public void setBExp_Date(final Date value)
    {
        this.BExp_Date = value;
    }

    public String getBExp_Client()
    {
        return this.BExp_Client;
    }

    public void setBExp_Client(final String value)
    {
        this.BExp_Client = value;
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
