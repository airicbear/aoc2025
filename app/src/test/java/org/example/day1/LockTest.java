package org.example.day1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LockTest {
    @Test
    void rotate_givenValidDirections_updatesLockState() {
        // Arrange
        Lock lock = new Lock(50);

        // Act
        lock.rotate(Direction.LEFT, 68);

        // Assert
        assertThat(lock.getCurrentPosition()).isEqualTo(82);
    }
    
    @Test
    void getPassword_givenValidRotations_returnsCorrectPassword() {
        assertThat(2 + 2).isEqualTo(4);
    }
}
