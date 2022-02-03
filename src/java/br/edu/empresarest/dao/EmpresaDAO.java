/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.empresarest.dao;

import br.edu.empresarest.model.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class EmpresaDAO extends BaseDAO{

public List<Empresa> getEmpresa() throws SQLException{
    
    List<Empresa> Listaa = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;

    try {

         conn = getConnection();
         stmt = conn.prepareStatement(" select * from test.empresa");
       //  System.out.println("caiuuuuuu");
         ResultSet rs = stmt.executeQuery();
         System.out.println(rs);
         while(rs.next()){

         Empresa e = createEmpresa(rs);
         Listaa.add(e);

        }
       
        rs.close();

        
    } finally  {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
    }


return Listaa;

}


/*

List<Carro> carros = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from carro");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Carro c = createCarro(rs);
				carros.add(c);
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return carros;
*/

    private Empresa createEmpresa(ResultSet rs) throws SQLException {
        Empresa e = new Empresa();
        e.setId(rs.getLong("id"));
        e.setNome(rs.getString("nome"));
        e.setNome(rs.getString("endereco"));
    return e;

    }

    public void save(Empresa e) throws SQLException {
                Connection conn = null;
		PreparedStatement stmt = null;
		
                
                try {
			conn = getConnection();
			if (e.getId()== null) {

				stmt = conn.prepareStatement(
								"insert into test.empresa (nome,endereco) VALUES(?,?)",
								Statement.RETURN_GENERATED_KEYS);

			} else {

				stmt = conn.prepareStatement("update test.empresa set nome=?, endereco=? where id =?");
			}
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getEndereco());



			if (e.getId() != null) {
				// Update
				stmt.setLong(3, e.getId());



			}




			int count = stmt.executeUpdate() ;
                             if (e.getId()== null) {
				Long id = getGeneratedId(stmt);
				e.setId(id);
                          
                                                }

			if (count == 0) {
				throw new SQLException("Erro ao inserir o carro");
			}
			// Se inseriu, ler o id auto incremento
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
    }

  	public static Long getGeneratedId(Statement stmt) throws SQLException {
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			Long id = rs.getLong(1);
			return id;
		}
		return 0L;
	}

  public boolean delete(Long id) throws SQLException {
		
            
                 Connection conn = null;
		
                
                PreparedStatement stmt = null;
		
                
                try {
			conn = getConnection();
			stmt = conn.prepareStatement("delete from test.empresa where id=?");
			stmt.setLong(1, id);
			int count = stmt.executeUpdate();
			boolean ok = count > 0;
			return ok;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

    
}
