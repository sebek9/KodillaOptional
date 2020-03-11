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
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public void save(Company company) {
        companyDao.save(company);
    }

    public void delete(Company company) {
        companyDao.delete(company);
    }


    public List<Employee> searchEmployee(String findEmployee) throws EntitiesFacadeException {
        List<Employee> lastname = employeeDao.retrieveEmployeeSurname(findEmployee);
        if (lastname.isEmpty()) {
            throw new EntitiesFacadeException(EntitiesFacadeException.ERR_SEARCHEMPLOYEE_ERROR);
        }
        return lastname;
    }

    public List<Employee> searchEmployeeAny(String findEmployee) throws EntitiesFacadeException {
        List<Employee> anyLettersLastname = employeeDao.findByFewLetters(findEmployee);
        if (anyLettersLastname.isEmpty()) {
            throw new EntitiesFacadeException(EntitiesFacadeException.ERR_SEARCHEMPLOYEE_ERROR);
        }
        return anyLettersLastname;
    }

    public List<Company> searchCompany(String findCompany) throws EntitiesFacadeException {
        List<Company> threeFirstLetters = companyDao.retrieveWithThreeFirstLetters(findCompany);
        if (threeFirstLetters.size() < 1) {
            throw new EntitiesFacadeException(EntitiesFacadeException.ERR_SEARCHCOMPANY_ERROR);
        }
        return threeFirstLetters;
    }

    public List<Company> searchCompanyAny(String findCompany) throws EntitiesFacadeException {
        List<Company> anyLetters = companyDao.retrieveWithAnyLetters(findCompany);
        if (anyLetters.size() < 1) {
            throw new EntitiesFacadeException(EntitiesFacadeException.ERR_SEARCHCOMPANY_ERROR);
        }
        return anyLetters;
    }
}

/*@Autowired
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
*/