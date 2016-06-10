package root_task_2_2.dom;

/**
 * Created by user on 03.06.2016.
 */
public interface Text extends Node {

    String getWholeText();

    void setWholeText(String wholeText);

    boolean isElementContentWhitespace();
}
