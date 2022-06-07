import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllB
 */
@WebServlet("/ViewAllB")
public class ViewAllB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllB() {
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
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		
		try {  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mca","mca");
			if(con==null)
				out.println("connection not created");
			  
			PreparedStatement ps=con.prepareStatement(  
			"select * from books");   
			  
			            
			ResultSet rs=ps.executeQuery();  
			 out.println("<html><body><table border='1'><tr><td>BOOK_ID</td><td>BOOK_NAME</td><td>AURTHOR</td><td>GENRE</td></tr>");
			 while(rs.next()) 
			 {
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>"); 
			 }
			
			 out.println("</table></body></html>");
			      
			          
			}catch (Exception e2) {System.out.println(e2);} 
			
			out.close();
		doGet(request, response);
	}

}