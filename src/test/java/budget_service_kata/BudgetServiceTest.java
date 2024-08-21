package budget_service_kata;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class BudgetServiceTest extends DatabaseTestCase {

    @InjectMocks
    private BudgetService sut;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        insertBudgets(new Budget[]{
                new Budget("202001", 31),
                new Budget("202002", 29),
                new Budget("202003", 31)
        });

        double actual = sut.totalAmount(getTestContext(),
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));

        Assert.assertEquals(0, actual, 0);
    }

    private void insertBudgets(Budget[] budgets) {
        BudgetPeer.save(budgets);
    }
}
