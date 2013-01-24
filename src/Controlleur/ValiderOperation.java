package Controlleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ActionAssemblageDAO;
import dao.LocalisationAssemblageDAO;

import Modele.ActionAssemblage;
import Modele.Assemblage;
import Modele.EtatOperation;
import Modele.LocalisationAssemblage;
import Modele.LocalisationPiece;
import Modele.Operateur;
import Modele.Operation;

/**
 * Servlet implementation class ValiderOperation
 */
@WebServlet("/ValiderOperation")
public class ValiderOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession se = request.getSession();
		List<Operation> listOp = (List<Operation>)se.getAttribute("operation");
		Assemblage assemblage = (Assemblage)se.getAttribute("assemblage");
		Operateur op = (Operateur)se.getAttribute("utilisateur");
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		//ajouter action assemblage
		for(Operation o: listOp)
		{
			int valueOP = (Integer)request.getAttribute("etat"+o.getOp_ID());
			EtatOperation eo;
			if(valueOP == 1)
			{
				eo = new EtatOperation("fait");
				o.setOp_EO(eo);
			}
			else 
			{
				eo = new EtatOperation("pasFait");
				o.setOp_EO(eo);
			}
			try {
			ActionAssemblage aa = new ActionAssemblage(assemblage.getA_ID(),op.getO_ID(),o.getOp_ID(),5,date);
			ActionAssemblageDAO actionAssemblage = ActionAssemblageDAO.getInstance();
			actionAssemblage.ajouter(aa);
			LocalisationAssemblage locAssemblage = new LocalisationAssemblage(date, op.getO_ID(), 5, assemblage.getA_ID());
			LocalisationAssemblageDAO locDAO = LocalisationAssemblageDAO.getInstance();
			locDAO.ajouter(locAssemblage);
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
