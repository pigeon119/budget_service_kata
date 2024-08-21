package budget_service_kata;

import java.sql.Connection;

import javax.naming.Context;

import org.junit.Before;

public abstract class DatabaseTestCase {
    Connection connection;

    @Before
    public void setUp() {
        connection = createTestDatabase();
        createTestTables();
        createTestUser();
    }

    private void createTestUser() {}

    private void createTestTables() {}

    private Connection createTestDatabase() {
        return null;
    }

    Context getTestContext() {
        return new UserContext();
    }

    Connection getTestConnection() {
        return connection;
    }

    void setConfigurations(String key, String value) {
    }
}