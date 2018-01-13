package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlreadyExistsException;
import entity.Client;
import service.ClientService;


public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REQUEST_ATTR_ERRORS = "errors";

    public SignupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> errors = new ArrayList<String>();
		ClientService service = new ClientService();
		Client new_client = new Client.Builder()
				.setLogin(request.getParameter("login"))
				.setPhoneNumber(request.getParameter("phone"))
				.build();
		try {
			service.registerClient(new_client, request.getParameter("password"));
		} catch (AlreadyExistsException e) {
			errors.add("login.exists");
		} finally {
			if(errors.isEmpty()) {
        		getServletContext ().getRequestDispatcher ("/jsp/order.jsp").forward (request, response);
        	}
        	else {
        		request.setAttribute (REQUEST_ATTR_ERRORS, errors);
        		getServletContext ().getRequestDispatcher ("/jsp/signup.jsp").forward (request, response);
        	}
		}
		
	}

}
