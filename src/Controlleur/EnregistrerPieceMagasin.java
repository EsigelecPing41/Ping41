/*****************************************************
* Module : Controlleur
* Fichier : EnregistrerPieceMagasin
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

import dao.OperateurDAO;
import dao.PieceDAO;

import Modele.Operateur;
import Modele.Piece;

/**
 * Servlet implementation class EnregistrerPieceMagasin
 */
@WebServlet(description = "Valider la piï¿½ce au magasin", urlPatterns = { "/EnregistrerPieceMagasin" })
public class EnregistrerPieceMagasin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrerPieceMagasin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : EnregistrerPieceMagasin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		//System.out.println("EnregistrerPieceMagasin");
		
		Piece p = (Piece)request.getAttribute("piece");
		//System.out.println("code barre"+p.getP_CodeBarre());
		
		PieceDAO pieceDao;
		try {
			pieceDao = PieceDAO.getInstance();
			System.out.println(p);
			int result = pieceDao.ajouter(p);
			RequestDispatcher dispatcher;
			String result2 ="Pièce enregistrée";
			request.setAttribute("result",result2);
			dispatcher = request.getRequestDispatcher("servlet/Magasin/result.jsp");
			dispatcher.forward( request, response );
			System.out.println("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher;
			String result2 ="Il y à eu un probléme avec la pièce";
			request.setAttribute("result",result2);
			dispatcher = request.getRequestDispatcher("result.jsp");
			dispatcher.forward( request, response );
			System.out.println("ko");
		}
		
		
	}

}
