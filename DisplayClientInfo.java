import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;
public class DisplayClientInfo extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException
{
resp.setContentType("text/html");
PrintWriter pw=resp.getWriter();
pw.println("<html><head><title>");
pw.println("Client Information</title>");
pw.println("<style> table,tr,td,th{ color: white;}</style></head>");
pw.println("<body>");
String clientName=req.getRemoteHost();
String clientIp=req.getRemoteAddr();
pw.println("Your computer name:<b>"+clientName+"</b><br>");
pw.println("Your computer ip:<b>"+clientIp+"</b><br>");
Enumeration en=req.getHeaderNames();
pw.println("<table border='2' bgcolor='black'>");
pw.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
while(en.hasMoreElements())
{
String headerName=(String)en.nextElement();
String headerValue=req.getHeader(headerName);
pw.println("<tr><td>"+headerName+"</td><td>"+headerValue+"</td></tr>");
}
pw.println("</table>");
pw.println("</body>");
pw.println("</html>");
pw.close();
}
}
