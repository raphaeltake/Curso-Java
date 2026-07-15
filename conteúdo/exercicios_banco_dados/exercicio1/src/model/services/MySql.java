package model.services;

import db.DB;
import db.DbExcepetion;
import model.exceptions.domainException;
import model.interfaces.DataControll;
import model.util.ColumnType;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySql implements DataControll {

    public MySql() {
    }

    private static boolean firstTime = true;

    //Cria a tabela dos autores
    //TODO: Passar a função para o MySql.java
    //TODO: Tornar ela reutilizável
    //TODO: Pegar os nomes dos arquivos sozinho
    @Override
    public void createDataBase(String path, Connection conn) {
        Statement ps = null;

        try {
            ps = conn.createStatement();

            String[][] readDataResult = readData(path);
            String[] columnFields = readDataResult[0];
            String[] largerData = readDataResult[1];

            Map<String, String> columnsType = ColumnType.findType(columnFields, largerData);

            String fields = generateCreateMessage(columnsType, path);

            ps.executeUpdate(fields);

        } catch (SQLException e) {
            throw new DbExcepetion(e.getMessage());
        } catch (Exception e) {
            throw new domainException("Erro inesperado!" + e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    static String[][] readData(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String[] columnFields = line.split(";");

            String[] lineData = br.readLine().split(";");
            String[] largerData = lineData;

            //Procura a linha com dados mais completa (o arquivo pode conter linhas com dados incompletos, pode causar
            //problemas quando for identificar o tipo da coluna
            while ((line = br.readLine()) != null){
                lineData = line.split(";");

                if (lineData.length > largerData.length) largerData = lineData;

                if (largerData.length == columnFields.length) break;
            }
            return new String[][] {columnFields, lineData};

        } catch (FileNotFoundException e){
            throw new domainException("Arquivo de autores não encontrado! " + e.getMessage());
        } catch (IOException e){
            throw new domainException("Erro inesperado" + e.getMessage());
        }
    }

    static String generateCreateMessage(Map<String, String> columnsType, String path){
        String dbName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
        StringBuilder fields = new StringBuilder();
        for (String key : columnsType.keySet()) {
            String field = String.format("%s %s", key, columnsType.get(key));
            if (firstTime) {
                field += " PRIMARY KEY";
                firstTime = false;
            }
            field += ", ";
            fields.append(field);
        }
        firstTime = true;
        return "CREATE TABLE IF NOT EXISTS " + dbName  +  " (" + fields.substring(0, fields.length() - 2) + ");";
    }

    @Override
    public void insertData() {

    }

    @Override
    public void deleteData() {

    }

}
