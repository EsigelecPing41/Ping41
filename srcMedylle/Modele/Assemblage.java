package Modele;

import java.sql.Array;

public class Assemblage 
{
    private int A_ID;
    private String A_Nom;
    private String A_Ref;
    private Array A_IDPieces;

    public Assemblage(int ID, String nom, String ref,Array Pieces)
    {
    	this.A_ID=ID;
    	this.A_Nom=nom;
    	this.A_Ref=ref;
    	this.A_IDPieces = Pieces;
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

    public void setA_Nom(final String value)
    {
        this.A_Nom = value;
    }

	public void setA_Ref(String a_Ref) 
	{
		A_Ref = a_Ref;
	}

	public String getA_Ref() 
	{
		return A_Ref;
	}

	public void setA_IDPieces(Array a_IDPieces) 
	{
		A_IDPieces = a_IDPieces;
	}

	public Array getA_IDPieces() 
	{
		return A_IDPieces;
	}

}
