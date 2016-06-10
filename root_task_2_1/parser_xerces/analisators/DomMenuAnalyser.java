package root_task_2_1.parser_xerces.analisators;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import root_task_2_1.menu_model.Menu;
import root_task_2_1.menu_model.MenuCategory;
import root_task_2_1.menu_model.menu_items.MenuItemComponent;
import root_task_2_1.menu_model.menu_logic.MenuItemBuilder;

import java.util.*;

import static root_task_2_1.parser_xerces.analisators.DocumentConstants.*;

public class DomMenuAnalyser {
    private MenuItemBuilder builder;

    private static DomMenuAnalyser instance;
    private DomMenuAnalyser(MenuItemBuilder builder){
        this.builder = builder;
    };

    public static DomMenuAnalyser getInstance(MenuItemBuilder builder) {
        if (instance == null)
        {
            instance = new DomMenuAnalyser(builder);
        }
        return instance;
    }

    public Menu buildMenu(Element element){
        NodeList list = element.getElementsByTagName(CATEGORY);
        String name  = element.getAttribute(NAME);
        String version = element.getAttribute(VERSION);
        List<MenuCategory> menuCategoris = buildCategoryList(list);

        return  builder.createMenu(menuCategoris, name, version);
    }

    protected List<MenuCategory> buildCategoryList(NodeList list){
       List<MenuCategory> menuCategoris = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node item = list.item(i);
            MenuCategory category = buildCategory((Element) item);
            menuCategoris.add(category);
        }
        return menuCategoris;
    }

    protected  MenuCategory buildCategory(Element node){
        List<MenuItemComponent> componentList = new ArrayList<>();
        String title = "";
        NodeList list = node.getChildNodes();
        ArrayList<Element> elements = pickElements(node);
        String id = node.getAttribute(ID);

        for (Element item : elements) {
            MenuItemComponent component;
            switch (item.getTagName()) {
                case TITLE:
                    title = item.getTextContent();
                    break;
                case SIMPLE_MENU_ITEM:
                    component = buildMenuItem(item, false);
                    componentList.add(component);
                    break;
                case COMPLEX_MENU_ITEM:
                    component = buildMenuItem(item, true);
                    componentList.add(component);
                    break;
            }
        }

        MenuCategory menuCategory = builder.createMenuCategory(title, componentList);
        return menuCategory;
    }

    protected MenuItemComponent buildMenuItem(Element element, boolean isComplex){

        String price ="";
        String name = "";
        String description ="";
        String foto = "";
        String ratioUnit ="";
        Map<String, Map<String, String>> mapOfSubElements = new HashMap<>();
        int counter = 0;

        List<String> ratio = new ArrayList<>();
        Element node = (Element) element.getElementsByTagName(MENU_ITEM).item(0);
        ArrayList<Element> elements = pickElements(node);
        String id = node.getAttribute(ID);

        for (Element item : elements) {
            switch (item.getTagName()) {
                case NAME:
                    name = item.getTextContent();
                    break;
                case DESCRIPTION :
                    description = item.getTextContent();
                    if (isComplex)  mapOfSubElements = getComplexContentOfElement(item, mapOfSubElements, counter++);
                    break;
                case PRICE:
                    price = item.getTextContent();
                    if (isComplex)  mapOfSubElements = getComplexContentOfElement(item, mapOfSubElements, counter++);
                    break;
                case FOTO:
                    foto = item.getAttribute(DocumentConstants.PATH);
                    break;
                case RATIO:
                    ratioUnit = item.getAttribute(DocumentConstants.UNIT);
                    ratio = Arrays.asList(item.getTextContent().split(" "));
            }
        }

        return isComplex ?  builder.createComplexMenuComponent(id, name, foto, mapOfSubElements, ratio, ratioUnit) :
                builder.createSimpleMenuComponent(id, name,foto,description,price,ratio,ratioUnit);
    }

    protected Map<String, Map<String, String>> getComplexContentOfElement(Element type, Map<String, Map<String, String>> map,
                                                                          int propertyNumber){

        String elName = type.getTagName();
        ArrayList<Element> list = pickElements(type);
        for (Element item : list){
            Map<String, String> innerMap = new HashMap<>();
            innerMap.put(elName, item.getTextContent());

            if (!map.containsKey(item.getAttribute(VARIANT_NUMBER)))
                map.put(item.getAttribute(VARIANT_NUMBER), innerMap);
            else {
                map.get(item.getAttribute(VARIANT_NUMBER)).put(elName, item.getTextContent());
            }
        }
        return map;
    }

    private ArrayList<Element> pickElements(Node node) {
        NodeList list = node.getChildNodes();
        ArrayList<Element> result = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element item = (Element) child;
                result.add(item);
            }
        }

        return result;
    }
}
