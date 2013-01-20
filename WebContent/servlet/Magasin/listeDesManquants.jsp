<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="Modele.Ordonnancement"%>
            <%@ page import="java.util.Iterator"%>    
            <%@ page import="java.util.List"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des manquants</title>
</head>
<body>
<%
	List<Ordonnancement> listordo = (List<Ordonnancement>)request.getAttribute("listordo"); 
Ordonnancement ordo;
Iterator i = listordo.iterator();
while(i.hasNext())
{
	ordo=(Ordonnancement)i.next();

%>
<table>
	<tr>
		<td>Designation
		</td>
		<td>
	   		<%= ordo.getOrd_Designation()    %>
	   </td>
	</tr>
	<tr>
		<td>QteFab
		</td>
		<td>
	   		<%=ordo.getOrd_QteFab()  %>
	   </td>
	</tr>
	<tr>
		<td>Ste
		</td>
		<td>
	   		<%=ordo.getOrd_Ste() %>
	   </td>
	</tr>
	<tr>
		<td>CodeClient
		</td>
		<td>
	   		<%=ordo.getOrd_CodeClient() %>
		</td>
	</tr>
	<tr>
		<td>DelaiCde
		</td>
		<td>
	  		<%=ordo.getOrd_DelaiCde() %>
	  </td>
	</tr>
	<tr>
		<td>MFab
		</td>
		<td>
	  		<%=ordo.getOrd_MFab() %>
	 	</td>
	</tr>
	<tr>
		<td>DelaiPrv
		</td>
		<td>
	    	<%=ordo.getOrd_DelaiPrv() %>
	    </td>
	</tr>
	<tr>
		<td>FamGest
		</td>
		<td>
	    	<%=ordo.getOrd_FamGest() %>
	    </td>
	</tr>
	<tr>
		<td>NumDossier
		</td>
		<td>
	    	<%=ordo.getOrd_NumDossier() %>
	    </td>
	</tr>
	<tr>
		<td>CodeGPAO
		</td>
		<td>
	    	<%=ordo.getOrd_CodeGPAO() %>
	    </td>
	</tr>
	<tr>
		<td>IndNomenclature
		</td>
		<td>
	    	<%=ordo.getOrd_IndNomenclature() %>
	    </td>
	</tr>
	<tr>
		<td>NumSerie
		</td>
		<td>
	    	<%=ordo.getOrd_NumSerie() %>
	    </td>
	</tr>
	<tr>
		<td>ComInterne
		</td>
		<td>
	    	<%=ordo.getOrd_ComInterne() %>
	    </td>
	</tr>
</table>
<%
	}
%>
</body>
</html>