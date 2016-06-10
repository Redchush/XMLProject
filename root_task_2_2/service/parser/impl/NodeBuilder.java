package root_task_2_2.service.parser.impl;

import root_task_2_2.dom.*;
import root_task_2_2.dom.impl.DOMImplementation;

import java.util.Map;
import java.util.HashMap;

/**
 *
 */
public class NodeBuilder {
    private Document document;
    private Element element;

    public NodeBuilder(Document document, Integer id, String tagName) {
        this.document = document;
        element = document.createNewElement(id, tagName);
    }

    public Element createNewElement(Map<String, String> attributes,
                                    String content, Element parent,
                                    Element prevSibling) {
        setAttributeToElement(attributes);
        setTextToElement(content);
        setFamilyToElement(parent,prevSibling);
        return element;
    }

    protected void setAttributeToElement(Map<String, String> attributes){
        Map<String, Node> attributeMap = createAttributesMap(attributes);
        NodeNamedMap map = DOMImplementation.createNodeNamedMap(attributeMap);
        element.setAttributes(map);
    }

    protected  Map<String, Node> createAttributesMap(Map<String, String> attributes) {
        Map<String, Node> attributeMap = new HashMap<>();
        for (Map.Entry<String, String> entry : attributes.entrySet()){
            String value = entry.getValue();
            String name = entry.getKey();
            Attribute attribute = createAttribute(name, value);
            attributeMap.put(name, attribute);
        }

        return attributeMap;
    }

    protected Attribute createAttribute(String name, String value){
        boolean isId = name.equals("id");
        return document.createNewAttribute(name, value, isId);
    }

    ///

    protected void setTextToElement(String content){
        Text text = createTextElement(content);
        element.setTextElement(text);
    }

    protected Text createTextElement(String content){
        Text text = null;
        if (content == null) return text;

        if ( (!content.contains("<")) && (!content.trim().equals(""))) {
            text = document.createNewTextElement(content);
            text.setParent(element);
            text.setPrevSibling(null);
            text.setNextSibling(null);
            element.addChild(text);
        }
        return text;
    }

    ///

    protected void setFamilyToElement(Element parent,
                                    Element prevSibling){
        element.setParent(parent);
        element.setPrevSibling(prevSibling);
        if (prevSibling != null) {
            prevSibling.setNextSibling(element);
        }
    }

}
