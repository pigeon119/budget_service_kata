package budget_service_kata;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.naming.Context;

public class BudgetService {
    // Bad smell: Singleton
    // Bad smell: Static block
    // Bad smell: Type Cast

    private static final Logger logger = Logger.getLogger(BudgetService.class.getName());

    private static String expiredUserIds;

    static {
        expiredUserIds = Configurations.getExpiredUserIds();
    }

    public BudgetService() {
    }

    public static void setExpiredUserIds(String expiredUserIds) {
        BudgetService.expiredUserIds = expiredUserIds;
    }

    public double totalAmount(Context context, LocalDate start, LocalDate end) {
        logger.info("enter totalAmount");

        if (expiredUserIds.contains(((UserContext) context).getUserID())) {
            return 0;
        }

        // Demo code for the kata, the implementation is not correct
        if (start.compareTo(end) == 0) {
            return 0;
        }

        double totalAmount = 0;
        try {
            // Demo code for the kata, the implementation is not correct
            for (Budget budget : BudgetPeer.getAll(context)) {
                if (budget.yearMonth.compareTo(start.toString()) >= 0 && budget.yearMonth.compareTo(end.toString()) <= 0) {
                    totalAmount += budget.amount;
                }
            }
        } catch (SQLException e) {
            logger.info("SQLException: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return totalAmount;
    }
}
