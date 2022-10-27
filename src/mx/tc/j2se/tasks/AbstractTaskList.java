package mx.tc.j2se.tasks;
import java.util.*;

public abstract class AbstractTaskList<Task> implements Iterable<Task>{
    public abstract void add(mx.tc.j2se.tasks.Task data);

    public abstract boolean remove (mx.tc.j2se.tasks.Task ob);

    //abstract void add (Task task);
    //abstract boolean remove (Task ob);
    public abstract int size();
    public abstract Task getTask(int index);

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
}
