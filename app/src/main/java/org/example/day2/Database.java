package org.example.day2;

public class Database {
    /**
       invalid if some sequence of numbers repeated twice
    */
    boolean isValidId(String id) {
        int chunkSize = id.length() / 2;
        
        for (int i = chunkSize; i >= 0; i--) {

            System.out.println(i);
            for (int j = 0; j < id.length(); j++) {
                System.out.println("j="     + j);

                int firstChunkStart = j;
                int firstChunkEnd = j + chunkSize - 1;
                int secondChunkStart = j + chunkSize;
                int secondChunkEnd = j + chunkSize * 2 - 1;

                assert (firstChunkEnd - firstChunkStart == chunkSize);
                assert (secondChunkEnd - secondChunkStart == chunkSize);

                System.out.println("[" + firstChunkStart + "," + firstChunkEnd + "]");
                System.out.println("[" + secondChunkStart + "," + secondChunkEnd + "]");

                String firstChunk = id.substring(firstChunkStart, firstChunkEnd);
                String secondChunk = id.substring(secondChunkStart, secondChunkEnd);

                System.out.println("firstChunk="+firstChunk);
                System.out.println("secondChunk="+secondChunk);

                if (firstChunk.equals(secondChunk)) {
                    return false;
                }
            }
        }

        return true;
    }
}
