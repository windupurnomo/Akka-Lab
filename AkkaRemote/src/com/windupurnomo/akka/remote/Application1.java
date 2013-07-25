package com.windupurnomo.akka.remote;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.kernel.Bootable;

public class Application1 implements Bootable{
	
	private ActorSystem system;
	private ActorRef actor;
	
	public Application1(){
		this.system = ActorSystem.create("Application1", ConfigFactory.load().getConfig("app1"));
		actor = system.actorOf(Props.create(Actor1.class), "actor1");
		ActorSelection as = system.actorSelection("");
	}
	
	public void doSomething(Object msg){
		actor.tell(msg, null);
	}
	
	@Override
	public void shutdown() {
		system.shutdown();
		
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}
	
}
