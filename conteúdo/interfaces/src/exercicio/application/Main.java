import exercicio.model.entities.Contract;
import exercicio.model.entities.Installment;
import exercicio.model.services.ContractService;
import exercicio.model.services.PaypalService;

void main() {
    Locale.setDefault(Locale.US);

    System.out.println("Entre os dados do contrato: ");
    int contractNum = inputs("Numero: ", Integer.class);
    LocalDate contractDate = inputs("Data (dd/MM/yyyy): ", LocalDate.class);
    double contractValue = inputs("Valor do contrato: ", Double.class);

    Contract contract = new Contract(contractNum, contractDate, contractValue);

    int months = inputs("Entre com o numero de parcelas: ", Integer.class);

    ContractService service = new ContractService();
    service.processContract(contract, months, new PaypalService());

    showInstallment(contract);
}

static <T> T inputs(String message, Class<T> type){
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.print(message);
    if (type == Integer.class){
        return type.cast(sc.nextInt());
    }

    if (type == LocalDate.class){
        String stringContractDate = sc.nextLine();
        return type.cast(LocalDate.parse(stringContractDate, fmt));
    }

    return type.cast(sc.nextDouble());
}

static void showInstallment(Contract contract){
    System.out.println("Parcelas: ");
    for (Installment ins : contract.getInstallments()){
        System.out.println(ins.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " + ins.getAmount());
    }
}