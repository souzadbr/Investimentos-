package br.com.zup.Aplicacao.Aplicação.config;

public class MensagemError {
    private String campo;
    private String mensagem;

    public MensagemError(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }


    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
