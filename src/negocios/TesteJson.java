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
	

	      /* public static void main(String[] args) throws IOException {
	    	   ArrayList<Aluno> alunos = new ArrayList<>();
	       Aluno teste = new Aluno("gabriel","senha","codigo");
	       alunos.add(teste);
	       
	       TesteJson testejson = new TesteJson();
	     // testejson.writeAlunoJSON(teste);
	      Aluno teste1 = testejson.readJSON("Json/teste.json");
	      System.out.println(teste1);
	       }*/
	       
	      void writeAlunoJSON(ArrayList<Pessoa> alunos) throws IOException { 
	          GsonBuilder builder = new GsonBuilder(); 
	          builder.setPrettyPrinting();
	          Gson gson = builder.create(); 
	          FileWriter writer = new FileWriter("Json/teste.json");   
	          writer.write(gson.toJson(alunos));   
	          writer.close(); 
	       }  
	       
	       private Aluno readJSON(String arquivo) throws FileNotFoundException { 
	          GsonBuilder builder = new GsonBuilder(); 
	          Gson gson = builder.create(); 
	          BufferedReader bufferedReader = new BufferedReader(
	             new FileReader(arquivo));   
	          
	          Aluno aluno = gson.fromJson(bufferedReader,Aluno.class); 
	          return aluno; 
	       } 
	       
	}

