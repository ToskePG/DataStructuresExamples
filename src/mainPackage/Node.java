package mainPackage;

public class Node {
	
	private Car data;
    private Node next;

    Node(Car car) {
        this.data = car;
        this.next = null;
    }

    public Car getData() {
        return data;
    }

    public void setData(Car data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
