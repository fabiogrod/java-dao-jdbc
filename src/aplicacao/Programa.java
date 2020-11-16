package aplicacao;

import java.util.Date;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
	
		Departamento departamento = new Departamento(1, "Livros");
		
		Vendedor vendedor = new Vendedor(21, "Fabio", "fabio@gmail.com", new Date(), 3000.0, departamento);
		
		VendedorDao vendedorDao = FabricaDao.gerarVendedorDao();
		
		System.out.println(vendedor);
		
	}
}
