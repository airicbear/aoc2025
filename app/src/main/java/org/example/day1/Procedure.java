package org.example.day1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Procedure {
    private Lock lock;
    private int zeroPositionCount;

    public Procedure() {
        this.lock = new Lock(50);
        this.zeroPositionCount = 0;
    }

    public void rotateLock(String path) throws IOException, InvalidInputException {
        String input = readResource(path);

        var lines = input.lines().toList();

        for (String line : lines) {
            if (!(line.startsWith("L") || line.startsWith("R"))) {
                throw new InvalidInputException("Invalid input.");
            }
            
            int distance = Integer.parseInt(line.substring(1));
                
            if (line.startsWith("L")) {
                this.lock.rotate(Direction.LEFT, distance, this::incrementZeroPositionCount);
            } else if (line.startsWith("R")) {
                this.lock.rotate(Direction.RIGHT, distance, this::incrementZeroPositionCount);
            }
        }
    }

    public Lock getLock() {
        return this.lock;
    }

    public int getZeroPositionCount() {
        return this.zeroPositionCount;
    }

    private void incrementZeroPositionCount(int position) {
        if (position == 0) {
            this.zeroPositionCount++;
        }
    }

    private String readResource(String path) throws IOException {
        try (var stream = getClass().getResourceAsStream(path)) {
            if (stream == null) {
                throw new IOException("Resource not found: " + path);
            }
            
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
