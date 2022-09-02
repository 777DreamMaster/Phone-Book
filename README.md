# Phone-Book

## Details

In this project there are used several alghoritms for searching users phone number. To analize speed of evry search method we have
the file **directory.txt** that contains the phone numbers of over a million people in multiple cities. And we need to find the numbers
of a few people whose names are listed in the file **find.txt**.
If the sorting process takes too long (more than 10 times longer than the linear search), the alghoritm swithed to linear search.

## Example

```
Start searching (linear search)...
Found 500 / 500 entries. Time taken: 0 min. 1 sec. 982 ms.

Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 0 min. 21 sec. 526 ms.
Sorting time: Time taken: 0 min. 19 sec. 838 ms. - STOPPED, moved to linear search
Searching time: Time taken: 0 min. 1 sec. 688 ms.

Start searching (quick sort + binary search)...
Found 500 / 500 entries. Time taken: 0 min. 1 sec. 97 ms.
Sorting time: Time taken: 0 min. 1 sec. 93 ms.
Searching time: Time taken: 0 min. 0 sec. 4 ms.

Start searching (hash table)...
Found 500 / 500 entries. Time taken: 0 min. 0 sec. 260 ms.
Creating time: Time taken: 0 min. 0 sec. 260 ms.
Searching time: Time taken: 0 min. 0 sec. 0 ms.
```
