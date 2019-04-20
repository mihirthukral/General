import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Login extends HttpServlet{
	PreparedStatement pst=null;
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
				
				pst=con.prepareStatement("select * from server where name=? and email=? and password=?");
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
		out.println("<html><head><title>Login_Signup</title><style>h1{color:red;}h2{color:red;}</style></head><body>");
		
		
			String name=req.getParameter("name");
			String password=req.getParameter("password");
			String email=req.getParameter("email");
			try{
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,password);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()){
			 
				 out.println("Name:"+name+"<br />Email:"+email+"<br/>");
			
			}
			else{
				out.println("<h2>Invalid username or password</h2><br /><a href='new.html'>Try again</a>");
			}
			}
			catch(SQLException q){
				out.println(q.getMessage()+"Server Error</body></html>");
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