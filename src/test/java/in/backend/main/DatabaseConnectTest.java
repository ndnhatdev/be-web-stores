package in.backend.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DatabaseConnectTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void testConnection() throws SQLException {
        assertThat(dataSource).isNotNull();

        try (Connection connection = dataSource.getConnection()) {
            assertThat(connection.isValid(1)).isTrue();
            assertThat(connection).isNotNull();

            System.out.println("Connection is success");
        }
    }
}
