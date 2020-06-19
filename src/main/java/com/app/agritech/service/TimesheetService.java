package com.app.agritech.service;

import java.util.List;

import com.app.agritech.entity.Address;
import com.app.agritech.entity.Client;
import com.app.agritech.entity.EmployeeAttendance;
import com.app.agritech.entity.EmployeeTimesheet;
import com.app.agritech.entity.PersonalDetails;
import com.app.agritech.entity.Project;
import com.app.agritech.entity.Task;
import com.app.agritech.entity.UserDetails;

public interface TimesheetService {

  void saveAddress(Address address);

  Project getProject(long id);

  Task getTask(long id);

  Client getClient(long id);

  EmployeeTimesheet saveEmployeeTimesheet(EmployeeTimesheet employeeTimesheet);

  EmployeeAttendance saveEmployeeAttendance(EmployeeAttendance employeeAttendance);

  Task saveTask(Task task);

  List<Project> getAllProjects();

  List<EmployeeTimesheet> getEmployeeTimesheetofUser(long userId);

  List<EmployeeAttendance> getEmployeeAttendanceofUser(long userId);

  List<Task> getAllTasks();

  List<Client> getAllClients();

  Project saveProject(Project project);

  Client saveClient(Client client);

  Address getAddress(Long id);

  PersonalDetails getPersonalDetails(Long id);

  void saveUserDetails(UserDetails user);

  UserDetails getUserDetails(Long id);

  UserDetails getUserDetails(String userId, String password);

  void saveProfile(PersonalDetails person);

}
