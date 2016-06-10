package root_task_2_2.dom;

import java.util.List;

/**
 *
 */
public interface Document extends Node {

    void setRootElement(Element rootElement);

    void setDefaultElement();

    Element getRootElement();

    Element createNewElement(String name);

    Attribute createNewAttribute(String name, String value, boolean isId);

    Element createNewElement(Integer position, String tagName);

    List<Node> getElementsByTagName(String name);

    Text createNewTextElement(String value);

}
