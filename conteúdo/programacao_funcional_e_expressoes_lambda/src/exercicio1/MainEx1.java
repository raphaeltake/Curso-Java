import exercicio1.model.entities.Product;

void main() {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter full file path: ");
    String path = sc.nextLine();

    try(BufferedReader br = new BufferedReader(new FileReader(path))){
        List<Product> products = new ArrayList<>();
        String line = br.readLine();

        while (line != null){
            String[] splitLine = line.split(",");
            products.add(new Product(splitLine[0], Double.parseDouble(splitLine[1])));
            line = br.readLine();
        }

        double averagePrice = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum) / products.size();

        System.out.printf("Average price: %.2f \n", averagePrice);

        List<String> productsString = new ArrayList<>(
                products.stream()
                .filter(x -> x.getPrice() < averagePrice)
                .map(Product::getName).toList()
        );

        productsString.sort(Comparator.reverseOrder());
        productsString.forEach(System.out::println);

    } catch (FileNotFoundException e){
        System.out.println("Arquivo não encontrado! " + e.getMessage());
    } catch (IOException e){
        System.out.println("Erro inesperado! " + e.getMessage());
    }
}
