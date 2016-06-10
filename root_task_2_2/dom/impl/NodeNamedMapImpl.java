package root_task_2_2.dom.impl;

import root_task_2_2.dom.Node;

import java.util.*;


class NodeNamedMapImpl implements root_task_2_2.dom.NodeNamedMap {

    private Map<String, Node> elementMap;

    protected NodeNamedMapImpl() {
        elementMap = new TreeMap<>();
    }

    protected NodeNamedMapImpl(Map<String, Node> elements) {
        if (elements != null) {
            this.elementMap = elements;
        } else elements = new TreeMap<>();
    }

    protected void addElementMap(Map<String, Node> elementMap) {
        if (elementMap != null)
            this.elementMap = elementMap;
    }

    @Override
    public int getLength(){
        return elementMap.size();
    }

    @Override
    public Node getNamedItem(String name){
        return elementMap.get(name);
    }

    @Override
    public Node removeNamedItem(String name) {
        return elementMap.remove(name);
    }

    @Override
    public Node addNamedItem(Node node){
         return elementMap.put(node.getName(), node);
    }

    @Override
    public String toString() {
        return "NodeNamedMapImpl{" +
                "elementMap=" + elementMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NodeNamedMapImpl that = (NodeNamedMapImpl) o;

        return elementMap != null ? elementMap.equals(that.elementMap) : that.elementMap == null;

    }

    @Override
    public int hashCode() {
        return elementMap != null ? elementMap.hashCode() : 0;
    }
}
