package model.services;

import db.DB;
import db.DbExcepetion;
import model.entities.Autores;
import model.exceptions.domainException;
import model.interfaces.DataControll;
import model.util.DataType;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MySql implements DataControll {

    public MySql() {
    }

    private static boolean firstTime = true;

    @Override
    public void createDataBase(String path, Connection conn) {
        Statement ps = null;

        try {
            conn.setAutoCommit(false);
            ps = conn.createStatement();

            String[][] readDataResult = readData(path);
            String[] columnFields = readDataResult[0];
            String[] largerData = readDataResult[1];

            Map<String, String> columnsType = DataType.findColumnsType(columnFields, largerData);

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
    public void insertArchiveData(String path, Connection conn) {
        String archiveName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
        PreparedStatement ps = null;

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            conn.setAutoCommit(false);
            String line = br.readLine();
            String[] header = line.split(";");
            int quantityDataExpected = header.length;
            String[] fields;
            List<List<Object>> data = new ArrayList<>();
            line = br.readLine();

            //TODO: Trocar: fazer a inserção dos dados a cada leitura (Todas as linhas do arquivo estão ficando salvas em uma lista)
            while(line != null){
                fields = line.split(";", -1);
                List<Object> row = new ArrayList<>(
                        Arrays.stream(fields)
                                .map(DataType::findDataType)
                                .toList()
                );
                while (row.size() < quantityDataExpected){
                    row.add(null);
                }

                data.add(row);
                line = br.readLine();
            }

            String columnsNames = "";
            for (String st : header){
                columnsNames += st + ", ";
            }

            System.out.println(columnsNames);
            String placeholders = String.join(", ", Collections.nCopies(quantityDataExpected, "?"));

            String sql = "INSERT INTO " +
                    archiveName +
                    String.format(" (%s)", columnsNames.substring(0, columnsNames.lastIndexOf(","))) +
                    " VALUES (" +
                    placeholders +
                    ")";

            ps = conn.prepareStatement(sql);

            for (List<Object> dataInsert : data){
                for (int i = 0; i < quantityDataExpected; i++) {
                    Object value = dataInsert.get(i);
                    if (value instanceof String && ((String) value).isEmpty()) {
                        value = null;
                    }
                    ps.setObject(i + 1, value);
                }
                ps.executeUpdate();
            }

        }
        catch (IOException e) {
            throw new domainException("Erro ao inserir dados! " + e.getMessage());
        }
        catch (SQLException e) {
            throw new DbExcepetion("Erro ao inserir no banco de dados! " + e.getMessage());
        }
//        catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
//            throw new domainException(e.getMessage());
//        }
        
        finally {
            DB.closeStatement(ps);
        }

    }

//    void createAutores(List<?> data) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        System.out.println("Criando Autor...");
//
//        Constructor<Autores> constructor = Autores.class.getConstructor(
//                Integer.class,
//                String.class,
//                String.class,
//                Integer.class,
//                String.class,
//                String.class,
//                Integer.class,
//                String.class,
//                String.class
//        );
//
//        // Convertemos a lista para o array de Object que o newInstance precisa
//        Autores autor = constructor.newInstance(data.toArray());
//        System.out.println(autor.toString());
//    }

    @Override
    public void deleteData() {

    }

}