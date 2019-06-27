package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	// Este objeto conn agora estará disponível em toda parte da nossa classe
	// SellerDaoJDBC
	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {

	}

	@Override
	public void update(Seller obj) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " 
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE Seller.Id = ? "
					);
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {			
				Department dep = instantiateDepartment(rs);				
				Seller obj = instantiateSeller(rs, dep);
				return obj;
			} 
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	//Metodo para fazer instanciação de Sellers - Ficar mais organizado	
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		
		//Colocamos o nome da coluna específica do banco de dados para pegar as informações	
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}

	//Metodo para fazer instanciação de Departamento - Ficar mais organizado
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		
		//Colocamos o nome da coluna específica do banco de dados para pegar as informações
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));   
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		return null;
	}
}