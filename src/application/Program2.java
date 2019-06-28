package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("---TEST 1 - department - insert");

		Department dep = new Department(null, "Back End");
		departmentDao.insert(dep);
		System.out.println("Inserted! New Id = " + dep.getId());

		System.out.println("\n---TEST 2 - department update");
		dep.setName("Design");
		dep.setId(6);
		departmentDao.update(dep);
		System.out.println("Update completed!");

		System.out.println("\n---TEST 3 - department delete");
		departmentDao.deleteById(8);
		System.out.println("Delete completed!");

		System.out.println("\n---TEST 4 - department - findById");
		Department department = departmentDao.findById(2);
		System.out.println(department.toString());

		System.out.println("\n---TEST 5 - department - findAll");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

	}

}
