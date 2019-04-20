import javax.servlet.*;
import java.sql.*;
public class MyListener implements ServletContextListener
{
	Connection con=null;
	public void contextInitialized(ServletContextEvent e){
		ServletContext ct=e.getServletContext();
		String load=ct.getInitParameter("load");
		String url=ct.getInitParameter("url");
		String user=ct.getInitParameter("user");
		String pass=ct.getInitParameter("pass");
		try{
				Class.forName(load);
				
			con=DriverManager.getConnection(url,user,pass);
				ct.setAttribute("con",con);
		}
		catch(Exception et){
			System.out.println(et);
			
		}
	}
	public void contextDestroyed(ServletContextEvent e){
		try{
			con.close();
		}
		catch(SQLException se){
			
		}
	}
}