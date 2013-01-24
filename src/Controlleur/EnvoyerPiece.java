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
import Modele.Date;
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
		System.out.println("Servlet envoyer piece");
		String numPiece = request.getParameter("num_piece");
		try {
			AssemblageDAO assemblageDAO = AssemblageDAO.getInstance();
			ClientDAO clientDAO = ClientDAO.getInstance();
			System.out.println("1");
			Assemblage assemblage= assemblageDAO.getAssemblage(numPiece);
			if(assemblage == null)
			{
				throw new Exception("L'assemblage n'existe pas");
			}
			//recuperer la date
			//creer un nouvel objet expedition
			
			ExpeditionDAO expeditionDAO = ExpeditionDAO.getInstance();
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			System.out.println("2");
			Client client = clientDAO.getCLient(assemblage.getA_CodeClient());
			System.out.println("Code client"+assemblage.getA_CodeClient());
			
			System.out.println("3");
			
			Expedition expeditionAssemblage = new Expedition(date,client.getC_CodeClient(),/*???Pas de bon expedition*/0,assemblage.getA_ID(),0);
			System.out.println("4");
			ExpeditionDAO.ajouter(expeditionAssemblage);
			//expedition effectuée
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
