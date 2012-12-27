package Modele;

public class Client 
{
    private int C_ID;
    private String C_Nom;
    private String C_Adresse;
    private String C_Description;
    private String C_Mdp;
    
    public Client(int ID, String Nom, String Adresse, String Description,String mdp)
    {
    	this.C_ID = ID;
    	this.C_Nom = Nom;
    	this.C_Adresse = Adresse;
    	this.C_Description=Description;
    	this.C_Mdp=mdp;
    }

    public int getC_ID() 
    {
        return this.C_ID;
    }

    public String getC_Nom() 
    {
        return this.C_Nom;
    }

    public String getC_Adresse() 
    {
        return this.C_Adresse;
    }

    public String getC_Description() 
    {
        return this.C_Description;
    }

    public void setC_ID(int value) 
    {
        this.C_ID = value;
    }

    public void setC_Adresse(String value)
    {
        this.C_Adresse = value;
    }

    public void setC_Description(String value)
    {
        this.C_Description = value;
    }

    public void setC_Nom(String value) 
    {
        this.C_Nom = value;
    }

	public void setC_Mdp(String c_Mdp) {
		C_Mdp = c_Mdp;
	}


	public String getC_Mdp() {
		return C_Mdp;
	}

}
