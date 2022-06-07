
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String fn=request.getParameter("fullname");
		String ph=request.getParameter("phone");
		
		          
		if(n==""|| p=="" || fn=="" || ph=="") {
			RequestDispatcher rd=request.getRequestDispatcher("ReaderLogin.html");  
	        rd.include(request,response);
	        out.print("<h1 style=color:white;>any field should not be empty......</h1>"); 
		}
		else {
			try {  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","mca","mca");  
				  
				PreparedStatement ps=con.prepareStatement(  
				"insert into reader values(?,?,?,?)");  
				  
				ps.setString(1,n);  
				ps.setString(2,p);  
				ps.setString(3,fn);
				ps.setString(4,ph);
				          
				int i=ps.executeUpdate();  
				if(i>0) {
					RequestDispatcher rd=request.getRequestDispatcher("Reg.html");  
		        rd.forward(request,response); 
				}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("ReaderLogin.html");  
			        rd.include(request,response);
			        out.print("<h1 >Server is not responding......</h1>");  
			        }
				          
				}catch (Exception e2) {System.out.println(e2);}  
				          
				out.close();
		}
		

	}
}