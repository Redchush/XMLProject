package root_task_2_2.dao.impl;


import root_task_2_2.dao.IFileDao;
import root_task_2_2.dao.exceptions.FileDaoException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 28.05.2016.
 */
public class FileDaoImpl implements IFileDao {

    private final String path;

    public FileDaoImpl(String path) {
        this.path = path;
    }

    @Override
    public String readSource() throws FileDaoException {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            String tempLine;
            while ((tempLine = fileReader.readLine()) != null) {
                builder.append(tempLine).append("\\n");
            }
        } catch (FileNotFoundException e){
            throw new FileDaoException("File on path " + path +
                    " isn't available now", e);

        }catch (IOException e) {
            throw new FileDaoException("Problem during reading the file: ", e);
        }

        builder.deleteCharAt(builder.length()-1);
        return new String(builder);
    }


}
