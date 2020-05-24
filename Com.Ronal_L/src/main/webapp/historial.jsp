<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historial De Usuarios</title>
</head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">


	$(document).ready(function(){ 
		 $.post('ServeletHistorial',{

		 },function(response){

		 var datos = JSON.parse(response);
		

		 var tabladatos = document.getElementById('tablaDatos');
		 for(let item of datos){

		 	tabladatos.innerHTML += `

				
		 	

		 `
		 }



		});
	
		
	});

</script>


<body>
<table class="table table-dark" id="tablaDatos">
	<thead>
	<th>Id</th>
	<th>Id Usuario</th>
	<th>Nombre</th>	
	<th>Apellido</th>	
	<th>Fecha</th>
	</thead>

		<tbody>
		

		</tbody>
	</table>

</body>
</html>