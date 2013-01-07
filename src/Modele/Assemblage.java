package Modele;

public class Assemblage 
{
    private int A_ID;
    private String A_Nom;
    private String A_CodeBarre;
    private boolean A_Statut;
    private String A_ListPieces;

    public Assemblage(int ID, String nom, String CB,boolean statut, String listPieces)
    {
    	this.A_ID=ID;
    	this.A_Nom=nom;
    	this.A_CodeBarre=CB;
    	this.A_Statut=statut;
    	this.A_ListPieces=listPieces;
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


}
