/*****************************************************
* Module : Controlleur
* Fichier : ValideFicheQualite
* Description : 
* Projet : SKF Traceability
* Auteur : GC
* Date : 12/12/12
* Version : 0.5
******************************************************/

package Controlleur;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ControleQualiteDAO;
import dao.CritereQualiteDAO;

import Modele.ControleQualite;
import Modele.CritereQualite;

/**
 * Servlet implementation class ValideFicheQualite
 */
@WebServlet(description = "Valider la pi�ce apr�s le contr�le qualit�", urlPatterns = { "/ValideFicheQualite" })
public class ValideFicheQualite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValideFicheQualite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet : ValideFicheQualite");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//david me renvoi le contro
		//recuperer fiche qualite en post
		List<ControleQualite> listQualite;
		RequestDispatcher dispatcher;
		//recuperer la liste et la renvoyer
		try {
			ControleQualiteDAO controleQualiteDao = ControleQualiteDAO.getInstance();
			CritereQualiteDAO critereQualiteDao = CritereQualiteDAO.getInstance();
			//Récupération du controle qualité rempli
			ControleQualite controleQualite = (ControleQualite)request.getAttribute("controleQualite");
			//Récupération des critère qualité
			List<CritereQualite> listeCritereQualite = controleQualite.getCQ_ListCriteres();
			//Mise à jour du résultat du controle
			controleQualiteDao.modifierResultat(controleQualite.getCQ_ID(), controleQualite.getCQ_Resultat());
			for(CritereQualite critere : listeCritereQualite)
			{
				//Mise à jour des critère de controle qualité
				critereQualiteDao.modifierResultat(critere.getCrQ_ID(), critere.getCrQ_resultat());
			}
			System.out.println("Tout est ok");
			request.setAttribute("enregistree", "1");
			request.setAttribute("codeErreur", "0");
			dispatcher = request.getRequestDispatcher("servlet/Qualite/index.html");
		} catch (Exception e) {
			System.out.println("Probleme");

			request.setAttribute("enregistree", "0");
			request.setAttribute("codeErreur", "1");
			dispatcher = request.getRequestDispatcher("servlet/Qualite/index.html");
			e.printStackTrace();
		
		}
		dispatcher.forward(request, response);
	
	}

}
