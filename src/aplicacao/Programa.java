package aplicacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import bd.BD;
import bd.BDExcecao;
import modelo.entidades.Departamento;

public class Programa {

	public static void main(String[] args) {
	
		Departamento departamento = new Departamento(1, "Livros");
		
		System.out.println(departamento);
		
	}
}
