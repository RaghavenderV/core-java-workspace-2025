package com.vodapally.logics;

import java.util.ArrayList;
import java.util.List;

public class MoveAllZroesToTheRight {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 6, 0, 9, 1, 0, 7, 0, 4, 32 };
		List<Integer> list = new ArrayList<>();

		for (int i : arr) {
			list.add(i);
		}

		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 0) {
				count++;
				list.remove(i);//remove 0 element
				i--; 
			}
		}

		for (int i = 0; i < count; i++) {
			list.add(0);
		}

		System.out.println(list);
	}
}