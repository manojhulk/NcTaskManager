package mx.tc.j2se.tasks;

import java.time.LocalDateTime;
import java.util.Iterator;

public class Tasks {
    public static Iterator<Task> incoming(Iterator<Task> tasks, LocalDateTime start,LocalDateTime end){
        AbstractTaskList obj = new ArrayTaskList() {
            @Override
            public Iterator<Task> iterator(){
                return super.iterator();
            }
            public void add(Task task){
                super.add(task);
            }
        };
        while (tasks.hasNext()){
            //System.out.println(tasks.next().getTitle());
            Task var = tasks.next();
            //System.out.println(var.getTitle());
            if(var.getEndTime().isAfter(end) && var.getStartTime().isBefore(start)){
                obj.add(var);
            }
        }
        return obj.iterator();
    }


}
