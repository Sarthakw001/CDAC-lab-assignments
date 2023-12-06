namespace day_2A
{
    public class Employee
    {
        private static int counter;

        private string name;
        internal int EmpNo { get; }
        private decimal basic;
        private short deptNo;

        internal string Name
        {
            set
            {
                if (value.Equals(""))
                {
                    Console.Write("Name cannot be empty");
                }
                else
                {
                    name = value;
                }
            }
            get
            {
                return name;
            }
        }

        internal decimal Basic
        {
            set
            {
                if (value > 0 && value < 10)
                {
                    basic = value;
                }
                else
                {
                    Console.WriteLine("Not in Range");
                }
            }
            get
            {
                return basic;
            }
        }

        internal short DeptNo
        {
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("Value should be greater than 0");
            }
        }

        public Employee(string name = "", decimal basic = 1, short deptNo = 1)
        {
            counter++;
            this.name = name;
            EmpNo = counter;
            this.basic = basic;
            this.deptNo = deptNo;
        }

        internal decimal GetNetSalary()
        {
            decimal basicSalary = 75000;
            return 9 / 10 * basicSalary;
        }

    }
}

