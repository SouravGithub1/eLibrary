
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookIn
 */
@WebServlet("/BookIn")
public class BookIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookIn() {
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
		
		String bid=request.getParameter("bookid");  
		String bn=request.getParameter("bookname");
		String an=request.getParameter("authorname");
		String g=request.getParameter("genre");
		
		          
		try {  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mca","mca");
		
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into books values(?,?,?,?)");   
		ps.setString(1,bid);  
		ps.setString(2,bn);  
		ps.setString(3,an);
		ps.setString(4,g);
		          
		int j=ps.executeUpdate();  
		if(j>0) {
			RequestDispatcher rd=request.getRequestDispatcher("insert.html"); 	       
            rd.include(request,response); 
	        out.println("<h1 style=color:white>SuccessFully inserted........</h1>");

		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("insert.html"); 	       
            rd.include(request,response); 
	        out.println("<h1 style=color:white>SuccessFully NOT inserted........</h1>");

		}
		      
		          
		}catch (Exception e2) {System.out.println(e2);} 
		
		out.close();
	}

}
