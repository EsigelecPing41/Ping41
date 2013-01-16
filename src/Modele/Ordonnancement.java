package Modele;

import java.util.Date;

	public class Ordonnancement
	{
	    private int Ord_ID;
	    private String Ord_Designation;
	    private int Ord_QteFab;
	    private String Ord_Ste;
	    private String Ord_CodeClient;
	    private Date Ord_DelaiCde;
	    private Date Ord_MFab;
	    private Date Ord_DelaiPrv;
	    private Date Ord_DelaiDde;
	    private String Ord_FamGest;
	    private String Ord_NumDossier;
	    private String Ord_CodeGPAO;
	    private String Ord_IndNomenclature;
	    private String Ord_NumSerie;
	    private String Ord_ComInterne;
	    private String Ord_NumAffaire;
	    private String Ord_Of;
	    
	    public Ordonnancement(int Ord_ID,
	    String Ord_Designation,
	    int Ord_QteFab,
	    String Ord_Ste,
	    String Ord_CodeClient,
	    Date Ord_DelaiCde,
	    Date Ord_MFab,
	    Date Ord_DelaiPrv,
	    Date Ord_DelaiDde,
	    String Ord_FamGest,
	    String Ord_NumDossier,
	    String Ord_CodeGPAO,
	    String Ord_IndNomenclature,
	    String Ord_NumSerie,
	    String Ord_ComInterne,
	    String Ord_NumAffaire,
	    String Ord_Of)
	    {
	    	this.Ord_CodeClient=Ord_CodeClient;
	    	this.Ord_CodeGPAO=Ord_CodeGPAO;
	    	this.Ord_ComInterne=Ord_ComInterne;
	    	this.Ord_DelaiCde=Ord_DelaiCde;
	    	this.Ord_DelaiDde=Ord_DelaiDde;
	    	this.Ord_DelaiPrv=Ord_DelaiPrv;
	    	this.Ord_Designation=Ord_Designation;
	    	this.Ord_FamGest=Ord_FamGest;
	    	this.Ord_ID=Ord_ID;
	    	this.Ord_IndNomenclature=Ord_IndNomenclature;
	    	this.Ord_MFab=Ord_MFab;
	    	this.Ord_NumDossier=Ord_NumDossier;
	    	this.Ord_NumSerie=Ord_NumSerie;
	    	this.Ord_QteFab=Ord_QteFab;
	    	this.Ord_Ste=Ord_Ste;
	    	this.Ord_NumAffaire=Ord_NumAffaire;
	    	this.Ord_Of=Ord_Of;
	    }
	    
		public void setOrd_ID(int ord_ID)
		{
			Ord_ID = ord_ID;
		}
		public int getOrd_ID() 
		{
			return Ord_ID;
		}
		public void setOrd_Designation(String ord_Designation) 
		{
			Ord_Designation = ord_Designation;
		}
		public String getOrd_Designation() 
		{
			return Ord_Designation;
		}
		public void setOrd_QteFab(int ord_QteFab)
		{
			Ord_QteFab = ord_QteFab;
		}
		public int getOrd_QteFab() 
		{
			return Ord_QteFab;
		}
		public void setOrd_Ste(String ord_Ste)
		{
			Ord_Ste = ord_Ste;
		}
		public String getOrd_Ste() 
		{
			return Ord_Ste;
		}
		public void setOrd_CodeClient(String ord_CodeClient) 
		{
			Ord_CodeClient = ord_CodeClient;
		}
		public String getOrd_CodeClient() 
		{
			return Ord_CodeClient;
		}
		public void setOrd_DelaiCde(Date ord_DelaiCde)
		{
			Ord_DelaiCde = ord_DelaiCde;
		}
		public Date getOrd_DelaiCde()
		{
			return Ord_DelaiCde;
		}
		public void setOrd_MFab(Date ord_MFab)
		{
			Ord_MFab = ord_MFab;
		}
		public Date getOrd_MFab() 
		{
			return Ord_MFab;
		}
		public void setOrd_DelaiPrv(Date ord_DelaiPrv)
		{
			Ord_DelaiPrv = ord_DelaiPrv;
		}
		public Date getOrd_DelaiPrv() 
		{
			return Ord_DelaiPrv;
		}
		public void setOrd_DelaiDde(Date ord_DelaiDde)
		{
			Ord_DelaiDde = ord_DelaiDde;
		}
		public Date getOrd_DelaiDde() 
		{
			return Ord_DelaiDde;
		}
		public void setOrd_FamGest(String ord_FamGest) 
		{
			Ord_FamGest = ord_FamGest;
		}
		public String getOrd_FamGest() 
		{
			return Ord_FamGest;
		}
		public void setOrd_NumDossier(String ord_NumDossier)
		{
			Ord_NumDossier = ord_NumDossier;
		}
		public String getOrd_NumDossier() 
		{
			return Ord_NumDossier;
		}
		public void setOrd_CodeGPAO(String ord_CodeGPAO) 
		{
			Ord_CodeGPAO = ord_CodeGPAO;
		}
		public String getOrd_CodeGPAO() 
		{
			return Ord_CodeGPAO;
		}
		public void setOrd_IndNomenclature(String ord_IndNomenclature)
		{
			Ord_IndNomenclature = ord_IndNomenclature;
		}
		public String getOrd_IndNomenclature() 
		{
			return Ord_IndNomenclature;
		}
		public void setOrd_NumSerie(String ord_NumSerie) 
		{
			Ord_NumSerie = ord_NumSerie;
		}
		public String getOrd_NumSerie()
		{
			return Ord_NumSerie;
		}
		public void setOrd_ComInterne(String ord_ComInterne) 
		{
			Ord_ComInterne = ord_ComInterne;
		}
		public String getOrd_ComInterne() 
		{
			return Ord_ComInterne;
		}

		public void setOrd_NumAffaire(String ord_NumAffaire) {
			Ord_NumAffaire = ord_NumAffaire;
		}

		public String getOrd_NumAffaire() {
			return Ord_NumAffaire;
		}

		public void setOrd_Of(String ord_Of) {
			Ord_Of = ord_Of;
		}

		public String getOrd_Of() {
			return Ord_Of;
		}

	}


