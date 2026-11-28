package org.example.day2;

import java.util.ArrayList;
import java.util.List;

public class GiftShop {
    Database database;

    public GiftShop() {
        this.database = new Database();
    }

    public List<List<String>> getManyIds(String idRanges) {
        String[] split = idRanges.split(",");
        List<List<String>> manyIds = new ArrayList<>();

        for (String idRange : split) {
            manyIds.add(this.getIds(idRange));
        }

        return manyIds;
    }

    /**
       create list of ids from a string range e.g., 100-200
    */
    public List<String> getIds(String idRange) {
        String[] split = idRange.split("-");
        long first = Long.parseLong(split[0]);
        long last = Long.parseLong(split[1]);
        List<String> ids = new ArrayList<>();

        for (long i = first; i <= last; i++) {
            ids.add(Long.toString(i));
        }

        return ids;
    }

    public List<String> getManyInvalidIds(String idRanges) {
        List<String> invalidIds = new ArrayList<>();
        
        for (List<String> ids : this.getManyIds(idRanges)) {
            invalidIds.addAll(this.getInvalidIds(ids));
        }

        return invalidIds;
    }

    public List<String> getInvalidIds(String idRange) {
        return this.getInvalidIds(this.getIds(idRange));
    }

    public List<String> getInvalidIds(List<String> ids) {
        List<String> invalidIds = new ArrayList<>();

        for (String id : ids) {
            if (!this.database.isValidId(id)) {
                invalidIds.add(id);
            }
        }

        return invalidIds;
    }

    public long sumManyIds(String idRanges) {
        return this.sumManyIds(this.getManyIds(idRanges));
    }

    public long sumManyIds(List<List<String>> manyIds) {
        long sum = 0;

        for (List<String> ids : manyIds) {
            sum += this.sumIds(ids);
        }

        return sum;
    }

    public long sumIds(String idRange) {
        return this.sumIds(this.getIds(idRange));
    }
    
    public long sumIds(List<String> ids) {
        long sum = 0;

        for (String id : ids) {
            sum += Long.parseLong(id);
        }

        return sum;
    }
}
