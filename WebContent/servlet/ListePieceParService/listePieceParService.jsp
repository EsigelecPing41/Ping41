<%--*****************************************************
* Module : Vue
* Fichier : etatDouchette
* Description : Fichier JSP permettant d'afficher la liste des pieces accessibles (utilise la servlet ListeDesPIecesParService pour ce mettre a jour)
* Projet : SKF Traceability
* Auteur : GC
* Date : 13/12/12
* Version : 0.5
******************************************************--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modele.Piece"%>
<%@ page import="Modele.Assemblage"%> 
<%@ page import="java.util.ArrayList"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/SKFTraceability/css/css.css" />
</head>
<body>
<center>
<form target="content" action="../content/metrologie.html" >
Numéro de série de la piéce :<br><input type="text" name="num_piece">
<!-- <a href="javascript:document.getElementById('scanner').style.display='block';document.getElementById('manuel').style.display='none'"><img src="servlet/img/douchette.jpg" width="20px"></a> -->
<div id="scanner" style="display : none;background-color:grey;">
Scanner le code bar<br><input type="submit" value="Simule la récupération via la douchette"></a><br><a href="javascript:document.getElementById('scanner').style.display='none';document.getElementById('manuel').style.display='block'">Annuler</a>
</div>
<div id="manuel">
<input type="submit" value="Valider"></a>
</div>
</form>
<% 
	HttpSession ses = request.getSession(true);
	//si on est en prod ou avant
	String lib = (String)ses.getAttribute("lib");
	System.out.println(lib);
	if(!lib.equals("Accueil") || !lib.equals("Aide"))
	{
		if(lib.equals("Qualite") || lib.equals("Production") || lib.equals("Expedition"))
		{
		
%>
<h2>Liste des assemblages</h2>
<table class="tableau">
<%	
			ArrayList<Assemblage> assemblages = (ArrayList<Assemblage>)ses.getAttribute("listeAssemblage");
			for ( int i=0; i<assemblages.size(); i++ ) {
%>
	 <tr>
		<td class="case"> <a target="page" href="/SKFTraceability/chercherPiece?id=<%=assemblages.get(i).getA_ID()%>"><%=assemblages.get(i).getA_Nom()%></a> </td>
		<td class="case"><%=assemblages.get(i).getA_CodeBarre() %></td>
	</tr>
<% 
			}
		}
		else
		{
			ArrayList<Piece> pieces = (ArrayList<Piece>)ses.getAttribute("listePiece");
			%>
			<h2>Liste des pièces</h2>
			<table class="tableau"><%
			for ( int i=0; i<pieces.size(); i++ ) {
			%>
		 <tr>
			<td class="case"> <a target="page" href="/SKFTraceability/chercherPiece?id=<%=pieces.get(i).getP_ID()%>"><%=pieces.get(i).getP_Nom()%></a> </td>
			<td class="case"><%=pieces.get(i).getP_CodeBarre() %></td>
		</tr>
			<%
				}	
		}
	}
%>
</table>


</ul>
</center>
</body>
</html>