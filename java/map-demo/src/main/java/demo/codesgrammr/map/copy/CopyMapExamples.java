package demo.codesgrammr.map.copy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CopyMapExamples {

    public static void main(String[] args) {
        CopyMapExamples copyMapExamples = new CopyMapExamples();
        copyMapExamples.runExamples();
    }

    public void runExamples() {
        copyViaConstructor();
        copyFromMap();
        cloneFromHashMap();
        loopAndCopy();
        streamAndCopy();
    }

    private void copyViaConstructor() {
        System.out.println("==================================================");
        Map hashMap = new HashMap();
        hashMap.put("a", "argentina");
        hashMap.put("b", "belarus");
        hashMap.put("c", "chile");
        hashMap.put("d", "denmark");
        hashMap.put("e", "england");

        // copy the map by passing into HashMap's constructor
        Map newHashMap = new HashMap(hashMap);
        newHashMap.forEach((k, v) -> System.out.println("[copyViaConstructor" + "] " + "key:" + k + " value:" + v));
        System.out.println("==================================================");
    }

    private void copyFromMap() {
        System.out.println("==================================================");
        Map hashMap = new HashMap();
        hashMap.put("a", "argentina");
        hashMap.put("b", "belarus");
        hashMap.put("c", "chile");
        hashMap.put("d", "denmark");
        hashMap.put("e", "england");

        Map newHashMap = new HashMap();
        // here we do the copy
        newHashMap.putAll(hashMap);

        newHashMap.forEach((k, v) -> System.out.println("[copyFromMap" + "] " + "key:" + k + " value:" + v));
        System.out.println("==================================================");
    }

    private void cloneFromHashMap() {
        System.out.println("==================================================");
        // we declare a HashMap object
        HashMap hashMap = new HashMap();
        hashMap.put("a", "argentina");
        hashMap.put("b", "belarus");
        hashMap.put("c", "chile");
        hashMap.put("d", "denmark");
        hashMap.put("e", "england");

        // here we do the copy
        HashMap newHashMap = (HashMap) hashMap.clone();

        newHashMap.forEach((k, v) -> System.out.println("[cloneFromHashMap" + "] " + "key:" + k + " value:" + v));
        System.out.println("==================================================");
    }

    private void loopAndCopy() {
        System.out.println("==================================================");
        Map<String, String> map = new HashMap();
        map.put("a", "argentina");
        map.put("b", "belarus");
        map.put("c", "chile");
        map.put("d", "denmark");
        map.put("e", "england");

        Map newMap = new HashMap();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }

        newMap.forEach((k, v) -> System.out.println("[loopAndCopy" + "] " + "key:" + k + " value:" + v));
        System.out.println("==================================================");
    }

    private void streamAndCopy() {
        System.out.println("==================================================");
        Map<String, String> map = new HashMap();
        map.put("a", "argentina");
        map.put("b", "belarus");
        map.put("c", "chile");
        map.put("d", "denmark");
        map.put("e", "england");

        Map newMap = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        newMap.forEach((k, v) -> System.out.println("[streamAndCopy" + "] " + "key:" + k + " value:" + v));
        System.out.println("==================================================");
    }


}
