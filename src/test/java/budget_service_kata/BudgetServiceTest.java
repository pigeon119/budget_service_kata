package budget_service_kata;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class BudgetServiceTest {

    @InjectMocks
    private BudgetService sut;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        // Act
        double actual = sut.totalAmount(
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1)
        );

        Assert.assertEquals(0, actual, 0);
    }

}
