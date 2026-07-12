import exercicio2.model.entities.Employee;

void main() {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter full file path: ");
    String path = sc.nextLine();

    try(BufferedReader br = new BufferedReader(new FileReader(path))){
        System.out.print("Enter salary: ");
        Double salary = sc.nextDouble();

        List<Employee> employees = new ArrayList<>();
        String line = br.readLine();

        while (line != null){
            String[] fields = line.split(",");
            Employee employee = new Employee(fields[0], fields[1], Double.parseDouble(fields[2]));
            employees.add(employee);
            line = br.readLine();
        }

        employees.stream()
                .filter(x -> x.getSalary() > salary)
                .map(Employee::getEmail)
                .sorted(String::compareTo)
                .forEach(System.out::println);

        Double salaryStartM = employees.stream()
                        .filter(x -> x.getName().charAt(0) == 'M')
                        .map(Employee::getSalary)
                        .reduce(0.0, Double::sum);

        System.out.printf("Sum of salary of people whose name starts with 'M': %.2f", salaryStartM);

    } catch(FileNotFoundException e){
        System.out.println("Arquivo não encontrado! " + e.getMessage());
    } catch (InputMismatchException e) {
        System.out.println("Valor incorreto! " + e.getMessage());
    }catch (IOException e) {
        throw new RuntimeException(e);
    }
}
