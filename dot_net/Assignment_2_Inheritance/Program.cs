namespace Assignment_3;

class Program
{
    static void Main(string[] args)
    {
        Employee employee = new Manager("Sarthak",4,11,"Asst. Manager");
        Console.WriteLine(employee.CalcNetSalary());
    }
}

