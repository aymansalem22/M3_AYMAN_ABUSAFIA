package dao;

import java.util.List;

import entity.Address;




public interface AddressDao {

	public List<Address> findall();
	
	boolean updateOneAddress(Address address);
	
	public Address findById(Long id);
	

	
	//It deletes an employee
	public void delete(Long id);
	
	public boolean saveOneAddress(Address address);
}
