package com.github.yin.spring.crafts.runtime;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class SettingsScope implements Scope {
    protected final Map<String, Object> beans = new HashMap<String, Object>();
    protected final Map<String, Runnable> onDestroy = new LinkedHashMap<String, Runnable>();

    public void onSettingChange() {
    	clear();
    }
    
	public Object get(String beanName, ObjectFactory<?> factory) {
		if (!beans.containsKey(beanName)) {
			beans.put(beanName, factory.getObject());
		}
		return beans.get(beanName);
	}

	public String getConversationId() {
		return String.valueOf(HelloWorld.counter);
	}

	public void registerDestructionCallback(String beanName, Runnable callback) {
		onDestroy.put(beanName, callback);
	}

	public Object remove(String beanName) {
		return beans.remove(beanName);
	}

	public Object resolveContextualObject(String arg0) {
		return null;
	}

    /**
     * Clears beans and processes all bean destruction callbacks.
     */
    protected final void clear() {
        processDestructionCallbacks();
        beans.clear();   
    }

    /**
     * Processes all bean destruction callbacks.
     */
    private final void processDestructionCallbacks() {
        for (String name: onDestroy.keySet()) {
            Runnable callback = onDestroy.get(name);
            callback.run();
        }
        onDestroy.clear();
    }
}
