package root_task_2_2.service.parser.impl;


import root_task_2_2.dao.DaoFactory;
import root_task_2_2.dao.IFileDao;
import root_task_2_2.dao.exceptions.FileDaoException;
import root_task_2_2.dom.Document;
import root_task_2_2.service.parser.DomParser;
import root_task_2_2.service.parser.exception.ExceptionUtils;
import root_task_2_2.service.parser.exception.ParserException;


public class HeavyDomParser implements DomParser {

    private final ParserHelper builder;

    public HeavyDomParser(){
       builder = ParserHelper.getDomBuilder();
    }

    @Override
    public void parseFully(String path) throws ParserException{
        String source;
        DaoFactory factory = DaoFactory.getInstance();
        IFileDao inputHelper = factory.getDAO(path);
        try {
            source = inputHelper.readSource();
        }
        catch (FileDaoException e) {
            throw new ParserException(ExceptionUtils.READING_EX, e);
        }
        source = ParserUtils.normaliseString(source);
        buildDom(source);
    }

    @Override
    public Document getDocument() throws ParserException {
        if (builder.isReady()) {
            return builder.getDocument();
        }
        else {
            throw new ParserException(ExceptionUtils.DOCUMENT_EX);
        }
    }

    private void buildDom(String source){
        source = builder.clipMeta(source);
        builder.buildElementTree(source);
    }

}
