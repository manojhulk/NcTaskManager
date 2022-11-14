package mx.tc.j2se.tasks;
import java.util.*;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList {
    private static final int INITIAL_CAPACITY = 10;
    private int len = 0;
    private Task[] elementData;
    /**
     *
     * constructor of custom ArrayList
     */
    public ArrayTaskList(){

        elementData= new Task[INITIAL_CAPACITY];
    }
    /**
     *
     * ArrayTaskList parameterized constructor
     * @param cap  indicates the size that we pass to constructor
     *  throws exception if @cap is negative
     */
    public ArrayTaskList(int cap){

        if(cap<0){
            throw new IllegalArgumentException("Time parameter should be positive");
        } else {
            elementData= new Task[cap];
        }
    }
    /**
     * add elements in custom/your own ArrayList
     * Method adds elements in ArrayListCustom.
     */
    @Override
    public void add (Task task){
        if(task == null){
            throw new IllegalArgumentException("task cannot be null");
        }
        if(len == elementData.length){
            increaseCapacity();
        }
        elementData[len++]=task;
    }
    /*
    * Increasing the capacity of elementData array size
    *
    */
    private void increaseCapacity() {
        int newCapacity=elementData.length*2;
        elementData=Arrays.copyOf(elementData,newCapacity);
    }

    /*
    * @getIndex() method gets the index of @Task task
    * @taskIndex is the index of specified task
    *
    */
    @Override
    public boolean remove (Task task){
        int taskIndex = getIndex(task);
        if(task == null){
            throw new IllegalArgumentException("task cannot be null");
        }
        if(taskIndex!=-1){
            for (int i = taskIndex; i < len - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            len--;
            return true;
        }
        return false;
    }

    /*
    * METHOD to get size of array elementData
    */
    @Override
    public int size(){
        return this.elementData.length;
    }
    @Override
    public Task getTask(int index){
        if (index < 0 || index >len) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                        + len);
        }
        return elementData[index];
    }

    @Override
    public Stream<Task> getStream() {
        //Stream<Task> taskStream= Arrays.stream(elementData);
        Stream.Builder<Task> streamTask = Stream.builder();
        for(Task i: this){
            streamTask.add(i);
        }
        Stream<Task> stream = streamTask.build();
        return stream;
        //Spliterator<task> mySpliterator = new arraySpliterator(elementData);
        // Here we are Defining our own stream using stream support
        //return StreamSupport.stream(mySpliterator, false);
        //return Stream.of(elementData) ;
    }

    public int getIndex(Task ob){
        int point=0;
        for(Task var: elementData){
            if(var == ob){
                return point;
            }
            point++;
        }
        return -1;
    }
}
