package com.vodapally.interview;

public class FindMinDistanceBetweenTwoWords {

	public static void main(String[] args) {
		
		String str = "use cloudtech for learning java";
		String s1="cloudtech";
		String s2="java";
		
	}
	
	public static int distance(String s, String w1, String w2) {
		if(w1.equals(w2))
		  return 0;
		
		String words[] = s.split(" ");
		int minDist = words.length+1;
		
		for (int index = 0; index < words.length; index++) {
			if(words[index].equals(w1)) {
				for (int search = 0; search < words.length; search++) {
					if(words[search].equals(w2)) {
						int current = Math.abs(index-search)-1;
						
						if(current<minDist)
							minDist=current;
						
					}
				}
			}
		}
		
		
		return minDist;
	}

}
