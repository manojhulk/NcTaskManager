package mx.tc.j2se.tasks;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>,Cloneable{
    public abstract void add(mx.tc.j2se.tasks.Task data);
    public abstract boolean remove (mx.tc.j2se.tasks.Task ob);
    public abstract int size();
    public abstract Task getTask(int index);
    public abstract Stream<Task> getStream();
    @Override
    public String toString(){
        String taskDesc = "";
        String taskType = this instanceof ArrayTaskList? "Array task list\n":"Linked task list\n";
        taskDesc+=taskType;
        for(Task curr: this){
            taskDesc += curr.toString()+"  \n";
        }
        return taskDesc;
    }

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
    @Override
    public boolean equals(Object obj) {
        //null instanceof Object will always return false
        AbstractTaskList tasks = (AbstractTaskList) obj;
        if(tasks == null){
            return false;
        }else if(obj.getClass()!=this.getClass()){
            return false;
        }else if(tasks.size()!=this.size()){
            return false;
        }
        for(int i=0;i<this.size();i++){
            if(!(this.getTask(i) == tasks.getTask(i))){
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        //int result=7;
        // result = 31 * result + ((this.getTitle() == null) ? 0 : title.hashCode());
        // result=31*result+((start?start.hashCode():0);
        return Objects.hash(this);
    }
    @Override
    public AbstractTaskList clone() throws CloneNotSupportedException{
        AbstractTaskList clonedOb = (AbstractTaskList)super.clone();
        return clonedOb;
    }
    public final AbstractTaskList incoming(LocalDateTime from, LocalDateTime to){
        AbstractTaskList st = this instanceof ArrayTaskList?TaskListFactory.createTaskList(ListTypes.types.ARRAY):TaskListFactory.createTaskList(ListTypes.types.LINKED);
        this.getStream().filter(task -> (task.getStartTime().isAfter(from) && task.getEndTime().isBefore(to))).forEach(st::add);
        //task.nextTimeAfter(from).isBefore(to)
        /*
         ArrayList<Task> list = new ArrayList<>();
        Stream<Task> stream = list.stream();
        */
        return st;
    }
}

//   public LinkedTaskList incoming(int from, int to){
//        LinkedTaskList subsets= new LinkedTaskList();
//        if(head!=null){
//            LinkedTaskList.Node current=head;
//            while(current!= null){
//                if(current.value.getStartTime()>=from && current.value.getEndTime()<=to){
//                    subsets.add(current.value);
//                }
//                current = current.next;
//            }
//        }
//        return subsets;
//    }
