<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modele.Assemblage"%> 
<%@ page import="Modele.ControleQualite"%>
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
	if(assemblage== null){
%>
	Erreur avec la piece
<%
	}else{
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
	<tr>
		<th class="case">Critères de qualités 1
		</th>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ok"> Ok
		</td>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ko"> Ko
		</td>
	</tr>
	<tr>
		<th class="case">Critères de qualités 2
		</th>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ok"> Ok
		</td>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ko"> Ko
		</td>
	</tr>
	<tr>
		<th class="case">Critères de qualités 3
		</th>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ok"> Ok
		</td>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ko"> Ko
		</td>
	</tr>
	<tr>
		<th class="case">Critères de qualités 4
		</th>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ok"> Ok
		</td>
		<td class="case"><INPUT type= "radio" name="Ok" value="Ko"> Ko
		</td>
	</tr>
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