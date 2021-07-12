/*
 * Copyright 2021 Mong Kok Seong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package demo.codesgrammr.list.create;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateListExamples {

    public static void main(String[] args) {
        CreateListExamples createListExamples = new CreateListExamples();
        createListExamples.runExamples();
    }

    public void runExamples() {
        createUnmodifiableList();
        createFixedList();
        createModifiableArrayList();
    }

    public List createUnmodifiableList() {
        // Create an unmodifiable list, you cannot modify existing item, nor delete and add new item
        List myList = List.of("a", "d", "c", "d", "e", "f");
        return myList;
    }

    public List createFixedList() {
        // Create a fixed size list, you cannot add new item or delete item, but you can modify existing item
        List myList = Arrays.asList("a", "d", "c", "d", "e", "f");
        return myList;

    }

    public List createModifiableArrayList() {
        // Create an Array list, you can modify it in anyway
        List myList = new ArrayList();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("e");
        myList.add("f");

        return myList;
    }
}
