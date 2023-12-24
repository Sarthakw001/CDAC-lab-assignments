using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using StudentManagementMVC.Models;

namespace StudentManagementMVC.Controllers
{
    public class StudentController : Controller
    {
        // GET: StudentController
        public ActionResult Index()
        {

            List<Student> list = Student.GetAllStudent();

            return View(list);
    
        }

        // GET: StudentController/Details/5
        public ActionResult Details(int id)
        {
            Student obj = Student.GetSingleStudent(id);
            return View(obj);
        }

        // GET: StudentController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: StudentController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Student obj, IFormCollection collection, int StudentNo, string Name, string Section, string Branch, string EmailId)
        {
            try
            {

                //to do - add to db
                Student.Insert(obj);
                //return RedirectToAction(nameof(Index));
                return RedirectToAction("Index");
                ViewBag.message = "success";
                return View();
            }
            catch (Exception ex)
            {
                ViewBag.message = ex.Message;
                return View();
            }
        }

        // GET: StudentController/Edit/5
        public ActionResult Edit(int id)
        {
            Student obj = Student.GetSingleStudent(id);
            return View(obj);
        }

        // POST: StudentController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, Student obj)
        {
            try
            {
                Student.Update(obj);
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
            Student obj = Student.GetSingleStudent(id);
            return View(obj);
        }

        // POST: StudentController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(IFormCollection collection, int id, Student obj)
        {
            try
            {
                Student.Delete(id);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
