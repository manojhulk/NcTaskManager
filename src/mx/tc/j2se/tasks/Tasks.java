package mx.tc.j2se.tasks;
import java.time.LocalDateTime;
import java.util.*;
//import java.util.SortedMap;

public class Tasks {
    public static Iterator<Task> incoming(Iterator<Task> tasks, LocalDateTime start,LocalDateTime end){
        if(end.isBefore(start) || tasks == null){
            throw new IllegalArgumentException("End time should be after the start time and arguments should not be null");
        }
        AbstractTaskList obj = tasks instanceof ArrayTaskList? TaskListFactory.createTaskList(ListTypes.types.ARRAY): TaskListFactory.createTaskList(ListTypes.types.LINKED);
        while (tasks.hasNext()){
            //System.out.println(tasks.next().getTitle());
            Task var = tasks.next();
            //System.out.println(var.getTitle());
            if(var.nextTimeAfter(start).isBefore(end)){
                obj.add(var);
            }
        }
        return obj.iterator();
    }

    /* This function returns SortedMap where the keys
    *  of the map are dates and values contains the set of tasks that are
    *  executed at that particular time
    * */

    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end){
        if(end.isBefore(start) || tasks == null){
            throw new IllegalArgumentException("End time should be after the start time and arguments should not be null");
        }
        Iterator<Task> taskList = Tasks.incoming(tasks,start,end);
        SortedMap<LocalDateTime, Set<Task>> table = new TreeMap<>();
        while(taskList.hasNext()){
            Task temp=taskList.next();
            if(!temp.isRepeated()){
                if(table.containsKey(temp.getTime())){
                    table.get(temp.getTime()).add(temp);
                }
                Set<Task> newSet = new TreeSet<>();
                newSet.add(temp);
                table.put(temp.getTime(),newSet);
            }else {
                for(LocalDateTime curr=temp.nextTimeAfter(start);(curr.isBefore(end) || curr.isEqual(end)) && (curr.isBefore(temp.getEndTime()) || curr.isEqual(temp.getEndTime()));curr=curr.plusHours(temp.getRepeatInterval())){
                    if(table.containsKey(curr)){
                        table.get(curr).add(temp);
                    }else{
                        Set<Task> tasKs = new TreeSet<>();
                        tasKs.add(temp);
                        table.put(curr,tasKs);
                    }
                }
            }

        }
        return table;
    }
}
