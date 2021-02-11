package negocios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.*;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Coordenacao;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;
import negocios.bean.Professor;

public class TesteJson {

	public void writeJSONPessoas(ArrayList<Pessoa> pessoas) throws IOException {
		ArrayList<Aluno> aluno = new ArrayList<>();
		ArrayList<Professor> prof = new ArrayList<>();
		ArrayList<Coordenacao> coord = new ArrayList<>();

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		for (Pessoa p : pessoas) {
			if (p instanceof Aluno) {
				aluno.add((Aluno) p);
			} else if (p instanceof Professor) {
				prof.add((Professor) p);
			} else if (p instanceof Coordenacao) {
				coord.add((Coordenacao) p);
			}
		}
		FileWriter writer = new FileWriter("Json/aluno.json");
		writer.write(gson.toJson(aluno));
		writer.close();
		writer = new FileWriter("Json/prof.json");
		writer.write(gson.toJson(prof));
		writer.close();
		writer = new FileWriter("Json/coord.json");
		writer.write(gson.toJson(coord));
		writer.close();
	}
	public void writeJSONMatriculas(ArrayList<AlunoMatriculado> matriculas) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter writer = new FileWriter("Json/alunoMatriculado.json");
		writer.write(gson.toJson(matriculas));
		writer.close();
	}
	public ArrayList<AlunoMatriculado> readJSONMatriculas() throws FileNotFoundException{
		ArrayList<AlunoMatriculado> result = new ArrayList<>();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		BufferedReader bf = new BufferedReader(new FileReader("Json/alunoMatriculado.json"));
		JsonArray array = gson.fromJson(bf, JsonArray.class);
		for (JsonElement p : array) {
			AlunoMatriculado a = gson.fromJson(p, AlunoMatriculado.class);
			System.out.println(a);
			result.add(a);
		}
		return result;
	}
	public void writeJSONDisciplinas(ArrayList<Disciplina> disciplinas) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter writer = new FileWriter("Json/disciplinas.json");
		writer.write(gson.toJson(disciplinas));
		writer.close();
	}
	public ArrayList<Disciplina> readJSONDisciplinas() throws FileNotFoundException{
		ArrayList<Disciplina> result = new ArrayList<>();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		BufferedReader bf = new BufferedReader(new FileReader("Json/disciplinas.json"));
		JsonArray array = gson.fromJson(bf, JsonArray.class);
		for (JsonElement p : array) {
			Disciplina a = gson.fromJson(p, Disciplina.class);
			System.out.println(a);
			result.add(a);
		}
		return result;
	}
	
	public void writeJSONSemestre(ArrayList<Double> doubl) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter writer = new FileWriter("Json/semestres.json");
		writer.write(gson.toJson(doubl));
		writer.close();
	}
	public ArrayList<Double> readJSONSemestre() throws FileNotFoundException{
		ArrayList<Double> result = new ArrayList<>();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		BufferedReader bf = new BufferedReader(new FileReader("Json/semestres.json"));
		JsonArray array = gson.fromJson(bf, JsonArray.class);
		for (JsonElement p : array) {
			Double a = gson.fromJson(p, Double.class);
			System.out.println(a);
			result.add(a);
		}
		return result;
	}

	public ArrayList<Pessoa> readJSONPessoas() throws IOException {
		ArrayList<Pessoa> result = new ArrayList<>();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		BufferedReader bf = new BufferedReader(new FileReader("Json/aluno.json"));
		JsonArray array = gson.fromJson(bf, JsonArray.class);
		for (JsonElement p : array) {
			Aluno a = gson.fromJson(p, Aluno.class);
			System.out.println(a);
			result.add(a);
		}
		bf.close();
		bf = new BufferedReader(new FileReader("Json/prof.json"));
		array = gson.fromJson(bf, JsonArray.class);
		for (JsonElement p : array) {
			Professor a = gson.fromJson(p, Professor.class);
			System.out.println(a);
			result.add(a);
		}
		bf.close();
		bf = new BufferedReader(new FileReader("Json/coord.json"));
		array = gson.fromJson(bf, JsonArray.class);
		for (JsonElement p : array) {
			Coordenacao a = gson.fromJson(p, Coordenacao.class);
			System.out.println(a);
			result.add(a);
		}

		System.out.println(result);
		return result;
	}

}
