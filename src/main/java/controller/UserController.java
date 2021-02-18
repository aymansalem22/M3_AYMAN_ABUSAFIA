package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import entity.Address;
import entity.User;
import util.AppConstants;

@WebServlet(name = "UserController", urlPatterns = { "/all" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao = new UserDaoImpl();

	public UserController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null || action.length() == 0)

			action = AppConstants.HOME_PAGE;

		switch (action) {
		case AppConstants.ACTION_RETRIEVE:
			retrieve(request, response);
			break;
		case AppConstants.ACTION_UPDATE:
			update(request, response);
			break;

		case "VIEW":
			getSingleEmployeeView(request, response);
			break;

		case AppConstants.ACTION_DELETE:
			delete(request, response);
			break;
		default:
			retrieve(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		userDao.delete(Long.valueOf(id));

		retrieve(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		User user = userDao.findById(Long.valueOf(id));
		Address address = user.getAddress();

		request.setAttribute("userr", user);
		request.setAttribute("address", address);

		request.getRequestDispatcher(AppConstants.Edit_USER_PAGE).forward(request, response);
	}

	private void retrieve(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> userList = userDao.findAll();
		List<Address> addressList = userDao.findAlladdress();

		request.setAttribute("list", userList);
		request.setAttribute("listaddress", addressList);

		request.getRequestDispatcher(AppConstants.HOME_PAGE).forward(request, response);

	}

	private void getSingleEmployeeView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("id");

		if (idString == null || idString.isEmpty()) {
			request.setAttribute("NOTIFICATION", "Please enter valid id");
			retrieve(request, response);
			return;
		}

		Long idUser = Long.valueOf(idString);
		User user1 = userDao.findById(idUser);
		if (user1 == null) {
			request.setAttribute("NOTIFICATION", "El empleado solicitado no existe.");
			retrieve(request, response);
			return;
		}

		request.setAttribute("userr", user1);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user-view.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create user
		String id = request.getParameter("id");

		User userr = new User();
		Address address1 = new Address();

		address1.setStreet(request.getParameter("street"));
		address1.setCountry(request.getParameter("country"));
		String codeString = request.getParameter("codepostal");
		Integer codepostal = Integer.valueOf(codeString);
		address1.setCodepostal(codepostal);
		userr.setAddress(address1);
		userr.setFirstname(request.getParameter("first_name"));
		userr.setLastname(request.getParameter("last_name"));
		String ageString = request.getParameter("age");
		Integer age = Integer.valueOf(ageString);
		userr.setAge(age);
		userr.setNif(request.getParameter("nif"));
		userr.setEmail(request.getParameter("email"));
		userr.setPassword(request.getParameter("password"));
		userr.setMaritalstatus(request.getParameter("marital_status"));

		if ((id.isEmpty() || id == null)) {

			if (userDao.saveOneUser(userr)) {
				request.setAttribute("NOTIFICATION", "Employee Saved Successfully!");
			}

		} else {

			userr.setId(Long.parseLong(id));
		    
			if (userDao.updateOneUser(userr)) {
				request.setAttribute("NOTIFICATION", "Employee Updated Successfully!");
			}

		}

		retrieve(request, response);

	}

}
