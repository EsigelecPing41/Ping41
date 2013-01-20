package Controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.Assemblage;
import Modele.Piece;
import dao.AssemblageDAO;
import dao.PieceDAO;

/**
 * Servlet implementation class LancementNouvellePiece$
 * Cet servlet permet à l'ordonnancement de lancer une nouvelle piece en fabrication
 */
@WebServlet("/LancementNouvellePiece")
public class LancementNouvellePiece extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LancementNouvellePiece() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Piece p;
		//lancement d'un assemblage
		Assemblage a;
		AssemblageDAO assemblageDao;
		//PieceDAO pieceDao;
		RequestDispatcher dispatcher;
		try {
			a = new Assemblage(request.getParameter("numero_serie"), request.getParameter("nb_dossier_def"), request.getParameter("code_gpao"), request.getParameter("ind_nomencl"), request.getParameter("designation_de_la_piece"),request.getParameter("ordre_fabrication"), request.getParameter("numero_affaire"), null);
			//p = new Piece(request.getParameter("numero_serie"), request.getParameter("nb_dossier_def"), request.getParameter("code_gpao"), request.getParameter("ind_nomencl"), request.getParameter("designation_de_la_piece"),request.getParameter("ordre_fabrication"), request.getParameter("numero_affaire"));
			//pieceDao = PieceDAO.getInstance();
			assemblageDao = AssemblageDAO.getInstance();
			assemblageDao.ajouter(a);
			//pieceDao.ajouter(p); //la piece est créée. On va maintenant chercher dans la bdd la liste des des manquants et la liste à servir
			dispatcher = request.getRequestDispatcher("Ordonnancement/index.html");//message piece créée avec succès
			//on doit pouvoir imprimer un code barre après ça.
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
