package Modele;

public class Piece 
{
    private int P_ID;
    private String P_Nom;
    private String P_CodeBarre;
    private boolean P_Statut;
    
    public Piece(int ID, String nom, String CB,boolean statut)
    {
    	this.P_ID = ID;
    	this.P_Nom = nom;
    	this.P_CodeBarre = CB;
    	this.P_Statut = statut;
    }
    
    public int getP_ID()
    {
        return this.P_ID;
    }
    public void setP_ID(int value)
    {
        this.P_ID = value;
    }
    public String getP_Nom()
    {
        return this.P_Nom;
    }

    public void setP_Nom(String value) 
    {
        this.P_Nom = value;
    }

    public String getP_CodeBarre() 
    {
        return this.P_CodeBarre;
    }

    public void setP_CodeBarre(String value) 
    {
        this.P_CodeBarre = value;
    }


	public void setP_Statut(boolean p_Statut)
	{
		P_Statut = p_Statut;
	}

	public boolean getP_Statut() 
	{
		return P_Statut;
	}

}
