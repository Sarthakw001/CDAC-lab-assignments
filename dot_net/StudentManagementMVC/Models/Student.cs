using Microsoft.Data.SqlClient;
using System.Data;

namespace StudentManagementMVC.Models
{
    public class Student
    {

        public int StudentNo { get; set; }
        public string? Name { get; set; }
        public string? Section { get; set; }
        public string? Branch { get; set; }

        public string? EmailId { get; set; }
        public static void Insert(Student obj)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=StudentDB;Integrated Security=True";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "insert into tbl_student values(@StudentNo,@Name,@Section,@Branch,@EmailId)";



                cmdInsert.Parameters.AddWithValue("@StudentNo", obj.StudentNo);
                cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                cmdInsert.Parameters.AddWithValue("@Section", obj.Section);
                cmdInsert.Parameters.AddWithValue("@Branch", obj.Branch);
                cmdInsert.Parameters.AddWithValue("@EmailId", obj.EmailId);
                cmdInsert.ExecuteNonQuery();

            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }

        }
        public static void Update(Student obj)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=StudentDB;Integrated Security=True";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "update tbl_student set Name=@Name, Section=@Section, Branch=@Branch ,EmailId=@EmailId where StudentNo=@StudentNo";




                cmdInsert.Parameters.AddWithValue("@StudentNo", obj.StudentNo);
                cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                cmdInsert.Parameters.AddWithValue("@Section", obj.Section);
                cmdInsert.Parameters.AddWithValue("@Branch", obj.Branch);
                cmdInsert.Parameters.AddWithValue("@EmailId", obj.EmailId);
                cmdInsert.ExecuteNonQuery();



            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }



        }
        public static void Delete(int StudentNo)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=StudentDB;Integrated Security=True";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "delete from tbl_student where StudentNo =@StudentNo";
                cmdInsert.Parameters.AddWithValue("@StudentNo", StudentNo);
                cmdInsert.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }




        }
        public static Student GetSingleStudent(int StudentNo)
        {
            Student obj = new Student();
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=StudentDB;Integrated Security=True";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "select * from tbl_student where StudentNo=@StudentNo";
                cmdInsert.Parameters.AddWithValue("@StudentNo", StudentNo);
                SqlDataReader dr = cmdInsert.ExecuteReader();
                if (dr.Read())
                {
                    obj.StudentNo = dr.GetInt32("StudentNo");
                    obj.Name = dr.GetString("Name");
                    obj.Section = dr.GetString("Section");
                    obj.@Branch = dr.GetString("@Branch");
                    obj.EmailId = dr.GetString("EmailId");
                }
                else
                {
                    obj = null;
                    //record not present
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }
            return obj;
        }
        public static List<Student> GetAllStudent()
        {
            List<Student> lstStud = new List<Student>();
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=StudentDB;Integrated Security=True";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "select * from tbl_student ";
                SqlDataReader dr = cmdInsert.ExecuteReader();
                while (dr.Read()) 
                    lstStud.Add(new Student { StudentNo = dr.GetInt32(0), Name = dr.GetString(1), Section = dr.GetString(2), Branch = dr.GetString(3), EmailId = dr.GetString(4) });
                dr.Close();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }
            return lstStud;
        }
    }
}
