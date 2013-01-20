/*****************************************************
* Module : Controlleur
* Fichier : LancerFicheSuiveuse
* Description : 
* Projet : SKF Traceability
* Auteur : GC
* Date : 12/12/12
* Version : 0.5
******************************************************/

package Controlleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Ordonnancement;

/**
 * Servlet implementation class LancerFicheSuiveuse
 */
@WebServlet(description = "Lancement de la liste a servir", urlPatterns = { "/LancerListeAServir" })
public class LancerListeAServir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LancerListeAServir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : LancerListeAServir");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Ordonnancement> listeOrdo = (List<Ordonnancement>) request.getAttribute("listOrdo");
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("servlet/Ordonnancement/ListesDesManquants.jsp");			
		dispatcher.forward( request, response );	
	}

}
