namespace Assignment_2_Array;

class Program
{
    public static void MarksOfCDACStudentsBatchWise()
    {
        Console.WriteLine("Enter number of Batches in CDAC");
        int numberOfBatches = Convert.ToInt32(Console.ReadLine());
        int[][] marksOfStudents = new int[numberOfBatches][];

        for (int i = 0; i < numberOfBatches; i++)
        {
            Console.WriteLine("Enter the number of Students in " + i + 1 + " batch");
            int numberOfStudents = Convert.ToInt32(Console.ReadLine());
            marksOfStudents[i] = new int[numberOfStudents];

            for (int j = 0; j < numberOfStudents; j++)
            {
                Console.WriteLine("Enter the marks of Student " + j + 1 + " in batch " + i + 1);
                marksOfStudents[i][j] = Convert.ToInt32(Console.ReadLine());
            }
        }

        for (int i = 0; i < numberOfBatches; i++)
        {
            Console.WriteLine("Mark of batch " + i + 1 + " students");
            for (int j = 0; j < marksOfStudents[i].Length; j++)
            {
                Console.WriteLine("Student " + j + 1 + " : " + marksOfStudents[i][j]);
            }
        }
    }

    public static void EmployeeDetails()
    {
        Console.WriteLine("Enter the number of Employees");
        int numberOfEmp = Convert.ToInt32(Console.ReadLine());

        Employee[] employee = new Employee[numberOfEmp];
        for(int i = 0; i < numberOfEmp; i++)
        {
            Console.WriteLine("Enter the details of Employee" + i + 1);
            string name = Console.ReadLine();
            decimal basic = Convert.ToDecimal(Console.ReadLine());
            short deptNo = Convert.ToInt16(Console.ReadLine());
            employee[i] = new Employee(name,basic,deptNo);
        }

        decimal maxSalary = -1;
        Employee employee1 = new();
        for(int i = 0; i < numberOfEmp; i++)
        {
            if (employee[i].GetNetSalary() > maxSalary)
            {
                maxSalary = employee[i].GetNetSalary();
                employee1 = employee[i];
            }
        }
        Console.WriteLine(employee1.ToString());

        Console.WriteLine("Enter EmpNo to be searched");
        int empNo = Convert.ToInt32(Console.ReadLine());

        for(int i = 0; i < numberOfEmp; i++)
        {
            if (employee[i].EmpNo == empNo)
            {
                Console.WriteLine(employee[i].ToString());
                break;
            }
        }

    }
    static void Main(string[] args)
    {
        MarksOfCDACStudentsBatchWise();
        EmployeeDetails();
    }
}
