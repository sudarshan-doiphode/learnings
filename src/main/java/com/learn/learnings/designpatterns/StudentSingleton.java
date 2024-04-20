package com.learn.learnings.designpatterns;

public class StudentSingleton {
    private static StudentSingleton instance;

    private StudentSingleton() {

    }

    public static StudentSingleton getInstance() {
        if(instance == null) {
            instance = new StudentSingleton();
        }
        return instance;
    }

    static class Student {
        public static void main(String[] args) {
            StudentSingleton studentSingleton = StudentSingleton.getInstance();
            StudentSingleton studentSingleton1 = StudentSingleton.getInstance();
            boolean result = studentSingleton.equals(studentSingleton1);
            System.out.println(result);
        }
    }
}
