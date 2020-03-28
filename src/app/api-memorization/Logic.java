package app;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class Logic {
    /**
     * 入力文字列が整数値か確認する
     * @param input
     * @return
     */
    public static boolean checkIsIntegerValue(String input) {
        boolean isDigit = true;
        for (int i = 0; i < input.length(); i++) {
            isDigit = Character.isDigit(input.charAt(i));
            if (!isDigit) {
                break;
            }
        }
        return isDigit;
    }

    /**
     * APIレスポンスをJSONのMapに変換
     */
    public static Map<String, String> transJsonMapFromResponse(String response) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        Map<String, String> jsonMap = new HashMap<>();

        try {
            // JavaScriptの実行
            Object obj = engine.eval(String.format("(%s)", response));
            // リフレクションでScriptObjectMirrorクラスの取得
            Class scriptClass = Class.forName("jdk.nashorn.api.scripting.ScriptObjectMirror");
            // リフレクションでキーセットを取得
            Object[] keys = ((java.util.Set)obj.getClass().getMethod("keySet").invoke(obj)).toArray();
            // リフレクションでgetメソッドを取得
            Method method_get = obj.getClass().getMethod("get", Class.forName("java.lang.Object"));

            for(Object key : keys) {
                Object val = method_get.invoke(obj, key);
                jsonMap.put(key.toString(), val.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonMap;
    }
}