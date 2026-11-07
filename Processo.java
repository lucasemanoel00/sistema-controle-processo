
import java.time.LocalDate;

public class Processo {

    private static int geradoridProcesso = 0;
    private final int numeroProcesso = ++geradoridProcesso;
    private Cliente cliente;
    private Funcionario funcionarioResponsavel;
    private String descricao;
    private LocalDate dataAbertura;
    private LocalDate dataFinal;
    private StatusProcesso statusProcesso;
    private Documento documento;

    public enum StatusProcesso {

        ABERTO,
        EM_ANALISE,
        AGUARDANDO_DOCUMENTOS,
        EM_ANDAMENTO,
        CONCLUIDO,
        CANCELADO

    }
    public Processo(Cliente cliente,Funcionario funcionarioResponsavel,String descricao,int diaAbertura,int mesAbertura,int anoAbertura,int diaPrevisto,int mesPrevisto,int anoPrevisto,StatusProcesso statusProcesso, Documento documento) {

        this.cliente = cliente;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.descricao = descricao;
        this.dataAbertura = LocalDate.of(anoAbertura,mesAbertura,diaAbertura);
        this.dataFinal = LocalDate.of(mesAbertura, anoAbertura, anoAbertura);
        this.dataFinal = LocalDate.of(anoPrevisto,mesPrevisto,diaPrevisto);
        this.statusProcesso = statusProcesso;
        this.documento = documento;

    }




}