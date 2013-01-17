package Modele;

public class Client 
{
    private String C_CodeClient;
    private String C_Nom;
    private String C_Adresse;
    private String C_Description;
    private String C_Mdp;
    
    public Client(String code, String Nom, String Adresse, String Description,String mdp)
    {
    	this.C_CodeClient = code;
    	this.C_Nom = Nom;
    	this.C_Adresse = Adresse;
    	this.C_Description=Description;
    	this.C_Mdp=mdp;
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

	public void setC_CodeClient(String c_CodeClient) {
		C_CodeClient = c_CodeClient;
	}

	public String getC_CodeClient() {
		return C_CodeClient;
	}

}
