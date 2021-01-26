<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/style.css" />
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
<title>Consulta CEP</title>
</head>
<body>
<h1>Digite o CEP</h1>
	
	<div class="icone d-flex justify-content-center">
	
	<img src="resources/img/mapa.jpg" alt="Mapa">
	
	</div>
	<form class="bg-light rounded p-4 box-shadow" action="salvarEndereco" method="post"
	onsubmit="return validarCampos()? true : false;" >
	<h3>${msg}</h3>
	<div class="form-group col">
	<label>CEP</label>
	<input type="text" class="form-control" id="cep" name="cep" onblur="consultarCep()">
	</div>
	<div class="form-group col">
	<label>Rua</label>
	<input type="text" class="form-control" id="rua" name="rua">
	</div>
	<div class="form-group col">
	<label>Bairro</label>
	<input type="text" class="form-control" id="bairro" name="bairro">
	</div>
	<div class="form-group col">
	<label>Cidade</label>
	<input type="text" class="form-control" id="cidade" name="cidade">
	</div>
	<div class="form-group col">
	<label>Estado</label>
	<input type="text" class="form-control" id="estado" name="estado">
	</div>
		<button type="submit" value="Salvar" class="btn btn-secondary mr-2">Salvar</button>  
	</form>
	
	<div class="row">
	<div class="col-md-12">
		<table class="table table-condensed table-hover">
			<tr>
				<th>CEP</th>
				<th>Rua</th>
				<th>Bairro</th>
				<th>Cidade</th>
				<th>Estado</th>

			</tr>
			<c:forEach items="${endereco}" var="end">
				<tr>
					<td><c:out value="${end.cep}" /></td>
		
				
					<td><c:out value="${end.rua}" /></td>
			
				
					<td><c:out value="${end.bairro}" /></td>
				
				
					<td><c:out value="${end.cidade}" /></td>
				
				
					<td><c:out value="${end.estado}" /></td>
				
				
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
	<script type="text/javascript" src="resources/js/javascript.js" /></script>
	<script type="text/javascript" src="resources/js/validacao.js" /></script>
</body>
</html>