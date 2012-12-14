package Modele;
import java.util.ArrayList;
import java.util.List;

public class Client 
{
    private int C_ID;

    private String C_Nom;
    private String C_Adresse;
    private String C_Description;
    public List<BonExpedition> C_BonExpedition = new ArrayList<BonExpedition> ();


    public Client(int C_ID, String C_Nom, String C_Adresse, String C_Description) {
		this.C_ID = C_ID;
		this.C_Nom = C_Nom;
		this.C_Adresse = C_Adresse;
		this.C_Description = C_Description;
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

    public void setC_ID(final int value) 
    {
        this.C_ID = value;
    }

    public void setC_Adresse(final String value)
    {
        this.C_Adresse = value;
    }

    public void setC_Description(final String value)
    {
        this.C_Description = value;
    }

    public void setC_Nom(final String value) 
    {
        this.C_Nom = value;
    }

    public void CreerClient()
    {
    }
    public void ModifierClient() 
    {
    }

    public void SupprimerClient() 
    {
    }

    public void AfficherClient()
    {
    }

	public String getC_Mdp() {
		// TODO Auto-generated method stub
		return null;
	}

}
