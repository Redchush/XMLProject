package root_task_2_2.service.parser;


import root_task_2_2.dom.Document;
import root_task_2_2.service.parser.exception.ParserException;


public interface DomParser {

     Document getDocument() throws ParserException;
     void parseFully(String path) throws ParserException;

}
