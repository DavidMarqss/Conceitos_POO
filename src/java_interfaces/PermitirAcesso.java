package java_interfaces;

public interface PermitirAcesso {
    /*public boolean autenticar();*/
    public boolean autenticar(String login, String senha);
    public boolean autenticar();
}
