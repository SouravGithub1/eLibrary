
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ULogin
 */
@WebServlet("/ULogin")
public class ULogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ULogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("password");  
	          
	    if(ULoginDao.validate(n, p)){  
	        RequestDispatcher rd=request.getRequestDispatcher("Reader.html");  
	        rd.forward(request,response);  
	        

	    }  
	    else{  
	        RequestDispatcher rd=request.getRequestDispatcher("ReaderLogin.html"); 
	        rd.include(request,response);  
	        out.print("<h1 >Sorry To Login, Invalid username or password....</h1>");  
	    }  
	          
	    out.close();  
	doGet(request, response);
	}

}
