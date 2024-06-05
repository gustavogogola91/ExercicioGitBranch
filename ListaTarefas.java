import java.util.ArrayList;

public abstract class ListaTarefas {
    

    private static ArrayList<Tarefa> lista = new ArrayList<>();

    public static void addTarefa(Tarefa tarefa) {
        lista.add(tarefa);
    }

    public static Tarefa buscarTarefa(String titulo) throws Exception {

        for (Tarefa tarefa : lista) {
            if (tarefa.getTitulo().equals(titulo)) {
                return tarefa;
            }
        }

        throw new Exception("\nTarefa não encontrada.\n");
    }

    public static void excluirTarefa(Tarefa tarefa) {
        lista.remove(tarefa);
    }
}
