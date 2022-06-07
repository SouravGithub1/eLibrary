
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
 * Servlet implementation class BookDel
 */
@WebServlet("/BookDel")
public class BookDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDel() {
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
		          
		try {  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mca","mca");  
		  
		PreparedStatement ps=con.prepareStatement("delete from books where bid = ?");  
		  
		ps.setString(1, bid);  
		
		          
		int j=ps.executeUpdate();  
		if(j>0) {
			RequestDispatcher rd=request.getRequestDispatcher("DelB.html"); 	       
            rd.include(request,response); 
	        out.print("SuccessFully Deleted........");

		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("DelB.html"); 	       
            rd.include(request,response); 
	        out.print("SuccessFully NOT Deleted........");

		}   
		          
		}catch (Exception e2) {System.out.println(e2);} 
		
		out.close();
	}

}
