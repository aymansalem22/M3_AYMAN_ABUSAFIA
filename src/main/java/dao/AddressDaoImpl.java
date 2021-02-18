package dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;

import entity.Address;

import util.JPAUtil;

public class AddressDaoImpl implements AddressDao {

	EntityManager manager;

	public void closeEntityManager() {
		manager.close();
	}

	public void openEntityManager() {
		manager = JPAUtil.getEntityManager();
	}

	@Override
	public List<Address> findall() {
		openEntityManager();
		TypedQuery<Address> namedQuery = manager.createNamedQuery("Address.findAll", Address.class);
		List<Address> addresses = namedQuery.getResultList();
		closeEntityManager();
		return addresses;
	}

	@Override
	public boolean updateOneAddress(Address address) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(address);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Address findById(Long id) {
		if (id == null) {
			return null;
		}
		openEntityManager();
		Address address = manager.find(Address.class, id);
		closeEntityManager();
		return address;
	}

	

	@Override
	public void delete(Long id) {
		openEntityManager();
		Address address = manager.find(Address.class, id);
		if (address != null) {
			manager.getTransaction().begin();
			manager.remove(address);
			manager.getTransaction().commit();
		}
		closeEntityManager();

	}

	@Override
	public boolean saveOneAddress(Address address) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(address); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

}
