package aplicacao;

import java.text.ParseException;
import java.util.List;

import modelo.dao.DepartamentoDao;
import modelo.dao.FabricaDao;
import modelo.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) throws ParseException {
	
//		Departamento departamento = new Departamento(1, "Livros");
//		
//		Departamento Departamento = new Departamento(21, "Fabio", "fabio@gmail.com", new Date(), 3000.0, departamento);
		
		
		DepartamentoDao DepartamentoDao = FabricaDao.gerarDepartamentoDao();
		
		System.out.println("=== TESTE #1: departamento pesquisarId ===");		
		Departamento departamento = DepartamentoDao.pesquisarId(3);		
		System.out.println(departamento);
		
		System.out.println("\n=== TESTE #2: Departamento pesquisar ===");
		departamento = new Departamento(2, null);
		List<Departamento> lista = DepartamentoDao.pesquisar();
		lista = DepartamentoDao.pesquisar();		
		for(Departamento d : lista) {
			System.out.println(d);
		}
				
		System.out.println("\n=== TESTE #3: Departamento inserir ===");		
		departamento.setId(4);		
		Departamento novoDepartamento = new Departamento(null, "Música");
		DepartamentoDao.insere(novoDepartamento);		
		System.out.println("Dados gravados. Novo Id = " + novoDepartamento.getId() );		
		
		System.out.println("\n=== TESTE #4: Departamento atualiza ===");		
		departamento = DepartamentoDao.pesquisarId(9);
		departamento.setNome("Audio");		
		DepartamentoDao.atualiza(departamento);
		System.out.println("Atualização realizada. Nome: " + departamento.getNome());
		
		System.out.println("\n=== TESTE #5: Departamento deleta ===");
		System.out.print("Digite um número de Id para deletar: ");
//		int id = sc.nextInt(); 
		int id = 15;
		System.out.print(id);
		DepartamentoDao.deletaId(id);
		System.out.println("\nDados apagados.");
	}
}
