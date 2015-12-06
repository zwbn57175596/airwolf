package com.designpatter.state.frogPrincess;

public class Prince implements State {

	@Override
	public void response() {
		System.out.println("prince!");
	}
}