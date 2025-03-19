package com.vodapally.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//Finding pairs which equals to same result
//Eg: input: {1,2,3,4,5} output : [1,4],[2,3] & [1,5],[2,4]
public class ArrayPairs {
	public static void findPairs1(int[] arr) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				String pair = "[" + arr[i] + "," + arr[j] + "]";
				if (map.containsKey(sum)) {
					String s = map.get(sum);
					s += pair;
					map.put(sum, s);
				} else {
					map.put(sum, pair);
				}
			}
		}
		for (Entry<Integer, String> result : map.entrySet()) {
			String valList = result.getValue();
			if (valList.length() > 5) {
				System.out.println(valList);
			}

		}
	}
	
	

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5};
		findPairs1(arr);
	}

}
