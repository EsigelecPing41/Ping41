package Controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PieceDAO;

import Modele.Piece;

/**
 * Servlet implementation class ValiderPieceRD
 */
@WebServlet("/ValiderPieceRD")
public class ValiderPieceRD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderPieceRD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		
		try {
			PieceDAO pieceDAO = PieceDAO.getInstance();
			Piece piece = (Piece)request.getAttribute("piece");
			pieceDAO.modifierCB(piece.getP_ID(), piece.getP_CodeBarre());
			pieceDAO.modifierNom(piece.getP_ID(), piece.getP_Nom());
			pieceDAO.modifierStatut(piece.getP_ID(), piece.getP_Statut());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
