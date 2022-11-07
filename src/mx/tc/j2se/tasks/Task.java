/*
* Task class
* It describes about various classes
*/
package mx.tc.j2se.tasks;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Task {
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime current;
    private LocalDateTime time;
    private long interval;
    private boolean repeat;
    private boolean active;

    /*
    * constructor for non-repetitive tasks
    *
     */
    public Task (String title, LocalDateTime time){
        if(time== null || title==null){
            throw new IllegalArgumentException("Time parameter should be positive and Title should be provided");
        }
        this.title = title;
        this.time = time;
        this.repeat = false;
        this.active = false;
    }
    /*
    * Constructor for repetitive tasks
    *
    */
    public Task (String title, LocalDateTime start, LocalDateTime end, long interval){
        if(start.getHour()<=0 || end.getHour()<=0 || start.getMinute()<0 || end.getMinute()<0|| interval<0||title==null) {
            throw new IllegalArgumentException("Time values and interval should be positive and greater than zero,title cannot be null");
        }
        this.title=title;
        this.start=start;
        this.end=end;
        this.interval=interval;
        this.repeat=true;
        this.active = false;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public boolean isActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active=active;
    }
    public boolean isRepeated(){
        return this.repeat;
    }


    @Override
    public String toString() {
        return this.isRepeated()?"RepetitiveTask{" +
                " title='" + title +
                ", start=" + this.getStartTime() +
                ", end=" + this.getEndTime() +
                ", interval=" + this.getRepeatInterval() +
                ", repeat=" + this.isRepeated() +
                ", active=" + this.isActive() + '\'' +
                '}': "Non-repetitive task{\n" +
                "title=" + this.getTitle() +
                ", time=" + this.getTime() +
                ", active=" + this.isActive() + '\'' +
                '}';
    }
    public void setTime(LocalDateTime time){
        if(this.time.getHour()<=0){
            throw new IllegalArgumentException("Time parameter should be positive");
        }
        if(isRepeated()){
            this.repeat=false;
            this.start=null;
            this.end=null;
            this.interval=0;
        }
        this.time=LocalDateTime.from(time);
    }
    public LocalDateTime getTime(){
        if(isRepeated()){
            return start;//getStartTime()
        }
        return time;
    }
    public LocalDateTime getStartTime(){
        if(isRepeated()){
            return start;
        }
        return time;
    }
    public LocalDateTime getEndTime(){
        if(isRepeated()){
            return end;
        }
        return time;
    }
    public long getRepeatInterval(){
        if(!isRepeated()){
            return 0;
        }
        return interval;
    }
    public void setTime(LocalDateTime start, LocalDateTime end, long interval){
        if(start.getHour()<0 || end.getHour()<0 || interval<0){
            throw new IllegalArgumentException("parameters should be positive values");
        }
        if(!isRepeated()){
            this.start=LocalDateTime.from(start);
            this.end=end;
            this.interval=interval;
            this.time=null;
            this.repeat=true;
        }else {
            this.start=LocalDateTime.from(start);
            this.end=end;
            this.interval=interval;
        }
    }
    public LocalDateTime nextTimeAfter (LocalDateTime current){
        LocalDateTime nextTime;
        if(!isActive()){
            nextTime=LocalDateTime.MIN;
        } else if (!isRepeated()) {
            nextTime=current.isBefore(time)?time:LocalDateTime.MIN;
        }else {
            if(current.isAfter(end)){
                nextTime=LocalDateTime.MIN;
            } else if (current.isBefore(start)) {
                nextTime=start;
            }else {
                LocalDateTime nextSlot =start.plusHours(interval);
                while(nextSlot.isBefore(current)|| nextSlot.isEqual(current)){
                    nextSlot=nextSlot.plusHours(interval);
                }
                nextTime=nextSlot.isBefore(end)?nextSlot:LocalDateTime.MIN;
            }
        }
        return nextTime;
    }

    @Override
    public boolean equals(Object obj) {
        Task currTask= (Task) obj;
        if (currTask==null|| this.getClass()!=currTask.getClass()){
            return false;
        } else if (this==currTask || (this.getTitle()==currTask.getTitle()) && (this.getStartTime()==currTask.getStartTime())&&(this.getEndTime()==currTask.getEndTime())&&(this.isActive()==currTask.isActive())&&(this.isRepeated()==currTask.isRepeated())&&(this.getRepeatInterval()==currTask.getRepeatInterval())&&(this.getTime()==currTask.getTime())) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.title,this.start,this.end,this.time,this.active,this.repeat);
    }
    public Task clone() throws CloneNotSupportedException {
        Task clonedOb;
        try {
            clonedOb = (Task) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedOb;
    }
}

