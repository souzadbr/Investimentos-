package br.com.zup.Aplicacao.Aplicação;

public class MensagemError {
    private String mensagem;

    public MensagemError(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
