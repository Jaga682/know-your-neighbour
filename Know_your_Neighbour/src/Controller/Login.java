package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Userbean;
import Service.Userdao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
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
		Userdao daoimpl=new Userdao();
		Userbean bean=new Userbean();
		bean.setName(request.getParameter("uname"));
		bean.setPassword(request.getParameter("password"));
		
		String name=bean.getName();
		HttpSession session=null;
		session.setAttribute("uname", name);
		System.out.println("Value="+session.getAttribute("uname").toString());
		boolean Run=false;
		Run=daoimpl.loginuser(bean);
		if(Run==true)
		{
			response.sendRedirect("home.jsp");
			System.out.println("Login success");
			
		}
		else {
			response.sendRedirect("passwordMismatch.html");
			System.out.println("Login fail");
		}
	}

}
