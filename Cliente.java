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
        this.dataCadastro = LocalDate.of(ano, mes, dia);
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


}