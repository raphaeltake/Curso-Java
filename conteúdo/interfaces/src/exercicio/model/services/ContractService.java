package exercicio.model.services;

import exercicio.model.entities.Contract;
import exercicio.model.entities.Installment;
import exercicio.model.interfaces.OnlinePaymentService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractService {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void processContract(Contract contract, Integer months, OnlinePaymentService service){
        LocalDate contractDate = contract.getDate();
        Installment[] installments = new Installment[months];
        for (int i = 1; i <= months; i++) {
            LocalDate installmentDate =  contractDate.plusMonths(i);

            Double amount = contract.getTotalValue() / months
                    + service.interest(contract.getTotalValue() / months, i);

            amount += service.paymentFee(amount);

            Installment installment = new Installment(installmentDate, amount);
            installments[i-1] = installment;
        }
        contract.setInstallments(installments);
    }
}
