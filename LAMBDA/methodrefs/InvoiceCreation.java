import java.util.*;
import java.util.function.Function;

class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice created for transaction: " + transactionId;
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {
        List<String> transactions = Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        Function<String, Invoice> invoiceCreator = Invoice::new;
        transactions.stream().map(invoiceCreator).forEach(System.out::println);
    }
}