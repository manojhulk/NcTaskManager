/*
* Task class
* It describes about various classes
*/
package mx.tc.j2se.tasks;
import java.time.LocalDateTime;
import java.time.LocalDateTime.*;
import java.time.LocalTime;

public class Task {
    LocalDateTime start;
    LocalDateTime end;
    LocalTime interval;
    private LocalDateTime time;
    boolean repeat;
    private boolean active;
    private String title;
    public Task (String title, LocalDateTime time){
        this.title=title;
        this.repeat=false;
        this.time=time;
        if(time.getHour()<0){
            throw new IllegalArgumentException("Time parameter should be positive");
        }
    }
    public Task (String title, LocalDateTime start, LocalDateTime end, LocalTime interval){
        this.title=title;
        this.start=start;
        this.end=end;
        this.interval=interval;
        this.repeat=true;
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

    public LocalDateTime getTime(){
        if(repeat){
            return time;
        }
        return null;
    }
    public void setTime(LocalDateTime time){
        if(repeat){
            repeat=false;
            this.time=time;
        }
        if(this.time.getHour()<0){
            throw new IllegalArgumentException("Time parameter should be positive");
        }
    }
    public LocalDateTime getStartTime(){
        if(repeat){
            return null;
        }
        return this.time;
    }
    public LocalDateTime getEndTime(){
        return this.end;
    }
    public LocalTime getRepeatInterval(){
        if(!repeat){
            return LocalTime.of(0,0,0);
        }
        return interval ;
    }
    public void setTime(LocalDateTime start, LocalDateTime end, LocalTime interval){
        if(!repeat){
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
        if(present.getHour()>end.getHour()){
            return null;
        }
        return present;
    }
}

