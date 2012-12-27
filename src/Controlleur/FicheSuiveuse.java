/*****************************************************
* Module : Controlleur
* Fichier : FicheQualitePiece
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

import dao.PieceDAO;

import Modele.Piece;

/**
 * Servlet implementation class FicheQualitePiece
 */
@WebServlet(description = "Charger la fiche qualit� d'une pi�ce", urlPatterns = { "/FicheQualitePiece" })
public class FicheSuiveuse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheSuiveuse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : FicheSuiveusePieceGET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : FicheSuiveusePOST");
		RequestDispatcher dispatcher;
		try {
			PieceDAO pieceDAO = PieceDAO.getInstance();
			request.setAttribute("piece",pieceDAO.getPiece(request.getParameter("num_piece")));
			dispatcher = request.getRequestDispatcher("servlet/Production/fiche_suiveuse.jsp");
			
		} catch (Exception e) {
			request.setAttribute("erreur","La piece n'existe pas");
			dispatcher = request.getRequestDispatcher("servlet/ScannerCodeBarre/scanner.jsp");			
		}
		dispatcher.forward( request, response );	
	}

}
