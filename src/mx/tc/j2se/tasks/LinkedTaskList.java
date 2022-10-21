package mx.tc.j2se.tasks;

public class LinkedTaskList {

    private Task data;
    private int lenLink;
    private LinkedTaskList nextNode;
    LinkedTaskList head;

    public LinkedTaskList(Task data){
        this.data = data;
    }

    public Task getData() {
        return data;
    }

    public void setData(Task data) {
        this.data = data;
    }

    public LinkedTaskList getNextNode() {
        return nextNode;
    }
    public void setNextNode(LinkedTaskList nextNode) {
        this.nextNode = nextNode;
    }
    public void add(Task data){
        LinkedTaskList newNode = new LinkedTaskList(data);
        lenLink++;
        if(this.head == null){
            head = newNode;
        }else {
            LinkedTaskList currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }
    public boolean deleteTask(Task ob){
        LinkedTaskList node = head;
        int cost=1;
        while(node.getNextNode().getData() != ob && node.getNextNode()!=null){
            node = node.getNextNode();
            cost++;
        }
        if(cost<lenLink){
            node.setNextNode(node.getNextNode().getNextNode());
            return true;
        }
        lenLink--;
        return false;
    }
    public int size(){
        return this.lenLink;
    }
    public void display(){
        if(head != null){
            LinkedTaskList currentNode = head;
            while(currentNode.getNextNode() != null){
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData());
        }
    }
    /*
    * @index refers to the position of link
    * Here LinkedTaskList indexing starts from 1
    *
    */
    public Task getTask(int index){
        int point=1;
        if (index < 1 || index >lenLink) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + lenLink);
        }
        if(head != null){
            LinkedTaskList currentNode = head;
            while(point!=index){
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getData();
        }
        return null;
    }

}
