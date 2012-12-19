package Modele;

public class Operation 
{
    private int Op_ID;
    private String Op_Libelle;
    private int Op_EO_ID;
    
    public Operation(int ID, String libelle,int EO_ID)
    {
    	this.Op_ID =ID;
    	this.Op_Libelle=libelle;
    	this.Op_EO_ID=EO_ID;
    }
    
    public int getOp_ID()
    {
        return this.Op_ID;
    }

    public void setOp_ID(int value) 
    {
        this.Op_ID = value;
    }

    public String getOp_Libelle() 
    {
        return this.Op_Libelle;
    }

    public void setOp_Libelle(String value)
    {
        this.Op_Libelle = value;
    }

	public void setOp_EO_ID(int op_EO_ID) 
	{
		Op_EO_ID = op_EO_ID;
	}

	public int getOp_EO_ID() 
	{
		return Op_EO_ID;
	}

}
