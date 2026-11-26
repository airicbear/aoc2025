package org.example.day1;

public class Lock {
    public static int MIN_POSITION = 0;
    public static int MAX_POSITION = 99;

    private int currentPosition;

    public Lock(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    void rotate(Direction direction, int distance) {
        if (direction == Direction.LEFT) {
            rotateLeft(distance);
        } else {
            rotateRight(distance);
        }
    }

    void rotateRight(int distance) {
        for (int i = 0; i < distance; i++) {
            if (this.currentPosition == MAX_POSITION) {
                this.currentPosition = MIN_POSITION;
            } else {
                this.currentPosition++;    
            }
        }
    }

    void rotateLeft(int distance) {
        for (int i = 0; i < distance; i++) {
            if (this.currentPosition == MIN_POSITION) {
                this.currentPosition = MAX_POSITION;
            } else {
                this.currentPosition--;
            }
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
