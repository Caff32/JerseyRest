/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.empresarest.model;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
        private Long id;
        private String nome;
        private String endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

        @Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", endereco=" + endereco + "]";
	}


    
}
