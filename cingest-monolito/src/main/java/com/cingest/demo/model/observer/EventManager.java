package com.cingest.demo.model.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cingest.demo.model.util.ApplicationConstants;

@Component
public class EventManager {
	 
	List<String> listeners = new ArrayList(Arrays.asList(ApplicationConstants.WEBHOOK_URL));
	
	@Autowired
	private EventListener eventListener;
	
	public void subscribe(String listener) {
		listeners.add(listener);
	}
	
	public void unsubscribe(String listener) {
		listeners.remove(listeners.indexOf(listener));
	}
	
	public void notify(String message) {
		for(String listener : listeners) {
			eventListener.alert(message, listener);
		}
	}
}
