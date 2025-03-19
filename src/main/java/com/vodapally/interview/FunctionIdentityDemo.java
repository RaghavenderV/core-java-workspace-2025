package com.vodapally.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FunctionIdentityDemo {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(5,6,6,7,9);

		Function<List, List> listFunc = Function.identity();
		System.out.println(listFunc.apply(list));
		
		Function<Integer, Integer> iFunc = Function.identity();
		System.out.println(iFunc.apply(34));
		System.out.println("-----------------------");
		
		//BinaryOperator demo
		BinaryOperator<Integer> biOp = (a,b)->a+b;
		System.out.println("Result: "+biOp.apply(5, 4));
		
		BinaryOperator<Integer> biOp1 = (a,b)->a;
		System.out.println("Result: "+biOp1.apply(5, 4));
		
		
		
		
		
	}

}
