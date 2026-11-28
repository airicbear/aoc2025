package org.example.day2;

public class Database {
    /**
       invalid if some sequence of numbers repeated twice
    */
    boolean isValidId(String id) {
        int initialChunkSize = id.length() / 2;
        
        for (int chunkSize = initialChunkSize; chunkSize >= 1; chunkSize--) {

            System.out.println("chunkSize="+chunkSize);
            for (int j = 0; j < id.length() - chunkSize * 2 + 1; j++) {
                System.out.println("j="     + j);

                int firstChunkStart = j;
                int firstChunkEnd = j + chunkSize;
                int secondChunkStart = j + chunkSize;
                int secondChunkEnd = j + chunkSize * 2;

                System.out.println("[" + firstChunkStart + "," + firstChunkEnd + "]");
                System.out.println("[" + secondChunkStart + "," + secondChunkEnd + "]");

                String firstChunk = id.substring(firstChunkStart, firstChunkEnd);
                String secondChunk = id.substring(secondChunkStart, secondChunkEnd);

                System.out.println("firstChunk="+firstChunk);
                System.out.println("secondChunk=" + secondChunk);

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
