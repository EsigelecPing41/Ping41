package Modele;
import java.util.Date;

public class Commande 
{
    private Date ComDate;
    public Piece ComPiece;

    public void setComDate(final Date value) 
    {
        this.ComDate = value;
    }

    public Date getComDate()
    {
        return this.ComDate;
    }

}
