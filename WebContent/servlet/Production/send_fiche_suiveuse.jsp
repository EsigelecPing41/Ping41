<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
    <%@ page import="java.util.Iterator"%> 
    <%@ page import="Modele.Assemblage"%> 
    <%@ page import="Modele.Piece"%> 
    <%@ page import="Modele.ActionAssemblage"%> 
    
    
	<%@ page import="dao.OperationDAO"%> 
	<%@ page import="dao.ActionAssemblageDAO"%> 	
	
	<%@ page import="java.text.SimpleDateFormat"%>   
	<%@ page import="java.util.Date"%> 
	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Assemblage assemblage = (Assemblage)request.getAttribute("assemblage");
	if(assemblage == null)
	{
		
	}
	else
	{
		ActionAssemblageDAO actionAssemblage = ActionAssemblageDAO.getInstance();
		operationDao.getListOperation();
	
		List<ActionAssemblage> listaction=ActionAssemblageDAO.getListActionAssemblage(assemblage.getA_ID());
	  	
		Iterator it = listaction.iterator();
		
		
		//Iterator it = actions.iterator();
		ActionAssemblage actionAssemblage;
		String error;
		int i = 1;
		while(i==1 & it.hasNext())
		{
			if(request.getParameter("date"+i) == null)
			{
				i=0;
				error="<br>Veuillez rentrer la date"+error;
			}
			if(request.getParameter("etat"+i) == null)
			{
				i=0;
				error="<br>Veuillez rentrer l'état."+error;
			}
			if(i==0)
			{
				
			}
			it.next();			
			if(i==1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("fiche_suiveuse.jsp");
				request.setAttribute("erreur",error);
				actionAssemblage=(ActionAssemblage)it.next();
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
				Date date = sdf.parse(request.getParameter("Date"+i));
				
				
				request.getParameter("etat"+i);
				actionAssemblage.setAA_Date(date);
				
				//request.setAttribute("date",date);
				dispatcher.forward( request, response );	
			}

				
				
				
				

				
				
				
			}
			if(i==0)
			{
				
			}
			request.setAttribute("listAction",listaction);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MajFicheSuiveuse");
			dispatcher.forward( request, response );	
		

	}
	
	
%>


</body>
</html>