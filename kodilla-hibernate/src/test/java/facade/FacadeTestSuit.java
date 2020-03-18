package facade;// package hibernate.facade;

import hibernate.manytomany.Company;
import hibernate.manytomany.Employee;
import hibernate.manytomany.dao.CompanyDao;
import hibernate.manytomany.dao.EmployeeDao;
import hibernate.manytomany.facade.EntitiesFacadeException;
import hibernate.manytomany.facade.FacadeManyToMany;
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
        List<Employee> employees = facadeManyToMany.findEmployees("clarck");

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



    /*
    @Autowired
    FacadeManyToMany facadeManyToMany;

    @Test
    public void facadeCompanyTest() {
        //Given
        Employee johnSmith1 = new Employee("John", "Smith");
        Employee stephanieClarckson1 = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky1 = new Employee("Linda", "Kovalsky");

        Company softwareMachine1 = new Company("Software Machine");
        Company dataMaesters1 = new Company("Data Maesters");
        Company greyMatter1 = new Company("Grey Matter");

        softwareMachine1.getEmployees().add(johnSmith1);
        dataMaesters1.getEmployees().add(stephanieClarckson1);
        dataMaesters1.getEmployees().add(lindaKovalsky1);
        greyMatter1.getEmployees().add(johnSmith1);
        greyMatter1.getEmployees().add(lindaKovalsky1);

        johnSmith1.getCompanies().add(softwareMachine1);
        johnSmith1.getCompanies().add(greyMatter1);
        stephanieClarckson1.getCompanies().add(dataMaesters1);
        lindaKovalsky1.getCompanies().add(dataMaesters1);
        lindaKovalsky1.getCompanies().add(greyMatter1);

        facadeManyToMany.save(softwareMachine1);
        int softwareMachineId = softwareMachine1.getId();
        facadeManyToMany.save(dataMaesters1);
        int dataMaestersId = dataMaesters1.getId();
        facadeManyToMany.save(greyMatter1);
        int greyMatterId = greyMatter1.getId();

        //When
        List<Company> threeFirstLetters = null;
        try {
            threeFirstLetters = facadeManyToMany.searchCompany("Sof");
        } catch (EntitiesFacadeException e) {
            e.printStackTrace();
        }

        List<Company> anyLetters = null;
        try {
            anyLetters = facadeManyToMany.searchCompanyAny("ter");
        } catch (EntitiesFacadeException e) {
            e.printStackTrace();
        }

        //Than
        try {
            Assert.assertEquals(1, threeFirstLetters.size());
            Assert.assertEquals(2, anyLetters.size());

            //CleanUp
            facadeManyToMany.delete(softwareMachineId);
            facadeManyToMany.delete(dataMaestersId);
            facadeManyToMany.delete(greyMatterId);
        } catch (Exception e){
        }
    }

    @Test
    public void facadeEmployeeTest() {
        //Given
        Employee johnSmith1 = new Employee("John", "Smith");
        Employee stephanieClarckson1 = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky1 = new Employee("Linda", "Kovalsoky");

        Company softwareMachine1 = new Company("Software Machine");
        Company dataMaesters1 = new Company("Data Maesters");
        Company greyMatter1 = new Company("Grey Matter");

        softwareMachine1.getEmployees().add(johnSmith1);
        dataMaesters1.getEmployees().add(stephanieClarckson1);
        dataMaesters1.getEmployees().add(lindaKovalsky1);
        greyMatter1.getEmployees().add(johnSmith1);
        greyMatter1.getEmployees().add(lindaKovalsky1);

        johnSmith1.getCompanies().add(softwareMachine1);
        johnSmith1.getCompanies().add(greyMatter1);
        stephanieClarckson1.getCompanies().add(dataMaesters1);
        lindaKovalsky1.getCompanies().add(dataMaesters1);
        lindaKovalsky1.getCompanies().add(greyMatter1);

        facadeManyToMany.save(softwareMachine1);
        int softwareMachine1 = softwareMachine1.getId();
        facadeManyToMany.save(dataMaesters1);
        int dataMaestersId = dataMaesters1.getId();
        facadeManyToMany.save(greyMatter1);
        int greyMatterId = greyMatter1.getId();

        //When
        List<Employee> lastname = null;
        try {
            lastname = facadeManyToMany.searchEmployee("Smith");
        } catch (EntitiesFacadeException e) {
            e.printStackTrace();
        }

        List<Employee> anyLettersLastname = null;
        try {
            anyLettersLastname = facadeManyToMany.searchEmployeeAny("so");
        } catch (EntitiesFacadeException e) {
            e.printStackTrace();
        }

        // Than
        try {
            Assert.assertEquals(1, lastname.size());
            Assert.assertEquals(2, anyLettersLastname.size());

            //CleanUp
            facadeManyToMany.delete(softwareMachine1);
            facadeManyToMany.delete(dataMaestersId);
            facadeManyToMany.delete(greyMatterId);
        } catch (Exception e){
        }
    }
}







/*
import hibernate.manytomany.Company;
import hibernate.manytomany.Employee;
import hibernate.manytomany.dao.CompanyDao;
import hibernate.manytomany.dao.EmployeeDao;
import hibernate.manytomany.Company;
import hibernate.manytomany.Employee;

import hibernate.manytomany.dao.EmployeeDao;
import hibernate.manytomany.facade.FacadeManyToMany;
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
    */