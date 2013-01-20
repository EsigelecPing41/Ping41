<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
    <%@ page import="java.util.Iterator"%> 
    <%@ page import="Modele.Assemblage"%> 
    <%@ page import="Modele.ControleQualite"%> 
    <%@ page import="Modele.CritereQualite"%>
    <%@ page import="Modele.Piece"%> 

    <% %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
	Assemblage assemblage = (Assemblage)request.getAttribute("assemblage");
	ControleQualite controleQualite = (ControleQualite)request.getAttribute("controleQualite");
	int j=1;
	List<CritereQualite> criteresqualites =controleQualite.getCQ_ListCriteres();
	Iterator i = criteresqualites.iterator();
	String str=null;
	CritereQualite crq;
	while(j==1 && i.hasNext())
	{
	  	crq = (CritereQualite)i.next();
	  	j=1;
		if(request.getParameter("Ok"+i) == null)
		{
			j=0;
		}
		
		crq=(CritereQualite)i.next();
		
		if(j==1)
		{
			crq = (CritereQualite)i.next();
			str=request.getParameter("Ok"+i);
			if(str=="ok")
			{
				if(crq.getCrQ_resultat()!=true);
				{
					crq.setCrQ_resultat(true);
				}
			}
			else
			{
				if(crq.getCrQ_resultat()!=false);
				{
					crq.setCrQ_resultat(false);
				}
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("ValideFicheQualite");
			request.setAttribute("assemblage",assemblage);
			request.setAttribute("controleQualite",controleQualite);
			dispatcher.forward( request, response );	
			
			
			
		}
		if(j==0)
		{
			
		}
	}

	
%>


</body>
</html>