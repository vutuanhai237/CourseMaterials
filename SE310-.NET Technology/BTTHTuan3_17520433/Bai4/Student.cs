using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTap4
{
    public class Student
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }
        public string Code { get; set; }
        public string Name { get; set; }
        public DateTime DateOfBirth { get; set; }
        public string Gender { get; set; }
        public string Address { get; set; }
        public int ClassId { get; set; }
        public float Score { get; set; }


        public void Update(Student student, bool updateCode = false)
        {
            this.Code = updateCode ? student.Code : this.Code;
            this.Name = student.Name;
            this.DateOfBirth = student.DateOfBirth;
            this.Gender = student.Gender;
            this.Address = student.Address;
            this.ClassId = student.ClassId;
            this.Score = student.Score;
        }

        public bool IsMale()
        {
            return this.Gender.Equals("Nam");
        }
    }
}
