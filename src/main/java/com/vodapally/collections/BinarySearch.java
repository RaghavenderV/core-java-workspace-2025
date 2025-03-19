package com.vodapally.collections;

import java.util.Arrays;

/**
 * @author Raghavender. V
 */
public class BinarySearch {

	public static void main(String[] args) throws Exception {

		int[] array = {6,8,44,81,56,10,34,87};
		Arrays.sort(array);
		System.out.println("input array: ");
		Arrays.stream(array).forEach(i -> System.out.print(i+ " "));
		
		int search = 87;
		System.out.println("\nSearch element index for "+search);

		binarySearch(array, search);
	}

	private static void binarySearch(int[] array, int search) {
		int p = -1, low = 0, mid, high = 8;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			// if search value is found at mid
			if (search == array[mid]) {
				p = mid;
				break;
			} 
			
			else if (search > array[mid]) {
				low = mid + 1;
			} 
			
			else if (search < array[mid]) {
				high = mid - 1;
			}
		} // while
		if (p == -1)
			System.out.println("Number does not exist in the array ");
		else {
			System.out.println("Number exists at index : " + (p ));
			System.out.println("Number found at position: "+(p+1));
		}

	}
}

/*
Binary Search Algorithm

Algorithm is quite simple. It can be done either recursively or iteratively:
Note: elements should be in sorted order
1. Get the middle element;
2. If the middle element equals to the searched value, the algorithm stops;
3. Otherwise, two cases are possible:
    * searched value is less than the middle element. In this case, go to the step 1 for the part 
    * of the array, before middle element.
    * searched value is greater, than the middle element. In this case, go to the step 1 for the part 
    * of the array, after middle element.

Now we should define, when iterations should stop. First case is when searched element is found. Second one is when 
sub array has no elements. In this case, we can conclude, that searched value doesn't present in the array.
Examples

Example 1. Find 6 in {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114}.

Step 1 (middle element is 19 > 6):     -1  5  6  18  19

Step 2 (middle element is 5 < 6):      -1  5  6  18  19 

Step 3 (middle element is 6 == 6):     6

*/