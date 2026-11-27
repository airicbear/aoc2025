package org.example.day1;

import java.util.function.IntConsumer;

public class Lock {
    public static int MIN_POSITION = 0;
    public static int MAX_POSITION = 99;

    private int currentPosition;

    public Lock(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    void rotate(Direction direction, int distance, IntConsumer update) {
        if (direction == Direction.LEFT) {
            rotateLeft(distance, update);
        } else {
            rotateRight(distance, update);
        }
    }

    void rotateRight(int distance, IntConsumer update) {
        for (int i = 0; i < distance; i++) {
            if (this.currentPosition == MAX_POSITION) {
                this.currentPosition = MIN_POSITION;
            } else {
                this.currentPosition++;    
            }
        }
        
        update.accept(this.currentPosition);
    }

    void rotateLeft(int distance, IntConsumer update) {
        for (int i = 0; i < distance; i++) {
            if (this.currentPosition == MIN_POSITION) {
                this.currentPosition = MAX_POSITION;
            } else {
                this.currentPosition--;
            }
        }
        
        update.accept(this.currentPosition);
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
