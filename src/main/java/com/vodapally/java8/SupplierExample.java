package com.vodapally.java8;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		// Supplier is a functional interface; it takes no arguments and returns result
		Supplier<LocalDateTime> s  = () -> LocalDateTime.now();
		LocalDateTime time = s.get();
		System.out.println("Time : "+time);
		
	}

}
