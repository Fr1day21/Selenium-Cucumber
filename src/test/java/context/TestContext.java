package context;

import java.util.HashMap;
import java.util.Map;

//using for implement get input value, can use for validation and more
public class TestContext {
    private Map<String, Object> data = new HashMap<>();

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(data.get(key));
    }
}
