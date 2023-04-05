package org.wiseApp;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;

    private Map<String, String> params;
    public Rq(String command) {
        // 정리 시작

        String[] commandBits = command.split("\\?", 2);
        actionCode = commandBits[0];
        params = new HashMap<>();
        String[] paramsBits = commandBits[1].split("&");

        for (String paramStr : paramsBits) {
            String[] paramStrBits = paramStr.split("=", 2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];

            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParams(String key) {
        return params.get(key);
    }
}
