package root_task_2_2.dom.impl;


import root_task_2_2.dom.*;


class ElementImpl extends NodeImpl implements Element {

    private Text textElement;

    protected ElementImpl() {
        super.type = DomUtils.ELEMENT;
    }

    protected ElementImpl(String tagName){
        this();
        super.name = tagName;
    }

    @Override
    public Element getParent() {
        return (Element) super.parent;
    }

    @Override
    public Element getPrevElementSibling() {
       return this.prevSibling.getType().equals(DomUtils.ELEMENT)?
               (Element) this.prevSibling : getNextElementSibling();
    }

    @Override
    public Element getNextElementSibling() {
        return (Element) super.nextSibling;
    }

    @Override
    public String getTextContent() {
        if (textElement != null) {
            this.textElement.getWholeText();
        }
        return null;
    }


    @Override
    public void setTextContent(String textElement) {
        if (textElement != null) {
            this.textElement.setWholeText(textElement);
        }
    }

    @Override
    public void setTextElement(Text content) {
        this.textElement = content;
    }

    @Override
    public Text getTextElement() {
        return textElement;
    }



    @Override
    public NodeList getChildrenElementsByTagName(String name) {
        NodeListImpl list = new NodeListImpl();
        Node child;
        while ( (child = children.next()) != null){
            if (child.getType()
                        .equals(DomUtils.ELEMENT))
            {
                list.addNode(child);
            }
        }
        return list;
    }

    @Override
    public Attribute getAttribute(String name) {
        return (Attribute) super.attributes.getNamedItem(name);
    }

    @Override
    public void addChild(Node element) {
        if (element != null) {
           if (element.getType().equals(DomUtils.ATTRIBUTE)) {
                children.addFirst(element);
            } else super.addChild(element);
        }
    }

    protected ElementImpl(Node parent) {
        super(parent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public NodeList getChildren() {
        return super.getChildren();
    }

    @Override
    public void setChildren(NodeList children) {
        super.setChildren(children);
    }

    @Override
    public boolean removeChild(Node element) {
        return super.removeChild(element);
    }

    @Override
    public Node getPrevSibling() {
        return super.getPrevSibling();
    }

    @Override
    public void setPrevSibling(Node prevSibling) {
        super.setPrevSibling(prevSibling);
    }

    @Override
    public Node getNextSibling() {
        return super.getNextSibling();
    }

    @Override
    public void setNextSibling(Node nextSibling) {
        super.setNextSibling(nextSibling);
    }

    @Override
    public void setParent(Node root) {
        super.setParent(root);
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    protected int getInnerId() {
        return super.getInnerId();
    }

    @Override
    protected void setInnerId(int innerId) {
        super.setInnerId(innerId);
    }

    @Override
    public String toString() {
       return "ElementImpl{" +
                super.toString() +
               "textElement=" + textElement +
                 '}';
    }


}
