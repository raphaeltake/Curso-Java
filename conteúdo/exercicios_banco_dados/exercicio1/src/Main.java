import db.DB;
import model.exceptions.domainException;
import model.services.MySql;

import java.sql.Connection;

void main() {

    Connection conn = null;

    //TODO: colocar para ele ler automaticamente todos os arquivos na pasta "data"
    try{
        conn = DB.getConnection();
        conn.setAutoCommit(false);

        //TODO: O arquivo livros deve ser o último a ser processo (contém foreign key).
        //TODO: Verificar se algum arquivo possuí foreign key antes de processar os dados.
        //OBS: Não está sendo criado as foreign keys da tabela livros.
        String path = "exercicio1/data";
        File directory = new File(path);
        File[] files = directory.listFiles(File::isFile);

        MySql mySql = new MySql();
        assert files != null;
        for (File file : files){
            mySql.createDataBase(file.getPath(), conn);
            mySql.insertArchiveData(file.getPath(), conn);
        }

        System.out.println("Feito");
        conn.commit();

    } catch (NullPointerException e) {
        throw new domainException("Pasta não encontrada! " + e.getMessage());
    } catch (Exception e) {
        throw new domainException(e.getMessage());
    } finally {
        DB.closeConnection();
    }
}