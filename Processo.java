
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Processo {

    DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
        this.dataFinal = LocalDate.of(anoPrevisto, mesPrevisto, diaPrevisto);
        this.dataFinal = LocalDate.of(anoPrevisto,mesPrevisto,diaPrevisto);
        this.statusProcesso = statusProcesso;
        this.documento = documento;

    }
    public void setCliente(Cliente cliente) {

        this.cliente = cliente;

    }
    public Cliente getCliente() {

        return this.cliente;

    }
    public void setFuncionarioResponsavel(Funcionario funcionario) {

        this.funcionarioResponsavel = funcionario;

    }
    public Funcionario getFuncionarioResponsavel() {

        return this.funcionarioResponsavel;

    }
    public void setDescricao(String descricao) {

        this.descricao = descricao;

    }
    public String getDescricao() {

        return this.descricao;

    }
    public void setDataAbertura(int dia,int mes,int ano) {

        this.dataAbertura = LocalDate.of(ano,mes,dia); 

    }
    public LocalDate getDataAbertura() {

        return this.dataAbertura;

    }
    public String getDataAberturaFormatado() {

        return getDataAbertura().format(FORMATO);

    }
    public void setDataPrevistaFinal(LocalDate dataFinal) {

        this.dataFinal = dataFinal;

    }
    public LocalDate getDataPrevistaFinal() {

        return this.dataFinal;

    }
    public String getDataPrevistaFinalFormatada() {

        return getDataPrevistaFinal().format(FORMATO);

    }
    public int getNumeroProcesso() {

        return this.numeroProcesso;

    }
    public void setStatusProcesso(StatusProcesso statusProcesso) {

        this.statusProcesso = statusProcesso;

    }
    public StatusProcesso getStatusProcesso () {

        return this.statusProcesso;

    }
    public void setDocumento(Documento documento) {

        this.documento = documento;

    }
    public Documento getDocumento() {

        return this.documento;

    }
    @Override 
    public String toString() {

        return "Numero do processo: %d \nDescrição: %s \nData de abertura: %s \nData prevista para o encerramento: %s \nStatus do processo: %s \n%s \n%s \n%s".formatted(getNumeroProcesso(),getDescricao(),getDataAberturaFormatado(),getDataPrevistaFinalFormatada(),getStatusProcesso(),getFuncionarioResponsavel(),getCliente(),getDocumento());

    }







}