package Modele;

public class CritereQualite
{
    private int CrQ_ID;
    private String CrQ_libelle;
    private boolean CrQ_resultat;
    
	public CritereQualite(int ID,String Libelle, boolean resultat)
	{		
    	this.CrQ_ID = ID;
    	this.CrQ_libelle = Libelle;
    	this.CrQ_resultat=resultat;
	}
	
	public CritereQualite(String Libelle, boolean resultat)
	{		
    	this.CrQ_libelle = Libelle;
    	this.CrQ_resultat=resultat;
	}

    public int getCrQ_ID() 
    {
        return this.CrQ_ID;
    }

    public void setCrQ_ID(int value)
    {
        this.CrQ_ID = value;
    }

    public String getCrQ_libelle()
    {
        return this.CrQ_libelle;
    }

    public void setCrQ_libelle(String value) 
    {
        this.CrQ_libelle = value;
    }

	public void setCrQ_resultat(boolean crQ_resultat) 
	{
		CrQ_resultat = crQ_resultat;
	}

	public boolean getCrQ_resultat()
	{
		return CrQ_resultat;
	}

}
