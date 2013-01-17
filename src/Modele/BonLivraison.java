package Modele;

import java.sql.Date;

public class BonLivraison
{
    private int BLiv_ID;
    private String BLiv_Designation;
    private int BLiv_Quantite;
    private String BLiv_Reference;
    private String BLiv_NumDossier;
    private String BLiv_Client;
    private Date BLiv_Date;
    
    public BonExpedition(int BExp_ID,String BExp_Designation, String BExp_Reference,String BExp_NumDossier,String BExp_Client,Date BExp_Date)
    {
       this.BExp_ID= BExp_ID;
       this.BExp_Designation=BExp_Designation;
       this.BExp_Reference=BExp_Reference;
       this.BExp_NumDossier=BExp_NumDossier;
       this.BExp_Client=BExp_Client;
       this.BExp_Date=BExp_Date;
    }
    
	
	
}
