package root_task_2_2.dom;

/**
 * Created by Student on 02-Jun-16.
 */
public interface Attribute extends Node {

    Element getOwnerElement();

    String getValue();

    boolean isId();

    void setValue(String value);
}
