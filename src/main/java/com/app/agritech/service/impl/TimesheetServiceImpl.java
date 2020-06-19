package com.app.agritech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.agritech.entity.Address;
import com.app.agritech.entity.Client;
import com.app.agritech.entity.EmployeeAttendance;
import com.app.agritech.entity.EmployeeTimesheet;
import com.app.agritech.entity.PersonalDetails;
import com.app.agritech.entity.Project;
import com.app.agritech.entity.Task;
import com.app.agritech.entity.UserDetails;
import com.app.agritech.repository.AddressRepository;
import com.app.agritech.repository.ClientRepository;
import com.app.agritech.repository.EmployeeAttendanceRepository;
import com.app.agritech.repository.EmployeeTimesheetRepository;
import com.app.agritech.repository.TaskRepository;
import com.app.agritech.repository.ProjectRepository;
import com.app.agritech.repository.PersonRepository;
import com.app.agritech.repository.UserDetailsRepository;
import com.app.agritech.service.TimesheetService;

@Service
public class TimesheetServiceImpl implements TimesheetService {

  @Autowired
  AddressRepository addressRepository;

  @Autowired
  ProjectRepository projectRepository;

  @Autowired
  ClientRepository clientRepository;

  @Autowired
  EmployeeTimesheetRepository employeeTimesheetRepository;

  @Autowired
  EmployeeAttendanceRepository employeeAttendanceRepository;

  @Autowired
  TaskRepository taskRepository;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  UserDetailsRepository userDetailsRepository;

  @Override
  public Address getAddress(Long id) {
    return addressRepository.findAllById(id);
  }

  @Override
  public void saveAddress(Address address) {
    addressRepository.save(address);
  }

  @Override
  public void saveUserDetails(UserDetails user) {
    userDetailsRepository.save(user);
  }

  @Override
  public UserDetails getUserDetails(Long id) {
    return userDetailsRepository.findAllById(id);
  }

  @Override
  public UserDetails getUserDetails(String userId, String password) {
    return userDetailsRepository.findAllByEmailIdAndPassword(userId, password);
  }

  @Override
  public void saveProfile(PersonalDetails person) {
    personRepository.save(person);
  }

  @Override
  public PersonalDetails getPersonalDetails(Long id) {
    return personRepository.findAllById(id);
  }

  @Override
  public EmployeeTimesheet saveEmployeeTimesheet(EmployeeTimesheet employeeTimesheet) {
    return employeeTimesheetRepository.save(employeeTimesheet);
  }

  @Override
  public Task saveTask(Task task) {
    return taskRepository.save(task);
  }

  @Override
  public Project saveProject(Project project) {
    return projectRepository.save(project);
  }

  @Override
  public Client saveClient(Client client) {
    return clientRepository.save(client);
  }

  @Override
  public List<Project> getAllProjects() {
    return (List<Project>) projectRepository.findAll();
  }

  @Override
  public List<Task> getAllTasks() {
    return (List<Task>) taskRepository.findAll();
  }

  @Override
  public List<Client> getAllClients() {
    return (List<Client>) clientRepository.findAll();
  }

  @Override
  public List<EmployeeTimesheet> getEmployeeTimesheetofUser(long userId) {
    return employeeTimesheetRepository.findAllByUserId(userId);
  }

  @Override
  public List<EmployeeAttendance> getEmployeeAttendanceofUser(long userId) {
    return employeeAttendanceRepository.findAllByUserId(userId);
  }

  @Override
  public Project getProject(long id) {
    return projectRepository.findById(id).get();
  }

  @Override
  public Task getTask(long id) {
    return taskRepository.findById(id).get();
  }

  @Override
  public Client getClient(long id) {
    return clientRepository.findById(id).get();
  }

  @Override
  public EmployeeAttendance saveEmployeeAttendance(EmployeeAttendance employeeAttendance) {
    return employeeAttendanceRepository.save(employeeAttendance);
  }

}
