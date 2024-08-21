package budget_service_kata;

import java.sql.SQLException;

import javax.naming.Context;

import com.google.common.annotations.VisibleForTesting;

public class BudgetPeer {
    public static Budget[] getAll(Context context) throws SQLException {
        return null;
    }

    @VisibleForTesting
    public static void save(Budget[] budgets) {
    }
}
