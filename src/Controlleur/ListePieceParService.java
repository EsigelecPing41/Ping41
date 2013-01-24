package Controlleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AssemblageDAO;
import dao.LocalisationAssemblageDAO;
import dao.LocalisationPieceDAO;
import dao.PieceDAO;

import Modele.Assemblage;
import Modele.LocalisationAssemblage;
import Modele.LocalisationPiece;
import Modele.Piece;

/**
 * Servlet implementation class ListePieceParService
 */
@WebServlet("/listePieceParService")
public class ListePieceParService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListePieceParService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("chargement des pieces");
		HttpSession session = request.getSession(true);  
		String s = request.getParameter("id");
		ArrayList<Piece> ListPieces = new ArrayList<Piece>();
		ArrayList<Assemblage> ListAssemblages = new ArrayList<Assemblage>();//liste des assemblage pour la qualité, l'expedition et les envois
		
		try {
			int serv = Integer.parseInt(s);
		    AssemblageDAO assemblageDAO = AssemblageDAO.getInstance();
			PieceDAO pieceDao = PieceDAO.getInstance();
			LocalisationAssemblageDAO lAssemblageDAO = LocalisationAssemblageDAO.getInstance();
			if(serv >4)
			{
				ArrayList<Assemblage> assemblages = (ArrayList<Assemblage>)assemblageDAO.getListAssemblage();				//on cherche les assemblages
				if(assemblages.size()!= 0)
				{
					
					for(Assemblage a:assemblages)
					{
						System.out.println("Assemblage "+ a.getA_ID());
						LocalisationAssemblage locAssemblage = lAssemblageDAO.getLocalisationAssemblage(a.getA_ID());
						System.out.println("Service ="+serv + "Localisation assemblage"+locAssemblage.getLA_L_ID());
						if(serv == locAssemblage.getLA_L_ID())
						{
							ListAssemblages.add(a);
						}
					}
				}
				session.setAttribute("listeAssemblage", ListAssemblages);
			}
			else
			{
				ArrayList<Piece> pieces = (ArrayList<Piece>)pieceDao.getListPiece();
				if(pieces.size() != 0)
				{
				
					LocalisationPieceDAO lPieceDAO = LocalisationPieceDAO.getInstance();
					for(Piece p : pieces)
					{
						System.out.println("Piece");
						LocalisationPiece locPiece = lPieceDAO.getLocalisationPiece(p.getP_ID());
						if(serv == locPiece.getLP_L_ID())
						{
							ListPieces.add(p);
						}
						session.setAttribute("listePiece", ListPieces);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			ListPieces.add(new Piece("Aucune pièce", "",true));
			
		    // traitement � faire dans ce cas
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/ListePieceParService/listePieceParService.jsp");
		dispatcher.forward( request, response );						
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
