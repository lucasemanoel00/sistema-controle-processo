
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static ArrayList<Processo> processos = new ArrayList<>();

    public static void main(String[] args) {

        int escolha;

        do {

            System.out.println("\n===== SISTEMA DE CONTROLE DE PROCESSOS =====\nDigite [1] para cadastrar um cliente\nDigite [2] para cadastrar um funcionário\nDigite [3] para abrir um processo\nDigite [4] para visualizar todos os clientes\nDigite [5] para visualizar todos os funcionários\nDigite [6] para visualizar todos os processos\nDigite [7] para gerenciar documentos\nDigite [8] para alterar o status de um processo\nDigite [0] para encerrar o sistema");

            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {

                case 1 -> cadastrarCliente();

                case 2 -> cadastrarFuncionario();

                case 3 -> abrirProcesso();

                case 4 -> listarClientes();

                case 5 -> listarFuncionarios();

                case 6 -> listarProcessos();

                case 7 -> gerenciarDocumentos();

                case 8 -> alterarStatusProcesso();

                case 0 -> System.out.println("Sistema encerrado!");

                default -> System.out.println("Opção inválida!");

            }

        } while (escolha != 0);

        sc.close();

    }

    // CADASTRO DE CLIENTES

    public static void cadastrarCliente() {

        System.out.println("\n===== CADASTRO DE CLIENTE =====");

        System.out.println("Digite o nome do cliente:");
        String nome = sc.nextLine();

        System.out.println("Digite o CPF do cliente:");
        String cpf = sc.nextLine();

        System.out.println("Digite o telefone do cliente:");
        String telefone = sc.nextLine();

        System.out.println("Digite o dia do cadastro:");
        int dia = sc.nextInt();

        System.out.println("Digite o mês do cadastro:");
        int mes = sc.nextInt();

        System.out.println("Digite o ano do cadastro:");
        int ano = sc.nextInt();

        System.out.println("\nEscolha o status do cliente:\n"
                + "[1] Inativo\n"
                + "[2] Ativo\n"
                + "[3] Bloqueado\n"
                + "[4] Em espera");

        int status = sc.nextInt();
        sc.nextLine();

        if (status < 1 || status > 4) {

            System.out.println("Status inválido!");
            return;

        }

        try {

            Cliente novoCliente = new Cliente(nome, cpf, telefone, dia, mes, ano, status);

            clientes.add(novoCliente);

            System.out.println("\nCliente cadastrado com sucesso!");
            System.out.println(novoCliente);

        } catch (RuntimeException e) {

            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());

        }

    }

    // CADASTRO DE FUNCIONÁRIOS

    public static void cadastrarFuncionario() {

        System.out.println("\n===== CADASTRO DE FUNCIONÁRIO =====");

        System.out.println("Digite o nome do funcionário:");
        String nome = sc.nextLine();

        System.out.println("Digite o CPF do funcionário:");
        String cpf = sc.nextLine();

        System.out.println("Digite o email corporativo:");
        String email = sc.nextLine();

        System.out.println("Digite o dia da contratação:");
        int dia = sc.nextInt();

        System.out.println("Digite o mês da contratação:");
        int mes = sc.nextInt();

        System.out.println("Digite o ano da contratação:");
        int ano = sc.nextInt();

        System.out.println("Digite o salário do funcionário:");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.println("\nEscolha o cargo do funcionário:\n"
                + "[1] Administrador\n"
                + "[2] Atendente\n"
                + "[3] Analista documental\n"
                + "[4] Analista de processos\n"
                + "[5] Supervisor\n"
                + "[6] Gestor");

        int escolhaCargo = sc.nextInt();

        Funcionario.CargoFuncionario cargo;

        switch (escolhaCargo) {

            case 1 -> cargo = Funcionario.CargoFuncionario.ADMINISTRADOR;

            case 2 -> cargo = Funcionario.CargoFuncionario.ATENDENTE;

            case 3 -> cargo = Funcionario.CargoFuncionario.ANALISTA_DOCUMENTAL;

            case 4 -> cargo = Funcionario.CargoFuncionario.ANALISTA_PROCESSOS;

            case 5 -> cargo = Funcionario.CargoFuncionario.SUPERVISOR;

            case 6 -> cargo = Funcionario.CargoFuncionario.GESTOR;

            default -> {
                System.out.println("Cargo inválido!");
                return;
            }

        }

        System.out.println("\nEscolha o status do funcionário:\n"
                + "[1] Ativo\n"
                + "[2] Inativo\n"
                + "[3] Afastado\n"
                + "[4] Férias\n"
                + "[5] Desligado");

        int escolhaStatus = sc.nextInt();
        sc.nextLine();

        Funcionario.StatusFuncionario status;

        switch (escolhaStatus) {

            case 1 -> status = Funcionario.StatusFuncionario.ATIVO;

            case 2 -> status = Funcionario.StatusFuncionario.INATIVO;

            case 3 -> status = Funcionario.StatusFuncionario.AFASTADO;

            case 4 -> status = Funcionario.StatusFuncionario.FERIAS;

            case 5 -> status = Funcionario.StatusFuncionario.DESLIGADO;

            default -> {
                System.out.println("Status inválido!");
                return;
            }

        }

        try {

            Funcionario novoFuncionario = new Funcionario(
                    nome, cpf, email, dia, mes, ano,
                    salario, cargo, status
            );

            funcionarios.add(novoFuncionario);

            System.out.println("\nFuncionário cadastrado com sucesso!");
            System.out.println(novoFuncionario);

        } catch (RuntimeException e) {

            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());

        }

    }

    // ABERTURA DE PROCESSOS

    public static void abrirProcesso() {

        if (clientes.isEmpty() || funcionarios.isEmpty()) {

            System.out.println("Cadastre pelo menos um cliente e um funcionário antes de abrir um processo!");
            return;

        }

        System.out.println("\n===== ABERTURA DE PROCESSO =====");

        listarClientes();

        System.out.println("\nDigite o identificador do cliente:");
        int idCliente = sc.nextInt();
        sc.nextLine();

        Cliente clienteEscolhido = buscarCliente(idCliente);

        if (clienteEscolhido == null) {

            System.out.println("Cliente não encontrado!");
            return;

        }

        listarFuncionarios();

        System.out.println("\nDigite o identificador do funcionário responsável:");
        int idFuncionario = sc.nextInt();
        sc.nextLine();

        Funcionario funcionarioEscolhido = buscarFuncionario(idFuncionario);

        if (funcionarioEscolhido == null) {

            System.out.println("Funcionário não encontrado!");
            return;

        }

        System.out.println("\nDigite a descrição do processo:");
        String descricao = sc.nextLine();

        System.out.println("\nDigite a data de abertura do processo:");

        System.out.println("Dia:");
        int diaAB = sc.nextInt();

        System.out.println("Mês:");
        int mesAB = sc.nextInt();

        System.out.println("Ano:");
        int anoAB = sc.nextInt();

        System.out.println("\nDigite a data prevista para o fim do processo:");

        System.out.println("Dia:");
        int diaFinal = sc.nextInt();

        System.out.println("Mês:");
        int mesFinal = sc.nextInt();

        System.out.println("Ano:");
        int anoFinal = sc.nextInt();
        sc.nextLine();

        try {

            Processo novoProcesso = new Processo(
                    clienteEscolhido,
                    funcionarioEscolhido,
                    descricao,
                    diaAB, mesAB, anoAB,
                    diaFinal, mesFinal, anoFinal
            );

            processos.add(novoProcesso);

            System.out.println("\nProcesso aberto com sucesso!");
            System.out.println(novoProcesso);

        } catch (RuntimeException e) {

            System.out.println("Erro ao abrir processo: " + e.getMessage());

        }

    }

    // LISTAGEM DE CLIENTES

    public static void listarClientes() {

        System.out.println("\n===== LISTA DE CLIENTES =====");

        if (clientes.isEmpty()) {

            System.out.println("Não existem clientes cadastrados!");
            return;

        }

        for (Cliente cliente : clientes) {

            System.out.println("\n" + cliente);

        }

    }

    // LISTAGEM DE FUNCIONÁRIOS

    public static void listarFuncionarios() {

        System.out.println("\n===== LISTA DE FUNCIONÁRIOS =====");

        if (funcionarios.isEmpty()) {

            System.out.println("Não existem funcionários cadastrados!");
            return;

        }

        for (Funcionario funcionario : funcionarios) {

            System.out.println("\n" + funcionario);

        }

    }

    // LISTAGEM DE PROCESSOS

    public static void listarProcessos() {

        System.out.println("\n===== LISTA DE PROCESSOS =====");

        if (processos.isEmpty()) {

            System.out.println("Não existem processos cadastrados!");
            return;

        }

        for (Processo processo : processos) {

            System.out.println("\n" + processo);

        }

    }

    // BUSCA DE CLIENTES

    public static Cliente buscarCliente(int identificador) {

        for (Cliente cliente : clientes) {

            if (cliente.getIdentificador() == identificador) {

                return cliente;

            }

        }

        return null;

    }

    // BUSCA DE FUNCIONÁRIOS

    public static Funcionario buscarFuncionario(int identificador) {

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getIdentificador() == identificador) {

                return funcionario;

            }

        }

        return null;

    }

    // BUSCA DE PROCESSOS

    public static Processo buscarProcesso(int numeroProcesso) {

        for (Processo processo : processos) {

            if (processo.getNumeroProcesso() == numeroProcesso) {

                return processo;

            }

        }

        return null;

    }

    // GERENCIAMENTO DE DOCUMENTOS

    public static void gerenciarDocumentos() {

        if (processos.isEmpty()) {

            System.out.println("Não existem processos cadastrados!");
            return;

        }

        listarProcessos();

        System.out.println("\nDigite o número do processo:");
        int numeroProcesso = sc.nextInt();
        sc.nextLine();

        Processo processoEscolhido = buscarProcesso(numeroProcesso);

        if (processoEscolhido == null) {

            System.out.println("Processo não encontrado!");
            return;

        }

        int escolha;

        do {

            System.out.println("\n===== GERENCIAMENTO DE DOCUMENTOS =====\n"
                    + "Digite [1] para adicionar um documento\n"
                    + "Digite [2] para listar todos os documentos\n"
                    + "Digite [3] para buscar um documento pelo identificador\n"
                    + "Digite [4] para remover um documento\n"
                    + "Digite [0] para voltar ao menu principal");

            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {

                case 1 -> adicionarDocumento(processoEscolhido);

                case 2 -> processoEscolhido.mostrarTodosDocs();

                case 3 -> buscarDocumento(processoEscolhido);

                case 4 -> removerDocumento(processoEscolhido);

                case 0 -> System.out.println("Voltando ao menu principal...");

                default -> System.out.println("Opção inválida!");

            }

        } while (escolha != 0);

    }

    // ADICIONAR DOCUMENTO

    public static void adicionarDocumento(Processo processo) {

        System.out.println("\n===== CADASTRO DE DOCUMENTO =====");

        System.out.println("Digite o nome do documento:");
        String nome = sc.nextLine();

        System.out.println("Digite a descrição do documento:");
        String descricao = sc.nextLine();

        System.out.println("Digite o dia do prazo de entrega:");
        int dia = sc.nextInt();

        System.out.println("Digite o mês do prazo de entrega:");
        int mes = sc.nextInt();

        System.out.println("Digite o ano do prazo de entrega:");
        int ano = sc.nextInt();
        sc.nextLine();

        try {

            processo.adicionarDocumento(nome, descricao, dia, mes, ano);

            System.out.println("Documento cadastrado com sucesso!");

        } catch (RuntimeException e) {

            System.out.println("Erro ao cadastrar documento: " + e.getMessage());

        }

    }

    // BUSCAR DOCUMENTO

    public static void buscarDocumento(Processo processo) {

        System.out.println("Digite o identificador do documento:");
        int identificador = sc.nextInt();
        sc.nextLine();

        try {

            System.out.println(processo.buscarID(identificador));

        } catch (IllegalAccessError e) {

            System.out.println("Não existem documentos cadastrados neste processo!");

        }

    }

    // REMOVER DOCUMENTO

    public static void removerDocumento(Processo processo) {

        System.out.println("Digite o identificador do documento:");
        int identificador = sc.nextInt();
        sc.nextLine();

        System.out.println(processo.removerDocumentoID(identificador));

    }

    // ALTERAR STATUS DO PROCESSO

    public static void alterarStatusProcesso() {

        if (processos.isEmpty()) {

            System.out.println("Não existem processos cadastrados!");
            return;

        }

        listarProcessos();

        System.out.println("\nDigite o número do processo que deseja alterar:");
        int numeroProcesso = sc.nextInt();
        sc.nextLine();

        Processo processoEscolhido = buscarProcesso(numeroProcesso);

        if (processoEscolhido == null) {

            System.out.println("Processo não encontrado!");
            return;

        }

        System.out.println("\n===== ALTERAÇÃO DE STATUS =====\n"
                + "Digite [1] para ABERTO\n"
                + "Digite [2] para EM ANÁLISE\n"
                + "Digite [3] para AGUARDANDO DOCUMENTOS\n"
                + "Digite [4] para EM ANDAMENTO\n"
                + "Digite [5] para CONCLUÍDO\n"
                + "Digite [6] para CANCELADO");

        int escolhaStatus = sc.nextInt();
        sc.nextLine();

        System.out.println(processoEscolhido.setStatusProcesso(escolhaStatus));

    }

}
