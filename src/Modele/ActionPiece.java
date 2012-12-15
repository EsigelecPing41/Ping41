package Modele;
import java.util.Date;

public class ActionPiece extends Action
{
	
	private int AP_IDPiece;

    public ActionPiece(Date aP_Date, int AP_IDPiece, int aP_IDOperateur, int aP_IDOperation) {
		super(aP_Date, aP_IDOperateur, aP_IDOperation);
		this.AP_IDPiece = AP_IDPiece;
	}

    public int getAP_IDPiece() {
		return AP_IDPiece;
	}

	public void setAP_IDPiece(int aP_IDPiece) {
		AP_IDPiece = aP_IDPiece;
	}

	

}

