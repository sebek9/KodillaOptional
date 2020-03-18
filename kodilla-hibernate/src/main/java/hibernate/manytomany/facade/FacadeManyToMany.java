package hibernate.manytomany.facade;


import hibernate.manytomany.Company;
import hibernate.manytomany.Employee;
import hibernate.manytomany.dao.CompanyDao;
import hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacadeManyToMany {


@Autowired
        private CompanyDao companies;
        @Autowired
        private EmployeeDao employees;

        public List<Company> findCompanies(String letters) {
            return companies.findByFewLetters("%" + letters + "%");
            //BEZPOSREDNIO W ZAPYTANIU
        }

        public List<Employee> findEmployees(String letters) {
            return employees.findByFewLetters("%" + letters + "%");
        }
    }