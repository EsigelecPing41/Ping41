package Controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.Piece;

/**
 * Servlet implementation class AfficherService
 */
@WebServlet(description = "Permet d'afficher le service", urlPatterns = { "/AfficherService" })
public class AfficherService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String valeurs[] = new String[10];
		valeurs[0] = "Accueil";
		valeurs[1] = "Magasin";
		valeurs[2] = "Metrologie";
		valeurs[3] = "Ordonnancement";
		valeurs[4] = "R&D";
		valeurs[5] = "Production";
		valeurs[6] = "Qualite";
		valeurs[7] = "Expedition";
		valeurs[8] = "Aide";
		
		System.out.println("chargement du service");
		HttpSession session = request.getSession(true);  
		String s = request.getParameter("id");
		int i = 0;
		System.out.println("s vaut : "+s);
		if(s != null && s != ""){			
			i = Integer.parseInt(s);			
		}	
		System.out.println("i vaut "+i);
		HttpSession ses = request.getSession(true);
		ses.setAttribute("id", i);
		ses.setAttribute("page", valeurs[i]);
		System.out.println("cv'est vide");
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/service.jsp");
		dispatcher.forward( request, response );	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
