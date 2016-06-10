package root_task_2_2.dom;

/**
 * Created by user on 03.06.2016.
 */
public interface NodeNamedMap {

    int getLength();

    Node getNamedItem(String name);

    Node removeNamedItem(String name);

    Node addNamedItem(Node node);
}
