class MyLinkedList {

    node head;
    node tail;
    int size;
    private class node {
        int value;
        node next;

        node(int value){
            this.value = value;
            next = null;
            
        }
    }
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int get(int index) {
        node temp = this.head;
        if (index >= this.size || index < 0){
            return -1;
        }
        
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.value;
    }
    
    public void addAtHead(int val) {
        this.size++;
        node newNode = new node(val);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        this.size++;
        node newNode = new node(val);
        if (tail == null){
            tail = newNode;
            head = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
            return;
        }
        
        if (index > this.size || index < 0){
            return;
        }
        node newNode = new node(val);
        node temp = this.head;
        node prev = null;
        for (int i = 0; i < index; i++){
            prev = temp;
            temp = temp.next;
        }
        if (prev == tail){
            tail = newNode;
        }
        prev.next = newNode;
        newNode.next = temp;
        this.size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0){
            return;
        }
        if (index == 0){
            head = head.next;
            this.size--;
            return;
        }
        node temp = this.head;
        node prev = null;
        for (int i = 0; i < index; i++){
            prev = temp;
            temp = temp.next;
        }
        if (temp == this.tail){
            tail = prev;
        }
        prev.next = temp.next;
        temp.next = null;
        this.size--;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
    }
}

