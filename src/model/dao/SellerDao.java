package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

		//Métodos responsáveis por realizar uma ação no banco de dados 
		//apartir do objeto que enviar-mos como parâmetro
		
		void insert(Seller obj);
		void update(Seller obj);
		void deleteById(Integer id);
		Seller findById(Integer id); //Retornará um objeto do banco de dados a partir do id. Se não tiver, retorna nulo
		List<Seller> findAll();      //Retornará todos os sellers em uma lista
}
