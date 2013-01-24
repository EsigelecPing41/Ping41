<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Modele.Assemblage"%> 
<%@ page import="Modele.CritereQualite" %>
<%@ page import="Modele.ControleQualite"%>
<%@ page import="Modele.Operation"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>







<html>
<head>
<link rel="stylesheet" href="/SKFTraceability/css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Production </title>
</head>
<body>
<center><h1>Production</h1>
	<%Assemblage assemblage= (Assemblage)request.getAttribute("assemblage");
	if(assemblage==null)
	{
	}
	else
	{	%>
	<table>
			<caption> Fiche Suiveuse </caption>
		<tr>

		 
		 
			<th>N° Assemblage</th>
			<td><%=assemblage.getA_CodeBarre() %></td>
		</tr>
		<tr>
			<th>Désignation</th>
			<td><%=assemblage.getA_Designation()%></td>
		</tr>
		<tr>
			<th>XXXXXXXXXXxxx</th>
			<td>XXXXXXXXXxx</td>
		</tr>
		
	</table> <br>
	<a href="index.html">Changer de piece</a>
<%ArrayList<Operation> listop = (ArrayList<Operation>)request.getAttribute("operation");%>
<%if(listop!=null) 
{



%>
<form action="validerOperation" method="post">
	<table>
		<tr>
			<th>nom de l'assemblage</th>
			<th>libellé del'operation</th>
			<th>NOM</th>
			<th>N°OUTILLAGE/N°SERIE</th>
			<th>PV/N°LOT</th>
			<th>REMARQUES EVENTUELLES</th>
			<th></th>
		</tr>
		<%
		Operation oper;
		Iterator i = listop.iterator();
		int j=0;
		while(i.hasNext())
		{//oper.ge
			
			oper=(Operation)i.next(); %>

		<tr>
			<td><%=oper.getOp_A_Nom() %></td>
			<td><%=oper.getOp_Libelle()%></td>
			<%if(oper.getOp_EO().getE_Etat().compareTo("fait")==0)
			{%>
			<td>OK<input type="hidden" name="etat<%=oper.getOp_ID() %>" value="1"></td>
			<%}else if (oper.getOp_EO().getE_Etat().compareTo("pasFait")==0){ %>
			<td>OK<input type="checkbox" name="etat<%=oper.getOp_ID() %>" value="1"></td>
			<%}else{ %>
			<td>erreur</td>
			<%} %>
		</tr>
		<%} %>

		
	</table>
	</form>
<% 		}
	}%>

	<input type="submit" value="Enregistrer">
	</center>
</body>
</html>