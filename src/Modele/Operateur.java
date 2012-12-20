package Modele;

public class Operateur 
{
    private int O_ID;
    private String O_Nom;
    private String O_Prenom;
    private String O_MotDePasse;
    private Parametre O_Parametre;

    public Operateur(int ID,String nom,String prenom,String mdp)
    {
    	this.O_ID= ID;
    	this.O_Nom= nom;
    	this.O_Prenom= prenom;
    	this.O_MotDePasse=mdp;
    	this.O_Parametre = new Parametre();
    }
    
    public Parametre getO_Parametre() {
		return O_Parametre;
	}

	public void setO_Parametre(Parametre o_Parametre) {
		O_Parametre = o_Parametre;
	}

	public Operateur(int ID,String nom,String prenom)
    {
    	this.O_ID= ID;
    	this.O_Nom= nom;
    	this.O_Prenom= prenom;
    }
    
    public int getO_ID()
    {
        return this.O_ID;
    }

    public void setO_ID(final int value)
    {
        this.O_ID = value;
    }

    public String getO_Nom() 
    {
        return this.O_Nom;
    }

    public void setO_Nom(final String value)
    {
        this.O_Nom = value;
    }

    public String getO_Prenom()
    {
        return this.O_Prenom;
    }

    public void setO_Prenom(final String value) 
    {
        this.O_Prenom = value;
    }

	public void setO_MotDePasse(String o_MotDePasse) 
	{
		O_MotDePasse = o_MotDePasse;
	}

	public String getO_MotDePasse() 
	{
		return O_MotDePasse;
	}

}

