package root_task_2_2.dom.impl;

import root_task_2_2.dom.Node;
import root_task_2_2.dom.NodeList;

import java.util.*;


class NodeListImpl implements NodeList {

    private LinkedList<Node> nodes = new LinkedList<>();
    private ListIterator<Node> listIterator;

    protected NodeListImpl(){
        listIterator = nodes.listIterator();
    }

    protected NodeListImpl(List<Node> nodes) {
        this.nodes.addAll(nodes);
        listIterator = nodes.listIterator();
    }

    @Override
    public boolean hasNext(){
        return listIterator.hasNext();
    }

    @Override
    public int size(){
        return nodes.size();
    }

    @Override
    public Node next() {
        if (listIterator.hasNext()) {
            return listIterator.next();
        }
        else return null;
    }

    @Override
    public Node previous() {
        if (listIterator.hasPrevious()) {
            return listIterator.previous();
        }
        else return null;
    }

    @Override
    public Node getNode(int index) throws IndexOutOfBoundsException{
        return nodes.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NodeListImpl nodeList = (NodeListImpl) o;

        if (nodes != null ? !nodes.equals(nodeList.nodes) : nodeList.nodes != null) {
            return false;
        }
        return listIterator != null ? listIterator.equals(nodeList.listIterator) : nodeList.listIterator == null;

    }

    @Override
    public int hashCode() {
        int result =
                (nodes != null) ? nodes.hashCode() : 0;
        result = 31 * result + (listIterator != null ?
                listIterator.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "NodeListImpl{" +
                "nodes=" + nodes +
                ", listIterator=" + listIterator +
                '}';
    }

    protected List<Node> getListOfNodes(){
        return nodes;
    }
    protected boolean isEmpty(){
        return nodes.isEmpty();
    }

    protected boolean addNode(Node node){
        boolean b = nodes.add(node);
        listIterator = nodes.listIterator();
        return b;
    }
    protected void addFirst(Node node){
        listIterator = nodes.listIterator();
        nodes.addFirst(node);
    }



}
