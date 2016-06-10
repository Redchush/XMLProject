package root_task_2_1.parser_xerces;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import root_task_2_1.menu_model.Menu;
import root_task_2_1.menu_model.menu_logic.MenuItemBuilder;
import root_task_2_1.parser_xerces.analisators.DomMenuAnalyser;

import java.io.IOException;

public class MenuParser {

    private static MenuParser instance;
    private String path;

    private MenuParser(String path) throws IOException, SAXException {
         this.path = path;
    };

    public static MenuParser getInstance(String path) throws IOException, SAXException {
        if (instance == null)
        {
            instance = new MenuParser(path);
        }
        return instance;
    }

    private Document makeDocument() throws IOException, SAXException{
        DOMParser parser = new DOMParser();
        parser.parse(path);
        return  parser.getDocument();
    }

    public Menu getMenu() throws IOException, SAXException {
        Document document = makeDocument();
        Element root = document.getDocumentElement();
        DomMenuAnalyser analyser = DomMenuAnalyser.getInstance(
                                    MenuItemBuilder.getInstance());
        Menu menu = analyser.buildMenu(root);
        return menu;
    }
}
