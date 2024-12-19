import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String... args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions =
                bankStatementCSVParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is " + BankTransaction.calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + BankTransaction.selectInMonth(bankTransactions, Month.JANUARY));

    }
}
