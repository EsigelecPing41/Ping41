
package Modele;
import java.util.ArrayList;
import java.util.List;

public class Assemblage 
{
    private int A_ID;
    private String A_Nom;
    public BonExpedition A_BonExpedition;
    public List<Piece> A_Pieces = new ArrayList<Piece> ();

    public int getA_ID() 
    {
        return this.A_ID;
    }

    public void setA_ID(final int value)
    {
        this.A_ID = value;
    }

    public String getA_Nom() 
    {
        return this.A_Nom;
    }

    public void setA_Nom(final String value)
    {
        this.A_Nom = value;
    }

    public void creerAssemblage() 
    {
    }

    public void ModifierAssemblage() 
    {
    }

    public void SupprimerAssemblage() 
    {
    }

    public void AfficherAssemblage() 
    {
    }

}
