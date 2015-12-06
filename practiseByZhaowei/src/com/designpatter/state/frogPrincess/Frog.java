package com.designpatter.state.frogPrincess;

public class Frog implements State {

	@Override
	public void response() {
		System.out.println("frog!");
	}
}