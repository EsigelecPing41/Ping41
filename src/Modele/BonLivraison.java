package Modele;

import java.sql.Date;

public class BonLivraison
{
    private int BLiv_ID;
    private String BLiv_Designation;
    private int BLiv_Quantite;
    private String BLiv_Reference;
    private String BLiv_NumDossier;
    private String BLiv_Fournisseur;
    private Date BLiv_Date;
    
    public BonLivraison(int ID,String Designation,int Quantite, String Reference,String NumDossier,String Fournisseur,Date Date)
    {
       this.setBLiv_ID(ID);
       this.setBLiv_Designation(Designation);
       this.setBLiv_Quantite(Quantite);
       this.setBLiv_Reference(Reference);
       this.setBLiv_NumDossier(NumDossier);
       this.setBLiv_Fournisseur(Fournisseur);
       this.setBLiv_Date(Date);
    }

	public void setBLiv_ID(int bLiv_ID) {
		BLiv_ID = bLiv_ID;
	}

	public int getBLiv_ID() {
		return BLiv_ID;
	}

	public void setBLiv_Designation(String bLiv_Designation) {
		BLiv_Designation = bLiv_Designation;
	}

	public String getBLiv_Designation() {
		return BLiv_Designation;
	}

	public void setBLiv_Quantite(int bLiv_Quantite) {
		BLiv_Quantite = bLiv_Quantite;
	}

	public int getBLiv_Quantite() {
		return BLiv_Quantite;
	}

	public void setBLiv_Reference(String bLiv_Reference) {
		BLiv_Reference = bLiv_Reference;
	}

	public String getBLiv_Reference() {
		return BLiv_Reference;
	}

	public void setBLiv_NumDossier(String bLiv_NumDossier) {
		BLiv_NumDossier = bLiv_NumDossier;
	}

	public String getBLiv_NumDossier() {
		return BLiv_NumDossier;
	}

	public void setBLiv_Fournisseur(String bLiv_Fournisseur) {
		BLiv_Fournisseur = bLiv_Fournisseur;
	}

	public String getBLiv_Fournisseur() {
		return BLiv_Fournisseur;
	}

	public void setBLiv_Date(Date bLiv_Date) {
		BLiv_Date = bLiv_Date;
	}

	public Date getBLiv_Date() {
		return BLiv_Date;
	}
    
	
	
}
