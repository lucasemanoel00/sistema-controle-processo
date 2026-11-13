
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class Funcionario extends Pessoa {
    
    private String emailCorporativo;
    private LocalDate dataContratacao;
    private double salario;
    private CargoFuncionario cargo;
    private StatusFuncionario statusFuncionario;
    
    public enum CargoFuncionario {

        ADMINISTRADOR,
        ATENDENTE,
        ANALISTA_DOCUMENTAL,
        ANALISTA_PROCESSOS,
        SUPERVISOR,
        GESTOR

    }
    public enum StatusFuncionario {

        ATIVO,
        INATIVO,
        AFASTADO,
        FERIAS,
        DESLIGADO

    }

    public Funcionario(String nome,String cpf,String emailCorporativo,int dia,int mes, int ano,double salario,CargoFuncionario cargo,StatusFuncionario statusFuncionario) {

        super(nome, cpf);

        LocalDate novaData = LocalDate.of(ano, mes, dia); 

        if (emailCorporativo== null || emailCorporativo.isBlank()) {

            throw new IllegalArgumentException("ERRO, email vazio");

        }
        this.emailCorporativo = emailCorporativo;
        
        if (novaData.isAfter(LocalDate.now())) {

            throw new IllegalArgumentException("ERRO, data inválida");

        }
        this.dataContratacao = novaData;
        
        if (!Double.isFinite(salario) ||salario <=0) {

            throw new IllegalArgumentException("O salário não pode ser negativo ou igual a R$ 0 ou não estar preenchido com um valor númerico");

        }
        else {

            this.salario = salario;

        }
        if (cargo == null){

            throw new IllegalArgumentException("ERRO, Cargo não definido");

        }
        this.cargo = cargo;

        if (statusFuncionario == null) {

            throw new IllegalArgumentException("ERRO, Status de funcionário não definido");

        }

        this.statusFuncionario = statusFuncionario;

    }
    public String getEmailCorporativo() {

        return this.emailCorporativo;

    }
    public LocalDate getDataContratacao() {

        return this.dataContratacao;

    }
    public double getSalario() {

        return this.salario;

    }
    public CargoFuncionario getCargoFuncionario() {

        return this.cargo;

    }
    public StatusFuncionario getStatusFuncionario() {

        return this.statusFuncionario;

    }
    public void setEmailCorporativo(String emailCorporativo) {

        if (emailCorporativo == null || emailCorporativo.isBlank()) {

            throw new IllegalArgumentException("Erro,Email vazio");

        }
        else {
        
            this.emailCorporativo = emailCorporativo;

        }
    }
    public void setDataContratacao(int dia,int mes,int ano) {

        LocalDate novaData = LocalDate.of(ano, mes, dia);

        if (novaData.isAfter(LocalDate.now())) {

            throw new DateTimeException("Erro,data inválida");

        }
        else {
        
            this.dataContratacao = novaData;
        
        }

    }
    public void setSalario(double salario) {

        if  (!Double.isFinite(salario) ||salario<=0) {

            throw new IllegalArgumentException("Salario inferior ou igual a zero não é permitido");

        }
        else {

            this.salario = salario;

        }

    }
    public void setCargoFuncionario(CargoFuncionario cargoFuncionario) {

        if (cargoFuncionario == null) {

            throw new IllegalArgumentException("ERRO, Cargo do funcionário não definido");

        }
            
        this.cargo =  cargoFuncionario;
        
    }
    public void setStatusFuncionario(StatusFuncionario status) {

        if (status == null) {

            throw new IllegalArgumentException("ERRO,Status do funcionário não informado");

        }

        this.statusFuncionario = status;

    }
    public String calcularTempoServido() {

        Period tempo = Period.between(dataContratacao, LocalDate.now());

        return "%d anos, %d meses e %d dias".formatted(tempo.getYears(),tempo.getMonths(),tempo.getDays());

    }
    @Override 
    public String toString() {

        return "Nome do funcionário: %s \nCPF: %s \nNumero identificador: %d \nEmail: %s \nData de contratação: %s \nSalário em R$ %.2f \nCargo funcionário: %s \nStatus funcionário: %s \nTempo servido: %s".formatted(getNomePessoa(),getCPF(),getIdentificador(),getEmailCorporativo(),getDataContratacao(),getSalario(),getCargoFuncionario(),getStatusFuncionario(),calcularTempoServido());

    }





}
