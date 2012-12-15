/*****************************************************
* Module : Controlleur
* Fichier : DouchetteConnectee
* Description : Permet de 
* Projet : SKF Traceability
* Auteur : GC
* Date : 12/12/12
* Version : 0.5
******************************************************/

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

import Modele.Piece;

/**
 * Servlet implementation class DouchetteConnectee
 */
@WebServlet(description = "Detecte la connexion d'une douchette", urlPatterns = { "/DouchetteConnectee" })
public class EtatDouchette extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtatDouchette() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On stocke dans une variable de session l'état de la douchette (TRUE pour la connexion)
		HttpSession session = request.getSession(true); 
		
		String s = request.getParameter("etat");
		try {
		    int etat = Integer.parseInt(s);
		    if(etat==1){
				session.setAttribute("etatDouchette", true);
			}else{
				session.setAttribute("etatDouchette", false);
			}
		    //On affiche la vue de l'état de la douchette
			RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/Douchette/etatDouchette.jsp");
			dispatcher.forward( request, response );
		} catch (NumberFormatException nfe) {
			//On affiche la vue de l'état de la douchette
			RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/Douchette/error.html");
			dispatcher.forward( request, response );
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
