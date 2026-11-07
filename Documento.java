
import java.time.LocalDate;

public class Documento {
    
    private static int gerenciadorId = 0;
    private final int identificadorDocumento = ++gerenciadorId;
    private String nomeDocumento;
    private String descricao;
    private LocalDate dataEntrega;
    private StatusDocumento statusDocumento;
    private boolean obrigatoriedade;
    private String justificativaRejeicao;

    public enum StatusDocumento {

        PENDENTE,
        RECEBIDO,
        EM_ANALISE,
        APROVADO,
        REJEITADO;

    }
    public Documento(String nomeDocumento,String descricao,int diaEntrega,int mesEntrega,int anoEntrega,StatusDocumento statusDocumento,String justificativaRejeicao) {

        this.nomeDocumento = nomeDocumento;
        this.descricao = descricao;
        this.dataEntrega = LocalDate.of(anoEntrega, mesEntrega, diaEntrega);
        this.statusDocumento = statusDocumento;
        this.justificativaRejeicao = justificativaRejeicao;
        this.obrigatoriedade = false;

    }



}
