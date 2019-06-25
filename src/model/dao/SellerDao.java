package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

		//M�todos respons�veis por realizar uma a��o no banco de dados 
		//apartir do objeto que enviar-mos como par�metro
		
		void insert(Seller obj);
		void update(Seller obj);
		void deleteById(Integer id);
		Seller findById(Integer id); //Retornar� um objeto do banco de dados a partir do id. Se n�o tiver, retorna nulo
		List<Seller> findAll();      //Retornar� todos os sellers em uma lista
}
