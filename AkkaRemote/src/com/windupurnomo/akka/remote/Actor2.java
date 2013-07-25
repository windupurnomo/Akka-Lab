package com.windupurnomo.akka.remote;

import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.Identify;
import akka.actor.ReceiveTimeout;
import akka.actor.UntypedActor;

public class Actor2 extends UntypedActor{
	private ActorRef remoteActor = null;
	private String path;
	
	public Actor2(String path){
		this.path = path;
		sendIdentifyRequest();
	}
	
	private void sendIdentifyRequest() {
		getContext().actorSelection(path).tell(new Identify(path), getSelf());
	}
	
	@Override
	public void onReceive(Object msg) throws Exception {
		
		if(msg instanceof ActorIdentity){
			remoteActor = ((ActorIdentity) msg).getRef();
		}else if(msg.equals(ReceiveTimeout.getInstance())){
			sendIdentifyRequest();
		}else if(remoteActor == null){
			System.out.println("Server 1 not ready yet...");
		}else if(msg instanceof String){
			remoteActor.tell(msg, getSelf());
		}else if(msg instanceof StringBuilder){
			System.out.println(msg.toString() + " has been processed...");
		}else{
			unhandled(msg);
		}
		
	}
	
}
