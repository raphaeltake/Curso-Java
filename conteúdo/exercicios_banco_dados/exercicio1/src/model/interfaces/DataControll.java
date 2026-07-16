package model.interfaces;

import java.sql.Connection;

public interface DataControll {
    void createDataBase(String path, Connection conn);

    void insertArchiveData(String path, Connection conn);

    void deleteData();
}
