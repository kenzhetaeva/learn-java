package practice1;

import java.util.HashMap;
import java.util.Map;

public class AlmostMutableClass {
    private String field;
    private Map<String, String> fieldMap;

    public AlmostMutableClass(String field, Map<String, String> fieldMap) {
        this.field = field;
        this.fieldMap = fieldMap;
    }

    public String getField() {
        return field;
    }

    public Map<String, String> getFieldMap() {
//        return fieldMap;
        Map<String, String> deepCopy = new HashMap<String, String>();
        for(String key : fieldMap.keySet()) {
            deepCopy.put(key, fieldMap.get(key));
        }
        return deepCopy;
    }
}
