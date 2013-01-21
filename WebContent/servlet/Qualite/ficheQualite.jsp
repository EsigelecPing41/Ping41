<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modele.Assemblage"%> 
<%@ page import="Modele.CritereQualite" %>
<%@ page import="Modele.ControleQualite"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../../../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Qualité</title>
</head>
<body>
 <% 
 	
	Assemblage assemblage= (Assemblage)request.getAttribute("assemblage");
 	ControleQualite controleQualite = (ControleQualite)request.getAttribute("controleQualite");
	ArrayList<CritereQualite> listCritere = (ArrayList<CritereQualite>)controleQualite.getCQ_ListCriteres();
 	if(assemblage== null){
%>
	Erreur avec la piece
<%
	}else{
		request.setAttribute("assemblage", assemblage);
		request.setAttribute("controleQualite", controleQualite);
		
%>
<center>
<h1>Qualité</h1>
<br><br>
<form action="valideFicheQualite" method="POST">
<table class="tableau">
	<tr>
		<th>N° du Code Barre
		</th>
		<td><%=assemblage.getA_CodeBarre() %>
		</td>
	</tr>
	<tr>
		<th>Nom de l'assemblage
		</th>
		<td><%=assemblage.getA_Designation()%>
		</td>
	</tr>
	<tr>
		<th>Fiche Pv de contrôle
		</th>
		<td>
		</td>
	</tr>
</table>
<br>
<br>
<table class="tableau">
	<tr><td>Nom  du test </td><td>Ok</td><td>Not ok</td></tr>
	<%
	
	for(int i = 0; i<listCritere.size();i++)
	{
		%>
	<tr>
		<th><%=listCritere.get(i).getCrQ_libelle() %></th>
			<td><input type="radio" name="<%=listCritere.get(i).getCrQ_ID() %>" value ="1"></td>
				<td><input type="radio" name="<%=listCritere.get(i).getCrQ_ID() %>" value ="0"></td>		
	</tr>
	<%} %>
</table>

<div id="manuel">
<input type="submit" value="Valider"></a>
</div>
</form>
</center>
<% 
	}
%>
</body>
</html>