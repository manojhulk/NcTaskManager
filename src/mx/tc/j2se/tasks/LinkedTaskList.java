package mx.tc.j2se.tasks;

import java.util.Arrays;
import java.util.stream.Stream;

public class LinkedTaskList extends AbstractTaskList {
    private int lenLink;
    private Node head = null;

    public static class Node {
        Task value;

        // connect each node to next node
        Node next;

        Node(Task data) {
            value = data;
            next = null;
        }
    }

    @Override
    public void add(Task data) {
        Node newNode = new Node(data);
        lenLink++;
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    @Override
    public boolean remove(Task ob) {
        Node node = head;
        int cost = 1;
        if (node.value == ob) {
            head = node.next;
            lenLink--;
            return true;
        } else {
            while (node.next.value != ob) {
                node = node.next;
                cost++;
                if (cost >= lenLink) {
                    return false;
                }
            }
            node.next = node.next.next;
            lenLink--;
            return true;
        }
    }
    @Override
    public int size() {
        return lenLink;
    }

    public void display() {
        if (head != null) {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
        } else {
            throw new IndexOutOfBoundsException("Empty list");
        }
    }

    /*
     * @index refers to the position of link
     * Here LinkedTaskList indexing starts from 1
     *
     */
    public Task getTask(int index) {
        int point = 1;
        if (index < 1 || index > lenLink) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + lenLink);
        }
        if (head != null) {
            Node currentNode = head;
            while (point != index) {
                currentNode = currentNode.next;
                point++;
            }
            return currentNode.value;
        }
        return null;
    }

    @Override
    public Stream<Task> getStream() {
        Stream.Builder<Task> streamTask = Stream.builder();
        for(Task i: this){
            streamTask.add(i);
        }
        Stream<Task> stream = streamTask.build();
        return stream;
        /*Task arr[] = new Task[this.size()];
        if (head != null) {
            Node currentNode = head;
            int i = 0;
            while (currentNode != null && i < this.size()) {
                arr[i] = currentNode.value;
                currentNode = currentNode.next;
                i++;
            }
        }
        Stream<Task> taskStream = Arrays.stream(arr);
        return taskStream;*/
    }
}

  /*  public boolean equals(Object obj) {
        //null instanceof Object will always return false
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LinkedTaskList))
            return false;
        if (((LinkedTaskList) obj).size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!(this.getTask(i) == ((LinkedTaskList) obj).getTask(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.hashCode();
    }
}

    public LinkedTaskList incoming(int from, int to){
        LinkedTaskList subsets= new LinkedTaskList();
        if(head!=null){
            LinkedTaskList.Node current=head;
            while(current!= null){
                if(current.value.getStartTime()>=from && current.value.getEndTime()<=to){
                    subsets.add(current.value);
                }
               current = current.next;
            }
        }
        return subsets;
    }*/

