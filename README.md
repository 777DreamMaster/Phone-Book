# Phone-Book

## Details

In this project there are used several alghoritms for searching users phone number. To analize speed of evry search method we have
the file **directory.txt** that contains the phone numbers of over a million people in multiple cities. And we need to find the numbers
of a few people whose names are listed in the file **find.txt**.
If the sorting process takes too long (more than 10 times longer than the linear search), the alghoritm swithed to linear search.

## Example

```
Start searching (linear search)...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.

Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 9 min. 15 sec. 291 ms.
Sorting time: 8 min. 45 sec. 251 ms.
Searching time: 0 min. 30 sec. 40 ms.

Start searching (quick sort + binary search)...
Found 500 / 500 entries. Time taken: 1 min. 21 sec. 996 ms.
Sorting time: 1 min. 17 sec. 381 ms.
Searching time: 0 min. 4 sec. 615 ms.

Start searching (hash table)...
Found 500 / 500 entries. Time taken: 0 min. 4 sec. 256 ms.
Creating time: 0 min. 4 sec. 121 ms.
Searching time: 0 min. 0 sec. 135 ms.
```
