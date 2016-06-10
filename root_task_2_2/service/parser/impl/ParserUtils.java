package root_task_2_2.service.parser.impl;

import java.util.regex.Pattern;


class ParserUtils {

    protected static final String XML_ENTER_STRING = "<\\?xml(.*)?\\?>";
    protected static final String META_BEGIN = "<?xml";
    protected static final String META_END = "?>";
    protected static final String GENERAL_PATTERN = "<([^/]{1}[^> ]+)[\\s]?([^>]*)((>(.+?)</\\1>)|( />))";

    protected static final Pattern TAG_PATTERN = Pattern.compile(GENERAL_PATTERN);
    protected static final Pattern XML_META = Pattern.compile(XML_ENTER_STRING);

    protected static  String normaliseString(String source){
        String adoptSourse = source.replace(" = ", "=")
                .replace("= ", "=")
                .replace(" =", "=")
                .replace("< ", "<")
                .replace(" >", ">")
                .replace("/>", " />")
                .replace("> <", "><");
        while (adoptSourse.contains("  ")){
            adoptSourse = adoptSourse.replaceAll("  ", " ");
        }
        return adoptSourse;

    }

}
