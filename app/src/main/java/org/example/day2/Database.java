package org.example.day2;

public class Database {
    /**
       invalid if some sequence of numbers repeated twice
    */
    boolean isValidId(String id) {
        if (id.length() % 2 == 1) {
            return true;
        }
        
        int initialChunkSize = id.length() / 2;
        
        for (int chunkSize = initialChunkSize; chunkSize >= initialChunkSize; chunkSize--) {
            for (int j = 0; j < 1; j++) {
                int firstChunkStart = j;
                int firstChunkEnd = j + chunkSize;
                int secondChunkStart = j + chunkSize;
                int secondChunkEnd = j + chunkSize * 2;

                String firstChunk = id.substring(firstChunkStart, firstChunkEnd);
                String secondChunk = id.substring(secondChunkStart, secondChunkEnd);

                assert (firstChunkEnd - firstChunkStart == chunkSize);
                assert (secondChunkEnd - secondChunkStart == chunkSize);

                if (firstChunk.equals(secondChunk)) {
                    return false;
                }
            }
        }

        return true;
    }
}
