import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
 class Server {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException{
        try{
            URL url=new URL("https://www.google.com");
            InetAddress ob=InetAddress.getByName("www.google.com");
             InetAddress ob1=InetAddress.getByName(url.getHost());
             System.out.println(url.getHost());
				 System.out.println("hello");
			
			System.out.println("h");
        }
        catch(Exception e){
            				 System.out.println(e.getMessage());
        }
        
    }
}
