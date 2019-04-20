import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
public class MyDateTimeServlet extends HttpServlet implements Runnable{
	Thread t=null;
	public  void init(){
		
		t=new Thread(this);
		t.start();
	}
	public void run(){
		try{
		while(true){
			t.join();
			Thread.sleep(1000);
		}}
		catch(InterruptedException ie){
			
			
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<html><head><title>Date Time Display</title>");
		pw.println("<style type='text/css'>");
		pw.println("h3{color:red}");
		pw.println("</style></head>");
		Date today=new Date();
		String s=today.toString();
		pw.println("<body>Current date and time:");
		pw.println("<h3>"+s+"</h3>");
		pw.println("</body></html>");
		pw.close();
	
	}
	
}
