package Modele;

import java.util.ArrayList;

public class Assemblage 
{
    private int A_ID;
    private String A_Nom;
    private String A_Ref;
    private ArrayList<Integer> A_ListPiece;

    public Assemblage(int ID, String nom, String ref)
    {
    	this.A_ID=ID;
    	this.A_Nom=nom;
    	this.A_Ref=ref;
    }
    
    public boolean ajouterPieceAssemblage(int ID)
    {
    	if(!this.A_ListPiece.contains(ID))
    	{
    		this.A_ListPiece.add(ID);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public boolean supprimerPieceAssemblage(int ID)
    {
    	if(this.A_ListPiece.contains(ID))
    	{
    		this.A_ListPiece.remove(ID);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
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

	public void setA_List(ArrayList<Integer> a_List) 
	{
		A_ListPiece = a_List;
	}

	public ArrayList<Integer> getA_List() 
	{
		return A_ListPiece;
	}


}
