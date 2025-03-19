package com.vodapally.logics;

class M {
	public int var = 5;
}

class N extends M {
	public boolean var = false;
	//public int var = 10;
}

public class VariableNotOverrides {

	public static void main(String[] args) {
		M m = new N();
		N n = new N();

		System.out.println(" var = " + m.var); // var=5 -> variable does not override
		System.out.println(" var = " + n.var); // var= false

	}

}
