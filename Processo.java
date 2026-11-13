import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Processo {
    
    public enum StatusProcesso {

        ABERTO,
        EM_ANALISE,
        AGUARDANDO_DOCUMENTOS,
        EM_ANDAMENTO,
        CONCLUIDO,
        CANCELADO;

    }

    private static int geradorNum = 0;
    private final int numeroProcesso = ++geradorNum;
    private Cliente cliente;
    private Funcionario funcionarioResponsavel;
    private String descricao;
    private LocalDate dataAbertura;
    private LocalDate dataPrevistaFinal;
    private StatusProcesso statusProcesso;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final List<Documento> documentos = new ArrayList<>();

    public Processo(Cliente cliente,Funcionario responsavel,String descricao,int diaAB,int mesAB,int anoAB,int diaFinal,int mesFinal,int anoFinal) {

        if (descricao == null || descricao.isBlank()) {

            throw new IllegalArgumentException("O processo deve conter uma descrição");

        }
        else {

            this.descricao = descricao;

        }
        if (cliente == null) {

            throw new IllegalArgumentException("O cliente deve estar registrado!");

        }
        else {

            this.cliente = cliente;

        }
        if (responsavel == null) {

            throw new IllegalArgumentException("O responsável deve estar cadastrado!");

        }
        else {

            this.funcionarioResponsavel = responsavel;

        }
        this.statusProcesso = StatusProcesso.ABERTO;

        if (diaAB <= 0 || mesAB <= 0 || anoAB <= 0) {

            throw new IllegalArgumentException("Data inválida");

        }
        else {
            
            this.dataAbertura = LocalDate.of(anoAB, mesAB, diaAB);
        
        }

        LocalDate novaDataFinal = LocalDate.of(anoFinal, mesFinal, diaFinal);

        if (diaFinal <= 0 || mesFinal <= 0 || anoFinal <= 0 || novaDataFinal.isBefore(this.dataAbertura)) {
            throw new IllegalArgumentException("Data inválida");
        }
        else {
            this.dataPrevistaFinal = novaDataFinal;
        }

    }
    public int getNumeroProcesso() {

        return this.numeroProcesso;

    }
    public Cliente getCliente() {

        return this.cliente;

    }
    public void setCliente(Cliente cliente) {

        if (cliente == null){

            throw new IllegalArgumentException("O cliente deve estar cadastro e não vázio");

        }

        this.cliente = cliente;

    }
    public Funcionario getFuncionarioResponsavel() {

        return this.funcionarioResponsavel;

    }
    public void setFuncionarioResponsavel(Funcionario funcionario) {

        if (funcionario == null) {

            throw new IllegalArgumentException("Funcionario deve ser registrado e para não ser inválidado");

        }

        this.funcionarioResponsavel = funcionario;

    }
    public String getDescricao() {

        return this.descricao;

    }
    public void setDescricao(String descricao) {

        if (descricao == null || descricao.isBlank()) {
        
            throw new IllegalArgumentException("Descrição inválida ou vazia");

        }

        this.descricao = descricao;

    }
    public LocalDate getDataAbertura() {

        return this.dataAbertura;

    }
    public String getDataAberturaFormat() {

        return this.dataAbertura.format(FORMATO);

    }
    public void setDataAbertura(int dia,int mes, int ano) {

        if (dia == 0 || mes == 0 || ano == 0) {

            throw new IllegalArgumentException("Data inválida!");

        }
        
        this.dataAbertura = LocalDate.of(ano,mes, dia);

    }
    public LocalDate getDataPrevistaFinal() {

        return this.dataPrevistaFinal;

    }
    public String getDataPrevistaFinalFormat() {

        return this.dataPrevistaFinal.format(FORMATO);

    }
    public void setDataPrevistaFinal(int dia,int mes,int ano) {

        LocalDate novaData = LocalDate.of(ano,mes,dia); 

        if (dia == 0 || mes == 0 || ano == 0 ||novaData.isBefore(this.dataAbertura)) {

            throw new IllegalArgumentException("Data inválida!");

        }

        this.dataPrevistaFinal = novaData;

    }
    public StatusProcesso getStatusProcesso() {

        return this.statusProcesso;

    }
    public String setStatusProcesso(int escolhaStatus) {

        switch (escolhaStatus) {
            
            case 1-> {

                this.statusProcesso = StatusProcesso.ABERTO;
                
                return "Processo em estado ABERTO";

            }
            case 2-> {

                this.statusProcesso = StatusProcesso.EM_ANALISE;
                return "Processo em estado EM ANÁLISE";

            }
            case 3 -> {

                this.statusProcesso = StatusProcesso.AGUARDANDO_DOCUMENTOS;

                return "Processo em estado: AGUARDANDO DOCUMENTOS";

            }
            case 4 -> {

                this.statusProcesso = StatusProcesso.EM_ANDAMENTO;
                return "Processo em estado: EM ANDAMENTO";

            }
            case 5 -> {

                this.statusProcesso = StatusProcesso.CONCLUIDO;
                return "Processo em estado: CONCLUIDO!";

            }
            case 6 -> {

                this.statusProcesso = StatusProcesso.CANCELADO;
                return "PROCESSO CANCELADO!";

            }
        }

        return "Processo não definido";

    }
    public void adicionarDocumento(String nomeDocumento,String descricao,int dia,int mes,int ano) {

        documentos.add(new Documento(nomeDocumento,descricao,dia,mes,ano));

    }
    public String removerDocumentoID(int identificador) {

        if (documentos.isEmpty()) {

            return "A lista de documentos está vazia";

        }
       
        boolean removido = documentos.removeIf(documento -> documento.getIdentificador() == identificador);
        if (removido) {
        
            return "Documento encontrado e removido com sucesso!";

        }
        return "Documento não encontrado!";
    }
    public String buscarID(int numeroIdentificador) {

        if (documentos.isEmpty()) {

                throw new IllegalAccessError("Lista vazia e não possui documentos");

            }

        for (Documento listagem: documentos) {

            

            if (listagem.getIdentificador() == numeroIdentificador) {

              return listagem.toString();

            }

        }

        return "Documento de número identificador %d não encontrado!".formatted(numeroIdentificador);

    }
    public void mostrarTodosDocs() {

        if (documentos.isEmpty()) {

            System.out.println("Lista vazia");
            return;

        }

        for (Documento listagem: documentos) {

            System.out.println(listagem);

        }

    }
    
    @Override
    public String toString() {

        return "Número identificador do processo: %d \n%s \n%s \nDescrição do processo: %s \nData de abertura: %s \nData Prevista para o fim do processo: %s \nStatus do processo: %s".formatted(getNumeroProcesso(),getCliente(),getFuncionarioResponsavel(),getDescricao(),getDataAberturaFormat(),getDataPrevistaFinalFormat(),getStatusProcesso()); 

    }

}
