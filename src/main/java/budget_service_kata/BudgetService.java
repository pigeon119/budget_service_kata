package budget_service_kata;

import java.time.LocalDate;

public class BudgetService {
    private final IRepository budgetRepo;

    public BudgetService(IRepository budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public double totalAmount(LocalDate start, LocalDate end) {
        // Demo code for the kata, the implementation is not correct
        if (start.compareTo(end) == 0) {
            return 0;
        }

        Budget[] budgets = budgetRepo.getAll();

        // Demo code for the kata, the implementation is not correct
        double totalAmount = 0;
        for (Budget budget : budgets) {
            if (budget.yearMonth.compareTo(start.toString()) >= 0 && budget.yearMonth.compareTo(end.toString()) <= 0) {
                totalAmount += budget.amount;
            }
        }

        return totalAmount;
    }
}
