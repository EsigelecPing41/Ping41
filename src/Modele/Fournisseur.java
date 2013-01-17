package Modele;

public class Fournisseur 
{
    private String F_CodeFournisseur;
    private String F_Nom;
    private String F_Adresse;
    private String F_Description;
    
    public Fournisseur(String code, String Nom, String Adresse, String Description)
    {
    	this.F_CodeFournisseur= code;
    	this.F_Nom = Nom;
    	this.F_Adresse = Adresse;
    	this.F_Description=Description;
    }

    public String getF_Nom()
    {
        return this.F_Nom;
    }

    public String getF_Adresse() 
    {
        return this.F_Adresse;
    }

    public String getF_Description()
    {
        return this.F_Description;
    }

    public void setF_Nom(final String value)
    {
        this.F_Nom = value;
    }

    public void setF_Adresse(final String value) 
    {
        this.F_Adresse = value;
    }

    public void setF_Description(final String value) 
    {
        this.F_Description = value;
    }

	public void setF_CodeFournisseur(String f_CodeFournisseur) {
		F_CodeFournisseur = f_CodeFournisseur;
	}

	public String getF_CodeFournisseur() {
		return F_CodeFournisseur;
	}

}
