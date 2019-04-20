import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class user extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.println("<html><head><title>UserInfo</title></head><body>User Info is:<br>");
	String Uname=req.getParameter("Uname");
	String gender=req.getParameter("gender");
	String H[]=req.getParameterValues("list");
	out.println("Name:"+Uname+"<br>Gender:"+gender+"<br>");
	for(String s:H){
		out.println(s+",");
	}
	out.println("</body></html>");
	out.close();
	}
}