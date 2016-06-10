package root_task_2_2.dom;

/**
 * Created by user on 28.05.2016.
 */
public interface Element extends Node {

    String getTextContent();

    Text getTextElement();

    void setTextContent(String text);

    void setTextElement(Text text);

    NodeList getChildrenElementsByTagName(String name);

    Attribute getAttribute(String name);

    Element getPrevElementSibling();

    Element getNextElementSibling();
}
