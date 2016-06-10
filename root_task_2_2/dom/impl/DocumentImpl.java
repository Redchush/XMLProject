package root_task_2_2.dom.impl;


import root_task_2_2.dom.*;

import java.util.*;


class DocumentImpl extends NodeImpl implements Document {

    private static int counter = 0;
    private final String name = DomUtils.DOCUMENT;
    private NodeNamedMap attributes;
    private Element rootElement;
    private NavigableMap<Integer, Node> innerNodeMap = new TreeMap<>();

    protected DocumentImpl() {
        super.setParent(null);
        super.setNextSibling(null);
        super.setPrevSibling(null);
        super.name = this.name;
    }

    protected DocumentImpl(NodeNamedMap attributes) {
        this();
        this.attributes = attributes;
    }

    @Override
    public void setRootElement(Element rootElement) {
        this.rootElement = rootElement;
    }

    @Override
    public Element getRootElement() {
        return this.rootElement;
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public NodeList getChildren() {
        return new NodeListImpl(Collections.singletonList((Node) rootElement));
    }

    @Override
    public void setParent(Node root) {}

    @Override
    public void setDefaultElement() {
        this.rootElement = (Element) innerNodeMap.firstEntry().getValue();
    }

    @Override
    public Element createNewElement(String name) {
        ElementImpl element = new ElementImpl();
        int id = generateId();
        element.setInnerId(id);
        return element;
    }

    @Override
    public Element createNewElement(Integer innerId, String tagName){
        ElementImpl element = new ElementImpl(tagName);
        element.setInnerId(innerId);
        innerNodeMap.put(innerId, element);
        return element;
    }

    @Override
    public Attribute createNewAttribute(String name, String value, boolean isId) {
        AttributeImpl element = new AttributeImpl(name, value, isId);
        int id = generateId();
        element.setInnerId(id);
        return element;
    }

    @Override
    public Text createNewTextElement(String value) {
        return new TextImpl(value);
    }

    @Override
    public List<Node> getElementsByTagName(String name) {
        List<Node> elements = new ArrayList<>();
        for (Node element : innerNodeMap.values()) {
            if (element.getName().equals(name))
                elements.add(element);
        }
        return elements;
    }


    @Override
    public String toString() {
        return "DocumentImpl{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", rootElement=" + rootElement +
                ", innerNodeMap=" + innerNodeMap +
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
        if (!super.equals(o)) {
            return false;
        }
        DocumentImpl document = (DocumentImpl) o;
        if (!name.equals(document.name)) {
            return false;
        }
        if (attributes != null ?
                !attributes.equals(document.attributes) : document.attributes != null) {
            return false;
        }
        if (rootElement != null ?
                !rootElement.equals(document.rootElement) : document.rootElement != null) {
            return false;
        }
        return innerNodeMap != null ?
                innerNodeMap.equals(document.innerNodeMap) : document.innerNodeMap == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name.hashCode());
        result = 31 * result +
                (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result +
                (rootElement != null ? rootElement.hashCode() : 0);
        result = 31 * result +
                (innerNodeMap != null ? innerNodeMap.hashCode() : 0);
        return result;
    }

    private int generateId() {
        return counter--;
    }

}
