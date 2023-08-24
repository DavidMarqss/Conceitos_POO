package java_classes;

import java_constantes.StatusAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno extends Pessoa {

	private String dataMatricula;

	List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	
	/*SETTERS E GETTERS*/

	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	
	@Override /*to String*/
	public String toString() {
		return "Aluno: " + super.nome + "\nCPF: " + super.cpf + "\nRG: " + super.rg + "\nIdade: " + super.idade
				+ "\nData de Nascimento: " + super.dataNascimento + "\nData da Matricula: "
				+ dataMatricula + "\nDisciplina: " + disciplinas;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	/*Metodos Proprios*/
	/*public void FazerCurso(String curso) {
		System.out.println("Curso: "+curso);
	}*/
	public double CalcularMedia() {
		double sNotas = 0.0;
		for (Disciplina disciplina : disciplinas) {
			sNotas += disciplina.getNota();
		}
		
		return sNotas/disciplinas.size();
	}
	public String Aprovacao() {
		double media = this.CalcularMedia();
		if(media >= 5) {
			if(media >=7) {
				return StatusAluno.APROVADO;
			}else {
				return StatusAluno.RECUPERACAO;
			}
		}else {
			return StatusAluno.REPROVADO;
		}
	}

	@Override
	public boolean pessoaMaiorIdade() {
		return idade >= 21;
	}

    @Override
    public double salario() {
        return 200;
    }

    public String msgMaiorIdade(){
		return this.pessoaMaiorIdade()? "Já pode ser preso" : "Acabou de nascer";
	}

}
