package com.designpatter.state.frogPrincess;

public class KissingPrincess {
	// 标志位，标志是青蛙还是王子。
	private boolean isFrog = true;

	// 根据isFrog进行不同的操作。
	public void greet() {
		if (isFrog)
			System.out.println("frog!");
		else
			System.out.println("prince!");
	}

	// 将isFrog设置成false。
	public void kiss() {
		isFrog = false;
	}

	// 主函数。
	public static void main(String[] args) {
		KissingPrincess prince = new KissingPrincess();
		prince.greet();
		prince.kiss();
		prince.greet();
	}
}

