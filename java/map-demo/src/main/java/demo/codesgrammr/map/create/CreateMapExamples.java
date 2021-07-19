package demo.codesgrammr.map.create;

import demo.codesgrammr.map.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateMapExamples {

    private static Map myStaticMap;

    static {
        myStaticMap = new HashMap();
        myStaticMap.put("a", "argentina");
        myStaticMap.put("b", "belarus");
        myStaticMap.put("c", "chile");
        myStaticMap.put("d", "denmark");
        myStaticMap.put("e", "england");
    }

    public static void main(String[] args) {
        CreateMapExamples createMapExamples = new CreateMapExamples();
        createMapExamples.runExamples();
    }

    /**
     * Run all examples.
     */
    public void runExamples() {
        alterSingletonMap_ImmutableElement();
        alterSingletonMap_MutableElement();
        alterUnModifiableMap_ImmutableElement();
        alterUnModifiableMap_MutableElement();
        alterJava9ofMap_ImmutableElement();
        alterJava9ofMap_MutableElement();

        createMapViaMapEntries();
        createMapViaStreamMapEntries();
    }

    private void createMapViaMapEntries() {
        Map map = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("AFG", 004),
                new AbstractMap.SimpleEntry<>("BLR", 112),
                new AbstractMap.SimpleEntry<>("CHL", 152),
                new AbstractMap.SimpleEntry<>("DNK", 208),
                new AbstractMap.SimpleEntry<>("GBR", 826)
        );

        map.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
    }

    private void createMapViaStreamMapEntries() {
        Map map = Stream.of(
                new AbstractMap.SimpleEntry<>("AFG", 004),
                new AbstractMap.SimpleEntry<>("BLR", 112),
                new AbstractMap.SimpleEntry<>("CHL", 152),
                new AbstractMap.SimpleEntry<>("DNK", 208),
                new AbstractMap.SimpleEntry<>("GBR", 826)
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        map.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
    }

    private void alterSingletonMap_ImmutableElement() {
        Map map = Collections.singletonMap("a", "argentina");

        alterImmutableElementsMap(map, "alterSingletonMap_ImmutableElement");
    }

    private void alterSingletonMap_MutableElement() {
        // using custom object as element
        Map myMap = Collections.singletonMap("abu", new Student("abu", "smith", 23, 3));

        alterMutableElementsMap(myMap, "alterSingletonMap_MutableElement");
    }

    private void alterUnModifiableMap_ImmutableElement() {
        Map hashMap = new HashMap();
        hashMap.put("a", "argentina");
        hashMap.put("b", "belarus");
        hashMap.put("c", "chile");
        hashMap.put("d", "denmark");
        hashMap.put("e", "england");
        Map unModifiableMap = Collections.unmodifiableMap(hashMap);

        alterImmutableElementsMap(unModifiableMap, "alterUnModifiableMap_ImmutableElement");
    }

    private void alterUnModifiableMap_MutableElement() {
        Map hashMap = new HashMap();
        hashMap.put("abu", new Student("abu", "smith", 23, 3));
        hashMap.put("bob", new Student("bob", "smith", 23, 3));
        hashMap.put("charlie", new Student("charlie", "smith", 23, 3));
        hashMap.put("danny", new Student("danny", "smith", 23, 3));
        hashMap.put("elaine", new Student("elaine", "smith", 23, 3));
        Map unModifiableMap = Collections.unmodifiableMap(hashMap);

        alterMutableElementsMap(unModifiableMap, "alterUnModifiableMap_MutableElement");
    }

    private void alterJava9ofMap_ImmutableElement() {
        Map map = Map.of("a", "argentina", "b", "belarus", "c", "chile", "d", "denmark", "e", "england");

        alterImmutableElementsMap(map, "alterJava9ofMap_ImmutableElement");
    }

    private void alterJava9ofMap_MutableElement() {
        Map map = Map.of("abu", new Student("abu", "smith", 23, 3), "bob", new Student("bob", "smith", 23, 3));

        alterMutableElementsMap(map, "alterJava9ofMap_MutableElement");
    }

    private void alterImmutableElementsMap(Map map, String operationName) {
        System.out.println("==================================================");
        // add
        try {
            System.out.println("[" + operationName + "] " + "Trying to add element");
            map.put("b", "belarus");
        } catch (UnsupportedOperationException ex) {
            System.out.println("[" + operationName + "] " + ex + " , because Map size is fixed");
        }

        // remove
        try {
            System.out.println("[" + operationName + "] " + "Trying to remove element");
            map.remove("a");
        } catch (UnsupportedOperationException ex) {
            System.out.println("[" + operationName + "] " + ex + " , because Map size is fixed");
        }

        // overwrite
        try {
            System.out.println("[" + operationName + "] " + "Trying to overwrite element");
            map.put("a", "afghanistan");
        } catch (UnsupportedOperationException ex) {
            System.out.println("[" + operationName + "] " + ex + " , because Map size is fixed");
        }

        // get and change
        System.out.println("[" + operationName + "] " + "Trying to get and change element");
        String aString = (String) map.get("a");
        System.out.println("[" + operationName + "] " + "Element value : " + aString);
        aString = "changed_to_new_value";
        System.out.println("[" + operationName + "] " + "Map element value : " + map.get("a") + " String value : " + aString);

        System.out.println("==================================================");
    }

    private void alterMutableElementsMap(Map map, String operationName) {
        System.out.println("==================================================");

        try {
            System.out.println("[" + operationName + "] " + "Trying to add element");
            map.put("bob", new Student("bob", "loren", 33, 6));
        } catch (UnsupportedOperationException ex) {
            System.out.println("[" + operationName + "] " + ex + " , because Map size is fixed");
        }

        // remove
        try {
            System.out.println("[" + operationName + "] " + "Trying to remove element");
            map.remove("abu");
        } catch (UnsupportedOperationException ex) {
            System.out.println("[" + operationName + "] " + ex + " , because Map size is fixed");
        }

        // overwrite
        try {
            System.out.println("[" + operationName + "] " + "Trying to update element");
            map.put("abu", new Student("abu", "smith", 23, 3));
        } catch (UnsupportedOperationException ex) {
            System.out.println("[" + operationName + "] " + ex + " , because Map size is fixed");
        }

        // get and change
        System.out.println("[" + operationName + "] " + "Trying to get and change element");
        Student student = (Student) map.get("abu");
        System.out.println("[" + operationName + "] " + "Element value : " + student);
        student.setLastName("alien");
        System.out.println("[" + operationName + "] " + "Map element value : " + map.get("abu") + " String value : " + student);

        System.out.println("==================================================");
    }

}
