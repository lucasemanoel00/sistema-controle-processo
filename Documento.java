
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Documento {
    
    private static int gerenciadorId = 0;
    private final int identificadorDocumento = ++gerenciadorId;
    private String nomeDocumento;
    private String descricao;
    private LocalDate dataEntrega;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private StatusDocumento statusDocumento;
    private boolean obrigatoriedade;
    private String justificativaRejeicao;

    public enum StatusDocumento {

        NAO_REGISTRADO,
        PENDENTE,
        RECEBIDO,
        EM_ANALISE,
        APROVADO,
        REJEITADO;

    }
    public Documento(String nomeDocumento,String descricao,int diaEntrega,int mesEntrega,int anoEntrega) {

        this.nomeDocumento = nomeDocumento;
        this.descricao = descricao;
        this.dataEntrega = LocalDate.of(anoEntrega, mesEntrega, diaEntrega);
        this.statusDocumento = StatusDocumento.NAO_REGISTRADO;
        this.obrigatoriedade = false;
        

    }
    public int getIdentificador() {

        return this.identificadorDocumento;

    }
    public String getNomeDocumento() {

        return this.nomeDocumento;

    }
    public void setNomeDocumento(String nomeDocumento) {

        this.nomeDocumento = nomeDocumento;

    }
    public String getDescricaoDocumento() {

        return this.descricao;

    }
    public void setDescricaoDocumento(String descricao) {

        this.descricao = descricao;

    }
    public LocalDate getDataEntrega() {

        return this.dataEntrega;

    }
    public String getDataEntregaFormat() {

        return this.dataEntrega.format(FORMATO);

    }
    public void setDataEntrega(int dia,int mes, int ano) {

        LocalDate novaData = LocalDate.of(ano,mes,dia);

        if (novaData.isBefore(LocalDate.now())) {

            throw new DateTimeException("Data inválida");

        }
        
        this.dataEntrega = LocalDate.of(ano,mes,dia);

    }
    public StatusDocumento getStatusDocumento() {

        return this.statusDocumento;

    }
    public void setStatusDocumento(StatusDocumento statusDocumento) {

        if (statusDocumento == null) {

            throw new IllegalArgumentException("Status do documento não informado, por favor informe-o");

        }

        this.statusDocumento = statusDocumento;

    }
    public void ativarObrigatoriedade() {

        this.obrigatoriedade = true;

    }
    public void desativarObrigatoriedade() {

        this.obrigatoriedade = false;

    }
    public String getObrigatoriedade() {

        if (this.obrigatoriedade) {

            return "Documento obrigatório!";

        }
        return "Documento não obrigatório";
    }

    public void documentoRejeitado() {

        this.statusDocumento = StatusDocumento.REJEITADO;
        
    }
    public void documentoAceito() {

        this.statusDocumento = StatusDocumento.APROVADO;

    }
    public String getStatusRejeitado() {

        if (this.statusDocumento == StatusDocumento.REJEITADO) {

            return "Documento: %s rejeitado!".formatted(getNomeDocumento());

        }
        return "Documento %s não foi rejeito no momento".formatted(getNomeDocumento());

    }

    public void setJustificativaRejeicao(String justificativaRejeicao) {

        if (justificativaRejeicao == null || justificativaRejeicao.isBlank()) {

            throw new IllegalArgumentException("Justificativa não explicitada de forma correta");

        }

        this.justificativaRejeicao = justificativaRejeicao;

    }
    public String getJustificativaRejeicao() {

        return this.justificativaRejeicao;

    }
    @Override 
    public String toString() {

        if (statusDocumento == StatusDocumento.REJEITADO) {
            
            return "Nome do documento: %s \nNúmero identificador: %d \nDescrição da requisição: %s \nData de entrega: %s \nStatus do documento: %s \nJustificativa de rejeição: %s".formatted(getNomeDocumento(),getIdentificador(),getDescricaoDocumento(),getDataEntregaFormat(),getStatusDocumento(),getJustificativaRejeicao());    
        
        }
        
        return "Nome do documento: %s \nNúmero identificador: %d \nDescrição da requisição: %s \nData de entrega: %s \nStatus do documento: %s".formatted(getNomeDocumento(),getIdentificador(),getDescricaoDocumento(),getDataEntregaFormat(),getStatusDocumento());
    }

}
