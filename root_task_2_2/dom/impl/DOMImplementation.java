package root_task_2_2.dom.impl;

import root_task_2_2.dom.Document;
import root_task_2_2.dom.Node;
import root_task_2_2.dom.NodeList;
import root_task_2_2.dom.NodeNamedMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 03.06.2016.
 */
public class DOMImplementation {

    private DOMImplementation(){}

    public static Document createDocument(){
        return new DocumentImpl();
    }

    public static NodeList createNodeList( List<Node> list){
        return new NodeListImpl(list);
    }

    public static NodeNamedMap createNodeNamedMap(Map<String, Node> map){
        return new NodeNamedMapImpl(map);
    }
}
