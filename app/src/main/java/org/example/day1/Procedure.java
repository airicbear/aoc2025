package org.example.day1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Procedure {
    private Lock lock;
    private int zeroPositionFullCount;
    private int zeroPositionClickCount;

    public Procedure() {
        this.lock = new Lock(50);
        this.zeroPositionFullCount = 0;
        this.zeroPositionClickCount = 0;
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
                this.lock.rotate(Direction.LEFT, distance, this::incrementZeroPositionFullCount, this::incrementZeroPositionClickCount);
            } else if (line.startsWith("R")) {
                this.lock.rotate(Direction.RIGHT, distance, this::incrementZeroPositionFullCount, this::incrementZeroPositionClickCount);
            }
        }
    }

    public Lock getLock() {
        return this.lock;
    }

    public int getZeroPositionFullCount() {
        return this.zeroPositionFullCount;
    }

    public int getZeroPositionClickCount() {
        return this.zeroPositionClickCount;
    }

    private void incrementZeroPositionFullCount(int position) {
        if (position == 0) {
            this.zeroPositionFullCount++;
        }
    }

    private void incrementZeroPositionClickCount(int position) {
        if (position == 0) {
            this.zeroPositionClickCount++;
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
