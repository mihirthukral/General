package myfilescodes;
import java.io.*;
public class FileExample
{
  public static void main(String args[]){
File myfile=new File("C:\\Program Files\\Common Files\\mcafee\\AlertManager");
    if(myfile.exists())
      System.out.println(myfile.getName()+"is present");
    else{
      System.out.println(myfile.getName()+"is not present");
      System.exit(0);
    }
    if(myfile.isFile())
      System.out.println(myfile.getName()+"is file");
    else
      System.out.println(myfile.getName()+"is directory");
  }
}
