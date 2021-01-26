package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Endereco;
import connection.SingleConnection;

public class DaoEndereco {
private Connection connection;
	
	
	public DaoEndereco(){
		connection = SingleConnection.getConnection();
	}

	
	
	public void Salvar(Endereco endereco){
		try{
			String sql="INSERT INTO endereco(cep, rua, bairro, cidade, estado) VALUES(?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, endereco.getCep());
			insert.setString(2, endereco.getRua());
			insert.setString(3, endereco.getBairro());
			insert.setString(4, endereco.getCidade());
			insert.setString(5, endereco.getEstado());
			insert.execute();
			connection.commit();
		}catch (Exception e){
			e.printStackTrace();
			try{
				connection.rollback();
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}
	}
	
	public List<Endereco> listar() throws Exception{
		List<Endereco> listar = new ArrayList<Endereco>();
		
		String sql = "select * from endereco";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()){
			Endereco endereco = new Endereco();
			endereco.setCep(resultSet.getString("cep"));
			endereco.setRua(resultSet.getString("rua"));
			endereco.setBairro(resultSet.getString("bairro"));
			endereco.setCidade(resultSet.getString("cidade"));
			endereco.setEstado(resultSet.getString("estado"));
			
			listar.add(endereco);
		}
		
		return listar;
	}
	
	public boolean validarEndereco(String cep) throws Exception {
		String sql = "SELECT * FROM endereco WHERE cep = '"+ cep +"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else{
		return false;
			}
	}

	
	}


