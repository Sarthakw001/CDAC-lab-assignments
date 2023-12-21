using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using StudentManagement.Models;

namespace StudentManagement.Controllers
{
    public class StudentController : Controller
    {
        // GET: StudentController
        public ActionResult Index()
        {
            List<Student> students = Student.Read();
            return View(students);
        }

        // GET: StudentController/Details/5
        public ActionResult Details(int id)
        {
            Student? student = Student.ReadStudent(id);
            return View(student);
        }

        // GET: StudentController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: StudentController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Student student)
        {
            try
            {
                Student.Insert(student);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: StudentController/Edit/5
        public ActionResult Edit(int id)
        {
            Student? student = Student.ReadStudent(id);
            return View(student);
        }

        // POST: StudentController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id,Student student)
        {
            try
            {
                Student.Edit(student);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: StudentController/Delete/5
        public ActionResult Delete(int id)
        {
            Student? student = Student.ReadStudent(id);
            return View(student);
        }

        // POST: StudentController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, Student student)
        {
            try
            {
                Student.Delete(student);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
