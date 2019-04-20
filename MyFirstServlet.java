import java.io.*;
import javax.servlet.*;
public class MyFirstServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse resp)throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2>Welcome to servlet world!</h2>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}