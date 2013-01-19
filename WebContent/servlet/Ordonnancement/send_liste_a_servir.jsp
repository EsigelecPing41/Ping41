<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%> 
    <%@ page import="java.util.Iterator"%> 
    <%@ page import="Modele.Ordonnancement"%>   
<%@ page import="java.text.SimpleDateFormat"%>   
<%@ page import="java.util.Date"%> 

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Ordonnancement> listOrdo;

String suivi = (String)request.getAttribute("suivi");
if((String)request.getAttribute("article1")!=null && (String)request.getAttribute("nb_a_fabr1")!=null && (String)request.getAttribute("ste1")!=null && (String)request.getAttribute("num_cmd1")!=null && (String)request.getAttribute("ref_cde1")!=null && (String)request.getAttribute("date_cde1")!=null && (String)request.getAttribute("mise_fab1")!=null && (String)request.getAttribute("delai_prv1")!=null&& (String)request.getAttribute("delai_dde1")!=null&& (String)request.getAttribute("fam_gest1")!=null&&(String)request.getAttribute("Ord_NumDossier")!=null&&(String)request.getAttribute("Ord_CodeGPAO")!=null &&(String)request.getAttribute("Ord_IndNomenclature")!=null &&(String)request.getAttribute("Ord_NumSerie")!=null &&(String)request.getAttribute("Ord_ComInterne")!=null)
{
	String pieceNom1 = (String)request.getAttribute("article1");
	Integer nb_a_fabr1 = (Integer)request.getAttribute("nb_a_fabr1");
	String ste1 = (String)request.getAttribute("ste1");
	String num_cmd1 = (String)request.getAttribute("num_cmd1");
	String ref_cde1 = (String)request.getAttribute("ref_cde1");
	String code_client1 = (String)request.getAttribute("code_client1");
	
	
		
	String cde1 = (String)request.getAttribute("date_cde1");
	String fab1 = (String)request.getAttribute("mise_fab1");
	String prv1 = (String)request.getAttribute("delai_prv1");
	String dde1 = (String)request.getAttribute("delai_dde1");
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	Date date_cde1 = sdf.parse(cde1);
	Date date_fab1 = sdf.parse(fab1);
	Date date_prv1 = sdf.parse(prv1);
	Date date_dde1 = sdf.parse(dde1);
	
	String fam_gest1 = (String)request.getAttribute("fam_gest1");
	
	String Ord_NumDossier = (String)request.getAttribute("Ord_NumDossier1");
	String Ord_CodeGPAO = (String)request.getAttribute("Ord_CodeGPAO1");
	String Ord_IndNomenclature = (String)request.getAttribute("Ord_IndNomenclature1");
	String Ord_NumSerie = (String)request.getAttribute("Ord_NumSerie1");
	String Ord_ComInterne = (String)request.getAttribute("Ord_ComInterne1");
	
	
	/*num commande?*/
	Ordonnancement ordonnancement = new Ordonnancement(/*int Ord_ID,*/pieceNom1,nb_a_fabr1,ste1,num_cmd1,code_client1,date_cde1,date_fab1,date_prv1,date_dde1,fam_gest1,Ord_NumDossier1, Ord_CodeGPAO1,Ord_IndNomenclature1,Ord_NumSerie1,Ord_ComInterne1);    
	listOrdo.add(0, ordonnancement);
}


if((String)request.getAttribute("article2")!=null && (String)request.getAttribute("nb_a_fabr2")!=null && (String)request.getAttribute("ste2")!=null && (String)request.getAttribute("num_cmd2")!=null && (String)request.getAttribute("ref_cde2")!=null && (String)request.getAttribute("date_cde2")!=null && (String)request.getAttribute("mise_fab2")!=null && (String)request.getAttribute("delai_prv2")==null&& (String)request.getAttribute("delai_dde2")!=null&& (String)request.getAttribute("fam_gest2")!=null)
{
	String pieceNom2 = (String)request.getAttribute("article2");
	String nb_a_fabr2 = (String)request.getAttribute("nb_a_fabr2");
	String ste2 = (String)request.getAttribute("ste2");
	String num_cmd2 = (String)request.getAttribute("num_cmd2");
	String ref_cde2 = (String)request.getAttribute("ref_cde2");

	
	
	String cde2 = (String)request.getAttribute("date_cde2");
	String fab2 = (String)request.getAttribute("mise_fab2");
	String prv2 = (String)request.getAttribute("delai_prv2");
	String dde2 = (String)request.getAttribute("delai_dde2");
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	Date date_cde2 = sdf.parse(cde2);
	Date date_fab2 = sdf.parse(fab2);
	Date date_prv2 = sdf.parse(prv2);
	Date date_dde2 = sdf.parse(dde2);
	

	String fam_gest2 = (String)request.getAttribute("fam_gest2");

	String Ord_NumDossier2 = (String)request.getAttribute("Ord_NumDossier2");
	String Ord_CodeGPAO2 = (String)request.getAttribute("Ord_CodeGPAO2");
	String Ord_IndNomenclature2 = (String)request.getAttribute("Ord_IndNomenclature2");
	String Ord_NumSerie2 = (String)request.getAttribute("Ord_NumSerie2");
	String Ord_ComInterne2 = (String)request.getAttribute("Ord_ComInterne2");
	
	Ordonnancement ordonnancement = new Ordonnancement(/*int Ord_ID,*/pieceNom2,nb_a_fabr2,ste2,num_cmd2,code_client2,date_cde2,date_fab2,date_prv2,date_dde2,fam_gest2,Ord_NumDossier2, Ord_CodeGPAO2,Ord_IndNomenclature2,Ord_NumSerie2,Ord_ComInterne2);    
	listOrdo.add(1, ordonnancement);
}

if((String)request.getAttribute("article3")!=null && (String)request.getAttribute("nb_a_fabr3")!=null && (String)request.getAttribute("ste3")!=null && (String)request.getAttribute("num_cmd3")!=null && (String)request.getAttribute("ref_cde3")!=null && (String)request.getAttribute("date_cde3")!=null && (String)request.getAttribute("mise_fab3")!=null && (String)request.getAttribute("delai_prv3")==null&& (String)request.getAttribute("delai_dde3")!=null&& (String)request.getAttribute("fam_gest3")!=null)
{
	String pieceNom3 = (String)request.getAttribute("article3");
	String nb_a_fabr3 = (String)request.getAttribute("nb_a_fabr3");
	String ste3 = (String)request.getAttribute("ste3");
	String num_cmd3 = (String)request.getAttribute("num_cmd3");
	String ref_cde3 = (String)request.getAttribute("ref_cde3");
	
	String date_cde3 = (String)request.getAttribute("date_cde3");
	String mise_fab3 = (String)request.getAttribute("mise_fab3");
	String delai_prv3 = (String)request.getAttribute("delai_prv3");
	String delai_dde3 = (String)request.getAttribute("delai_dde3");
	
	String fam_gest3 = (String)request.getAttribute("fam_gest3");
}


RequestDispatcher dispatcher = request.getRequestDispatcher("LancerListeAServir");
Ordonnancement ordonnancement = new Ordonnancement(/*int Ord_ID,*/pieceNom1,nb_a_fabr1,ste1,num_cmd1,code_client1,date_cde1,date_fab1,date_prv1,date_dde1,fam_gest1,Ord_NumDossier, Ord_CodeGPAO,Ord_IndNomenclature,Ord_NumSerie,Ord_ComInterne);    
listOrdo.add(2, ordonnancement);

request.setAttribute("listOrdo",listOrdo);
request.setAttribute("suivi",suivi);
dispatcher.forward( request, response );	






%>
</body>
</html>