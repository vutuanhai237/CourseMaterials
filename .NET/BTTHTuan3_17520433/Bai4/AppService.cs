using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTap4
{
    public class AppService
    {
        protected AppDbContext db;
        public AppService()
        {
            this.db = new AppDbContext();
            this.CreateClassData();
        }

        private void CreateClassData()
        {
            if (db.Classes.Count() > 0)
            {
                return;
            }
            var sampleClasses = new List<Class>()
            {
                new Class() { Id = 1, Name = "10A1" },
                new Class() { Id = 2, Name = "10A2" },
                new Class() { Id = 3, Name = "10A3" },
                new Class() { Id = 4, Name = "10A4" },
                new Class() { Id = 5, Name = "10A5" },
                new Class() { Id = 6, Name = "11A1" },
                new Class() { Id = 7, Name = "11A2" },
                new Class() { Id = 8, Name = "11A3" },
                new Class() { Id = 9, Name = "11A4" },
                new Class() { Id = 10, Name = "11A5" },
                new Class() { Id = 12, Name = "12A1" },
                new Class() { Id = 13, Name = "12A2" },
                new Class() { Id = 14, Name = "12A3" },
                new Class() { Id = 15, Name = "12A4" },
                new Class() { Id = 16, Name = "12A5" }
            };
            db.Classes.AddRange(sampleClasses);
            db.SaveChanges();
        }

        public void Close()
        {
            this.db.Dispose();
        }

        public IEnumerable<Student> GetAllStudents()
        {
            try
            {
                return this.db.Students;
            } catch
            {
                return null;
            }
        }

        public bool AddStudent(Student student, out string errorMsg) 
        {
            try
            {
                var codeCheck = (from s in this.db.Students
                           where s.Code.Equals(student.Code)
                           select s.Code).FirstOrDefault();
                if (!String.IsNullOrEmpty(codeCheck))
                {
                    errorMsg = "Mã học sinh đã tồn tại";
                    return false;
                }
                this.db.Students.Add(student);
                this.db.SaveChanges();
                errorMsg = null;
                return true;
            } catch (Exception err)
            {
                errorMsg = "Internal application error";
                return false;
            }
        }

        public bool DeleteStudent(string stdCode, out string msg)
        {
            try
            {
                var std = (from s in this.db.Students
                           where s.Code.Equals(stdCode)
                           select s).FirstOrDefault();
                if (std == null)
                {
                    msg = "Mã học sinh không tồn tại";
                    return false;
                }
                this.db.Students.Remove(std);
                this.db.SaveChanges();
                msg = "Xóa thành công";
                return true;
            } catch
            {
                msg = "Internal error";
                return false;
            }
        }

        public bool UpdateStudent(Student student, out string errorMsg)
        {
            try
            {
                var std = (from s in this.db.Students
                           where s.Code.Equals(student.Code)
                           select s).First();
                if (std == null)
                {
                    errorMsg = "Không tìm thấy học sinh";
                    return false;
                }
                std.Update(student);
                this.db.SaveChanges();
                errorMsg = null;
                return true;
            } catch
            {
                errorMsg = "Internal application error";
                return false;
            }
        }

        public IEnumerable<Class> GetAllClasses()
        {
            try
            {
                return this.db.Classes;
            } catch
            {
                return null;
            }
        }
    }
}
