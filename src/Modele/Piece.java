package Modele;

public class Piece 
{
    private int P_ID;
    private String P_Nom;
    private String P_CodeBarre;
    private String P_A_Nom;
    private boolean P_Statut;
    private String P_Commentaire;
   
    public Piece(int ID, String nom, String CB, String A_Nom, boolean statut,String Comm)
    {
    	this.P_ID = ID;
    	this.P_Nom = nom;
    	this.P_CodeBarre = CB;
    	this.P_A_Nom=A_Nom;
    	this.P_Statut = statut;
    	this.P_Commentaire=Comm;
    }
    public Piece(String nom, String A_Nom, boolean statut)
    {
       	this.P_Nom = nom;
    	this.P_A_Nom=A_Nom;
    	this.P_Statut = statut;
    }
    public Piece(String nom, String CB, String A_Nom, boolean statut)
    {
       	this.P_Nom = nom;
    	this.P_A_Nom=A_Nom;
    	this.P_Statut = statut;
    	this.P_CodeBarre=CB;
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

	public void setP_A_Nom(String p_A_Nom) 
	{
		P_A_Nom = p_A_Nom;
	}

	public String getP_A_Nom()
	{
		return P_A_Nom;
	}
	public void setP_Commentaire(String p_Commentaire) {
		P_Commentaire = p_Commentaire;
	}
	public String getP_Commentaire() {
		return P_Commentaire;
	}

}
