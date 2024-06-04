import java.util.ArrayList;

public abstract class ListaTarefas {
    

    private static ArrayList<Tarefa> lista = new ArrayList<>();

    public static void addTarefa(Tarefa tarefa) {
        lista.add(tarefa);
    }
}
