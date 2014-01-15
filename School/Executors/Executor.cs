using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace School {
    class Executor {
        /**
         * Method called when a command is run
         * @param command The command run
         * @param args The arguments of the command
         * @return The information to display 
         */
        public string onCommand(string command, string[] args) {
            if (command.Equals("help"))
                if (args.Length == 0) return "Avaliable commands:"
                        + "\nHelp - Displays all commands.\n\tHelp [command] - Displays the command's description."
                        + "\nGrades - Displays average grades of all students in the class.\n\tGrades [student] - Display a student's grades."
                        + "\nTeacher [teacher] - Displays teacher information."
                        + "\nStudent [student] - Displays student information.";
                else if (args.Length == 1)
                    if (args[0].Equals("grades")) {
                        return "Help - Grades:"
                                + "\nThis command displays the average class grade, as well as a teacher grade based on the students opinions."
                                + "\n\nYou may also lookup a specific student's grades by using their name.";
                    } else if (args[0].Equals("teachers")) {
                        return "Help - Teacher:"
                                + "\nThis command displays the teacher's grade, based on student opinion. It will also display the lesson plans for the week.";
                    } else if (args[0].Equals("student")) {
                        return "Help - Student:"
                                + "\nThis command displays the student's grades, teacher and schedule.";
                    } else return "Invalid help subject.";
                else return "Too many arguments.";
            if (command.Equals("grades"))
                if (args.Length == 0) {
                    string format = "All student grade averages:\n";
                    string[] students = Students.StudentStorage.getAllStudents();
                    string[] grades = Students.StudentStorage.getAllGradeAverages();
                    for (int index = 0; index < students.Length; index++)
                        format += students[index] + "'s GPA: " + grades[index] + "\n";
                    return format.Substring(0, format.Length - 2);
                } else return "Too many arguments.";
            if (command.Equals("teacher"))
                if (args.Length == 0) {
                    string format = "Avaliable Teachers:";
                    string[] teachers = Teachers.TeacherGenerator.getAvaliableTeachers();
                    foreach (string teacher in teachers)
                        format += "\n  - " + teacher;
                    return format;
                } else if (args.Length == 1) {
                    if (!Teachers.TeacherStorage.verifyTeacher(args[0])) return "Invalid teacher.";
                    string[] teacherInfo = Teachers.TeacherStorage.getTeacherInfo(args[0]);
                    string format = "Teacher Info - " + teacherInfo[0] + ":";
                    for (int index = 1; index < teacherInfo.Length - 1; index++) 
                        format += "\n  - " + teacherInfo[index] + ": " + teacherInfo[++index];
                    return format;
                } else return "Too many arguments.";
            if (command.Equals("student"))
                if (args.Length == 0) {
                    string format = "All Students (" + Students.StudentStorage.getAllStudents().Length + "):";
                    foreach (string student in Students.StudentStorage.getAllStudents())
                        format += student + "\n";
                    return format.Substring(0, format.Length - 2);
                } else if (args.Length < 1) return "Too many arguments";
                else if (!Students.StudentStorage.checkStudent(args[0])) return "Invalid student.";
                else {
                    Students.StudentSetup instance = Students.StudentStorage.getStudentInstance(args[0]);
                    string format = "Student Report - " + args[0] + ":";
                    format += "\nSchedule:";
                    for (int index = 0; index <= 5; index++)
                        format += "\n  - " + instance.getSchedule()[index] + ": " + instance.getTeachers()[index];
                    format += "\nGrades:";
                    for (int index = 0; index <= 5; index++)
                        format += "\n  - " + instance.getSchedule()[index] + ": " + instance.getGrades()[index];
                    format += "\nGPA: " + instance.getGradeAverage();
                    return format;
                }
            return "Invalid command.";
        }
    }
}
