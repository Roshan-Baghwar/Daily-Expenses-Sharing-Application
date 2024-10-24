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
                writer.append(expense.getId().toString())  // Convert ID to string explicitly
                        .append(", ")
                        .append(expense.getDescription())
                        .append(", ")
                        .append(String.valueOf(expense.getTotalAmount()))
                        .append(", ")
                        .append(String.valueOf(expense.getSplitType()))
                        .append(", ");

                // Writing each participant's owed amount
                StringBuilder participantInfo = new StringBuilder();
                for (Participant participant : expense.getParticipants()) {
                    participantInfo.append(participant.getUser().getName())
                            .append(": ")
                            .append(String.valueOf(participant.getAmountOwed()))
                            .append("; ");
                }

                writer.append(participantInfo.toString().trim())  // Avoid unnecessary spaces
                      .append('\n');  // Newline for the next expense
            }

            System.out.println("CSV balance sheet generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
