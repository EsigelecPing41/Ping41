package Modele;
import java.util.ArrayList;
import java.util.List;

import Modele.Operateur;


public class CritereQualite
{
    private int CrQ_ID;
    private String CrQ_libelle;
    public List<Operateur> CrQ_Operateurs = new ArrayList<Operateur> ();
    
	public CritereQualite(int ID,String Libelle) {
		// TODO Auto-generated constructor stub
		
    	this.CrQ_ID = ID;
    	this.CrQ_libelle = Libelle;

	}

    public int getCrQ_ID() 
    {
        return this.CrQ_ID;
    }

    public void setCrQ_ID(final int value)
    {
        this.CrQ_ID = value;
    }

    public String getCrQ_libelle()
    {
        return this.CrQ_libelle;
    }

    public void setCrQ_libelle(final String value) 
    {
        this.CrQ_libelle = value;
    }

}
