using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTap4
{
    public class AppDbContext : DbContext
    {
        private const string connectionString = "Server=VTHCOMPUTER;Database=BaiTap4;Trusted_Connection=True;";
        public DbSet<Student> Students { get; set; }
        public DbSet<Class> Classes { get; set; }

        public AppDbContext() : base(connectionString)
        {
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        }
    }
}
