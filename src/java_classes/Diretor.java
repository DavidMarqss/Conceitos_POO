package java_classes;

import java_interfaces.PermitirAcesso;

public class Diretor extends Pessoa implements PermitirAcesso {
    private String registro;
    private int tempoDirecao;
    private String titulacao;

    private String login;
    private String senha;

    public Diretor() {
    }
    public Diretor(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public int getTempoDirecao() {
        return tempoDirecao;
    }

    public void setTempoDirecao(int tempoDirecao) {
        this.tempoDirecao = tempoDirecao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "registro='" + registro + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public double salario() {
        return 4500;
    }


    @Override
    public boolean autenticar(String login, String senha) {
        /*return login.equals("admin") && senha.equals("admin");*/
        this.login = login;
        this.senha = senha;
        return autenticar();
    }

    @Override
    public boolean autenticar() {
        return login.equals("master") && senha.equals("master");
    }
}
