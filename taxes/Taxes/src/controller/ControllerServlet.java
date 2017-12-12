package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.View;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    
	//impl serializable  
	private static final long serialVersionUID = 1L;
	
	private View view;
	private Controller controller = new Controller();

    public ControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String welcomeJSPpath = "/";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(welcomeJSPpath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//utf-8 does not work with view.append("cirillic text");
		response.setCharacterEncoding("UTF-16");
		view = new View(request.getParameter("locale"));
		int person_id;
		try {
			person_id = Integer.parseInt(request.getParameter("ID"));
			view.addSaved("total");
			view.add("\t" + controller.getTotal(person_id));
			view.addAllTaxes(controller.getAll(person_id));
			view.add("\n");
			view.addAllSortedTaxes(controller.getAll(person_id));
		}
		catch (NumberFormatException e) {
			view.addSaved("unableParseID");
		}
		finally {
			response.getWriter().append(view.getPage());
			//view.clear();
		}
	}

}
