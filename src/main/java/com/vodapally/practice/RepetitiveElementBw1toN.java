package com.vodapally.practice;

import java.util.ArrayList;
import java.util.List;

public class RepetitiveElementBw1toN {
	 
    public int findDuplicateNumber(List<Integer> numbers){
         
        int highestNumber = numbers.size() - 1;
        int total = getSum(numbers);
        int duplicate = total - (highestNumber*(highestNumber+1)/2);
        return duplicate;
    }
     
    public int getSum(List<Integer> numbers){
         
        int sum = 0;
        for(int num:numbers){
            sum += num;
        }
        return sum;
    }
     
    public static void main(String a[]){
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i=1;i<=5;i++){
            numbers.add(i);
        }
        //add duplicate number into the list
        numbers.add(2);
        RepetitiveElementBw1toN dn = new RepetitiveElementBw1toN();
        System.out.println("Duplicate Number: "+dn.findDuplicateNumber(numbers));
    }
}
