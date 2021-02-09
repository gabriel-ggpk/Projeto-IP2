package negocios;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.*;
import negocios.bean.Aluno;
import negocios.bean.Pessoa;
public class TesteJson {
		
	       
	     public void writeAlunoJSON(ArrayList<Aluno> pessoas) throws IOException { 
	 
	    	
	          GsonBuilder builder = new GsonBuilder(); 
	          //builder.setPrettyPrinting();
	          Gson gson = builder.create(); 
	          FileWriter writer = new FileWriter("Json/teste.json");   
	          writer.write(gson.toJson(pessoas));   
	          writer.close(); 
	       }  
	       
	       
		public ArrayList<Pessoa> readJSON() throws FileNotFoundException { 
	    	
	          GsonBuilder builder = new GsonBuilder(); 
	          Gson gson = builder.create(); 
	          BufferedReader bufferedReader = new BufferedReader( new FileReader("Json/teste.json"));  
	          JsonArray pessoas =  gson.fromJson(bufferedReader, JsonArray.class);
	          for(JsonElement p: pessoas) {
	        	  Aluno a = gson.fromJson(p, Aluno.class);
	        	  System.out.println(a);
	          }
	          //System.out.println(pessoas);
	          return null; 
	       } 
	       
	}

