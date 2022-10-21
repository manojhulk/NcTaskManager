package mx.tc.j2se.tasks;
import java.util.*;

public class ArrayTaskList<task> {
    private static final int INITIAL_CAPACITY = 10;
    private int len = 0;
    private Task[] elementData ={};
    /**
     *
     * constructor of custom ArrayList
     */
    public ArrayTaskList(){

        elementData= new Task[INITIAL_CAPACITY];
    }
    /**
     *
     * constructor of parameterized ArrayList
     * @param cap  indicates the size that we pass
     */
    public ArrayTaskList(int cap){
        elementData= new Task[cap];
    }
    /**
     * add elements in custom/your own ArrayList
     * Method adds elements in ArrayListCustom.
     */

    public void add (Task task){
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
    * @getIndex() method gets the index of Task task
    * @taskIndex is the index of specified task
    *
    */

    public boolean remove (Task task){
        int taskIndex = getIndex(task);
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
    public int size(){
        return len;
    }
    public Task getTask(int index){
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + len);
        }
        return elementData[index];
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
