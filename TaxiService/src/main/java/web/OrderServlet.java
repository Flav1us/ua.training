package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.CarType;
import service.DictionayService;
import service.OrderService;

public class OrderServlet extends HttpServlet {
	private static final String CALCULATE_ACTION ="calculate";
	private static final String SUBMIT_ACTION ="submitOrder";
	  public static final String SESSION_ATTR_COUNTRYID = "countryId";

	void doExecute(HttpServletRequest request, HttpServletResponse response, String action)
			throws ServletException, IOException {
		System.out.println("OrderServlet start");
		OrderService service = new OrderService();

		HttpSession session = request.getSession();
		String forwardPage = "/jsp/order.jsp";
		
		if(CALCULATE_ACTION.equals(action)){
			String streetFrom = request.getParameter("streetFrom");
			String streetTo = request.getParameter("streetTo");
			int hhArrive = Integer.valueOf(request.getParameter("hhArrive"));
			int mmArrive = Integer.valueOf(request.getParameter("mmArrive"));
			String carType = request.getParameter("carType");
			System.out.println("streetFrom ={"+streetFrom+"},streetTo ={"+streetTo+"},carType ={"+carType+"}");
			OrderService.OrderResult  result = service.calculate(streetFrom, streetTo, hhArrive, mmArrive, carType);

	    	request.setAttribute ("streetFrom", streetFrom);
	    	request.setAttribute ("streetTo", streetTo);
	    	request.setAttribute ("hhArrive", hhArrive);
	    	request.setAttribute ("mmArrive", mmArrive);
	    	request.setAttribute ("carType", carType);

	    	request.setAttribute ("result", result);

	    	forwardPage = "/jsp/orderSubmit.jsp";
		} else 
		if(SUBMIT_ACTION.equals(action)){
			String orderNumber = request.getParameter("orderNumber");

			OrderService.OrderResult  result = service.submitOrder(orderNumber);
	    	request.setAttribute ("result", result);
	    	request.setAttribute ("submitOk", "ok");
	    	forwardPage = "/jsp/orderSubmit.jsp";
		}
		
		DictionayService dictionary = new DictionayService();
		String lang = (String) session.getAttribute (SESSION_ATTR_COUNTRYID);
		ArrayList<CarType> carTypes = dictionary.getCarType(lang);
    	request.setAttribute ("carTypes", carTypes);
    	
		forward(request, response, forwardPage);
	}

	protected void forward (HttpServletRequest request, HttpServletResponse response, String forward)  throws ServletException, IOException {
        getServletContext ().getRequestDispatcher (forward).forward (request, response);
 }
}
