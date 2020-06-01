# RandomSelector

Randomly select values from a given range avoiding duplicates.

## Overview

A RandomSelector can be constructed in 2 ways. The first way is by specifying 
the number of values to choose from. So, as the test code shows, if 9 values is 
required, then integer values from 1 to 9 are available and can be randomly 
selected using the get() method. The second method is to provide the constructor 
with an array of integers, from which values will be selected.

## Test Code Output

Running the test code should produce something similar to the following:

	Initial state of sel (continuous sequence):
	  sel.getCount() = 9    sel.getAvailable() = 9  sel = 1, 2, 3, 4, 5, 6, 7, 8, 9

	Now randomly get all values, and then 1 more:
	  i = 0 - sel.getAvailable() = 9  sel.get() = 2  sel = 1, 9, 3, 4, 5, 6, 7, 8
	  i = 1 - sel.getAvailable() = 8  sel.get() = 1  sel = 8, 9, 3, 4, 5, 6, 7
	  i = 2 - sel.getAvailable() = 7  sel.get() = 8  sel = 7, 9, 3, 4, 5, 6
	  i = 3 - sel.getAvailable() = 6  sel.get() = 9  sel = 7, 6, 3, 4, 5
	  i = 4 - sel.getAvailable() = 5  sel.get() = 6  sel = 7, 5, 3, 4
	  i = 5 - sel.getAvailable() = 4  sel.get() = 7  sel = 4, 5, 3
	  i = 6 - sel.getAvailable() = 3  sel.get() = 5  sel = 4, 3
	  i = 7 - sel.getAvailable() = 2  sel.get() = 3  sel = 4
	  i = 8 - sel.getAvailable() = 1  sel.get() = 4  sel = 
	  i = 9 - sel.getAvailable() = 0  sel.get() = 0  sel = 

	State of sel after reset:
	  sel.getCount() = 9    sel.getAvailable() = 9  sel = 1, 2, 3, 4, 5, 6, 7, 8, 9

	Now randomly get 5 values:
	  i = 0 - sel.getAvailable() = 9  sel.get() = 8  sel = 1, 2, 3, 4, 5, 6, 7, 9
	  i = 1 - sel.getAvailable() = 8  sel.get() = 4  sel = 1, 2, 3, 9, 5, 6, 7
	  i = 2 - sel.getAvailable() = 7  sel.get() = 9  sel = 1, 2, 3, 7, 5, 6
	  i = 3 - sel.getAvailable() = 6  sel.get() = 7  sel = 1, 2, 3, 6, 5
	  i = 4 - sel.getAvailable() = 5  sel.get() = 2  sel = 1, 5, 3, 6

	Now try to remove the first 5 values and check validity:
	  i = 1 - sel.getAvailable() = 4  sel.remove(1) = removed  sel = 6, 5, 3
	  i = 2 - sel.getAvailable() = 3  sel.remove(2) = gone  sel = 6, 5, 3
	  i = 3 - sel.getAvailable() = 3  sel.remove(3) = removed  sel = 6, 5
	  i = 4 - sel.getAvailable() = 2  sel.remove(4) = gone  sel = 6, 5
	  i = 5 - sel.getAvailable() = 2  sel.remove(5) = removed  sel = 6

	Initial state of sel2 (customised sequence):
	  sel2.getCount() = 8    sel2.getAvailable() = 8  sel2 = 1, 1, 2, 3, 5, 8, 13, 21

	Now randomly get all values:
	  i = 0 - sel2.getAvailable() = 8  sel2.get() = 8  sel2 = 1, 1, 2, 3, 5, 21, 13
	  i = 1 - sel2.getAvailable() = 7  sel2.get() = 21  sel2 = 1, 1, 2, 3, 5, 13
	  i = 2 - sel2.getAvailable() = 6  sel2.get() = 5  sel2 = 1, 1, 2, 3, 13
	  i = 3 - sel2.getAvailable() = 5  sel2.get() = 1  sel2 = 1, 13, 2, 3
	  i = 4 - sel2.getAvailable() = 4  sel2.get() = 13  sel2 = 1, 3, 2
	  i = 5 - sel2.getAvailable() = 3  sel2.get() = 2  sel2 = 1, 3
	  i = 6 - sel2.getAvailable() = 2  sel2.get() = 1  sel2 = 3
	  i = 7 - sel2.getAvailable() = 1  sel2.get() = 3  sel2 = 
