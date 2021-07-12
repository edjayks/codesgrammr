/*
 * Copyright 2021 Mong Kok Seong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package demo.codesgrammr.list.search;

import demo.codesgrammr.list.create.CreateListExamples;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class FindListElementExamples {

    public static void main(String[] args) {
        FindListElementExamples findListElementExamples = new FindListElementExamples();
        findListElementExamples.runExamples();
    }

    public void runExamples() {
        CreateListExamples createListExamples = new CreateListExamples();

        findElement(createListExamples.createUnmodifiableList(), "c");
    }

    private void findElement(List myList, String elementToFind) {
        // loop via index
        System.out.println("== START == For Loop from index 0");
        boolean found = false;
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
            if (myList.get(i).equals(elementToFind)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Found it!");
        }
        System.out.println("== END ==");

        // enhanced for loop
        System.out.println("== START == While Loop from index 0");
        found = false;
        for (Object myItem : myList) {
            System.out.println(myItem);
            if (myItem.equals(elementToFind)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Found it!");
        }
        System.out.println("== END ==");

        // via iterator
        System.out.println("== START == List Iterator");
        found = false;
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            String myItem = iterator.next();
            System.out.println(myItem);
            if (myItem.equals(elementToFind)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Found it!");
        }
        System.out.println("== END ==");

        // via contains
        if (myList.contains(elementToFind)) {
            System.out.println("Found it!");
        }

        // via indexOf
        if (myList.indexOf(elementToFind) >= 0) {
            System.out.println("Found it!");
        }

        // via stream
        System.out.println("== START == Stream");
        Optional optional = myList.stream()
                .filter(myItem -> myItem.equals(elementToFind))
                .findFirst();

        if (optional.isPresent()) {
            System.out.println("Found it!");
        }
        System.out.println("== END ==");
    }
}
