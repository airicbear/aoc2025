# day 2 plan

after gaining entry into the north pole, we get to the gift shop.
an elf added a bunch of invalid product id's to their database.
you are given a bunch of ranges of id's.

## part 1

### product requirements

- find all invalid id's that appear in the ranges

- invalid id's are any id's with any sequence of digits repeated twice

- find the sum of all invalid id's

### example

```
11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
1698522-1698528,446443-446449,38593856-38593862,565653-565659,
824824821-824824827,2121212118-2121212124
```

- gives 1227775554

- 1010 is invalid because '10' repeats itself consecutively

### design

- 1 class to read document and run instructions

- 1 class to represent the gift shop

- 1 class to represent the database

### how to determine if an id is invalid

- we want O(n) if possible

- simple case (non-working solution):

for character in string:
    if character == next character:
        return invalid
        
- solving it for real:

    - suppose we have something like 10230301 - which should be invalid since '21' is repeated consecutively
    
    - compare '1' with '0' - no match; compare '0' with '2' - no match, etc.
    
    - compare '10' with '23' - no match; compare '02' with '30' - no match, etc. until '30' with '30' - match!
    
- different approach:

    - '1023' / '0301'
    - '102' / '303'; '023' / '030'; '230' / '301'
    - '10' / '23'; '02' / '30'; '23' / '03'; '30' / '30' - match!
    
    - in pseudocode...
    
    chunkSize = string length / 2
    
    for (chunkSize .. 0)
        for (i = 0; i < string length - chunkSize; i++)
            string[i, i + chunkSize - 1] = string[i + chunkSize, i + chunkSize * 2]    

11

cs = 1

---

j = 0; j < 1 - 0 = 0; j++

0, 0 + 1 - 1 = 0

0 + 1 = 1, 0 + 1 * 2 = 2

---

j = 0; j < 1; j++

0, 0

1, 1

---

chunk = 2

j = 0; j < 2; j++

0, 0 + 2 - 1 = 1

0 + 2, 0 + 2 * 2 - 1 = 3
p
---

0, 2

2, 4
