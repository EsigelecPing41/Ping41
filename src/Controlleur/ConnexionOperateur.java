
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

import form.ConnexionOperateurForm;

import Modele.Operateur;
import Modele.Piece;

/**
 * Servlet implementation class ConnexionOperateur
 */
@WebServlet(description = "Connexion d'un op�rateur", urlPatterns = { "/ConnexionOperateur" })
public class ConnexionOperateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String ATT_USER         = "utilisateur";
	 public static final String ATT_FORM         = "form";
	 public static final String ATT_SESSION_USER = "sessionUtilisateur";
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

		/* Préparation de l'objet formulaire */
        ConnexionOperateurForm form = new ConnexionOperateurForm();
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession(true);
        session.setAttribute("etatDouchette", false);
        RequestDispatcher dispatcher;
        
        /* Traitement de la requête et récupération du bean en résultant */
        if ( form.connecterUtilisateur( request ) ) {
        	
        	try {
        		OperateurDAO operateurDao = OperateurDAO.getInstance();
    			Operateur operateur = operateurDao.getOperateur(form.getValeur("login"),form.getValeur("password"));
    			session.setAttribute( ATT_SESSION_USER, operateur );
        		session.setAttribute("LIB_ERREUR", "");
        		session.setMaxInactiveInterval(operateur.getO_Parametre().getP_DureeVie());
        		dispatcher = request.getRequestDispatcher("servlet/index.html");
    		}
        	catch (Exception e) {
        		System.out.println(e.toString());
        		session.setAttribute("LIB_ERREUR", e.getMessage());
                session.setAttribute( ATT_SESSION_USER, null );
                dispatcher = request.getRequestDispatcher("index.jsp");
        	}
        } else {
        	session.setAttribute("LIB_ERREUR", form.getErreurs().toString());
            session.setAttribute( ATT_SESSION_USER, null );
            dispatcher = request.getRequestDispatcher("index.jsp");
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, null );
    	
        dispatcher.forward( request, response );
		
		
	}

}
