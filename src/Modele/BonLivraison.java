package Modele;
import java.util.ArrayList;
import java.util.List;

public class BonLivraison extends Bon 
{
    private int BLiv_ID;
    public List<Piece> Bliv_Pieces  = new ArrayList<Piece> ();


    public int getBLiv_ID()
    {
        return this.BLiv_ID;
    }

    public void setBLiv_ID(final int value)
    {
        this.BLiv_ID = value;
    }

}
