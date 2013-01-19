package Modele;

import java.sql.Date;

public class BonCommande
{
    private int BCom_ID;
    private String BCom_Designation;
    private int BCom_Quantite;
    private String BCom_Reference;
    private String BCom_NumDossier;
    private String BCom_Fournisseur;
    private Date BCom_Date;
    
    public BonCommande(int ID,String Designation,int Quantite, String Reference,String NumDossier,String Fournisseur,Date Date)
    {
       this.BCom_ID=ID;
       this.BCom_Designation=Designation;
       this.BCom_Quantite=Quantite;
       this.BCom_Reference=Reference;
       this.BCom_NumDossier=NumDossier;
       this.BCom_Fournisseur=Fournisseur;
       this.BCom_Date=Date;
    }

	public void setBCom_ID(int bCom_ID) {
		BCom_ID = bCom_ID;
	}

	public int getBCom_ID() {
		return BCom_ID;
	}

	public void setBCom_Designation(String bCom_Designation) {
		BCom_Designation = bCom_Designation;
	}

	public String getBCom_Designation() {
		return BCom_Designation;
	}

	public void setBCom_Quantite(int bCom_Quantite) {
		BCom_Quantite = bCom_Quantite;
	}

	public int getBCom_Quantite() {
		return BCom_Quantite;
	}

	public void setBCom_Reference(String bCom_Reference) {
		BCom_Reference = bCom_Reference;
	}

	public String getBCom_Reference() {
		return BCom_Reference;
	}

	public void setBCom_NumDossier(String bCom_NumDossier) {
		BCom_NumDossier = bCom_NumDossier;
	}

	public String getBCom_NumDossier() {
		return BCom_NumDossier;
	}

	public void setBCom_Fournisseur(String bCom_Fournisseur) {
		BCom_Fournisseur = bCom_Fournisseur;
	}

	public String getBCom_Fournisseur() {
		return BCom_Fournisseur;
	}

	public void setBCom_Date(Date bCom_Date) {
		BCom_Date = bCom_Date;
	}

	public Date getBCom_Date() {
		return BCom_Date;
	}
    
}
