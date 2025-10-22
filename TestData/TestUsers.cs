using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SeleniumAutomationProject.TestData
{
    public class TestUser
    {
        public string Name { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public string Gender { get; set; }
        public string EmploymentStatus { get; set; }
    }

    public static class TestUsers
    {
        public static TestUser GetValidUser()
        {
            return new TestUser
            {
                Name = "John Doe",
                Email = "john.doe@example.com",
                Password = "Password123",
                Gender = "Male",
                EmploymentStatus = "Student"
            };
        }



    }
}

