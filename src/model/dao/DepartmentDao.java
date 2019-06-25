package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	//Métodos responsáveis por realizar uma ação no banco de dados 
	//apartir do objeto que enviar-mos como parâmetro
	
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id); //Retornará um objeto do bando de dados a partir do id. Se não tiver, retorna nulo
	List<Department> findAll();      //Retornará todos os departamentos em uma lista
	
}
