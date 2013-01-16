package Controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OperationDAO;
import dao.PieceDAO;

/**
 * Servlet implementation class Magasin
 */
@WebServlet("/Magasin")
public class Magasin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Magasin() {
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
		// TODO Auto-generated method stub
		System.out.println("servlet : MagasinPOST");
		RequestDispatcher dispatcher;
		try {
			PieceDAO pieceDAO = PieceDAO.getInstance();
			request.setAttribute("piece",pieceDAO.getPiece(request.getParameter("num_piece")));
			dispatcher = request.getRequestDispatcher("servlet/Magasin/magasin.jsp");
			
		} catch (Exception e) {
			request.setAttribute("erreur","La piece n'existe pas");
			dispatcher = request.getRequestDispatcher("servlet/ScannerCodeBarre/scanner.jsp");			
		}
		dispatcher.forward( request, response );	
	}

}
