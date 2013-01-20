package Modele;

import java.sql.Date;

public class BonExpedition 
{
    private int BExp_ID;
    private String BExp_Designation;
    private int BExp_Quantite;
    private String BExp_Reference;
    private String BExp_NumDossier;
    private String BExp_Client;
    private Date BExp_Date;
    
    public BonExpedition(int BExp_ID,String BExp_Designation,int BExp_Quantite,String BExp_Reference,String BExp_NumDossier,String BExp_Client,Date BExp_Date)
    {
       this.BExp_ID= BExp_ID;
       this.BExp_Designation=BExp_Designation;
       this.BExp_Quantite=BExp_Quantite;
       this.BExp_Reference=BExp_Reference;
       this.BExp_NumDossier=BExp_NumDossier;
       this.BExp_Client=BExp_Client;
       this.BExp_Date=BExp_Date;
    }
    
    public BonExpedition(String BExp_Designation,int BExp_Quantite,String BExp_Reference,String BExp_NumDossier,String BExp_Client,Date BExp_Date)
    {
       this.BExp_Designation=BExp_Designation;
       this.BExp_Quantite=BExp_Quantite;
       this.BExp_Reference=BExp_Reference;
       this.BExp_NumDossier=BExp_NumDossier;
       this.BExp_Client=BExp_Client;
       this.BExp_Date=BExp_Date;
    }
    
	public void setBExp_ID(int bExp_ID) {
		BExp_ID = bExp_ID;
	}
	public int getBExp_ID() {
		return BExp_ID;
	}
	public void setBExp_Designation(String bExp_Designation) {
		BExp_Designation = bExp_Designation;
	}
	public String getBExp_Designation() {
		return BExp_Designation;
	}
	public void setBExp_Reference(String bExp_Reference) {
		BExp_Reference = bExp_Reference;
	}
	public String getBExp_Reference() {
		return BExp_Reference;
	}
	public void setBExp_NumDossier(String bExp_NumDossier) {
		BExp_NumDossier = bExp_NumDossier;
	}
	public String getBExp_NumDossier() {
		return BExp_NumDossier;
	}
	
	public void setBExp_Client(String bExp_Client) {
		BExp_Client = bExp_Client;
	}
	public String getBExp_Client() {
		return BExp_Client;
	}
	public void setBExp_Date(Date bExp_Date) {
		BExp_Date = bExp_Date;
	}
	public Date getBExp_Date() {
		return BExp_Date;
	}

	public void setBExp_Quantite(int bExp_Quantite) {
		BExp_Quantite = bExp_Quantite;
	}

	public int getBExp_Quantite() {
		return BExp_Quantite;
	}
    
    
	
}
