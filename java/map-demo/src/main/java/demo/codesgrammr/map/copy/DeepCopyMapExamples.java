package demo.codesgrammr.map.copy;

import demo.codesgrammr.map.Student;

import java.util.*;

public class DeepCopyMapExamples {

    public static void main(String[] args) {
        DeepCopyMapExamples deepCopyMapExamples = new DeepCopyMapExamples();
        deepCopyMapExamples.runExamples();
    }

    private void runExamples() {
        // all our students
        Student studentA = new Student("angel", "ali", 21, 4);
        Student studentB = new Student("billy", "bobby", 20, 3);
        Student studentC = new Student("cereal", "charlie", 22, 5);

        // studentA, B and C all belong to this university
        University universityOne = new University("University of Your Imagination");
        Map<University, List<Student>> universityStudentMap = new HashMap<>();
        universityStudentMap.put(universityOne, Arrays.asList(studentA, studentB, studentC));

        // the map we will copy everything into
        Map<University, List<Student>> newMap = copyMap(universityStudentMap);

        // try to change a single student particular in the old map
        studentA.setAge(44);
        universityOne.setName("University of Star Studies");
        universityStudentMap.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
        // notice the student A in here still age 21
        newMap.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));

    }

    private Map copyMap(Map<University, List<Student>> universityStudentMap) {
        // the map we will copy everything into
        Map<University, List<Student>> newMap = new HashMap<>();

        for (Map.Entry<University, List<Student>> entry : universityStudentMap.entrySet()) {

            List<Student> newStudentList = new ArrayList<>();
            for (Student student : entry.getValue()) {
                // build new student object with immutable field values from existing student list
                newStudentList.add(new Student(student.getFirstName(), student.getLastName(), student.getAge(), student.getGrade()));
            }

            University university = new University(entry.getKey().getName());
            newMap.put(university, newStudentList);
        }
        return newMap;
    }
}
