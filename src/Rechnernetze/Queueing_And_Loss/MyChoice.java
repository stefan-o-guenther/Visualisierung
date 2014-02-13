package Rechnernetze.Queueing_And_Loss;

import java.awt.Choice;

public class MyChoice extends Choice {
	private double vals[];

	public MyChoice(String items[], double values[], int defaultValue) {
		for (int i=0; i<items.length;i++) {
			super.addItem(items[i]);
		}
		vals=values;
		super.select(defaultValue-1);
	}
	
	public double getVal() {
		return  vals[super.getSelectedIndex()];
	}
}