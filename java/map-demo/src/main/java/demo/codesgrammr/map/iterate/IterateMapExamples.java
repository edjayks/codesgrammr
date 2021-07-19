package demo.codesgrammr.map.iterate;

import java.util.Iterator;
import java.util.Map;

public class IterateMapExamples {

    public static void main(String[] args) {
        IterateMapExamples iterateMapExamples = new IterateMapExamples();
        iterateMapExamples.runExamples();
    }

    private void runExamples() {
        iterateViaEntrySet();
        iterateKeySet();
        iterateValues();
        iterateViaIterator();
        iterateViaForEach();
        iterateViaStream();
    }

    private void iterateViaEntrySet() {
        System.out.println("==================================================");

        Map<String, String> map = Map.of("a", "argentina", "b", "belarus", "c", "chile", "d", "denmark", "e", "england");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[iterateViaEntrySet" + "] " + "key: " + entry.getKey() + " value: " + entry.getValue());
        }

        System.out.println("==================================================");
    }

    private void iterateKeySet() {
        System.out.println("==================================================");

        Map<String, String> map = Map.of("a", "argentina", "b", "belarus", "c", "chile", "d", "denmark", "e", "england");

        for (String key : map.keySet()) {
            System.out.println("[iterateKeySet" + "] " + "key: " + key + " value: " + map.get(key));
        }
        System.out.println("==================================================");
    }

    private void iterateValues() {
        System.out.println("==================================================");

        Map<String, String> map = Map.of("a", "argentina", "b", "belarus", "c", "chile", "d", "denmark", "e", "england");

        for (String value : map.values()) {
            System.out.println("[iterateValues" + "] " + "value: " + value);
        }
        System.out.println("==================================================");
    }

    private void iterateViaIterator() {
        System.out.println("==================================================");

        Map<String, String> map = Map.of("a", "argentina", "b", "belarus", "c", "chile", "d", "denmark", "e", "england");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("[iterateViaIterator" + "] " + "key: " + entry.getKey() + " value: " + entry.getValue());
        }

        System.out.println("==================================================");
    }

    private void iterateViaForEach() {
        System.out.println("==================================================");

        Map<String, String> map = Map.of("a", "argentina", "b", "belarus", "c", "chile", "d", "denmark", "e", "england");

        map.forEach((k,v) -> System.out.println("[iterateViaForEach" + "] " + "key: " + k + " value: " + v));

        System.out.println("==================================================");
    }

    private void iterateViaStream() {
        System.out.println("==================================================");

        Map<String, String> map = Map.of("a", "argentina", "b", "belarus", "c", "chile", "d", "denmark", "e", "england");

        map.entrySet().stream()
                .forEach(entry -> System.out.println("[iterateViaForEach" + "] " + "key: " + entry.getKey() + " value: " + entry.getValue()));

        System.out.println("==================================================");
    }
}
