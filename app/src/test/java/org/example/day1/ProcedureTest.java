package org.example.day1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

class ProcedureTest {
    @Test
    void rotateLock_givenSampleDocument_updatesLockStateCorrectly() throws IOException, InvalidInputException {
        // Arrange
        Procedure procedure = new Procedure();

        // Act
        procedure.rotateLock("/day1/sample.txt");

        // Assert
        assertThat(procedure.getLock().getCurrentPosition()).isEqualTo(32);
        assertThat(procedure.getZeroPositionCount()).isEqualTo(3);
    }

    @Test
    void rotateLock_givenInputDocument_updatesLockStateCorrectly() throws IOException, InvalidInputException {
        // Arrange
        Procedure procedure = new Procedure();

        // Act
        procedure.rotateLock("/day1/input.txt");

        // Assert
        assertThat(procedure.getZeroPositionCount()).isEqualTo(1021);
    }
}
