using System;
using System.Text;

namespace School {
    class School {
        private static Executor executor = new Executor();
        public static void Main(string[] args) {
            Console.WriteLine("Welcome to school. Please type a command or 'help' for a list of commands.");
            Students.StudentGenerator.generate();
            string input = Console.ReadLine();
            string[] inputArgs = new string[(input.Split(' ').Length - input.Split(' ')[0].Length)];
            if (input.Contains(" ")) inputArgs = input.Substring(input.Split(' ')[0].Length + 1, input.Length).Split(' ');
            Console.WriteLine(executor.onCommand(input.Split(' ')[0], inputArgs) + "\n\n");
        }
    }
}
