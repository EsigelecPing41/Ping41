package Controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Piece;
import dao.PieceDAO;

/**
 * Servlet implementation class RechercheDevellopement
 */
@WebServlet(description = "R&D", urlPatterns = { "/RechercheDevellopement" })
public class RechercheDevellopement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheDevellopement() {
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
		PieceDAO pieceDao;
		String numPiece = request.getParameter( "num_piece" );
		try {
			pieceDao = PieceDAO.getInstance();
			Piece p = pieceDao.getPiece(numPiece);
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("servlet/R&D/retour_piece_RD.jsp");
			dispatcher.forward( request, response );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
