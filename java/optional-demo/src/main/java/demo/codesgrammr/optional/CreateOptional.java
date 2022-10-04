package demo.codesgrammr.optional;

import java.util.*;

public class CreateOptional {

    public static void main(String[] args) {
//        creationExamples();
//        getExamples();
//        isPresentExamples();
//        orElseExamples();
//        orElseGetExamples();
//        ifPresentExamples();
//        filterExample();
//        mapExample();
        flatMapExample();
    }

    private static void creationExamples() {
        // empty optional
        Optional<String> emptyOptional = Optional.empty();
        // this will result in NoSuchElementException
//        System.out.println("Empty optional value: " + emptyOptional.get());

        String nullString = null;
        // do some operations on the string...
        // wrap into  Optional
        Optional<String> optional = Optional.ofNullable(nullString);

        String s = new String("one to three jump");
        // do some operations on the string...
        // wrap a String into optional, of() does not allow null value
        Optional<String> optionalS = Optional.of(s);

        // wrap a Double into optional
        Double d = Double.valueOf(12.2d);
        Optional<Double> doubleOptional = Optional.of(d);

        Optional<List> listOptional = Optional.ofNullable(new ArrayList());

        Optional<Map> mapOptional = Optional.ofNullable(new HashMap());

        Optional<School> schoolOptional = Optional.of(new School());
    }

    private static void getExamples() {
        String s = new String("one to three jump");
        Optional<String> optionalS = Optional.ofNullable(s);
        System.out.println(optionalS.get());

        Optional<String> nullS = Optional.ofNullable(null);
        // calling get will give us NoSuchElementException
//        System.out.println(nullS.get());
    }

    private static void isPresentExamples() {
        Optional<String> nullS = Optional.ofNullable(null);

        if (nullS.isPresent()) {
            System.out.println(nullS.get());
        }
    }

    private static void orElseExamples() {
        Optional<String> nullS = Optional.ofNullable(null);

        System.out.println(nullS.orElse("Nothing's in there"));
    }

    private static void orElseGetExamples() {
        Optional<String> nullS = Optional.ofNullable(null);

        System.out.println(nullS.orElseGet(() -> returnSomething()));
    }

    private static String returnSomething() {
        return "something";
    }

    private static void ifPresentExamples() {
        Optional<String> optionalS = Optional.ofNullable("My name is Ali");

        optionalS.ifPresent(s -> System.out.println("Hello " + s));

        System.out.println(optionalS.get());
    }

    private static void filterExample() {
        Optional<String> optionalS = Optional.ofNullable("My name is Ali");

        String matched = optionalS.filter(s -> {
            if(s.contains("banana")) {
                return true;
            }
            return false;
        }).get();

        System.out.println(matched);
    }

    private static void mapExample() {
        // example 1
        Optional<String> optionalS = Optional.ofNullable("My name is Ali");

        Optional<String> anotherOptionalS = optionalS.map(s -> s = "Hello " + s);

        System.out.println(anotherOptionalS.get());
        // above will output: Hello My name is Ali

        System.out.println(optionalS.get());
        // above will output: My name is Ali


        // example 2
        Optional<School> schoolOptional = fetchMeASchool();
        Optional<School> anotherSchoolOptional = schoolOptional.map(s -> {
            s.setOpen(true);
            return s;
        });
        System.out.println("Is another school open: " + anotherSchoolOptional.get().isOpen());
        // above will output: true
        System.out.println("Is school open: " + schoolOptional.get().isOpen());
        // above will output: true

        // example 3
        Optional<Map<String, List>> multiValueConfigMap = fetchMultiValueConfigMap();
        // as you can see below, there is no flattening
        multiValueConfigMap.map(m -> {
            for (Map.Entry<String, List> entry : m.entrySet()) {
                // do something
            }
            return m;
        });
    }

    private static void flatMapExample() {
        // Example 1
        Optional<String> optionalS = Optional.ofNullable("My name is Ali");

        // we are asked to wrap into an Optional ourselves
        Optional<String> anotherOptionalS = optionalS.flatMap(s -> Optional.of("Hello " + s));

        System.out.println(anotherOptionalS.get());
        // above will output: Hello My name is Ali

        System.out.println(optionalS.get());
        // above will output: My name is Ali


        // example 2
        Optional<School> schoolOptional = fetchMeASchool();

        Optional<School> anotherSchoolOptional = schoolOptional.flatMap(s -> {
            s.setOpen(true);
            return Optional.of(s);
        });
        System.out.println("Is another school open: " + anotherSchoolOptional.get().isOpen());
        // above will output: true
        System.out.println("Is school open: " + schoolOptional.get().isOpen());
        // above will output: true

        // example 3
        Optional<Map<String, List>> multiValueConfigMap = fetchMultiValueConfigMap();
        // as you can see below, there is no flattening
        multiValueConfigMap.flatMap(m -> {
            for (Map.Entry<String, List> entry : m.entrySet()) {
                // do something
            }
            return Optional.of(m);
        });
    }

    private static Optional<School> fetchMeASchool() {
        School goodSchool = new School();
        goodSchool.setName("Good for You High School");
        goodSchool.setOpen(true);

        return Optional.of(goodSchool);
    }

    private static Optional<Map<String, List>> fetchMultiValueConfigMap() {
        Map<String, List> multiValueMap = new HashMap<>();

        multiValueMap.put("acceptable_file_types", List.of("jpg","png","bmp"));
        multiValueMap.put("whitelisted_ip_addresses", List.of("10.128.0.1","10.128.0.2","10.128.0.3"));
        multiValueMap.put("blacklisted_ip_addresses", List.of("10.128.0.2"));

        return Optional.of(multiValueMap);
    }
}
