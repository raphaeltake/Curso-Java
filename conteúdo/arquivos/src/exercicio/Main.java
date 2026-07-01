void main() {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Caminho do arquivo: ");
    String path = sc.nextLine();
    try (BufferedReader br = new BufferedReader(new FileReader(path))){
        String line = br.readLine();
        String[] data_in = null;

        String folderPath = path.substring(0, path.lastIndexOf("/"));

        boolean arquivo_criado = create_out_folder(folderPath);

        System.out.println(arquivo_criado);
        System.out.println(folderPath);
        while (line != null){
            data_in = line.split(",");
            write_data(data_in, folderPath);
            line = br.readLine();
        }

    } catch(IOException e){
        e.printStackTrace();
    }

    sc.close();
}

static void write_data(String[] data, String path){
    String text = data[0] + "," + calc_price(Double.parseDouble(data[1]), Integer.parseInt(data[2]));
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(path + "/out/summary.csv", true))){
        bw.write(text);
        bw.newLine();
    } catch(IOException e){
        e.printStackTrace();
    }
}

static boolean create_out_folder(String path){
    return new File(path + "/out").mkdir();
}

static double calc_price(double price, int quantity){
    return price * quantity;
}
