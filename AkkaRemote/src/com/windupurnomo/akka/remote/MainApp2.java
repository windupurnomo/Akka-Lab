package com.windupurnomo.akka.remote;

public class MainApp2 {
	public static void main(String args[]){
		Application2 app = new Application2();
		
		while(true){
			app.doSomething("windu");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
