package model.interfaces;

import java.sql.Connection;

public interface DataControll {
    //Cria a tabela dos autores
    //TODO: Passar a função para o MySql.java
    //TODO: Tornar ela reutilizável
    //TODO: Pegar os nomes dos arquivos sozinho
    void createDataBase(String path, Connection conn);
    void insertData();
    void deleteData();
}
