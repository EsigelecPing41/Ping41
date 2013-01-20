<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Modele.Piece"%> 
<%@ page import="Modele.Assemblage"%> 
<%@ page import="Modele.Operation"%> 
<%@ page import="Modele.ActionAssemblage"%> 
<%@ page import="dao.ActionAssemblageDAO"%> 


<%@ page import="Modele.EtatOperation"%> 
<%@ page import="java.util.List"%> 
<%@ page import="java.util.Iterator;"%> 

<html>
<head>
<link rel="stylesheet" href="../../../css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Production </title>
</head>
<body>
<% 
	List<Operation> listOp = (List<Operation>)request.getAttribute("operation");
	Assemblage assemblage = (Assemblage)request.getAttribute("assemblage");
	String error = (String)request.getAttribute("erreur");
	Operation operation;
	Piece piece= null;
	if(assemblage== null){
%>
	Erreur avec l'assemblage
<%
	}else{
		
		if(error!=null)
		{
			%>
			
			<%=error %>
			
			<%
			
		}
		
%>

<center><h1>Production</h1>
	
	<table class="tableau_info">
			<caption> Fiche Suiveuse </caption>
		<tr>
			<th class="case_info">N° Piéce</th>
			<td class="case_info"><%=assemblage.getA_CodeBarre() %></td>
		</tr>
		<tr>
			<th class="case_info">Désignation</th>
			<td><%=assemblage.getA_Nom() %></td>
		</tr>
		<tr>
			<th class="case_info">XXXXXXXXXXxxx</th>
			<td class="case_info">XXXXXXXXXxx</td>
		</tr>
		
	</table> <br>
	<form action="send_fiche_qualite">
	<table  class="tableau">
		<tr>
			<th class="case">OPERATION</th>
			<th class="case">DATE</th>
			<th class="case">NOM</th>
			<th class="case">N°OUTILLAGE/N°SERIE</th>
			<th class="case">PV/N°LOT</th>
			<th class="case">REMARQUES EVENTUELLES</th>
			<th class="case"></th>
		</tr>
	<% 
	List<ActionAssemblage> listaction;
	ActionAssemblage action;
	EtatOperation etatop;
	
	Iterator ops = listOp.iterator();
	int i=1;
	while(ops.hasNext())
	{
   	operation = (Operation)ops.next();
   	//ActionAssemblageDAO actionAssemblageDAO = ActionAssemblageDAO.getInstance();
   	listaction=ActionAssemblageDAO.getListActionAssemblage(assemblage.getA_ID());
  	
	Iterator actions = listaction.iterator();
	if(actions!=null)
	{	
		while(actions.hasNext())
		{
		action = (ActionAssemblage)actions.next();
	%>
		<tr>
		<td class="case"><%=operation.getOp_Libelle() %></td>
		<td><%=action.getAA_Date() %></td>
		<td class="case"></td>
		<td class="case"><%=operation.getOp_EO().getE_Etat()%></td>
	<%
	
	//Iterator etat = EtatOperation;	
	%>	
		
		
	</tr>
	<%
		}
	}
	else
	{
		
	}

		%>
		<tr>
			<td class="case"><%=operation.getOp_Libelle()%></td>
			<td class="case"><input name="date<%=i%>" type="text" size="2" style="width:90px"> format : DD/MM/YY</td>
			<td class="case"></td>
			<td class="case">N°Série <input name="num_serie<%=i%>" type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat<%=i%>" value="1"></td>
		</tr>
		<%i++; %>
		<%//=}%>
		
	</table>
	


	<input type="submit" value="Enregistrer">
	</form>
	</center>
<% 
	}
%>
		
		
		
	</table>


	<input type="submit" value="Enregistrer">
	
<% 	} %>
</body>
</html>