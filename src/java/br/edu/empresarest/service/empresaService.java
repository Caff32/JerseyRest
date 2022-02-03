/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.empresarest.service;

import br.edu.empresarest.dao.EmpresaDAO;
import br.edu.empresarest.model.Empresa;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class empresaService {

private EmpresaDAO  db = new EmpresaDAO();

public List<Empresa> getEmpresa(){

    try {

    List<Empresa> empresas = db.getEmpresa();

    return empresas;
        
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<Empresa>();

    }
}

	public boolean save(Empresa empresa) {
		try {
			db.save(empresa);
			return true;

	} catch (SQLException e) {
			return false;
		}
	}

   	public boolean delete(Long id) {
		try {
			return db.delete(id);
		} catch (SQLException e) {
			return false;
		}
	}
}
