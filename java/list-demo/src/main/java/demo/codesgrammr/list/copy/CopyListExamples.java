/*
 * Copyright 2021 Mong Kok Seong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package demo.codesgrammr.list.copy;

import demo.codesgrammr.list.create.CreateListExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CopyListExamples {

    public static void main(String[] args) {
        CopyListExamples copyListExamples = new CopyListExamples();
        copyListExamples.runExamples();
    }

    public void runExamples() {
        CreateListExamples createListExamples = new CreateListExamples();

        copyToList_Constructor(createListExamples.createModifiableArrayList());
        copyToList_AddAll(createListExamples.createModifiableArrayList());
        copyToList_Stream(createListExamples.createModifiableArrayList());
        copyToList_List(createListExamples.createModifiableArrayList());

        String[] myArray = new String[] {"a","b","c","d","e","f"};
        copyfromArray_asList(myArray);
        copyfromArray_addAll(myArray);
        copyfromArray_stream(myArray);
    }

    private List copyToList_Constructor(List myList) {
        System.out.println("== START == Copy list to list using ArrayList Constructor");
        // using built-in copyOf() method
        List myNewList = new ArrayList(myList);
        System.out.println("=> Done copying.");

        myList.add("z");
        myList.set(0, "b");

        System.out.println("=> myList elements:");
        myList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("=> myNewList elements:");
        myNewList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("== END ==");
        System.out.println("");

        return myNewList;
    }

    private List copyToList_AddAll(List myList) {
        System.out.println("== START == Copy list to list using list's addAll()");

        List myNewList = new ArrayList(myList.size());
        myNewList.addAll(myList);
        System.out.println("=> Done copying.");

        myList.add("z");
        myList.set(0, "b");
        myNewList.add("gg");

        System.out.println("=> myList elements");
        myList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("=> myNewList elements");
        myNewList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("== END ==");
        System.out.println("");

        return myNewList;
    }

    private List copyToList_Stream(List myList) {
        System.out.println("== START == Copy list to list using lists' stream");
        // using built-in copyOf() method
        List myNewList = (List) myList.stream().collect(Collectors.toList());
        System.out.println("=> Done copying.");

        myList.add("z");
        myList.set(0, "b");
        myNewList.add("gg");

        System.out.println("=> myNewList elements");
        myNewList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("=> myList elements");
        myList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });
        System.out.println("== END ==");
        System.out.println("");
        return myNewList;
    }

    // this only available starting java 10
    private List copyToList_List(List myList) {
        System.out.println("== START == Copy list to list using List.copyOf(), Java 10 and above only");
        // using built-in copyOf() method
        List myNewList = List.copyOf(myList);
        System.out.println("=> Done copying.");

        myList.add("z");
        myList.set(0, "b");

        // myNewList is unmodifiable, if we do this, we will get an UnsupportedOperationException
//        myNewList.add("gg");

        System.out.println("=> myNewList elements");
        myNewList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("=> myList elements");
        myList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });
        System.out.println("== END ==");
        System.out.println("");

        return myNewList;
    }

    private List copyfromArray_asList(String[] myArray) {
        System.out.println("== START == Copy array to list using Arrays.asList()");

        List myNewList = Arrays.asList(myArray);
        System.out.println("=> Done copying.");

        System.out.println("=> myNewList elements");
        myNewList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("=> myArray elements");
        for (String myItem : myArray) {
            System.out.println(myItem);
        }
        System.out.println("== END ==");
        System.out.println("");

        return myNewList;
    }

    private List copyfromArray_addAll(String[] myArray) {
        System.out.println("== START == Copy array to list using Collections.addAll()");

        List myNewList = new ArrayList(myArray.length);
        Collections.addAll(myNewList, myArray);
        System.out.println("=> Done copying.");

        System.out.println("=> myNewList elements");
        myNewList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("=> myArray elements");
        for (String myItem : myArray) {
            System.out.println(myItem);
        }
        System.out.println("== END ==");
        System.out.println("");

        return myNewList;
    }

    private List copyfromArray_stream(String[] myArray) {
        System.out.println("== START == Copy array to list using Arrays.stream()");

        List myNewList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println("=> Done copying.");

        System.out.println("=> myNewList elements");
        myNewList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });

        System.out.println("=> myArray elements");
        for (String myItem : myArray) {
            System.out.println(myItem);
        }
        System.out.println("== END ==");
        System.out.println("");

        return myNewList;
    }
}
