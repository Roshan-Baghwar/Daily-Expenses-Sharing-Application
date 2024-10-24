import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BalanceSheetGenerator {

    public void getBalanceSheet(List<Expense> expenses, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Writing header
            writer.append("Expense ID, Description, Total Amount, Split Type, Participants & Owed Amount\n");

            // Writing each expense record
            for (Expense expense : expenses) {
                writer.append(expense.getId())
                        .append(", ")
                        .append(expense.getDescription())
                        .append(", ")
                        .append(String.valueOf(expense.getTotalAmount()))
                        .append(", ")
                        .append(String.valueOf(expense.getSplitType()))
                        .append(", ");

                for (Participant participant : expense.getParticipants()) {
                    writer.append(participant.getUser().getName())
                            .append(": ")
                            .append(String.valueOf(participant.getAmountOwed()))
                            .append("; ");
                }
                
                writer.append('\n');  // Newline for the next expense
            }

            System.out.println("CSV balance sheet generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
