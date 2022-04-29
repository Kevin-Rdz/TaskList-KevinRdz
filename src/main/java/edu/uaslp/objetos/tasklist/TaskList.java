package edu.uaslp.objetos.tasklist;

import edu.uaslp.objetos.exception.TaskListException;
import edu.uaslp.objetos.exception.TaskNotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TaskList {
    LinkedList<Task> List = new LinkedList<>();

    public int getSize() {
        return List.size();
    }
    public TaskList(){

    }

    //Añadir tareas
    public void add(Task task) {
        List.add(task);
    }

    //Eliminar tareas
    public void remove(Task task) {
        List.remove(task);
    }

    //Buscar tarea por su nombre
    public Task find(String name) throws TaskNotFoundException {
        Task task = null;
        int size = List.size();
        for(int i=0;i < size; i++){
            if(Objects.equals(name, task.getTitle())){
                return task;
            }
        }
        throw new TaskNotFoundException("Task with title 'Hacer ejercicio' not found");
    }

    //Marcarla como realizada
    public void markAsDone(String task ) {
        Task task2 = find(task);
        task2.setDone(true);
    }

    //Quitar la marca
    public void markAsNotDone(String task) {
        Task task2 = find(task);
        task2.setDone(false);
    }

    //Obtener la siguietne tarea a realizar (la que tenga el deadline más cercano)
    public Task getNextTask() {
        LocalDateTime deadline = LocalDateTime.now();
        int size = List.size(), i;

        for (i=0; i < size; i++){
            if (deadline.compareTo(List.get(i).getDueDate()) > 0){
                return List.get(i+1);
            }
        }
        throw new TaskListException();
    }

    //Obtener la lista de tareas a realziar ordenadas por deadline (del más cercano al más lejano)
    public List<Task> getNextTasks() {
        List<Task> list = new LinkedList<>();

        for (Task task : this.List) {
            if (!task.isDone()) {
                list.add(task);
            }
        }
        list.sort(Comparator.comparing(Task::getDueDate));
        return list;
    }
}
