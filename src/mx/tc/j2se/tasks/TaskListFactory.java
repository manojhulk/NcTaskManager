package mx.tc.j2se.tasks;

public class TaskListFactory {
    static AbstractTaskList createTaskList(ListTypes.types type){
        if(type== ListTypes.types.ARRAY){
            return new ArrayTaskList<>();
        }
        else{
            return new LinkedTaskList();
        }
    }
}
