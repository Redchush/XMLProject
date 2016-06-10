package root_task_2_2.dao;


import root_task_2_2.dao.impl.FileDaoImpl;

/**
 * Factory for getting the class which implements IFileDao interface
 */
public class DaoFactory {

    private static DaoFactory instance;
    private DaoFactory(){}

    public static DaoFactory getInstance() {
        if (instance == null)
        {
            instance = new DaoFactory();
        }
        return instance;
    }

    public IFileDao getDAO(String source){
        return new FileDaoImpl(source);
    }
}
