package sb_rest.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sb_rest.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("from Employee ").getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee emp) {
        Employee newEmp = entityManager.merge(emp); // не возвращает назначенный Id при Добавлении сущности
        emp.setId(newEmp.getId()); // только для responce
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.createQuery("delete from Employee where id=:emp_id")
                .setParameter("emp_id", id)
                .executeUpdate();
    }
}
