import mx.tc.j2se.tasks.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Iterator;

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


        // Task 1


        /** Iterator for ArrayTaskList**/



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
        /*if(tk1.isRepeated()){
            LocalDateTime restart = tk1.getStartTime();
            LocalDateTime reEnd=tk1.getEndTime();
            long inter=tk1.getRepeatInterval();
            tk1.setActive(false);
            tk1.setTitle("race");
            //tk1.setTime(LocalDateTime.of(2022, Month.valueOf("AUGUST"),24,16,00),LocalDateTime.of(2022, Month.valueOf("AUGUST"),24,16,00),2);
            System.out.println(tk1.isActive());
            System.out.println(restart+""+reEnd+""+inter+""+tk1.getTitle());
        }else{
            LocalDateTime gt= tk1.getTime();
            tk1.setActive(false);
            tk1.setTitle("Morning run");
            System.out.println(tk1.isActive());
            System.out.println("Not repeated"+gt+""+tk1.getTitle());
        }*///System.out.println(tk2.nextTimeAfter(LocalDateTime.of(2022, Month.valueOf("AUGUST"),24,8,15)));
        //TaskListFactory tlf=new TaskListFactory();


        AbstractTaskList at= TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        at.add(tk1);
        at.add(tk2);
        at.add(tk3);
        at.add(tk4);
        //System.out.println(at.remove(tk1));
        //System.out.println(at.size());
        //System.out.println(at.getTask(1));
        //System.out.println(at.toString());

        /** LINKED LIST CREATION using Abstract task list **/
        /*LinkedTaskList linkList = new LinkedTaskList();//TaskListFactory.createTaskList(ListTypes.types.LINKED);
        linkList.add(tk1);
        linkList.add(tk2);
        System.out.println(linkList.size());
        System.out.println(linkList.toString());*/
        //System.out.println(at.incoming(LocalDateTime.of(2022, Month.valueOf("AUGUST"),24,8,15),LocalDateTime.of(2022, Month.valueOf("AUGUST"),24,8,15)));
        /*Iterator<Task> it=at.iterator();
        Iterator<Task> item= incoming(it,LocalDateTime.of(2022,Month.valueOf("AUGUST"),25,8,0),LocalDateTime.of(2022,Month.valueOf("AUGUST"),26,8,0));
        while(item.hasNext()){
            System.out.println(item.next().getTitle());
        }*/

        AbstractTaskList abt= TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        abt.add(tk1);
        Iterator<Task> it=abt.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        //System.out.println(abt.equals(at));

        System.out.println(abt.incoming(LocalDateTime.of(2022,Month.valueOf("AUGUST"),25,8,0),LocalDateTime.of(2022,Month.valueOf("AUGUST"),26,8,0)));

        System.out.println("THE END");
    }
}