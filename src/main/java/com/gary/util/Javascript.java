package com.gary.util;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Map;

public class Javascript {
	public static Object execute(String javascript, String method, Map<String, Object> vars, Object...params) throws Exception{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("javascript");
        if (vars != null){
            for (Map.Entry<String, Object> entry : vars.entrySet()) {
                se.put(entry.getKey(), entry.getValue());
            }
        }
		se.eval(javascript);
        if (se instanceof Invocable) {  
            Invocable invoke = (Invocable) se;  
            return invoke.invokeFunction(method,params);  
        } 
        return null;
	}
}
