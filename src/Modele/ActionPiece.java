package Modele;
import java.util.Date;

public class ActionPiece
{
	private Date AP_Date;
    private int AP_IDPiece;
    private int AP_IDOperateur;
    private int AP_IDOperation;

    
    public int getAP_IDPiece() {
		return AP_IDPiece;
	}

	public void setAP_IDPiece(int aP_IDPiece) {
		AP_IDPiece = aP_IDPiece;
	}

	public int getAP_IDOperateur() {
		return AP_IDOperateur;
	}

	public void setAP_IDOperateur(int aP_IDOperateur) {
		AP_IDOperateur = aP_IDOperateur;
	}

	public int getAP_IDOperation() {
		return AP_IDOperation;
	}

	public void setAP_IDOperation(int aP_IDOperation) {
		AP_IDOperation = aP_IDOperation;
	}
	
    public Date getAP_Date()
    {
        return this.AP_Date;
    }

    public void setAP_Date(final Date value)
    {
        this.AP_Date = value;
    }

	

}

