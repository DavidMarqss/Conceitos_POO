package java_funcoes;

import java_interfaces.PermitirAcesso;

public class FuncaoAutenticacao {

    PermitirAcesso permitirAcesso;

    public boolean autenticar(){
        return permitirAcesso.autenticar();
    }

    public FuncaoAutenticacao (PermitirAcesso acesso){
        this.permitirAcesso = acesso;
    }
}
