package java_executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import java_classes.Aluno;
import java_classes.Diretor;
import java_classes.Disciplina;
import java_classes.Secretario;
import java_constantes.StatusAluno;
import java_funcoes.FuncaoAutenticacao;

@SuppressWarnings("ALL")
public class ClasseExecutavel {
    public static void main(String[] args) {
        try {

            String login = JOptionPane.showInputDialog("Digite o login:");
            String senha = JOptionPane.showInputDialog("Digite a senha:");

            if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar() || new FuncaoAutenticacao(new Secretario(login, senha)).autenticar()) {

                List<Aluno> alunos = new ArrayList<>();

                HashMap<String, List<Aluno>> maps = new HashMap<>();

                for (int qtd = 1; qtd <= 5; qtd++) {

                    String nome = JOptionPane.showInputDialog("Digite seu nome");
			        String idade = JOptionPane.showInputDialog("Digite sua idade");
			        String cpf = JOptionPane.showInputDialog("Digite seu CPF");
			        String rg = JOptionPane.showInputDialog("Digite seu RG");
			        String dataNasc = JOptionPane.showInputDialog("Digite sua data de nascimento");
			        String dataMat = JOptionPane.showInputDialog("Digite sua data de matricula");

                    Aluno a = new Aluno();


                    a.setNome(nome);
			        a.setIdade(Integer.parseInt(idade));
			        a.setCpf(cpf);
			        a.setRg(rg);
			        a.setDataNascimento(dataNasc);
			        a.setDataMatricula(dataMat);

                    for (int pos = 1; pos <= 4; pos++) {
                        String disc = JOptionPane.showInputDialog("Digite a Disciplina " + pos + ":");
                        String nota = JOptionPane.showInputDialog("Digite a nota " + pos + ":");

                        Disciplina d = new Disciplina();
                        d.setDisciplina(disc);
                        d.setNota(Double.parseDouble(nota));
                        a.getDisciplinas().add(d);

                    }

                    int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma Disciplina ?");
                    int pos = 1;

                    if (escolha == 0) {
                        int continuar = 0;
                        while (continuar == 0) {

                            String removerDisc = JOptionPane.showInputDialog("Escolha qual deseja remover:\n1-2-3-4");

                            a.getDisciplinas().remove(Integer.parseInt(removerDisc) - pos);
                            pos++;
                            continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar removendo?");

                        }
                    }

                    alunos.add(a);
                }
                maps.put(StatusAluno.APROVADO, new ArrayList<>());
                maps.put(StatusAluno.RECUPERACAO, new ArrayList<>());
                maps.put(StatusAluno.REPROVADO, new ArrayList<>());

                for (Aluno aluno : alunos) {
                    if (aluno.Aprovacao().equalsIgnoreCase(StatusAluno.APROVADO)) {
                        maps.get(StatusAluno.APROVADO).add(aluno);
                    } else if (aluno.Aprovacao().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                        maps.get(StatusAluno.RECUPERACAO).add(aluno);

                    } else {
                        maps.get(StatusAluno.REPROVADO).add(aluno);
                    }
                }

                System.out.println("--------Lista dos Aprovados--------\n");
                for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                    System.out.println(aluno.getNome());
                    System.out.println(aluno.getCpf());
                    System.out.println(aluno.getIdade());
                    System.out.println(aluno.getDataMatricula());
                    System.out.println(aluno.getDisciplinas());
                    System.out.println(aluno.CalcularMedia());
                }
                System.out.println("--------Lista em Recuperação--------\n");
                for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                    System.out.println(aluno.getNome());
                    System.out.println(aluno.getCpf());
                    System.out.println(aluno.getIdade());
                    System.out.println(aluno.getDataMatricula());
                    System.out.println(aluno.getDisciplinas());
                    System.out.println(aluno.CalcularMedia());
                }
                System.out.println("--------Lista dos Reprovados--------\n");
                for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                    System.out.println(aluno.getNome());
                    System.out.println(aluno.getCpf());
                    System.out.println(aluno.getIdade());
                    System.out.println(aluno.getDataMatricula());
                    System.out.println(aluno.getDisciplinas());
                    System.out.println(aluno.CalcularMedia());
                }


            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado");
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao converter numeros");
        }catch (NullPointerException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao processar notas");

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro inesperado");
        }finally {
            JOptionPane.showMessageDialog(null,"BIP BOP");
        }
    }
}
