<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Modele.Piece"%> 
<%@ page import="Modele.Assemblage"%> 
<%@ page import="Modele.Operation"%> 
<%@ page import="Modele.ActionAssemblage"%> 
<%@ page import="dao.ActionAssemblageDAO"%> 
<%@ page import="Modele.CritereQualite" %>
<%@ page import="Modele.ControleQualite"%>
<%@ page import="Modele.Operation"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>


<%@ page import="Modele.EtatOperation"%> 
<%@ page import="java.util.List"%> 
<%@ page import="java.util.Iterator;"%> 







<html>
<head>
<link rel="stylesheet" href="../../../css/css.css" />
<link rel="stylesheet" href="/SKFTraceability/css/css.css" />
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
	<%Assemblage assemblage= (Assemblage)request.getAttribute("assemblage");
	if(assemblage==null)
	{
	}
	else
	{	%>
	<table>
			<caption> Fiche Suiveuse </caption>
		<tr>
			<th class="case_info">N° Piéce</th>
			<td class="case_info"><%=assemblage.getA_CodeBarre() %></td>


		 
		 
			<th>N° Assemblage</th>
			<td><%=assemblage.getA_CodeBarre() %></td>

		</tr>
		<tr>
			<th class="case_info">Désignation</th>
			<td><%=assemblage.getA_Nom() %></td>
			<th>Désignation</th>
			<td><%=assemblage.getA_Designation()%></td>
		</tr>
		<tr>
			<th class="case_info">XXXXXXXXXXxxx</th>
			<td class="case_info">XXXXXXXXXxx</td>
			<th>XXXXXXXXXXxxx</th>
			<td>XXXXXXXXXxx</td>
		</tr>
		
	</table> <br>
	<form action="send_fiche_qualite">
	<table  class="tableau">
	<a href="index.html">Changer de piece</a>
<%ArrayList<Operation> listop = (ArrayList<Operation>)request.getAttribute("operation");%>
<%if(listop!=null) 
{



%>
<form action="validerOperation" method="post">
	<table>
		<tr>
			<th class="case">OPERATION</th>
			<th class="case">DATE</th>
			<th class="case">NOM</th>
			<th class="case">N°OUTILLAGE/N°SERIE</th>
			<th class="case">PV/N°LOT</th>
			<th class="case">REMARQUES EVENTUELLES</th>
			<th class="case"></th>
			<th>nom de l'assemblage</th>
			<th>libellé del'operation</th>
			<th>NOM</th>
			<th>N°OUTILLAGE/N°SERIE</th>
			<th>PV/N°LOT</th>
			<th>REMARQUES EVENTUELLES</th>
			<th></th>
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
		<%
		Operation oper;
		Iterator i = listop.iterator();
		int j=0;
		while(i.hasNext())
		{//oper.ge
			
			oper=(Operation)i.next(); %>

		<tr>
			<td class="case"><%=operation.getOp_Libelle()%></td>
			<td class="case"><input name="date<%=i%>" type="text" size="2" style="width:90px"> format : DD/MM/YY</td>
			<td class="case"></td>
			<td class="case">N°Série <input name="num_serie<%=i%>" type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"> <input type="text" size="2" style="width:10px"><input type="text" size="2" style="width:10px"></td>
			<td class="case">P.V.FOURNISSEUR</td>
			<td class="case"><textarea></textarea></td>
			<td class="case">OK<input type="checkbox" name="etat<%=i%>" value="1"></td>
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
		<%i++; %>
		<%//=}%>
		
	</table>
	
		<%} %>

























































	<input type="submit" value="Enregistrer">
	</form>
	</center>
<% 
	}
%>
		
		
		
	</table>


	<input type="submit" value="Enregistrer">
	
<% 	} %>
		
	</table>
	</form>
<% 		}
	}%>

	<input type="submit" value="Enregistrer">
	</center>
</body>
</html>