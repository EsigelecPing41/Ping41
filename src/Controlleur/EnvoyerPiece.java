/*****************************************************
* Module : Controlleur
* Fichier : EnvoyerPiece
* Description : 
* Projet : SKF Traceability
* Auteur : GC
* Date : 12/12/12
* Version : 0.5
******************************************************/

package Controlleur;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.Assemblage;
import Modele.Client;
import Modele.Expedition;
import Modele.Piece;

import dao.AssemblageDAO;
import dao.ClientDAO;
import dao.ExpeditionDAO;
import dao.PieceDAO;

/**
 * Servlet implementation class EnvoyerPiece
 */
@WebServlet(description = "Envoi d'une pi�ce", urlPatterns = { "/EnvoyerPiece" })
public class EnvoyerPiece extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvoyerPiece() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : EnvoyerPiece");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numPiece = request.getParameter("num_piece");
		try {
			AssemblageDAO assemblageDAO = AssemblageDAO.getInstance();
			ClientDAO clientDAO = ClientDAO.getInstance();
			Assemblage assemblage= assemblageDAO.getAssemblage(numPiece);
			//recuperer la date
			//creer un nouvel objet expedition
			ExpeditionDAO expeditionDAO = ExpeditionDAO.getInstance();
			java.util.Date date = new java.util.Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			Client client = clientDAO.getCLient(assemblage.getA_CodeClient());//en attendant medylle
			Expedition expeditionAssemblage = new Expedition(timeStamp,client.getC_CodeClient(),/*???Pas de bon expedition*/0,assemblage.getA_ID(),0);
			ExpeditionDAO.ajouter(expeditionAssemblage);
			//expedition effectuée
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
