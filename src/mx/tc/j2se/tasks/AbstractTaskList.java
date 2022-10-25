package mx.tc.j2se.tasks;

public abstract class AbstractTaskList {
    abstract void add (Task task);
    abstract boolean remove (Task ob);
    abstract int size();
    abstract Task getTask(int index);
}
