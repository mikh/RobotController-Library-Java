package test;

import robot.Robot_controller;

public class Debug {
	public static void main(String[] args){
		String words = "/d3000/Hello World567#/enter:300//d2000//ctrl/a/d2000//ctrl/c/d2000//ctrl/v/ctrl/v";
		System.out.println(Robot_controller.translate(words));
		Robot_controller.type(words);
	}
}
