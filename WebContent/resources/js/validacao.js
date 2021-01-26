function validarCampos() {
			if(document.getElementById("cep").value == '') {
				alert("Informe o CEP!");
				return false;
			}
			return true;
		}
