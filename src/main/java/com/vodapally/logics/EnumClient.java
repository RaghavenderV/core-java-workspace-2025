package com.abhi.logics;

import java.util.ArrayList;
import java.util.List;

/*
* Author@ Raghavender Vodapally
* Date@ Jan 16, 2018
*/

enum RoleType {
	ADMIN, DEV, MANAGER, HR
}

enum EmployeeRoleType {
	ADMIN(10), DEV(20), MANAGER(30), HR(40); // we can assign some constant values

	private final int roleCode;

	private EmployeeRoleType(int roleCode) { // by default it is private
		this.roleCode = roleCode;
	}

	public int getRoleCode() { // getter method
		return roleCode;
	}

}

public class EnumClient {

	public static void main(String[] args) {
		//ArrayList<String> list;
		RoleType dev = RoleType.DEV;

		System.out.println("Print using sop");
		System.out.println(dev);
		System.out.println("-------------------------");

		RoleType[] values = RoleType.values();
		for (RoleType rt : values) {
			System.out.println(rt + "\t");
		}

		System.out.println("-----EmployeeRoleType-----");
		EmployeeRoleType[] values2 = EmployeeRoleType.values();

		for (EmployeeRoleType employeeRoleType : values2) {
			System.out.println(employeeRoleType + "\t" + employeeRoleType.getRoleCode() + "\t");
		}

	}

}
