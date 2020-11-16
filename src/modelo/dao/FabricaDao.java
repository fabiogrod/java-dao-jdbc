package modelo.dao;

import bd.BD;
import modelo.dao.impl.VendedorDaoJDBC;

public class FabricaDao {
	
	public static VendedorDao gerarVendedorDao()
	{
		return new VendedorDaoJDBC(BD.abreConexao());
	}

}
