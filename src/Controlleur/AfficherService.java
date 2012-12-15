package Controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.Operateur;
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
		String s = request.getParameter("id");
		int i = 0;
		if(s != null && s != ""){			
			i = Integer.parseInt(s);			
		}	
		try
		{
			HttpSession ses = request.getSession(true);
			Operateur operateur = (Operateur)ses.getAttribute("sessionUtilisateur");
			ses.setAttribute("id", operateur.getO_Parametre().getMenu(i, 3));
			ses.setAttribute("dossier", operateur.getO_Parametre().getMenu(i, 2));
			ses.setAttribute("action", operateur.getO_Parametre().getMenu(i, 6));
			ses.setAttribute("scan", operateur.getO_Parametre().getMenu(i, 4));
			ses.setAttribute("lib", operateur.getO_Parametre().getMenu(i, 1));
			ses.setAttribute("menu", operateur.getO_Parametre().getMenu(i, 5));
			RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/service.jsp");
			dispatcher.forward( request, response );	
		}catch(Exception e){
			System.out.println("i vaut :"+i);
			e.printStackTrace();
			System.out.println("i vaut :"+i);
			RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.jsp");
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
