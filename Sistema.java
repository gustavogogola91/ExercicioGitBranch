public class Sistema {

    public static void exibirMenu() {
        System.out.println("1. Cadastrar Tarefa");
        System.out.println("2. Buscar Tarefa");
        System.out.println("3. Editar Tarefa");
        System.out.println("4. Excluir Tarefa");
        System.out.println("5. Listar Todas as Tarefas");
        System.out.println("0. Sair");
    }

    public static void verificarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarTarefa();
                break;
            case 2:
                buscarTarefa();
                break;
            case 3:
                editarTarefaSubMenu();
                break;
            case 4:
                // Lógica para excluir tarefa
                break;
            case 5:
                // Lógica para listar todas as tarefas
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void cadastrarTarefa() {

        String titulo;
        String descricao;
        String dataVencimento;
        String status;

        System.out.println("\nCadastro de tarefa");

        titulo = Console.lerString("\nDigite o nome da tarefa");
        descricao = Console.lerString("\nDigite a descrição");
        dataVencimento = Console.lerString("\nDigite a data de vencimento da tarefa");
        status = Console.lerString("\nDigite o status");

        Tarefa tempTarefa = new Tarefa(titulo, descricao, dataVencimento, status);

        ListaTarefas.addTarefa(tempTarefa);

    }

    private static void buscarTarefa() {
        System.out.println("\nBuscar tarefa");
        String titulo = Console.lerString("Digite o titulo da tarefa");

        try {
            Tarefa tempTarefa = ListaTarefas.buscarTarefa(titulo);

            System.out.println(tempTarefa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void editarTarefaSubMenu() {

        Tarefa busca;
        System.out.println("Editar tarefa\n");

        String titulo = Console.lerString("Digite o titulo da tarefa");

        try {
            busca = ListaTarefas.buscarTarefa(titulo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        int op;
        do {
            System.out.println("1. Editar titulo");
            System.out.println("2. Editar descricao");
            System.out.println("3. Editar data de vencimento");
            System.out.println("4. Editar status");
            System.out.println("0. Cancelar");
            op = Console.lerInt("Sua opção");

            switch (op) {
                case 1:
                    String novoTitulo = Console.lerString("Digite o novo titulo");
                    busca.setTitulo(novoTitulo);
                    break;
                case 2:
                    String novaDesc = Console.lerString("Digite a nova descrição");
                    busca.setDescricao(novaDesc);
                    break;
                case 3:
                    String novaData = Console.lerString("Digite a nova data de vencimento");
                    busca.setDataVencimento(novaData);
                    break;
                case 4:
                    String novoStatus = Console.lerString("Digite o novo status");
                    busca.setStatus(novoStatus);
                    break;

                case 0:
                    System.out.println("Cancelando...");
                    return;

                default:
                    System.out.println("\nOpção inválida\n");
                    break;
            }
        } while (op != 0);

        System.out.println("Alterado com sucesso!");
    }

}
