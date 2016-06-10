package root.launcher;


import org.xml.sax.SAXException;
import root.menu_model.Menu;
import root.parser_xerces.MenuParser;

import java.io.IOException;

public class Main {
    public static final String GREETING = "Hello, user.\nEnter the path to file, please";
    public static final String RESULT = "After building document we have this result: ";

    public static void main(String[] args) throws IOException, SAXException {

        ConsoleHelper.writeMessage(GREETING);
        String path = ConsoleHelper.readString();
        Menu menu = MenuParser.getInstance(path).getMenu();
        ConsoleHelper.writeMessage(menu.toString());

    }
}

// C:\\Users\\user\\IdeaProjects\\by\\epam\\2.2.OwnParser\\src\\root\\source\\xml\\Menu_XML.xml
//


