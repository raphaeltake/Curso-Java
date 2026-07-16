package model.util;

import model.exceptions.domainException;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataType {

    //Identifica o tipo da coluna (TEXT ou INTEGER)
    public static Map<String, String> findColumnsType(String[] fields, String[] data){
        Map<String, String> columns = new LinkedHashMap<>();
        int i = 0;

        for (String field : fields){
            try{
                Integer.parseInt(data[i]);
                columns.put(field, "INTEGER");
            } catch (NumberFormatException e){
                columns.put(field, "TEXT");
            } catch (Exception e2){
                throw new domainException("Erro inesperado! " + e2.getMessage());
            }
            i++;
        }

        return columns;
    }

    public static Object findDataType(String data){
        try {
            return Integer.parseInt(data);
        } catch (NumberFormatException e){
            return data;
        } catch (Exception e){
            throw new domainException("Erro inesperado! " + e.getMessage());
        }
    }

}
