
package hibernate.manytomany.facade;
import hibernate.manytomany.Company;
import hibernate.manytomany.Employee;
import hibernate.manytomany.dao.CompanyDao;
import hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuit {
    @Autowired
    FacadeManyToMany facadeManyToMany;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFindCompanies() {
        //given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        //when
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        List<Company> companies = facadeManyToMany.findCompanies("ter");

        //then
        Assert.assertEquals(2, companies.size());

        //cleanup
        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(dataMaesters);
            companyDao.delete(greyMatter);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindEmployees() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaClarckson = new Employee("Linda", "Clarckson");

        //when
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaClarckson);
        List<Employee> employees = facadeManyToMany.findEmployees("son");

        //then
        Assert.assertEquals(2, employees.size());

        //cleanup
        try {
            employeeDao.delete(johnSmith);
            employeeDao.delete(stephanieClarckson);
            employeeDao.delete(lindaClarckson);
        } catch (Exception e) {
            //do nothing
        }
    }
}