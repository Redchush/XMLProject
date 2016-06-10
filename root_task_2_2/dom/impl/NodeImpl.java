package root_task_2_2.dom.impl;


import root_task_2_2.dom.Node;
import root_task_2_2.dom.NodeList;
import root_task_2_2.dom.NodeNamedMap;

abstract class NodeImpl implements Node {

    protected NodeListImpl children = new NodeListImpl();
    protected String name;
    protected Node prevSibling;
    protected Node nextSibling;
    protected Node parent;
    protected String type;
    protected NodeNamedMap attributes;

    private int innerId;


    protected NodeImpl() {}

    protected NodeImpl(Node parent) {
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public NodeList getChildren() {
        return children;
    }

    @Override
    public void setChildren(NodeList children) {
        this.children = (NodeListImpl) children;
    }

    @Override
    public void addChild(Node element) {
        if (element != null) {
            children.addNode(element);
        }
    }

    @Override
    public boolean removeChild(Node element) {
        if (element != null) {
            children.getListOfNodes().remove(element);
            return true;
        }
        return false;
    }

    @Override
    public Node getPrevSibling() {
        return prevSibling;
    }

    @Override
    public void setPrevSibling(Node prevSibling) {
        this.prevSibling = prevSibling;
    }

    @Override
    public Node getNextSibling() {
        return nextSibling;
    }

    @Override
    public void setNextSibling(Node nextSibling) {
        this.nextSibling = nextSibling;
    }

    @Override
    public Node getParent() {
        return this.parent;
    }

    @Override
    public void setParent(Node root) {
        this.parent = root;
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public NodeNamedMap getAttributes() {
        return attributes;
    }

    @Override
    public void setAttributes(NodeNamedMap attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NodeImpl node = (NodeImpl) o;
        if (innerId != node.innerId) {
            return false;
        }
        if (children != null ? !children.equals(node.children) : node.children != null) {
            return false;
        }
        if (name != null ? !name.equals(node.name) : node.name != null) {
            return false;
        }
        if (attributes != null ? !attributes.equals(node.attributes) : node.attributes != null){
            return false;
        }
        if (prevSibling != null ?
                !prevSibling.getName().equals(node.prevSibling.getName()) : node.prevSibling != null) {
            return false;
        }
        if (nextSibling != null ?
                !nextSibling.getName().equals(node.nextSibling.getName()) : node.nextSibling != null) {
            return false;
        }
        if (parent != null ?
                !parent.getName().equals(node.parent.getName())
                : node.parent.getName() != null) {
            return false;
        }
        return type != null ? type.equals(node.type) : node.type == null;
    }

    @Override
    public int hashCode() {
        int result = children != null ? children.hashCode() : 0;
        result = 31 * result +
                (name != null ? name.hashCode() : 0);
        result = 31 * result +
                (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result +
                (prevSibling != null ? prevSibling.getName().hashCode() : 0);
        result = 31 * result +
                (nextSibling != null ? nextSibling.getName().hashCode() : 0);
        result = 31 * result +
                (parent.getName() != null ? parent.getName().hashCode() : 0);
        result = 31 * result +
                (type != null ? type.hashCode() : 0);
        result = 31 * result + innerId;
        return result;
    }

    @Override
    public String toString() {
        return "NodeImpl{" +
                ", innerId=" + innerId + "\'" +
                ", name='" + name + "\'" +
                ", type='" + type + "\'" +
                ", attributes='=" + attributes + "\'" +
                ", children='" + children + "\'" +
                ", parent='" + (parent == null ? null : parent.getName()) + "\'" +
                ", prevSibling='" + (prevSibling == null ? null : prevSibling.getName()) + "\'" +
                ", nextSibling='" + (nextSibling == null ? null : nextSibling.getName()) + "\'" +
                 '}' + "\n";
    }


    protected int getInnerId() {
        return innerId;
    }
    protected void setInnerId(int innerId) {
        this.innerId = innerId;
    }
}
