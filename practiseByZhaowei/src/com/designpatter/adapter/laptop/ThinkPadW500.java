package com.designpatter.adapter.laptop;

/**
 * THINKPAD W500型电脑
 * @author airwolf
 *
 */
public class ThinkPadW500 {

	//当前电源
	private int power;

	//电脑电源标准20V
	private final int laptopStandard = 20;
	
	//电源适配器
	private LenovoPowerAdapter adapter;

	private void pluginPower(PowerOutput out) {
		power = out.outputPower(); // 接入电源
		System.out.println("电脑接通" + power + "V电源");
	}

	// 启动电脑
	public void startComputer() {
		if (this.power > this.laptopStandard) { //电压是否过大
			System.out.println("电脑被烧毁");
		} else {
			System.out.println("电脑开始启动");
		}
	}

	public ThinkPadW500(PowerOutput out) {
		adapter = new LenovoPowerAdapter(out);
		pluginPower(adapter);
//		pluginPower(out);
	}

	public static void main(String[] args) {
		PowerOutput po = new NationalStandardPower();
		ThinkPadW500 w500 = new ThinkPadW500(po);
		w500.startComputer();
	}

}
