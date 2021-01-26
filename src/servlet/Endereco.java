package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoEndereco;

/**
 * Servlet implementation class Endereco
 */
@WebServlet("/salvarEndereco")
public class Endereco extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DaoEndereco daoendereco = new DaoEndereco();
	
    public Endereco() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		beans.Endereco endereco = new beans.Endereco();
		endereco.setCep(cep);
		endereco.setRua(rua);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);

		
		try{
			
		 if(!daoendereco.validarEndereco(cep)){
			daoendereco.Salvar(endereco);
			request.setAttribute("msg", "CEP Cadastrado");
		}else {
			request.setAttribute("msg", "Endereço ja esta cadastrado");
		}
			RequestDispatcher view = request.getRequestDispatcher("");
			request.setAttribute("endereco", daoendereco.listar());
			view.forward(request, response);
			}catch (Exception e){
				e.printStackTrace();
			}
		}

}
