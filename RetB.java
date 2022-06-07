
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetB
 */
@WebServlet("/RetB")
public class RetB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetB() {
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
		
		String bid=request.getParameter("bookingid");  
		          
		try {  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","mca","mca");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"delete from bookis where bookingid = ?");  
		  
		ps.setString(1, bid);  
		
		          
		int i=ps.executeUpdate();  
		if(i>0) {
			RequestDispatcher rd=request.getRequestDispatcher("BookIss.html");  
        rd.forward(request,response); 
		}
		      
		          
		}catch (Exception e2) {System.out.println(e2);} 
		
		out.close();
	}

}
