import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Register extends HttpServlet{
	PreparedStatement ps=null;
	Connection con=null;
	PrintWriter out=null;
	public void init() throws ServletException{
		ServletContext sc=super.getServletContext();
		String load=sc.getInitParameter("load");
		String url=sc.getInitParameter("url");
		String user=sc.getInitParameter("user");
		String pass=sc.getInitParameter("pass");
		try{
				Class.forName(load);
				
			con=DriverManager.getConnection(url,user,pass);
				ps=con.prepareStatement("insert into server(name,email,password) values(?,?,?)");
				
		}
		catch(Exception e){
			System.out.println(e);
			ServletException se=new ServletException();
			throw se;
		}
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html><head><title>Login_Signup</title><style>h1{color:blue;}h2{color:blue;}</style></head><body>");
		
		
			String name=req.getParameter("name");
			String password=req.getParameter("password");
			String email=req.getParameter("email");
			try{
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.execute();
			out.println("<h1>Registration completed</h1>");
			out.println("<a href='new.html'><h2>Click here to go to login page</h2></a>");
			}
			catch(SQLException q){
				out.println("Server Error</body></html>");
				out.close();
			}
 
	}
	public void destroy(){
		try{
			con.close();
	
		}
		catch(SQLException se){
			
		}
	}
}