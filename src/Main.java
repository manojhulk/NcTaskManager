import mx.tc.j2se.tasks.*;

public class Main {
    public static void main(String[] args) {
        Task ts = new Task("Morning run",24);
        Task ns = new Task("race",4,20,2);
        ArrayTaskList<Task> aList = new ArrayTaskList<>();
        aList.add(ts);
        aList.add(ns);
        //AbstractTaskList at=TaskListFactory.createTaskList(ARRAY);
        /*
        * @index starts from 1 in LinkedTaskList
        * */
        LinkedTaskList lt=new LinkedTaskList();
        lt.add(ts);
        lt.add(ns);

        //TaskListFactory tlo= new TaskListFactory();
        AbstractTaskList abt= TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        abt.add(ts);
        abt.add(ns);
        //System.out.println(abt.size());
        /*System.out.println(lt.getTask(1));
        *@result mx.tc.j2se.tasks.Task@1b6d3586
        *System.out.println(lt.remove(ts));
        *System.out.println(lt.size());
        *lt.display();
         */
        /*
        System.out.println(aList.getTask(0));
        System.out.println(aList.size());
        *@output 2
        */
        if(ts.isRepeated()){
            int restart = ns.getStartTime();
            int reEnd=ns.getEndTime();
            int inter=ns.getRepeatInterval();
            ns.setActive(false);
            ns.setTitle("race");
            ns.setTime(2,6,1);
            System.out.println(ns.isActive());
            System.out.println(restart+""+reEnd+""+inter+""+ns.getTitle());
        }else{
            int gt= ts.getTime();
            ts.setActive(false);
            ts.setTitle("Morning run");
            ts.setTime(10);
            System.out.println(ts.isActive());
            System.out.println("Not repeated"+gt+""+ts.getTitle());
        }
        System.out.println("Hello!");
    }
}