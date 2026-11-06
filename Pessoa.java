public abstract class Pessoa {
    
    private String nomePessoa;
    private String cpf;
    private static int geradorID = 0;
    private final int identificador = ++geradorID;

    public Pessoa(String nomePessoa,String cpf) {

        this.nomePessoa = nomePessoa;
        this.cpf = cpf;

    }
    public void setNomePessoa(String nomePessoa) {

        this.nomePessoa = nomePessoa;

    }
    public void setCPF(String cpf) {

        this.cpf = cpf;

    }
    public String getNomePessoa() {

        return this.nomePessoa;

    }
    public String getCPF() {

        return this.cpf;

    }
    public int getIdentificador() {

        return this.identificador;

    }
    @Override
    public String toString() {

        return "Nome: %s \nCPF: %s \nNúmero identificador: %d".formatted(getNomePessoa(),getCPF(),getIdentificador());

    }


}
