package Modele;
public class BonExpedition extends Bon
{
    private int BExp_ID;
    public Client BExp_Client;


    public int getBExp_ID()
    {
        return this.BExp_ID;
    }

    public void setBExp_ID(final int value) 
    {
        this.BExp_ID = value;
    }

}
