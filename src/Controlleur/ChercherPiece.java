
/*****************************************************
* Module : Controlleur
* Fichier : ChercherPiece
* Description : Afficher la localisation d'une pi�ce
* Projet : SKF Traceability
* Auteur : GC
* Date : 12/12/12
* Version : 0.5
******************************************************/

package Controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PieceDAO;


import Modele.Piece;

@WebServlet("/ChercherPiece")
public class ChercherPiece extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ChercherPiece() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PieceDAO pieceDao =	PieceDAO.getInstance();
		
		try { 
			int i = Integer.parseInt(request.getParameter("id")); 
			Piece piece = pieceDao.getPiece(i);
			if(piece != null){
				HttpSession session = request.getSession(true);  
				session.setAttribute("pieceActive", piece);
			}else{
				System.out.println("piece KO");
			}
		}catch (Exception e) { 
			System.out.println("ID invalable"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
	}

}
