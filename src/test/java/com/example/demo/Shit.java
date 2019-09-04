package com.example.demo;

import java.util.Arrays;

import org.junit.Test;

public class Shit {
	@Test
	public void test1() {
		String s = "EW_N3011678757";
		String b = "﻿EW_N3011678757";
		
		System.out.println(Arrays.toString(s.getBytes()));
		System.out.println(Arrays.toString(b.getBytes()));
	}
}
