package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientNotExistsException;
import entity.Client;
import service.ClientService;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String REQUEST_PARAM_PASSWORD = "password";
	private static final String REQUEST_PARAM_LOGIN = "login";
	private static final String REQUEST_PARAM_COUNTRY_ID = "countryId";
	private static final String REQUEST_ATTR_ERRORS = "errors";
	//private String FORWARD = "/list?actionId=initList";
	private String FORWARD = "/jsp/order.jsp";
  
	public static final String FORWARD_LOGIN = "/jsp/login.jsp";

	private static final String SESSION_ATTR_CLIENT = "client";
	
	//private DatabaseConnector database_connector = new MySQLDatabaseConnector();
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(FORWARD_LOGIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> errors = new ArrayList<String>();
		ClientService service = new ClientService();
		try {
			HttpSession session = request.getSession();
			// action set locale
			String countryId = request.getParameter(REQUEST_PARAM_COUNTRY_ID);
			if (countryId != null) {
				session.setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", countryId);
				getServletContext().getRequestDispatcher(FORWARD_LOGIN).forward(request, response);
			} else {
				// action login
				String password = request.getParameter(REQUEST_PARAM_PASSWORD);
				String login = request.getParameter(REQUEST_PARAM_LOGIN);

				if (login == null || login.length() == 0) {
					errors.add("login.emptyLogin");
				}
				if (password == null || password.length() == 0) {
					errors.add("login.emptyPassword");
				}
				if (errors.size() == 0) {
					Client client = service.getClient(login, password);
					session.setAttribute(SESSION_ATTR_CLIENT, client);
				}
				request.setAttribute(REQUEST_ATTR_ERRORS, errors); // ?empty
			}

		} catch (ClientNotExistsException ce) {
			errors.add ("login.wrongUser");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	errors.add ("login.serviceTemporarilyUnaviable");
    	//processError(request,response,e);	
	    } finally {
	    	if(errors.isEmpty()) {
        		getServletContext ().getRequestDispatcher (FORWARD).forward (request, response);
        	}
        	else {
        		request.setAttribute (REQUEST_ATTR_ERRORS, errors);
        		getServletContext ().getRequestDispatcher (FORWARD_LOGIN).forward (request, response);
        	}
	    }
	}

	/*private Client tryGetClient(String login, String password, ArrayList<String> errors) {
		Client cl = null;
		try {
			cl = database_connector.getClient(login, password);
		}
		catch (ClientNotExistsException e) {
			errors.add("incorrect_credentials");
		}
		return cl;
	}*/

}
