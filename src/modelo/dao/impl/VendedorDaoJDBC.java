package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bd.BD;
import bd.BDExcecao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	
	private Connection con;
	
	public VendedorDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insere(Vendedor Vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualiza(Vendedor Vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletaId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor pesquisarId(Integer id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = con.prepareStatement("SELECT vendedor.*, departamento.Nome as DepNome FROM vendedor INNER JOIN departamento ON vendedor.IdDepartamento = departamento.Id WHERE vendedor.Id = ? ");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				
				Departamento departamento = instanciarDepartamento(rs);				
				Vendedor vendedor = instanciarVendedor(rs, departamento);
				
				return vendedor;
			}
			return null;
		}
		catch(SQLException e) {
			throw new BDExcecao(e.getMessage());
		}
		finally {
			BD.fechaStatement(pst);
			BD.fechaResultSet(rs);
		}		
	}

	private Vendedor instanciarVendedor(ResultSet rs, Departamento departamento) throws SQLException {
		Vendedor vendedor = new Vendedor();		
		vendedor.setId(rs.getInt("Id") );
		vendedor.setNome(rs.getString("Nome") );
		vendedor.setEmail(rs.getString("Email") );
		vendedor.setSalarioBase(rs.getDouble("SalarioBase") );
		vendedor.setDataAniversario(rs.getDate("DataAniversario") );
		vendedor.setDepartamento(departamento);
		return vendedor;
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId(rs.getInt("IdDepartamento") );
		departamento.setNome(rs.getString("DepNome") );
		return departamento;
	}

	@Override
	public List<Vendedor> pesquisar() {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = con.prepareStatement("SELECT vendedor.*, departamento.Nome AS DepNome FROM vendedor INNER JOIN departamento ON vendedor.IdDepartamento = departamento.Id ORDER By Nome");
			
			rs = pst.executeQuery();
			
//			while (rs.next()) {
//				System.out.println(rs.getString("Nome"));
//			}
			
			List<Vendedor> lista = new ArrayList<>();
			
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("IdDepartamento"));
				
				if (dep == null) {
					dep = instanciarDepartamento(rs);
					map.put(rs.getInt("IdDepartamento"), dep);
				}
				
				Vendedor vendedor = instanciarVendedor(rs, dep);
				
				lista.add(vendedor);
			}
			return lista;
		}
		catch(SQLException e) {
			throw new BDExcecao(e.getMessage());
		}
		finally {
			BD.fechaStatement(pst);
			BD.fechaResultSet(rs);
		}
	}

	@Override
	public List<Vendedor> pesquisarDepartamento(Departamento departamento) {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = con.prepareStatement("SELECT vendedor.*, departamento.Nome AS DepNome FROM vendedor INNER JOIN departamento ON vendedor.IdDepartamento = departamento.Id WHERE IdDepartamento = ? ORDER BY Nome");
			pst.setInt(1, departamento.getId());
			rs = pst.executeQuery();
			
//			while (rs.next()) {
//				System.out.println(rs.getString("Nome"));
//			}
			
			List<Vendedor> lista = new ArrayList<>();
			
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("IdDepartamento"));
				
				if (dep == null) {
					dep = instanciarDepartamento(rs);
					map.put(rs.getInt("IdDepartamento"), dep);
				}
				
				Vendedor vendedor = instanciarVendedor(rs, dep);
				
				lista.add(vendedor);
			}
			return lista;
		}
		catch(SQLException e) {
			throw new BDExcecao(e.getMessage());
		}
		finally {
			BD.fechaStatement(pst);
			BD.fechaResultSet(rs);
		}
	}
}
