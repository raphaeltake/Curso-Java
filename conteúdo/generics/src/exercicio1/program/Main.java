import exercicio1.model.entities.Log;

void main() {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter file full path: ");
    String path = sc.nextLine();

    try(BufferedReader br = new BufferedReader(new FileReader(path))){
        String line = br.readLine();
        Set<Log> setLog = new HashSet<>();

        while (line != null){
            String[] lineSplit = line.split(" ");
            Log log = new Log(lineSplit[0], Instant.parse(lineSplit[1]));
            setLog.add(log);
            line = br.readLine();
        }

        System.out.println("Total users: " + setLog.size());

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
