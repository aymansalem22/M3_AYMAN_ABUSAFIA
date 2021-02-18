package dao;


import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;

import entity.Address;
import entity.User;
import util.JPAUtil;

public class UserDaoImpl implements UserDao {

	private static final String USER_COUNT = "SELECT COUNT(u) FROM User u "
			+ "WHERE u.email = :email AND u.password = :password";

	private static final String FIND_BY_EMAIL = "SELECT u FROM User u "
			+ "WHERE u.email = :email ";
	
	
	
	
	EntityManager manager;

	public void closeEntityManager() {
		manager.close();
	}

	public void openEntityManager() {
		manager = JPAUtil.getEntityManager();
	}

	
	
	
	
	@Override
	public List<User> findAll() {
		openEntityManager();
		TypedQuery<User> namedQuery = manager.createNamedQuery("User.findAll", User.class);
		

		List<User> user = namedQuery.getResultList();
		
		closeEntityManager();
		return user;
	}

	
	public List<Address> findAlladdress() {
		openEntityManager();
	
		TypedQuery<Address> namedQuery1 = manager.createNamedQuery("Address.findAll", Address.class);

		
		List<Address>  address= namedQuery1.getResultList();
		closeEntityManager();
		return address;
	}
	
	
	@Override
	public User findById(Long id) {
		if (id == null) {
			return null;
		}
		openEntityManager();
		User user = manager.find(User.class, id);
		closeEntityManager();
		return user;
	}

	@Override
	public Address findByIdAddress(Long id) {
		if (id == null) {
			return null;
		}
		openEntityManager();
		Address address = manager.find(Address.class, id);
		closeEntityManager();
		return address;
	}
	
	
	@Override
	public boolean saveOneUser(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(user); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public void delete(Long id) {
		openEntityManager();
		User user = manager.find(User.class, id);
		if (user != null) {
			manager.getTransaction().begin();
			manager.remove(user);
			manager.getTransaction().commit();
		}
		closeEntityManager();
		
	}

	@Override
	public boolean updateOneUser(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(user); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User updatePassword(Long userId, String newPass) {
		if (userId == null) {
			return null;
		}
		openEntityManager();
		manager.getTransaction().begin();
		User userDB = this.findById(userId);
		userDB.setPassword(newPass);
		manager.getTransaction().commit();
		closeEntityManager();
		return userDB;
	}

	@Override
	public boolean login(String email, String password) {
		openEntityManager();
		TypedQuery<Long> query = manager.createQuery(USER_COUNT, Long.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Long numUser = query.getSingleResult();
		System.out.println("Numero de usuarios con email y password: " + numUser);
		closeEntityManager();
		return numUser > 0;
	}

	@Override
	public User findByEmail(String email) {
		if (email == null || email.isEmpty()) {
			return null;
		}
		openEntityManager();
		TypedQuery<User> namedQuery = manager.createQuery(FIND_BY_EMAIL, User.class);
		namedQuery.setParameter("email", email);
		User user = namedQuery.getSingleResult();
		 closeEntityManager();
		return user;
	}

	

}
