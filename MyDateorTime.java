import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.text.*;
import java.time.*;
public class MyDateorTime extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException	{
 	resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html><body>");
		
		String s=req.getParameter("date");
		
		if("date".equalsIgnoreCase(s)){
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/yyyy");
			 s=sdf.format(d);
		}
		else{
			LocalTime d=LocalTime.now();
				s=d.toString();
		}
		
		out.println("<h3>"+s+"</h3></body></html>");
		
	}
}