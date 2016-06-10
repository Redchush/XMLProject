package root_task_2_2.dao;

import root_task_2_2.dao.exceptions.FileDaoException;

public interface IFileDao {

    String readSource() throws FileDaoException;

}
