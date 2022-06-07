
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("adminName");  
		    String p=request.getParameter("password");  
		          
		    if(LoginDao.validate(n, p)){  
		        RequestDispatcher rd=request.getRequestDispatcher("Admin User.html");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        RequestDispatcher rd=request.getRequestDispatcher("Admin Login.html");  
		        rd.include(request,response);  
		        out.print("<h2 style=color:blue>Invalid username or password.....</h2>");  
		    }  
		          
		    out.close();  
		doGet(request, response);
	}

}
