import java.time.LocalDate;

public class Cliente extends Pessoa {

    //private Processo processoCliente;
    private String telefoneCliente;
    private LocalDate dataCadastro;
    private StatusCliente StatusAtualCliente;
    
    public enum StatusCliente {

        ATIVO,
        EM_ESPERA,
        INATIVO,
        BLOQUEADO

    }
    
    public Cliente(String nomePessoa,String cpf,String telefoneCliente,int dia,int mes, int ano,int decisaoStatusCliente) {

        super(nomePessoa, cpf);

        if (dia <= 0 ||mes <= 0 || ano <= 0){

            throw new IllegalArgumentException("Data inválida, data inferior ou igual zero");

        }
        else {
        
            this.dataCadastro = LocalDate.of(ano, mes, dia);
        }
        this.telefoneCliente = telefoneCliente;

        switch (decisaoStatusCliente) {
            
            case 1 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.INATIVO;

            }
            case 2 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.ATIVO;

            }
            case 3 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.BLOQUEADO;

            }
            case 4 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.EM_ESPERA;

            }

            default-> {

                this.StatusAtualCliente = Cliente.StatusCliente.INATIVO;

            }

        }
    }
    public String getTelefone() {

        return this.telefoneCliente;

    }
    public LocalDate getDataCadastro() {

        return this.dataCadastro;

    }
    public StatusCliente getStatusAtualCliente() {

        return this.StatusAtualCliente;

    }
    public void setTelefoneCliente(String telefoneCliente) {

        this.telefoneCliente = telefoneCliente;

    }
    public void setDataCadastro(int dia,int mes,int ano) {

        if (dia <= 0 ||mes <= 0 || ano <= 0){

            throw new IllegalArgumentException("Data inválida, data inferior ou igual zero");

        }
        else {
        
            this.dataCadastro = LocalDate.of(ano, mes, dia);
        
        }

    }
    public void cadastradoHoje() {

        this.dataCadastro = LocalDate.now();

    }
    public void setStatusAtualCliente(int decisaoStatusCliente) {

        switch (decisaoStatusCliente) {
            
            case 1 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.INATIVO;

            }
            case 2 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.ATIVO;

            }
            case 3 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.BLOQUEADO;

            }
            case 4 -> {

                this.StatusAtualCliente = Cliente.StatusCliente.EM_ESPERA;

            }

            default-> {

                this.StatusAtualCliente = Cliente.StatusCliente.INATIVO;

            }

        }

    }
    @Override 
    public String toString() {

        return "Nome do cliente: %s \nCPF:%s \nNúmero identificador: %d \nTelefone: %s \nData de cadastro: %s \nStatus atual do cliente %s".formatted(getNomePessoa(),getCPF(),getIdentificador(),getTelefone(),getDataCadastro(),getStatusAtualCliente());

    }



}