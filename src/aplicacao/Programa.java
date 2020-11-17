package aplicacao;

import java.util.List;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
	
//		Departamento departamento = new Departamento(1, "Livros");
//		
//		Vendedor vendedor = new Vendedor(21, "Fabio", "fabio@gmail.com", new Date(), 3000.0, departamento);
		
		VendedorDao vendedorDao = FabricaDao.gerarVendedorDao();
		
		System.out.println("=== TESTE #1: vendedor pesquisarId ===");		
		Vendedor vendedor = vendedorDao.pesquisarId(3);
		
		System.out.println(vendedor);
		
		System.out.println("\n=== TESTE #2: vendedor pesquisarDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.pesquisarDepartamento(departamento);
		
		for(Vendedor v : lista) {
			System.out.println(v);
		}
		
		System.out.println("\n=== TESTE #3: vendedor pesquisar ===");
		
		lista = vendedorDao.pesquisar();
		
		for(Vendedor v : lista) {
			System.out.println(v);
		}
		
	}
}
