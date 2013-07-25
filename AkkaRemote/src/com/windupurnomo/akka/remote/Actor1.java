package com.windupurnomo.akka.remote;

import akka.actor.UntypedActor;

public class Actor1 extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof String){
			System.out.printf("Processing message: %s ...\n", message.toString());
			//getSender().tell(new StringBuilder(message.toString() + " ->result"), null);
		}else{
			unhandled(message);
		}
	}
	
}
