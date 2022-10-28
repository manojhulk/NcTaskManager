package mx.tc.j2se.tasks;
import java.util.*;
import java.util.stream.Stream;

public abstract class AbstractTaskList<Task> implements Iterable<Task>{
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
//    public ArrayTaskList incoming(int from, int to){
//        ArrayTaskList subsets= (ArrayTaskList) getStream().filter(t ->(t.getStartTime()>=from && t.getStartTime()<=to)==true).forEach(t -> {});
//        //ArrayList<Task> list = new ArrayList<>();
//        //Stream<Task> stream = list.stream();
//        for(mx.tc.j2se.tasks.Task t:elementData){
//            if(t.getStartTime()>=from && t.getStartTime()<=to){
//                subsets.add(t);
//            }else{
//                throw new IndexOutOfBoundsException("Time must be with in the range") ;
//            }
//        }
//        return subsets;
//    }



}
