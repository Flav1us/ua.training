package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientNotExistsException;
import dao.DatabaseConnector;
import dao.impl.MySQLDatabaseConnector;
import entities.Client;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String REQUEST_PARAM_PASSWORD = "password";
	private static final String REQUEST_PARAM_LOGIN = "login";
	private static final String REQUEST_PARAM_COUNTRY_ID = "countryId";
	private static final String REQUEST_ATTR_ERRORS = "errors";
	private String FORWARD = "/list?actionId=initList";
  
	public static final String FORWARD_LOGIN = "/jsp/login.jsp";

	private static final String SESSION_ATTR_USERLOGIN = "login";
	
	private DatabaseConnector database_connector = new MySQLDatabaseConnector();
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> errors = new ArrayList<String>();
    	try {
	    		HttpSession session = request.getSession();

		    	//action set locale
		    	String countryId = request.getParameter (REQUEST_PARAM_COUNTRY_ID);
	            if(countryId != null) {
		    		request.getSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", countryId);
            		getServletContext ().getRequestDispatcher (FORWARD_LOGIN).forward (request, response);
	            } else {
	            	//action login
	            	String password = request.getParameter (REQUEST_PARAM_PASSWORD);
	            	String login = request.getParameter (REQUEST_PARAM_LOGIN);
	            	//login = null;
	            	
	            	if (login == null || login.length () == 0) {
	            		errors.add ("login.emptyLogin");
	            	}
	            	if (password == null || password.length () == 0) {
	            		errors.add ("login.emptyPassword");
	            	}
	            	if (errors.size () == 0) {
	            		Client cl = tryGetClient(login, password, errors);
	            		if(cl != null) {
	            			session.setAttribute (SESSION_ATTR_USERLOGIN, login);
	            		} else {
	            			errors.add ("login.wrongUser");
	            		}
	            	}
	            	request.setAttribute (REQUEST_ATTR_ERRORS, errors);
	            	//request.setAttribute ("str", "Anton");

	            	if(errors.size() == 0) {
	            		getServletContext ().getRequestDispatcher (FORWARD).forward (request, response);
	            	}
	            	else {
	            		request.setAttribute (REQUEST_ATTR_ERRORS, errors);
	            		getServletContext ().getRequestDispatcher (FORWARD_LOGIN).forward (request, response);
	            	}
	            }
	    	
	    } catch (Exception e) {
	    	errors.add ("login.pleaseFillOutTheFollowing");
	    	request.setAttribute (REQUEST_ATTR_ERRORS, errors);
    		getServletContext ().getRequestDispatcher (FORWARD_LOGIN).forward (request, response);

//	    	processError(request,response,e);
	    }

	}

	private Client tryGetClient(String login, String password, ArrayList<String> errors) {
		Client cl = null;
		try {
			cl = database_connector.getClient(login, password);
		}
		catch (ClientNotExistsException e) {
			errors.add("incorrect_credentials");
		}
		return cl;
	}

}
