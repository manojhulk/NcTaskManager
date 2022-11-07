import mx.tc.j2se.tasks.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Iterator;

import static mx.tc.j2se.tasks.Tasks.incoming;

public class Main {
    public static void main(String[] args) {
       /* Task ts = new Task("Morning run", 20);
        Task ns = new Task("race",4,20,2);
        Task t3 = new Task("Playing",8,25,2);
        */

        //Task2
        /*Creation of ArrayTaskList object
        * Addition of tasks to list
        * Removal of task
        * Display of tasks
        * Getting size of list
        * */

        /*ArrayTaskList<Task> aList = new ArrayTaskList<>();
        aList.add(ts);
        aList.add(ns);
        aList.add(t3);
        aList.remove(ts);
        aList.display();
        System.out.println(aList.size());
        System.out.println(aList.getTask(0));
        System.out.println(aList.size());
        *@output 2
        */

        /* LinkedTaskList creation
        * @index starts from 1 in LinkedTaskList
        * Adding tasks
        * Removal of tasks
        * size of list
        * Display of linkedTaskList
        * */
        /*LinkedTaskList lt=new LinkedTaskList();
        lt.add(ts);
        lt.add(ns);
        lt.add(t3);
        lt.remove(ts);
        System.out.println(lt.size());
        lt.display();*/

        //Task 4
        //TaskListFactory tlo= new TaskListFactory();
        /* AbstractTaskList abt= TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        abt.add(ts);
        abt.add(ns);*/
        //System.out.println(abt.size());
        /*System.out.println(lt.getTask(1));
        *@result mx.tc.j2se.tasks.Task@1b6d3586
        *System.out.println(lt.remove(ts));
        *System.out.println(lt.size());
        *lt.display();

        /** LINKED LIST CREATION using Abstract task list **/
        /*AbstractTaskList linkList = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        linkList.add(ts);
        linkList.add(ns);
        System.out.println(linkList.size());
        linkList.getTask(1);
        System.out.println(linkList.toString());*/


        // Task 1
        /*if(ts.isRepeated()){
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
        }*/

        /** Iterator for ArrayTaskList**/

        /*AbstractTaskList abt= TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        Iterator<Task> it=abt.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }*/

        //Task 5
        /** Creating object for abstractTaskList and implementing equals() and hashCode() methods**/
        /*AbstractTaskList at1=TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        at1.add(ts);
        at1.add(ns);
        at1.add(t3);
        int hashValue1=at1.hashCode();
        int hashValue2=abt.hashCode();
        System.out.println(hashValue1);
        System.out.println(hashValue2);
        System.out.println(at1.equals(abt));
        // clone of tasks
        System.out.println(at1.clone());
        System.out.println(abt.clone());
        */
        /*

        */
        Task tk1=new Task("Lunch with Beautiful girl", LocalDateTime.of(2022, Month.valueOf("AUGUST"),24,16,00));
        Task tk2=new Task("Morning run",LocalDateTime.of(2022, Month.valueOf("MARCH"),1,8,15),LocalDateTime.of(2022, Month.valueOf("SEPTEMBER"),1,8,15), 24);
        Task tk3=new Task("Taking Medication",LocalDateTime.of(2022,Month.valueOf("AUGUST"),20,8,15),LocalDateTime.of(2022,Month.valueOf("SEPTEMBER"),28,8,15),12);
        Task tk4=new Task("Meeting with friends",LocalDateTime.of(2022,Month.valueOf("SEPTEMBER"),1,18,0));
        //System.out.println(tk2.nextTimeAfter(LocalDateTime.of(2022, Month.valueOf("AUGUST"),24,8,15)));
        //TaskListFactory tlf=new TaskListFactory();
        AbstractTaskList at= TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        at.add(tk1);
        at.add(tk2);
        at.add(tk3);
        at.add(tk4);
        //at.display();
        Iterator<Task> it=at.iterator();
        Iterator<Task> item= incoming(it,LocalDateTime.of(2022,Month.valueOf("AUGUST"),25,8,0),LocalDateTime.of(2022,Month.valueOf("AUGUST"),26,8,0));
        while(item.hasNext()){
            System.out.println(item.next().getTitle());
        }
        System.out.println("THE END");
    }
}