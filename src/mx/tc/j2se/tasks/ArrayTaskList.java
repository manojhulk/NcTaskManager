package mx.tc.j2se.tasks;
import java.util.*;

public class ArrayTaskList<task> extends AbstractTaskList implements Cloneable {
    private static final int INITIAL_CAPACITY = 10;
    private int len = 0;
    private Task[] elementData={};
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
        return len;
    }
    @Override
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
    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList subsets= new ArrayTaskList();
        for(Task t:elementData){
            if(t.getStartTime()>=from && t.getStartTime()<=to){
                subsets.add(t);
            }else{
                throw new IndexOutOfBoundsException("Time must be with in the range") ;
            }
        }
        return subsets;
    }
    public boolean equals(Object obj) {
        //null instanceof Object will always return false
        if(obj==null){
            return false;
        }
        if (!(obj instanceof ArrayTaskList))
            return false;
        if(((ArrayTaskList) obj).size()!=this.size()){
            return false;
        }
        for(int i=0;i<this.size();i++){
            if(!(this.getTask(i) == ((ArrayTaskList) obj).getTask(i))){
                return false;
            }
        }
        return true;
    }
    public int hashCode() {
        return 0;
    }
    public Object clone() throws CloneNotSupportedException{
        ArrayTaskList clonedOb = (ArrayTaskList)super.clone();
        return clonedOb;
    }
}
