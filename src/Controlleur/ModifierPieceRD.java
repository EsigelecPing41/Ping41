/*****************************************************
* Module : Controlleur
* Fichier : ModifierPieceRD
* Description : 
* Projet : SKF Traceability
* Auteur : GC
* Date : 12/12/12
* Version : 0.5
******************************************************/

package Controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.Piece;

import dao.PieceDAO;

/**
 * Servlet implementation class ModifierPieceRD
 */
@WebServlet(description = "Modifie les caract�ristiques d'une pi�ce", urlPatterns = { "/ModifierPieceRD" })
public class ModifierPieceRD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ATT_SESSION_USER = "piece";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPieceRD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : ModifierPieceRD");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = null;
		try {
			PieceDAO pieceDAO = PieceDAO.getInstance();			
			//Récupération d'une piece grace à son numéro
			String numPiece = request.getParameter("num_piece");			
			Piece piece = pieceDAO.getPiece(numPiece);
			request.setAttribute("piece", piece);
    		dispatcher = request.getRequestDispatcher("servlet/R&D/R&D.jsp");
    		
		} catch (Exception e) {
			System.out.println("pièce non trouvee");
			dispatcher = request.getRequestDispatcher("servlet/R&D/index.html");
			e.printStackTrace();	
		}
		dispatcher.forward( request, response );
	}

}
