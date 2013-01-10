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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AssemblageDAO;
import dao.ControleQualiteDAO;
import dao.CritereQualiteDAO;
import dao.PieceDAO;

import Modele.Assemblage;
import Modele.ControleQualite;
import Modele.CritereQualite;
import Modele.Piece;

/**
 * Servlet implementation class FicheQualitePiece
 */
@WebServlet(description = "Charger la fiche qualit� d'une pi�ce", urlPatterns = { "/FicheQualitePiece" })
public class FicheQualitePiece extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheQualitePiece() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : FicheQualitePieceGET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : FicheQualitePiecePOST");
		RequestDispatcher dispatcher;
		String numPiece = request.getParameter("num_piece"); 
		try {
			//Un controle qualite contient plusieurs critere qualite. 
			PieceDAO pieceDAO = PieceDAO.getInstance();
			AssemblageDAO assemblageDAO = AssemblageDAO.getInstance();
			Assemblage assemblage = assemblageDAO.getAssemblage(numPiece); 
			ControleQualiteDAO controleQualiteDAO = ControleQualiteDAO.getInstance();
			ControleQualite controleQualite = controleQualiteDAO.getControleQualite(assemblage.getA_ID());
			controleQualite.setCQ_ListCriteres(controleQualiteDAO.getListCritereControle(controleQualite.getCQ_ID()));
			
			//liste controle qualitecontroleQualite = controleQualiteDAO.getListControleQualiteDAO(assemblage.getA_ID());
			
			request.setAttribute("assemblage",assemblageDAO.getAssemblage(request.getParameter("num_piece")));
			request.setAttribute("controleQualite"  , controleQualite);
			dispatcher = request.getRequestDispatcher("servlet/Qualite/ficheQualite.jsp");
			
			
		} catch (Exception e) {
			System.out.println("erreur");
			request.setAttribute("erreur","La piece n'existe pas");
			dispatcher = request.getRequestDispatcher("servlet/ScannerCodeBarre/scanner.jsp");			
		}
		dispatcher.forward( request, response );	
		
	
	}

}
