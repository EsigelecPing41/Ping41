 <%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Modele.Piece"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/SKFTraceability/css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Magasin</title>
</head>
<body>
<center>
	<h1>MAGASIN</h1>
	<br>
	<form method="post" action="/SKFTraceability/servlet/Magasin/send_nouvelle_piece.jsp" >
<%
Piece piece = (Piece)request.getAttribute("piece");
if(piece!=null )
{
	%>Le <%=piece.getP_Nom()%> : <%=piece.getP_CodeBarre()%> est déja rentrée<%
}
else
{
	HttpSession ses = request.getSession(true);
	String error = (String)ses.getAttribute("error");
	if(error == null)
	{
		error = "";
	}

%>
	<!--<a href="">Imprimer le code barre</a>-->
<!-- 	<input type="hidden" value="<%//(String)ses.getAttribute("piece") %>" name= "codeBarre"> -->
	<%=error %>
	<table class="tableau">
		<tr>
			<th class="case">code barre</th>
			<td class="case"><input type="text" value="" name="codeBarre"></td>
		</tr>
		<tr>
			<th class="case">Nom de la pièce</th>
			<td class="case"><input type="text" value="" name="nomPiece"></td>
		</tr>
		
		<tr>
			<th class="case">Nom de l'assemblage pièce</th>
			<td class="case"><input type="text" value="" name="nomAPiece"></td>
		</tr>
		
		<tr>
			<th class="case">Nom fournisseur</th>
			<td class="case"><input type="text" value="" name= "nomFournisseur"></td>
		</tr>
		
		<tr>
			<th class="case">Numéro dossier</th>
			<td class="case"><input type="text" value="" name= "numDossier"></td>
		</tr>
		
		<tr>
			<th class="case">Numéro référence</th>
			<td class="case"><input type="text" value="" name= "numReference"></td>
		</tr>
		
		<tr>
			<th class="case">Quantité</th>
			<td class="case"><input type="text" value="" name= "quantite"></td>
		</tr>
		
		<tr>
			<th class="case">Date de livraison (AAAA/MM/JJ)</th>
			<td class="case"><input type="text" value="" name= "dateLivraison"></td>
		</tr>			
		<tr>
			<th colspan="2"><input type="submit" value="Enregistrer"></th>
		</tr>
	</table>
	</form>
	<%}%>
</center>
</body>
</html>