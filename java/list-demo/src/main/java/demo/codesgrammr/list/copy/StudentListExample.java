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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentListExample {

    public static void main(String[] args) {
        StudentListExample studentListExample = new StudentListExample();
        studentListExample.runExample();
    }

    public void runExample() {

        // create 6 students
        Student studentOne = new Student("john", 1);
        Student studentTwo = new Student("bob", 2);
        Student studentThree = new Student("sarah", 3);
        Student studentFour = new Student("bill", 2);
        Student studentFive = new Student("kelly", 3);
        Student studentSix = new Student("alice", 1);

        // put all 6 students into a list
        List<Student> myStudents = Arrays.asList(studentOne, studentTwo, studentThree, studentFour, studentFive, studentSix);

        // copy the students into a new list
        List<Student> myNewStudents = new ArrayList<>(myStudents.size());
        myNewStudents.addAll(myStudents);

        // alter content of original list
        myStudents.get(1).setFullName("alien");

        System.out.println("== START == All elements in original list");
        // let's see all elements in original list
        myStudents.stream().forEach((myItem) -> {
            System.out.println(myItem.getFullName());
        });
        System.out.println("== END ==");
        System.out.println("");

        System.out.println("== START == All elements in new list");
        // see all elements in new list
        myNewStudents.stream().forEach((myItem) -> {
            System.out.println(myItem.getFullName());
        });
        System.out.println("== END ==");
        System.out.println("");
    }
}
