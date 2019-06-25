package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	//M�todos respons�veis por realizar uma a��o no banco de dados 
	//apartir do objeto que enviar-mos como par�metro
	
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id); //Retornar� um objeto do bando de dados a partir do id. Se n�o tiver, retorna nulo
	List<Department> findAll();      //Retornar� todos os departamentos em uma lista
	
}
