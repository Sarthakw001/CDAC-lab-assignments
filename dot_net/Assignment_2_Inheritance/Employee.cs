namespace Assignment_3
{
	public interface IDbFunctions
	{

	}
	public abstract class Employee : IDbFunctions
	{
		private static int counter;
		protected String name;
		protected int EmpNo { get; }
		protected short deptNo;
		protected abstract decimal Basic { get; set; }

		public String Name
		{
			set
			{
				if (value.Equals(""))
				{
					Console.WriteLine("Empty String Not Allowed");
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

        public short DeptNo
        {
            set
            {
                if (value > 0)
                {
					deptNo = value;
                }
                else
                {
					Console.WriteLine("value must be greater than 0");
                }
            }
			get
			{
				return deptNo;
			}
        }
        public Employee(String name, short deptNo)
		{
			counter++;
			this.name = name;
			EmpNo = counter;
			this.deptNo = deptNo;
		}

        protected internal abstract decimal CalcNetSalary();
	}


    public class Manager : Employee, IDbFunctions
	{
		protected String designation;
		private decimal basic;
		public String Designation
        {
            set
            {
                if (value.Equals(""))
                {
                    Console.WriteLine("Empty String Not Allowed");
                }
                else
                {
                    designation = value;
                }
            }
			get
			{
				return designation;
			}
        }

		protected override decimal Basic
		{
			set
			{
				if(value > 1 && value < 9)
				{
					basic = value;
				}
				else
				{
					Console.WriteLine("Not in range");
				}
			}
			get
			{
				return basic;
			}
		}
		public Manager(String name,short deptNo, decimal basic, String designation) : base(name, deptNo)
		{
			this.designation = designation;
			this.basic = basic;
		}

        protected internal override decimal CalcNetSalary()
        {
			int basicSalary = 75000;
			return 9 / 10 * basicSalary;
        }
    }

	public class GeneralManager : Manager, IDbFunctions
	{
		protected String Perks { get; set; }
		private decimal basic;

        protected override decimal Basic
		{
			set
			{
				if(value > 11 && value < 50)
				{
					basic = value;
				}
				else
				{
					Console.WriteLine("Not in range");
				}
			}
			get
			{
				return basic;
			}
		}

		public GeneralManager(String name, short deptNo, decimal basic, String designation,String perks) : base(name, deptNo,basic,designation)
		{
			this.Perks = perks;
		}

        protected internal override decimal CalcNetSalary()
        {
            return base.CalcNetSalary() + 50000;
        }
    }

	public class CEO : Employee,IDbFunctions
	{
		private decimal basic;
		protected override decimal Basic
		{
			set
			{
				if (value > 100 && value < 500)
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

        protected internal sealed override decimal CalcNetSalary()
        {
			return 9 / 10 * 10000000;
        }

		public CEO(String name,short deptNo, decimal basic) : base(name, deptNo) 
		{
			this.basic = basic;
		}
    }
}

