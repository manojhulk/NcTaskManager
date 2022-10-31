/*
* Task class
* It describes about various classes
*/
package mx.tc.j2se.tasks;
import java.time.LocalDateTime;
import java.time.LocalDateTime.*;
import java.time.LocalTime;

public class Task {
    String title;
    LocalDateTime start;
    LocalDateTime end;
    LocalDateTime current;
    LocalDateTime time;
    LocalTime interval;
    boolean repeat;
    boolean active;

    /*
    * constructor for non-repetitive tasks
    *
     */
    public Task (String title, LocalDateTime time){
        if(time.getHour()<0 && time.getMinute()<0){
            throw new IllegalArgumentException("Time parameter should be positive");
        }
        this.title = title;
        this.time = time;
        this.repeat = false;
        this.active = true;
    }
    /*
    * Constructor for repetitive tasks
    *
    */
    public Task (String title, LocalDateTime start, LocalDateTime end, LocalTime interval){
        if(start.getHour()<0 || end.getHour()<0 || start.getMinute()<0 || end.getMinute()<0) {
            throw new IllegalArgumentException("Time values cannot be negative");
        }
        if (interval.getHour()< 0) {
            throw new IllegalArgumentException("The interval for repeating tasks should be greater than zero.");
        }
        this.title=title;
        this.start=start;
        this.end=end;
        this.interval=interval;
        this.repeat=true;
        this.active = true;
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
        return repeat;
    }

    @Override
    public String toString() {
        return "Task{" +
                "start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", time=" + time +
                ", repeat=" + repeat +
                ", active=" + active +
                ", title='" + title + '\'' +
                '}';
    }
    public void setTime(LocalDateTime time){
        if(isRepeated()){
            repeat=false;
            this.time=time;
        }
        if(this.time.getHour()<0){
            throw new IllegalArgumentException("Time parameter should be positive");
        }
    }
    public LocalDateTime getTime(){
        if(isRepeated()){
            return getStartTime();//getStartTime()
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
            return this.end;
        }
        return time;
    }
    public LocalTime getRepeatInterval(){
        if(!isRepeated()){
            return LocalTime.of(0,0,0);
        }
        return interval ;
    }
    public void setTime(LocalDateTime start, LocalDateTime end, LocalTime interval){
        if(!isRepeated()){
            this.start=start;
            this.end=end;
            this.interval=interval;
            this.repeat=true;
        }
        if(this.start.getHour()<0 || this.end.getHour()<0 || this.interval.getHour()<0){
            throw new IllegalArgumentException("parameters should be positive");
        }

    }
    public LocalDateTime nextTimeAfter (LocalDateTime current){
        LocalDateTime present=current.plusHours(interval.getHour());
        present=present.plusMinutes(interval.getMinute());
        if(current.plusHours(interval.getHour()).isBefore(end)){
            active=true;
            current=current.plusHours(interval.getHour());//long interval
            return current;
        }
        active=false;
        return LocalDateTime.parse("-1");
    }
}

