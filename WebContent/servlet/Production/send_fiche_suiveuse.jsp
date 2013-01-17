<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
    <%@ page import="java.util.Iterator"%> 
    <%@ page import="Modele.Assemblage"%> 
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
	if(assemblage == null)
	{
		
	}
	else
	{
		Piece pieces = assemblage.getListPieces();
	}
	Iterator it = pieces.iterator();
	Piece piece;
	int i = 1;
	while(i==1 & it.hasNext())
	{
		if(request.getParameter("DD"+i) == null)
		{
			i=0;
			RequestDispatcher dispatcher = request.getRequestDispatcher("fiche_suiveuse.jsp");
			request.setAttribute("erreur","jour manquant");
			dispatcher.forward( request, response );	
			
			
			
		}
		if(request.getParameter("MM"+i) == null)
		{
			i=0;
		}
		if(request.getParameter("YY"+i) == null)
		{
			i=0;
		}
		if(request.getParameter("num_serie"+i) == null)
		{
			i=0;
		}
		if(request.getParameter("etat"+i) == null)
		{
			i=0;
		}
		piece=(Piece)it.next();
		piece.setP_CodeBarre();
		piece.setA_CodeBarre();
		
		if(i==1)
		{
			piece = (Piece)it.next();
			request.getParameter("DD"+i);
			request.getParameter("MM"+i);
			request.getParameter("YY"+i);
			request.getParameter("num_serie"+i);
			request.getParameter("etat"+i);
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("MajFicheSuiveuse");
			dispatcher.forward( request, response );	
			
			
			
		}
		if(i==0)
		{
			
		}
	}

	
%>


</body>
</html>