package root_task_2_2.dom;

public interface NodeList {

    boolean hasNext();

    int size();

    Node next();

    Node getNode(int index) throws IndexOutOfBoundsException;

    Node previous();
}
