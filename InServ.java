
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class InServ
 */
@WebServlet("/InServ")
public class InServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("t1");
		String m=request.getParameter("t2");
		double marks=Double.parseDouble(m);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","aman");
			if(con==null)
				out.println("connection not created");
			else
				out.println("connection created");
				CallableStatement cs=con.prepareCall("{call proc1(?,?,?)}");
				cs.registerOutParameter(1,Types.VARCHAR);
				cs.setString(2, name);
				cs.setDouble(3, marks);
				int x=cs.executeUpdate();
				if(x>0)
				{
					out.println(cs.getString(1));
				}
		}
		catch(Exception e) {out.println(e);}
	}

}