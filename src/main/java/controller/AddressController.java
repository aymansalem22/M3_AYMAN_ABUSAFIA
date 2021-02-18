package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDaoImpl;
import entity.Address;

import util.AppConstants;

/**
 * Servlet implementation class AddressController
 */
@WebServlet("/AddressController")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AddressDaoImpl addressdao=new AddressDaoImpl();
  
    public AddressController() {}

	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.length() == 0)
			
    	action = AppConstants.Address_RETRIEVE;
		

		switch (action) {
		case AppConstants.Address_RETRIEVE:
			retrieve(request, response);
			break;
		case AppConstants.Address_UPDATE:
			update(request, response);
			break;

		case AppConstants.Address_View:
			getSingleEmployeeView(request, response);
			break;

		case AppConstants.Address_DELETE:
			delete(request, response);
			break;
		default:
			retrieve(request, response);
		}
}

	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		addressdao.delete(Long.valueOf(id));

		retrieve(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		Address address = addressdao.findById(Long.valueOf(id));
		request.setAttribute("address", address);
		request.getRequestDispatcher(AppConstants.Edit_ADDRESS_PAGE).forward(request, response);
	}
	
	private void retrieve(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Address> addressList = addressdao.findall();
		request.setAttribute("addresses", addressList);
		request.setAttribute("NOTIFICATION1", "Login Successful");
		request.getRequestDispatcher(AppConstants.Address_Homepage).forward(request, response);

	}
	
	private void getSingleEmployeeView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("id");

		if (idString == null || idString.isEmpty()) {
			request.setAttribute("NOTIFICATION", "Please enter valid id");
			retrieve(request, response);
			return;
		}

		Long idAddress = Long.valueOf(idString);
		Address address1 = addressdao.findById(idAddress);
		if (address1 == null) {
			request.setAttribute("NOTIFICATION", "El empleado solicitado no existe.");
			retrieve(request, response);
			return;
		}

		request.setAttribute("address", address1);

		RequestDispatcher dispatcher = request.getRequestDispatcher(AppConstants.View_ADDRESS_PAGE);
		dispatcher.forward(request, response);
	}
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// create address
		String id = request.getParameter("id");
		Address address1 = new Address();
	    address1.setStreet(request.getParameter("street"));
	    String CodePostalString = request.getParameter("codepostal");
		Integer Postal = Integer.valueOf(CodePostalString);
	    address1.setCodepostal(Postal);
	    address1.setCountry(request.getParameter("country"));
	    

		if (id.isEmpty() || id == null) {

			if (addressdao.saveOneAddress(address1)) {
				request.setAttribute("NOTIFICATION", "Employee Saved Successfully!");
			}

		} else {

			address1.setId(Long.parseLong(id));
			if (addressdao.updateOneAddress(address1)) {
				request.setAttribute("NOTIFICATION", "Employee Updated Successfully!");
			}

		}

		retrieve(request, response);

	}

}
