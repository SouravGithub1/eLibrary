
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
 * Servlet implementation class NewIss
 */
@WebServlet("/NewIss")
public class NewIss extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewIss() {
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
		
		String bing=request.getParameter("booking");  
		String bn=request.getParameter("bookname");
		String un=request.getParameter("username");
		String d=request.getParameter("date");
		
		          
		try {  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mca","mca");
		if(con==null)
			out.println("connection not created");
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into bookis values(?,?,?,?)");   
		ps.setString(1,bing);  
		ps.setString(2,bn);  
		ps.setString(3,un);
		ps.setString(4,d);
		          
		int j=ps.executeUpdate();  
		if(j>0) {
			RequestDispatcher rd=request.getRequestDispatcher("BookIss.html");  
        rd.forward(request,response); 
		}
		      
		          
		}catch (Exception e2) {System.out.println(e2);} 
		
		out.close();
	}

}
