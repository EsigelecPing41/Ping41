package Modele;
import java.util.ArrayList;
import java.util.List;

public class CritereQualite
{
    private int CrQ_ID;
    private String CrQ_Libelle;
    public List<Operateur> CrQ_Operateurs = new ArrayList<Operateur> ();

    public int getCrQ_ID() 
    {
        return this.CrQ_ID;
    }

    public void setCrQ_ID(final int value)
    {
        this.CrQ_ID = value;
    }

    public String getCrQ_Libelle()
    {
        return this.CrQ_Libelle;
    }

    public void setCrQ_Libelle(final String value) 
    {
        this.CrQ_Libelle = value;
    }

}
