import db.DB;
import db.DbExcepetion;
import model.exceptions.domainException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

void main() {

    Connection conn = null;


    try{
        conn = DB.getConnection();
        conn.setAutoCommit(false);
        create_autores_db("exercicio1/data/autores.csv", conn);
        System.out.println("Feito");
        conn.commit();

    } catch (Exception e) {
        throw new domainException(e.getMessage());
    } finally {
        DB.closeConnection();
    }
}

static void create_autores_db(String path, Connection conn) {
    Statement ps = null;

    try(BufferedReader br = new BufferedReader(new FileReader(path))){
        ps = conn.createStatement();
        String line = br.readLine();
        String[] columnFields = line.split(";");

        String[] lineData = br.readLine().split(";");
        String[] largerData = lineData;

        while ((line = br.readLine()) != null){
            lineData = line.split(";");

            if (lineData.length > largerData.length) largerData = lineData;

            if (largerData.length == columnFields.length) break;

        }

        Map<String, String> columnsType = columnType(columnFields, largerData);

        String fields = "";
        boolean firstTime = true;

        for (String key : columnsType.keySet()){
            String field = String.format("%s %s", key, columnsType.get(key));
            if (firstTime) {
                field += " PRIMARY KEY";
                firstTime = false;
            }
            field += ", ";
            fields += field;
        }
        fields = "CREATE TABLE autores_ex1 (" + fields.substring(0, fields.length() - 2) + ");";
        System.out.println(fields);

        ps.executeUpdate(fields);

    } catch (FileNotFoundException e){
        throw new domainException("Arquivo de autores não encontrado! " + e.getMessage());
    } catch (IOException e){
        throw new domainException("Erro inesperado" + e.getMessage());
    } catch (SQLException e) {
        throw new DbExcepetion(e.getMessage());
    }
    finally {
        DB.closeStatement(ps);
    }
}

static Map<String, String> columnType(String[] fields, String[] data){
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
