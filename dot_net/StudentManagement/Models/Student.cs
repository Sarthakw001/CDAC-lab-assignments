using Microsoft.Data.SqlClient;
using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Models
{
    public class Student
    {
        public int StudentNo { get; set; }
        [Required(ErrorMessage = "Name required")]
        public string? Name { get; set; }
        [Required(ErrorMessage ="Section Required")]
        public string? Section { get; set; }
        [Required(ErrorMessage ="Branch Required")]
        public string? Branch { get; set; }
        [Required(ErrorMessage ="Email Required")]
        [EmailAddress]
        public string? EmailId { get; set; }

        public static void Insert(Student student)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=student_details;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            try
            {
                cn.Open();
                SqlCommand insert = new SqlCommand();
                insert.Connection = cn;
                insert.CommandType = System.Data.CommandType.Text;
                insert.CommandText = "insert into student values(@Name,@Section,@Branch,@EmailId)";

               // insert.Parameters.AddWithValue("@StudentNo", student.StudentNo);
                insert.Parameters.AddWithValue("@Name", student.Name);
                insert.Parameters.AddWithValue("@Section", student.Section);
                insert.Parameters.AddWithValue("@Branch", student.Branch);
                insert.Parameters.AddWithValue("@EmailId", student.EmailId);

                insert.ExecuteNonQuery();

                Console.WriteLine("Student inserted");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally 
            { 
                cn.Close();
            }
        }

        public static void Edit(Student student)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=student_details;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            try
            {
                cn.Open();
                SqlCommand edit = new SqlCommand();
                edit.Connection = cn;
                edit.CommandType = System.Data.CommandType.Text;
                edit.CommandText = "update student set Name=@Name,Section=@Section,Branch=@Branch,EmailId=@EmailId where StudentNo=@StudentNo";

                edit.Parameters.AddWithValue("@Name", student.Name);
                edit.Parameters.AddWithValue("@Section", student.Section);
                edit.Parameters.AddWithValue("@Branch", student.Branch);
                edit.Parameters.AddWithValue("@EmailId", student.EmailId);
                edit.Parameters.AddWithValue("@StudentNo", student.StudentNo);


                edit.ExecuteNonQuery();

                Console.WriteLine("Student updated");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        public static void Delete(Student student)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=student_details;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            try
            {
                cn.Open();
                SqlCommand delete = new SqlCommand();
                delete.Connection = cn;
                delete.CommandType = System.Data.CommandType.Text;
                delete.CommandText = $"delete from student where StudentNo={student.StudentNo}";

               // delete.Parameters.AddWithValue("@StudentNo", student.StudentNo);


                delete.ExecuteNonQuery();

                Console.WriteLine("Student deleted");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        public static List<Student> Read()
        {
            List<Student> list = new List<Student>();
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=student_details;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            try
            {
                cn.Open();
                SqlCommand read = new SqlCommand();
                read.Connection = cn;
                read.CommandType = System.Data.CommandType.Text;
                read.CommandText = "select StudentNo,Name,Section,Branch,EmailId from student";

                SqlDataReader reader = read.ExecuteReader();
                while (reader.Read())
                {
                    list.Add(new Student { StudentNo= reader.GetInt32(0), Name = reader.GetString(1), Section = reader.GetString(2), Branch = reader.GetString(3), EmailId = reader.GetString(4) });
                }
                reader.Close();

                Console.WriteLine("Reading values from DB...........");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
            return list;
        }

        public static Student? ReadStudent(int id) 
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=student_details;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            try
            {
                cn.Open();
                SqlCommand read = new SqlCommand();
                read.Connection = cn;
                read.CommandType = System.Data.CommandType.Text;
                read.CommandText = $"select * from student where StudentNo={id}";

                SqlDataReader reader = read.ExecuteReader();
                if (reader.Read())
                {
                    return (new Student {StudentNo=reader.GetInt32(0), Name = reader.GetString(1), Section = reader.GetString(2), Branch = reader.GetString(3), EmailId = reader.GetString(4) });
                }
                reader.Close();

                Console.WriteLine("Reading single value from DB...........");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
            return null;
        }


    }
}
