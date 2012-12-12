package Modele;
import java.util.ArrayList;
import java.util.List;

public class Fournisseur 
{
    private int F_ID;
    private String F_Nom;
    private String F_Adresse;
    private String F_Description;
    public List<Piece> F_Pieces = new ArrayList<Piece> ();

    public int getF_ID() 
    {
        return this.F_ID;
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

    public void setF_ID(final int value) 
    {
        this.F_ID = value;
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

    public void CreerFournisseur() 
    {
    }

    public void ModifierFournisseur() 
    {
    }

    public void SupprimerFournisseur()
    {
    }

    public void AfficherFournisseur() 
    {
    }

}
