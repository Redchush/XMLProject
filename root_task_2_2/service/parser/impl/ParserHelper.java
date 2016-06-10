package root_task_2_2.service.parser.impl;


import root_task_2_2.dom.Document;
import root_task_2_2.dom.Element;
import root_task_2_2.dom.impl.DOMImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;


public class ParserHelper {

    private static ParserHelper instance;

    private Document document;
    private boolean isReady = false;
    private ParserHelper(Document document){}

    public static ParserHelper getDomBuilder() {
        if (instance == null)
        {
            Document document = DOMImplementation.createDocument();
            document.setRootElement(null);
            instance = new ParserHelper(document);
            instance.document = document;
        }
        return instance;
    }

    protected boolean isReady() {
        return isReady;
    }

    protected Document getDocument() {
        return document;
    }


    /**
     *   String common = "<([^/]{1}[^>]+)[\\s]?([^> ]*)((>(.+?)</\\1>)|( />))";
     *   String group1= "<([^/]{1}[^> ]+)";
     *   String group2="[\\s]?([^>]*)";
     *   String group3_4= "(>(.+?)</\\1>)";
     *   String group4= "( />)";
     *   Pattern pattern = Pattern.compile(group1+group2+ "(" + group3 + "|" + group4 + ")")
     */

    protected  String defineMeta(String source){
        String attributes = source.substring(
                source.indexOf(ParserUtils.META_BEGIN),
                source.indexOf(ParserUtils.META_END));
        Map<String, String> attributesMap = new HashMap<>();
        parseAttributes(attributes, attributesMap);

        return source.replace(ParserUtils.META_BEGIN, "")
                     .replace(ParserUtils.META_END, "");
    }

    protected  String clipMeta(String bounds){
        return bounds.substring(
                bounds.indexOf(ParserUtils.META_END)
        );
    }

    protected void buildElementTree(String source){
        findAllTags(source, source, null);
        isReady = true;
        document.setDefaultElement();
    }

    /**
     *  matcher.group(1) //tag name
     *  matcher.group(2)  //attributes
     *  matcher.group(3)  //works,  the /> indicates simpleTag
     *  matcher.group(4) //works
     *  matcher.group(5)); //content
     */
    private void findAllTags(String source,
                                      String initialSource,
                                      Element parent){
        Matcher matcher =ParserUtils.TAG_PATTERN. matcher(source);
        Integer id;
        String tagName;
        String content;

        Element prevSibling = null;
        Element nextSibling = null;

        int indexToStart = initialSource.indexOf(source);
        Map<String, String> attributes = new HashMap<>();

        while (matcher.find()) {
            String element = matcher.group();
            tagName = matcher.group(1);
            content = matcher.group(5);
            id = initialSource.indexOf(matcher.group(), indexToStart);
            String temp = matcher.group(2);

            if (temp.length() > 1){
                parseAttributes(temp, attributes);
            }
            NodeBuilder builder = new NodeBuilder(document, id, tagName);

            Element current =  builder.createNewElement(attributes, content,
                                                        parent, prevSibling);
            if (parent != null) {
                parent.addChild(current);
            }
            prevSibling = current;
            if (element.contains("<")){
                findAllTags(element.substring(1).trim(), initialSource, current);
            }
        }
    }


    private void parseAttributes(String bounds, Map<String, String> attributeMap){
        String[] attr = bounds.split("\" ");
        String[] concrete;

        if (attr.length == 0)
            attr = bounds.split("=");

        for (String elem : attr){
             concrete = elem.split("=");
             attributeMap.put(concrete[0], concrete[1].replace("\"", ""));
        }
    }



}
