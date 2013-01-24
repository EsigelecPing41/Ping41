package Controlleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.ControleQualite;
import Modele.CritereQualite;
import dao.ControleQualiteDAO;
import dao.CritereQualiteDAO;

/**
 * Servlet implementation class ValideControleQualite
 */
@WebServlet("/ValideControleQualite")
public class ValideControleQualite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValideControleQualite() {
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
		//david me renvoi le contro
		//recuperer fiche qualite en post
		System.out.println("Servlet valider controle qualite");
		ArrayList<CritereQualite> listeCritereQualite;
		RequestDispatcher dispatcher;
		//recuperer la liste et la renvoyer
		try {
			ControleQualiteDAO controleQualiteDao = ControleQualiteDAO.getInstance();
			CritereQualiteDAO critereQualiteDao = CritereQualiteDAO.getInstance();
			//Récupération du controle qualité rempli
			ControleQualite controleQualite = (ControleQualite)request.getSession().getAttribute("controleQualite");
			//Récupération des critère qualité
			listeCritereQualite = (ArrayList<CritereQualite>)controleQualite.getCQ_ListCriteres();
			//recuperer la liste des id critere dans des variable et mettre à jour le critereQualite.resultat
			
			for(int i = 0; i< listeCritereQualite.size(); i++)
			{
				int i_result = Integer.valueOf(request.getParameter(String.valueOf(listeCritereQualite.get(i).getCrQ_ID())));
				System.out.println("Result test " +i_result);
				boolean result = true;
				if(i_result ==0)
				{
					result = false;
					controleQualite.setCQ_Resultat(false); //le controle qualite sera faux si une erreur apparait
				}
					
				listeCritereQualite.get(i).setCrQ_resultat(result);
			}
			//Mise à jour du résultat du controle
			System.out.println("4");
			if(controleQualite.getCQ_Resultat()==false)
			{
				System.out.println("Le controle est false");
			}
			else System.out.println("le controle est true");
			controleQualiteDao.modifierResultat(controleQualite.getCQ_ID(), controleQualite.getCQ_Resultat());
			for(CritereQualite critere : listeCritereQualite)
			{
				//Mise à jour des critère de controle qualité
				critereQualiteDao.modifierResultat(critere.getCrQ_ID(), critere.getCrQ_resultat());
			}
			
			request.setAttribute("enregistree", "1");
			request.setAttribute("codeErreur", "0");
			dispatcher = request.getRequestDispatcher("servlet/Qualite/index.html");
		} catch (Exception e) {
			System.out.println(e.toString());
			request.setAttribute("enregistree", "0");
			request.setAttribute("codeErreur", "1");
			dispatcher = request.getRequestDispatcher("servlet/Qualite/index.html");
			e.printStackTrace();
		
		}
		dispatcher.forward(request, response);
	}

}
