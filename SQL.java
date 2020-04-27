package org.sid;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.regex.Pattern;

import org.apache.ibatis.jdbc.ScriptRunner;


public class SQL {

  public static void main(String[] args) {
       
	  
	  
	  String path = "D:\\xampp\\htdocs\\dolibarr\\htdocs\\install\\mysql\\tables\\";
      try {
          Class.forName("com.mysql.jdbc.Driver");
         ScriptRunner runner = new ScriptRunner(DriverManager.getConnection("jdbc:mysql://localhost:3306/pro", "root", ""));
          
         File folder = new File("D:\\xampp\\htdocs\\dolibarr\\htdocs\\install\\mysql\\tables");
     	File[] listOfFiles = folder.listFiles();
     	for (File file : listOfFiles) {
     	    if (file.isFile()) {
     	    	
     	    	if(!Pattern.matches("^.*key.sql$",file.getName()) && Pattern.matches("^.*.sql$",file.getName()))
     	    	{
     	    		runner.runScript(new BufferedReader(new FileReader(path+file.getName())));
     	    	}
     	    }
     	}
     	for (File file : listOfFiles) {
     	    if (file.isFile()) {
     	    	
     	    	if(Pattern.matches("^.*key.sql$",file.getName()))
     	    	{
     	    		runner.runScript(new BufferedReader(new FileReader(path+file.getName())));
     	    	}
     	    }
     	}	
         
         
         
      } catch (Exception e) {
          System.err.println(e);
      }
  }
}