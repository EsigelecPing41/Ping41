package Modele;

public class Assemblage 
{
    private int A_ID;
    private String A_NumSerie;
    private String A_Nom;
    private String A_CodeBarre;
    /*Recuperer a partir de Piece, grace a P_A_Nom = A_Nom*/
    private String A_ListPieces;
    /*Recuperer a partir de Operation, grace a Op_A_Nom = A_Nom*/
    private String A_ListOperations;
    
    private boolean A_Statut;
    /*Recuperer a partir d'Ordonnancement, grace a Ord_NumSerie=A_NumSerie*/
    private String A_CodeClient;
    private String A_NumDossier;
    private String A_CodeGPAO;
    private String A_IndNomenclature;
    private String A_Designation;
    private String A_Of;
    private String A_NumAffaire;


    public Assemblage(int ID, String A_NumSerie,String nom, String CB,String CodeClient, String listPieces,String Operations,boolean statut,String A_NumDossier,String A_CodeGPAO,String A_IndNomenclature,String A_Designation ,String A_Of,String A_NumAffaire)
    {
    	this.A_ID=ID;
    	this.A_NumSerie= A_NumSerie;
    	this.A_Nom=nom;
    	this.A_CodeBarre=CB;
    	this.A_CodeClient=CodeClient;
    	this.A_ListPieces=listPieces;
    	this.A_ListOperations=Operations;
    	this.A_Statut=statut;
    	
    	this.A_NumDossier=A_NumDossier;
    	this.A_CodeGPAO=A_CodeGPAO;
    	this.A_IndNomenclature=A_IndNomenclature;
    	this.A_Designation=A_Designation;
    	this.A_Of=A_Of;
    	this.A_NumAffaire=A_NumAffaire;
    }
    
    public Assemblage(String A_NumSerie,String nom, String CB,String CodeClient, String listPieces,String Operations,boolean statut,String A_NumDossier,String A_CodeGPAO,String A_IndNomenclature,String A_Designation ,String A_Of,String A_NumAffaire)
    {
    	this.A_NumSerie= A_NumSerie;
    	this.A_Nom=nom;
    	this.A_CodeBarre=CB;
    	this.A_CodeClient=CodeClient;
    	this.A_ListPieces=listPieces;
    	this.A_ListOperations=Operations;
    	this.A_Statut=statut;
    	
    	this.A_NumDossier=A_NumDossier;
    	this.A_CodeGPAO=A_CodeGPAO;
    	this.A_IndNomenclature=A_IndNomenclature;
    	this.A_Designation=A_Designation;
    	this.A_Of=A_Of;
    	this.A_NumAffaire=A_NumAffaire;
    }
    
    public int getA_ID() 
    {
        return this.A_ID;
    }

    public void setA_ID(final int value)
    {
        this.A_ID = value;
    }

    public String getA_Nom() 
    {
        return this.A_Nom;
    }

    public void setA_Nom(String value)
    {
        this.A_Nom = value;
    }

	public void setA_CodeBarre(String CB) 
	{
		A_CodeBarre = CB;
	}

	public String getA_CodeBarre() 
	{
		return A_CodeBarre;
	}

	public void setA_Statut(boolean statut) 
	{
		A_Statut = statut;
	}

	public boolean getA_Statut() 
	{
		return A_Statut;
	}

	public void setListPieces(String listPieces) 
	{
		A_ListPieces = listPieces;
	}

	public String getListPieces() 
	{
		return A_ListPieces;
	}

	public void setA_ListOperations(String a_ListOperations) 
	{
		A_ListOperations = a_ListOperations;
	}

	public String getA_ListOperations()
	{
		return A_ListOperations;
	}

	public void setA_NumDossier(String a_NumDossier) 
	{
		A_NumDossier = a_NumDossier;
	}

	public String getA_NumDossier() 
	{
		return A_NumDossier;
	}

	public void setA_CodeGPAO(String a_CodeGPAO) 
	{
		A_CodeGPAO = a_CodeGPAO;
	}

	public String getA_CodeGPAO() 
	{
		return A_CodeGPAO;
	}

	public void setA_IndNomenclature(String a_IndNomenclature) 
	{
		A_IndNomenclature = a_IndNomenclature;
	}

	public String getA_IndNomenclature() 
	{
		return A_IndNomenclature;
	}

	public void setDesignation(String designation) 
	{
		A_Designation = designation;
	}

	public String getDesignation() 
	{
		return A_Designation;
	}

	public void setA_Designation(String a_Designation) 
	{
		A_Designation = a_Designation;
	}

	public String getA_Designation() 
	{
		return A_Designation;
	}

	public void setA_Of(String a_Of) 
	{
		A_Of = a_Of;
	}

	public String getA_Of()
	{
		return A_Of;
	}

	public void setA_NumAffaire(String a_NumAffaire) 
	{
		A_NumAffaire = a_NumAffaire;
	}

	public String getA_NumAffaire()
	{
		return A_NumAffaire;
	}

	
	public void setA_NumSerie(String a_NumSerie) 
	{
		A_NumSerie = a_NumSerie;
	}

	public String getA_NumSerie() 
	{
		return A_NumSerie;
	}

	public void setA_CodeClient(String a_CodeClient) 
	{
		A_CodeClient = a_CodeClient;
	}

	public String getA_CodeClient() 
	{
		return A_CodeClient;
	}


}
