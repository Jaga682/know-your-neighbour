package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Userbean;
import Service.Userdao;

/**
 * Servlet implementation class Regdata
 */
@WebServlet("/Regdata")
public class Regdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Regdata() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	Userdao userdao=new Userdao();
	Userbean userbean=new Userbean();
	userbean.setName(request.getParameter("name"));
	userbean.setMobile(request.getParameter("mobile"));
	userbean.setPassword(request.getParameter("password"));
	userbean.setAddress(request.getParameter("address"));
	userbean.setCity(request.getParameter("city"));
	userbean.setState(request.getParameter("state"));
	userbean.setCountry(request.getParameter("country"));
	userdao.addUserdata(userbean);
	System.out.println("Registration Done");
	}

}
