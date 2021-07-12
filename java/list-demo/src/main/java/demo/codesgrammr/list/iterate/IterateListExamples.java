/*
 * Copyright 2021 Mong Kok Seong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package demo.codesgrammr.list.iterate;

import demo.codesgrammr.list.create.CreateListExamples;

import java.util.Iterator;
import java.util.List;

public class IterateListExamples {

    public static void main(String[] args) {
        IterateListExamples iterateListExamples = new IterateListExamples();
        iterateListExamples.runExamples();
    }

    public void runExamples() {
        CreateListExamples createListExamples = new CreateListExamples();

        iterateList(createListExamples.createUnmodifiableList());
    }

    private void iterateList(List myList) {

        System.out.println("== START == For Loop from index 0");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        System.out.println("== END ==");

        System.out.println("== START == While Loop from index 0");
        for (Object myItem : myList) {
            System.out.println(myItem);
        }
        System.out.println("== END ==");

        System.out.println("== START == List Iterator");
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("== END ==");

        System.out.println("== START == List's For Each");
        myList.forEach((myItem) -> {
            System.out.println(myItem);
        });
        System.out.println("== END ==");

        System.out.println("== START == Stream");
        myList.stream().forEach((myItem) -> {
            System.out.println(myItem);
        });
        System.out.println("== END ==");
    }
}
