package ru.fkr.app.usb;

import java.util.ArrayList;
import java.util.List;



public class Counter {
	private Thread counterLoad;
	private int  n;
	private List<Integer> a = new ArrayList<>();
	public Counter(){
		counterLoad = new Thread(new CounterRun());
	}
	private class CounterRun implements Runnable{
		
		@Override
		public void run() {
			for (int i = 0; i <= n; i++){
				a.add(i);
			}
			
		}
		
	}
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
}
