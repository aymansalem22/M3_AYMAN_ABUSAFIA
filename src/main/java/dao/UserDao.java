package dao;

import java.util.List;

import entity.Address;
import entity.User;

public interface UserDao {

	
//It returns a list of all employees
	
public List<User> findAll();
	
	//It returns one employee by id
public User findById(Long id);



////It create one user
//public User create(User user);

//register one user 
public boolean saveOneUser(User user);

//It deletes an employee
public void delete(Long id);

public User findByEmail(String email);

public List<Address> findAlladdress();
// It updates an employee
boolean updateOneUser(User user);
public Address findByIdAddress(Long id);
public User updatePassword(Long userId, String newPass);

public boolean login(String email, String password);

}
