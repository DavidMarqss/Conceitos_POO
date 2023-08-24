package java_classes;

import java_interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {
    private String registro;
    private String nivelCargo;
    private String experiencia;

    private String login;
    private String senha;

    public Secretario () {

    }
    public Secretario (String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Secretario{" +
                "nivelCargo='" + nivelCargo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public double salario() {
        return 1500;
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
        return login.equals("admin") && senha.equals("admin");
    }
}
