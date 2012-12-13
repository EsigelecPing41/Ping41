package Modele;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Piece 
{
    private int P_ID;
    private String P_Nom;
    private String P_CodeBarre;
    private int P_IDLieu;
    private Set<Operation> P_ListOperations = new HashSet<Operation>();
    private int P_IDFournisseur;
    private int P_IDCommande ;
    private enum P_Statut {OK,KO};
    
    public Piece()
    {
    	
    }
    
    public Piece(int ID, String nom, String CB,int lieu, int fournisseur,int commande)
    {
    	this.P_ID = ID;
    	this.P_Nom = nom;
    	this.P_CodeBarre = CB;
    	this.P_IDLieu = lieu;
    	this.P_IDFournisseur = fournisseur;
    	this.P_IDCommande= commande;
    }
    
    public Set<Operation> getListOperation() 
    {
        return P_ListOperations;
    }

    public void setListOperation(Set<Operation> P_ListOperations) 
    {
        this.P_ListOperations = P_ListOperations;
    }

    public void addOperation(Operation Op)	
    {
        if(!this.P_ListOperations.contains(Op))
        	this.P_ListOperations.add(Op);
    }

    public void removeOperation(Operation Op)
    {
    	if(this.P_ListOperations.contains(Op))
        this.P_ListOperations.remove(Op);
    }

    public int getP_ID()
    {
        return this.P_ID;
    }
    public void setP_ID(final int value)
    {
        this.P_ID = value;
    }
    public String getP_Nom()
    {
        return this.P_Nom;
    }

    public void setP_Nom(final String value) 
    {
        this.P_Nom = value;
    }

    public String getP_CodeBarre() 
    {
        return this.P_CodeBarre;
    }

    public void setP_CodeBarre(final String value) 
    {
        this.P_CodeBarre = value;
    }

    public void AfficherPiece() 
    {
    	
    }
	public void setP_IDLieu(int p_IDLieu) {
		P_IDLieu = p_IDLieu;
	}
	public int getP_IDLieu() {
		return P_IDLieu;
	}
	public void setP_IDFournisseur(int p_IDFournisseur) {
		P_IDFournisseur = p_IDFournisseur;
	}
	public int getP_IDFournisseur() {
		return P_IDFournisseur;
	}
	public void setP_IDCommande(int p_IDCommande) {
		P_IDCommande = p_IDCommande;
	}
	public int getP_IDCommande() {
		return P_IDCommande;
	}

	@Override
	public String toString() {
		return "Piece [P_ID=" + P_ID + ", P_Nom=" + P_Nom + ", P_CodeBarre="
				+ P_CodeBarre + ", P_IDLieu=" + P_IDLieu
				+ ", P_ListOperations=" + P_ListOperations
				+ ", P_IDFournisseur=" + P_IDFournisseur + ", P_IDCommande="
				+ P_IDCommande + "]";
	}

}
