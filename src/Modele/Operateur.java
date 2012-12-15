package Modele;
import java.util.ArrayList;


public class Operateur 
{
    private int O_ID;
    private String O_Nom;
    private String O_Prenom;
    private String O_Login;
    private String O_MotDePasse;
    private ArrayList<Lieu> O_ZoneAcces;
    private Parametre O_Parametre;

    public Operateur(int O_ID, String O_Nom, String O_Prenom) {
		this.O_ID = O_ID;
		this.O_Nom = O_Nom;
		this.O_Prenom = O_Prenom;
		this.O_Parametre = new Parametre();
	}

	public Operateur() {
		// TODO Auto-generated constructor stub
		this.O_Parametre = new Parametre();
	}

	public Parametre getO_Parametre() {
		return O_Parametre;
	}

	public void setO_Parametre(Parametre o_Parametre) {
		O_Parametre = o_Parametre;
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

    public void CreerOperateur() 
    {
    }

    public void ModifierOperateur() 
    {
    }

    public void SupprimerOperateur() 
    {
    }

    public void AfficherOperateur() 
    {
    }

	public void setO_Login(String o_Login) 
	{
		O_Login = o_Login;
	}

	public String getO_Login()
	{
		return O_Login;
	}

	public void setO_MotDePasse(String o_MotDePasse) 
	{
		O_MotDePasse = o_MotDePasse;
	}

	public String getO_MotDePasse() 
	{
		return O_MotDePasse;
	}

	public void setO_ZoneAcces(ArrayList<Lieu> o_ZoneAcces) 
	{
		O_ZoneAcces = o_ZoneAcces;
	}

	public ArrayList<Lieu> getO_ZoneAcces()
	{
		return O_ZoneAcces;
	}

	public boolean tester() {
		// TODO Auto-generated method stub
		return false;
	}

}

