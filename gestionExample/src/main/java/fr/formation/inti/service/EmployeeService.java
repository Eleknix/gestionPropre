package fr.formation.inti.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;

//@Service("service")
public class EmployeeService implements IEmployeeService {
	private final static Log log = LogFactory.getLog(EmployeeService.class);
	@Autowired
	@Qualifier("dao")
	private IEmployeeDao dao;

	public EmployeeService() {
		log.info("new EmployeeService()");
		dao = new EmployeeDao();
	}

	@Override
	public Integer save(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		dao.update(employee);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		dao.beginTransaction();
		List<Employee> list = dao.findAll();
		dao.close();
		return list;
	}

	public void setDao2(IEmployeeDao dao) {
		log.info("----->SetDao");
		this.dao = dao;
	}
}