package me.Dinner1111.School.Schedule;

import java.util.Random;

import me.Dinner1111.School.Teachers.TeacherGenerator;
import me.Dinner1111.School.Utils.ArrayUtils;

public class ScheduleGenerator {
    private static final String[] classes = { 
        "Geometry", "Biology", "English I", "World History", "Computer Science", 
        "French", "Spanish", "Japanese", "Civics", "Chemistry",  
        "Business", "Algebra", "Calculus", "English II", "Physical Education" 
    };
    /**
     * Generates a random schedule
     * @return A random schedule
     */
    public static final String[] generate() {
        String[] schedule = new String[5];
        while (true) {
            for (int index = 0; index <= 5; index++)
                schedule[index] = classes[new Random().nextInt(classes.length)] + "," + TeacherGenerator.getTeacher();
            if (ArrayUtils.checkDuplicates((Object[]) schedule)) break;
        }
        return schedule;
    }
}