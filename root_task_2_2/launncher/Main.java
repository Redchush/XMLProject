package root_task_2_2.launncher;


import root_task_2_2.dom.Document;
import root_task_2_2.dom.Element;
import root_task_2_2.dom.Node;
import root_task_2_2.dom.NodeList;
import root_task_2_2.service.parser.DomParser;
import root_task_2_2.service.parser.ParserFactory;
import root_task_2_2.service.parser.exception.ParserException;

/**
 *
 */
public class Main {
    public static final String GREETING = "Hello, user.\nEnter the path to file, please";
    public static final String RESULT = "After building document we have this result: ";

    public static void main(String[] args) throws ParserException {

        ConsoleHelper.writeMessage(GREETING);
        String path = ConsoleHelper.readString();

        ParserFactory factory = ParserFactory.getFactory();
        DomParser parser= factory.getHeavyParser();
        parser.parseFully(path);

        Document document = parser.getDocument();
        Element root =  document.getRootElement();
        printChildren(root);
    }

    private static void printChildren(Node node){
        NodeList list = node.getChildren();
        ConsoleHelper.writeMessage("Element : " + node.toString()); ;
        ConsoleHelper.writeMessage("-children:");
        if (list != null) {
            Node nodse;
            while (list.hasNext()) {
                nodse = list.next();
                printChildren(nodse);
            }
        }
        ConsoleHelper.writeMessage("_________");
    }
}

// C:\\Users\\user\\IdeaProjects\\by\\epam\\2.2.OwnParser\\src\\root_task_2_2\\source\\xml\\Menu_XML.xml

