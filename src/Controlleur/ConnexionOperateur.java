
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
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OperateurDAO;
import dao.PieceDAO;

import Modele.Operateur;
import Modele.Piece;

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
		System.out.println("servlet : ConnexionOperateurds");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On instancie un operateur DAO
		OperateurDAO operateurDAO  = new OperateurDAO();
		// On récupére les valeurs pour le login/mdp
		String login = request.getParameter("login");
		String mdp = request.getParameter("motDePasse");
		if(login == "" || mdp == ""){
			//Si le login OU mdp est vide, on stocke l'erreur dans une variable de session
			HttpSession session = request.getSession(true);  
			session.setAttribute("erreurConnexion", "login/mdp vide");
			System.out.println("login/mdp vide");
			//On affiche le formulaire de connexion
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward( request, response );
		}else{
			//On récupere l'operateur suivant le login/mot de passe transmis
			Operateur operateur = operateurDAO.getOperateur(login,mdp);
			if(operateur != null){
				//Si l'opérateur existe
				System.out.println("Utilisateur OK");
				HttpSession session = request.getSession(true);  
				session.setAttribute("utilisateur", operateur);
				session.setAttribute("etatDouchette", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/index.html");
				dispatcher.forward( request, response );
			}else{		
				//Si l'opérateur n'existe pas
				HttpSession session = request.getSession(true);  
				session.setAttribute("erreurConnexion", "login/mdp incorrect");
				System.out.println("login/mdp incorrect");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward( request, response );
			}
		}	
		
		
		
	}

}
