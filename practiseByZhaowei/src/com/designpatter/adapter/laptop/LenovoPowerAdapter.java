package com.designpatter.adapter.laptop;

/**
 * 电源适配器
 * @author airwolf
 *
 */
public class LenovoPowerAdapter implements PowerOutput{
	
	private int power;

	// 电源输出
	public int outputPower() {
		System.out.println("电源适配器输出： " + power + "V");
		return power;
	}
	
	// 电源输入
	private void input(PowerOutput out){
		this.power = out.outputPower();
		System.out.println("电源适配器输入： " + power + "V");
		powerChange(); //变压
	}
	
	public LenovoPowerAdapter(PowerOutput out) {
		input(out);
	}
	
	// 变压
	private void powerChange(){
		power = 20;
	}
}
