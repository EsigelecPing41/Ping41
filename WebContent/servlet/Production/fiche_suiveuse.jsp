<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modele.Piece"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<link rel="stylesheet" href="../../../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Production </title>
</head>
<body>
<% 
	Piece piece = (Piece)request.getAttribute("piece");
	if(piece== null){
%>
	Erreur avec la piece
<%
	}else{
%>
<center><h1>Production</h1>
	
	<table class="tableau_info">
			<caption> Fiche Suiveuse </caption>
		<tr>
			<th class="case_info">N� Pi�ce</th>
			<td class="case_info"><%=piece.getP_CodeBarre() %></td>
		</tr>
		<tr>
			<th class="case_info">D�signation</th>
			<td><%=piece.getP_Nom() %></td>
		</tr>
		<tr>
			<th class="case_info">XXXXXXXXXXxxx</th>
			<td class="case_info">XXXXXXXXXxx</td>
		</tr>
		
	</table> <br>
	<table  class="tableau">
		<tr>
			<th class="case">OPERATION</th>
			<th class="case">DATE</th>
			<th class="case">NOM</th>
			<th class="case">N�OUTILLAGE/N�SERIE</th>
			<th class="case">PV/N�LOT</th>
			<th class="case">REMARQUES EVENTUELLES</th>
			<th class="case"></th>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
		<tr>
			<td class="case">ROTOR NU</td>
			<td class="case"><input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px">/<input type="text" size="2" style="width:30px"></td>
			<td class="case"></td>
			<td class="case">N�S�rie <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat" value="1"></td>
		</tr>
	</table>


	<input type="submit" value="Enregistrer">
	</center>
<% 
	}
%>
</body>
</html>