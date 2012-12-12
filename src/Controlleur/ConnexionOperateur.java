
/*****************************************************
* Module : Controlleur
* Fichier : ConnexionOperateur
* Description : 
* Projet : SKF Traceability
* Auteur : GC
* Date : 12/12/12
* Version : 0.5
******************************************************/

package Controlleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.Operateur;

/**
 * Servlet implementation class ConnexionOperateur
 */
@WebServlet(description = "Connexion d'un opérateur", urlPatterns = { "/ConnexionOperateur" })
public class ConnexionOperateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionOperateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : ConnexionOperateur");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// On récupére les valeurs pour le login/mdp
		/**response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("CODE_DE_MA_PAGE_HTML");
		out.close();
		String login = request.getParameter("login");
		String mdp = request.getParameter("motDePasse");
		//On teste si le login/mdp est null
		if(login == "" || mdp == ""){
			System.out.println("login/mdp vide");
		}else{
			Operateur operateur = new Operateur(login,mdp);
			if(operateur.tester()){
				System.out.println("Utilisateur OK");
				HttpSession session = request.getSession(true);  
				session.putValue("utilisateur", operateur);
			}else{
				System.out.println("login/mdp incorrect");
			}
		}*/
		System.out.println("POST");
		
		
	}

}
