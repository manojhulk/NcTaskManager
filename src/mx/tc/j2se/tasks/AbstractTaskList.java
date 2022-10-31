package mx.tc.j2se.tasks;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>{
    public abstract void add(mx.tc.j2se.tasks.Task data);

    public abstract boolean remove (mx.tc.j2se.tasks.Task ob);

    //abstract void add (Task task);
    //abstract boolean remove (Task ob);
    public abstract int size();
    public abstract Task getTask(int index);
    public abstract Stream<Task> getStream();

    @Override
    public Iterator<Task> iterator() {
        Iterator<Task> it = new Iterator<Task>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size() && getTask(currentIndex)!= null;
            }

            @Override
            public Task next() {
                return getTask(currentIndex++);
            }
            public void remove()
            {
                // OverRiding Default Remove  Method.
                throw new UnsupportedOperationException();
            }

        };
        return it;
    }
    public ArrayTaskList incoming(LocalDateTime from, LocalDateTime to){
        ArrayTaskList st = new ArrayTaskList();
        getStream().filter(task -> (task.getStartTime().isAfter(from) && task.getEndTime().isBefore(to)) == true).forEach(task -> st.add(task));
        //ArrayList<Task> list = new ArrayList<>();
        //Stream<Task> stream = list.stream();
        return st;
    }



}
