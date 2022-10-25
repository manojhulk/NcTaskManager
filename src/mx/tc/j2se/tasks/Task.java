/*
* Task class
* It describes about various classes
*/
package mx.tc.j2se.tasks;

public class Task {
    int start;
    int end;
    int interval;
    private int time;
    boolean repeat;
    private boolean active;
    private String title;
    public Task (String title, int time){
        this.title=title;
        this.repeat=false;
        this.time=time;
        if(this.time<0){
            throw new IllegalArgumentException("Time parameter should be positive");
        }
    }
    public Task (String title, int start, int end, int interval){
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

    public int getTime(){
        if(repeat){
            return time;
        }
        return 0;
    }
    public void setTime(int time){
        if(repeat){
            repeat=false;
            this.time=time;
        }
        if(this.time<0){
            throw new IllegalArgumentException("Time parameter should be positive");
        }
    }
    public int getStartTime(){
        if(repeat){
            return 0;
        }
        return this.time;
    }
    public int getEndTime(){
        return this.end;
    }
    public int getRepeatInterval(){
        if(!repeat){
            return 0;
        }
        return -1;
    }
    public void setTime(int start, int end, int interval){
        if(!repeat){
            this.start=start;
            this.end=end;
            this.interval=interval;
            this.repeat=true;
        }
        if(this.start<0 || this.end<0 || this.interval<0){
            throw new IllegalArgumentException("parameters should be positive");
        }

    }
    public int nextTimeAfter (int current){
        int present=current + start;
        if(present>end){
            return -1;
        }
        return present;
    }
}

