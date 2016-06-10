package root_task_2_2.dom;

/**
 * Created by user on 28.05.2016.
 */
public interface Node {

    String getName();

    void setName(String name);

    NodeList getChildren();

    void setChildren(NodeList children);

    void addChild(Node element);

    boolean removeChild(Node element);

    Node getPrevSibling();

    void setPrevSibling(Node prevSibling);

    Node getNextSibling();

    void setNextSibling(Node nextSibling);

    Node getParent();

    void setParent(Node root);

    boolean hasChildren();

    String getType();

    NodeNamedMap getAttributes();

    void setAttributes(NodeNamedMap attributes);
}
