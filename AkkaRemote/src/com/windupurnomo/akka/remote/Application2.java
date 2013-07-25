package com.windupurnomo.akka.remote;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.kernel.Bootable;

public class Application2 implements Bootable{
	private ActorSystem system;
	private ActorRef actor;
	
	public Application2(){
		system = ActorSystem.create("Application2", ConfigFactory.load().getConfig("app2"));
		final String path = "akka.tcp://Application1@127.0.0.1:2552/user/actor1";
		actor = system.actorOf(Props.create(Actor2.class, path), "actor2");
	}
	
	public void doSomething(String msg){
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
