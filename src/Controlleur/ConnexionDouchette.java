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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DouchetteConnectee
 */
@WebServlet(description = "Detecte la connexion d'une douchette", urlPatterns = { "/DouchetteConnectee" })
public class ConnexionDouchette extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionDouchette() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On stocke dans une variable de session l'état de la douchette (TRUE pour la connexion)
		HttpSession session = request.getSession(true);  
		session.setAttribute("etatDouchette", true);
		//On affiche la vue de l'état de la douchette
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/Douchette/etatDouchette.jsp");
		dispatcher.forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
