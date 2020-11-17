package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) throws ParseException {
	
//		Departamento departamento = new Departamento(1, "Livros");
//		
//		Vendedor vendedor = new Vendedor(21, "Fabio", "fabio@gmail.com", new Date(), 3000.0, departamento);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
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
				
		System.out.println("\n=== TESTE #4: vendedor inserir ===");
		
		departamento.setId(4);
		
		Vendedor novoVendedor = new Vendedor(null, "Vladmir Antonio", "vladmir@gmail.com", sdf.parse("12/03/1949"), 6000.00, departamento);
		
		vendedorDao.insere(novoVendedor);
		
		System.out.println("Dados gravados. Novo Id = " + novoVendedor.getId() );		
	}
}
