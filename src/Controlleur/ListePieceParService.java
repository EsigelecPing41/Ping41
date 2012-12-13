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
 * Servlet implementation class ListePieceParService
 */
@WebServlet("/listePieceParService")
public class ListePieceParService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListePieceParService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);  
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece(1, "PIECE 1", "",3, 3,3));
		pieces.add(new Piece(1, "PIECE 2", "",3, 3,3));
		pieces.add(new Piece(1, "PIECE 3", "",3, 3,3));
		session.setAttribute("listePiece", pieces);
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet/ListePieceParService/listePieceParService.jsp");
		dispatcher.forward( request, response );						
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
