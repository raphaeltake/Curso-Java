void main() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter file full path: ");
    String path = sc.nextLine();

    try(BufferedReader br = new BufferedReader(new FileReader(path))){

        String line = br.readLine();
        Map<String, Integer> candidates = new LinkedHashMap<>();

        while(line != null){
            String[] lineSplite = line.split(",");

            if (candidates.containsKey(lineSplite[0])){
                candidates.put(lineSplite[0], candidates.get(lineSplite[0]) + Integer.parseInt(lineSplite[1]));
            } else {
                candidates.put(lineSplite[0], Integer.parseInt(lineSplite[1]));
            }

            line = br.readLine();
        }

        for (String key : candidates.keySet()){
            System.out.println(key + ": " + candidates.get(key));
        }

    } catch(FileNotFoundException e) {
        System.out.println("Arquivo não encontrado");
    } catch(IOException e){
        System.out.println("Erro inesperado");
    }


}