<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Modele.Assemblage"%> 
<%@ page import="Modele.CritereQualite" %>
<%@ page import="Modele.ControleQualite"%>
<%@ page import="java.util.ArrayList"%>

<html>
<head>
<link rel="stylesheet" href="/SKFTraceability/css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Production </title>
</head>
<body>
<center><h1>Production</h1>
	
	<table>
			<caption> Fiche Suiveuse </caption>
		<tr>
	<%Assemblage assemblage= (Assemblage)request.getAttribute("assemblage");
	if(assemblage==null)
	{
 	ControleQualite controleQualite = (ControleQualite)request.getAttribute("controleQualite");%>
			<th>N� Assemblage</th>
			<td><%=assemblage.getA_CodeBarre() %></td>
		</tr>
		<tr>
			<th>D�signation</th>
			<td><%=assemblage.getA_Designation()%></td>
		</tr>
		<tr>
			<th>XXXXXXXXXXxxx</th>
			<td>XXXXXXXXXxx</td>
		</tr>
		
	</table> <br>
	<a href="index.html">Changer de piece</a>

	<table>
		<tr>
			<th>OPERATION</th>
			<th>DATE</th>
			<th>NOM</th>
			<th>N�OUTILLAGE/N�SERIE</th>
			<th>PV/N�LOT</th>
			<th>REMARQUES EVENTUELLES</th>
			<th></th>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td>ROTOR NU</td>
			<td><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td></td>
			<td>N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td>P.V.FOURNISSEUR</td>
			<td><textarea></textarea></td>
			<td>OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
	</table>
<% }%>

	<input type="submit" value="Enregistrer">
	</center>
</body>
</html>