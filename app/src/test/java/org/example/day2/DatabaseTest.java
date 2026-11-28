package org.example.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

class DatabaseTest {
    @ParameterizedTest
    @ValueSource(strings = { "11", "22", "99", "1010", "1188511885", "222222", "446446", "38593859" })
    void isValidId_givenInvalidId_returnsFalse(String id) throws IOException {
        // Arrange
        Database database = new Database();

        // Act
        boolean result = database.isValidId(id);

        // Assert
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1023" })
    void isValidId_givenValidId_returnsTrue(String id) throws IOException {
        // Arrange
        Database database = new Database();

        // Act
        boolean result = database.isValidId(id);

        // Assert
        assertThat(result).isEqualTo(true);
    }
}
