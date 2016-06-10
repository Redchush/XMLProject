package root_task_2_2.service.parser;


import root_task_2_2.service.parser.impl.HeavyDomParser;

public class ParserFactory {

    private static ParserFactory instance;
    private ParserFactory(){}

    public static ParserFactory getFactory() {
        if (instance == null)
        {
            instance = new ParserFactory();
        }
        return instance;
    }

    public DomParser getHeavyParser(){
        return new HeavyDomParser();
    }
}
