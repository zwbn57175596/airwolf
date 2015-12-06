package com.designpatter.adapter.laptop;

/**
 * 标准电脑
 * @author airwolf
 *
 */
public class NationalStandardPower implements PowerOutput{
	
	public final int nationalStandardPower = 220;

	@Override
	public int outputPower() {
		System.out.println("标准电源接通。输出电压：" + nationalStandardPower + "V");
		return nationalStandardPower;
	}
}
