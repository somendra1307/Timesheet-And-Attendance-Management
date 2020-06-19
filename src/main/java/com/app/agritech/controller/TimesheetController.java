package com.app.agritech.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.agritech.constant.Attendance;
import com.app.agritech.constant.States;
import com.app.agritech.constant.UserType;
import com.app.agritech.dto.EmpAttendance;
import com.app.agritech.dto.EmpHours;
import com.app.agritech.entity.Address;
import com.app.agritech.entity.Client;
import com.app.agritech.entity.EmployeeAttendance;
import com.app.agritech.entity.EmployeeTimesheet;
import com.app.agritech.entity.PersonalDetails;
import com.app.agritech.entity.Project;
import com.app.agritech.entity.Task;
import com.app.agritech.entity.UserDetails;
import com.app.agritech.messaging.EmailData;
import com.app.agritech.service.TimesheetService;
import com.app.agritech.service.CloudinaryService;
import com.app.agritech.service.EmailService;
import com.app.agritech.utility.DateSupport;
import com.app.agritech.utility.Utility;

@Controller
public class TimesheetController {

  @Autowired
  TimesheetService timesheetService;

  @Autowired
  EmailService emailService;

  @Autowired
  CloudinaryService cloudinaryService;

  @GetMapping("/playGame")
  public String playGame() {
    return "ballStrikerGame";
  }

  @GetMapping("/logout")
  public String logOut(ModelMap model, HttpServletRequest request) {
    request.getSession().setAttribute("user", null);
    model.put("success", "You are logged out successfully.");
    return "login";
  }

  @GetMapping("/addTask")
  public String addTaskpage(ModelMap model, HttpServletRequest request) {
    model.clear();
    return "addTask";
  }

  @GetMapping("/addClient")
  public String addClientpage(ModelMap model, HttpServletRequest request) {
    model.clear();
    return "addClient";
  }

  @GetMapping("/addProject")
  public String addProjectpage(ModelMap model, HttpServletRequest request) {
    model.clear();
    return "addProject";
  }

  @GetMapping("/register")
  public String registerPage(ModelMap model) {
    model.put("states", States.getStateMap());
    return "register";
  }

  @GetMapping("/index")
  public String homePage(ModelMap model, HttpServletRequest request) {
    model.clear();
    return "index";
  }

  @GetMapping("/generateReport")
  public String generateReportPage(ModelMap model, HttpServletRequest request) {
    model.clear();
    return "generateReport";
  }

  @GetMapping("/logMyHour")
  public String logMyHourPage(ModelMap model, HttpServletRequest request) {
    model.clear();

    List<Project> projects = timesheetService.getAllProjects();

    List<Task> tasks = timesheetService.getAllTasks();

    List<Client> clients = timesheetService.getAllClients();

    model.put("tasks", tasks);
    model.put("projects", projects);
    model.put("clients", clients);
    return "logMyHour";
  }

  @GetMapping("/login")
  public String loginPage(ModelMap model, HttpServletRequest request) {
    model.clear();
    return "login";
  }

  @GetMapping("/addAttendance")
  public String addAttendancePage(ModelMap model, HttpServletRequest request) {
    model.clear();
    return "logAttendance";
  }

  @PostMapping(value = "/authenticate")
  public String authenticate(ModelMap model, HttpServletRequest request) {
    model.clear();

    HttpSession session = request.getSession();
    String userId = request.getParameter("username");
    String password = request.getParameter("password");

    UserDetails user = timesheetService.getUserDetails(userId, password);

    if (user != null) {
      user.setLoggedIn(true);
      user.setLastLogInDate(new Date());
      timesheetService.saveUserDetails(user);
      session.setAttribute("user", user);
      session.setAttribute("roleCode", user.getRoleCode() + "");
      model.put("messageCount", 10);
      model.put("loggedin", true);
      model.put("states", States.getStateMap());
      return "index";
    } else {
      model.put("error", "Invalid Credential has been attempted to log in!");
      return "login";
    }
  }

  @GetMapping("/myProfile")
  public String getProfile(ModelMap model, HttpServletRequest request) {
    UserDetails user = (UserDetails) request.getSession().getAttribute("user");
    PersonalDetails person = user.getPersonalDetails();
    model.put("userProfile", person);
    return "myProfile";
  }

  @PostMapping("/saveProfile")
  public String updateProfile(@ModelAttribute("userProfile") PersonalDetails userProfile, ModelMap model,
      HttpServletRequest request) {
    timesheetService.saveProfile(userProfile);
    model.put("userProfile", userProfile);
    model.put("success", "Your profile saved successfully");
    model.put("title", "Success: ");
    return "myProfile";
  }

  @PostMapping(value = "/logHour")
  public String logHour(ModelMap model, HttpServletRequest request) {
    model.clear();

    UserDetails userDetails = ((UserDetails) request.getSession().getAttribute("user"));
    String projectId = request.getParameter("projectId");
    String clientId = request.getParameter("clientId");
    String taskId = request.getParameter("taskId");
    String duration = request.getParameter("duration");
    String ticketId = request.getParameter("ticketId");
    String description = request.getParameter("description");

    EmployeeTimesheet et = new EmployeeTimesheet();
    et.setClientId(Long.parseLong(clientId));
    et.setDate(new Date());
    et.setDescription(description);
    et.setHours(Byte.parseByte(duration));
    et.setIssueTrackingId(ticketId);
    et.setProjectId(Long.parseLong(projectId));
    et.setTaskId(Long.parseLong(taskId));
    et.setUserId(userDetails.getId());

    timesheetService.saveEmployeeTimesheet(et);
    model.put("success", "your record submitted successfully");

    List<EmployeeTimesheet> empTimesheets = timesheetService.getEmployeeTimesheetofUser(userDetails.getId());
    List<EmpHours> ehours = new ArrayList<>();
    for (EmployeeTimesheet employeeTimesheet : empTimesheets) {
      EmpHours e = new EmpHours();
      e.setClient(timesheetService.getClient(employeeTimesheet.getClientId()).getName());
      e.setDate(DateSupport.convertDateToString(employeeTimesheet.getDate(), DateSupport.DEFAULT_DATE_FORMAT));
      e.setDescription(employeeTimesheet.getDescription());
      e.setDuration(employeeTimesheet.getHours());
      e.setIssueTrackingId(employeeTimesheet.getIssueTrackingId());
      e.setProject(timesheetService.getProject(employeeTimesheet.getProjectId()).getName());
      e.setTask(timesheetService.getTask(employeeTimesheet.getTaskId()).getName());
      ehours.add(e);
    }

    model.put("logHours", ehours);

    return "myTimesheet";
  }

  @PostMapping(value = "/addAttendance")
  public String addAttendance(ModelMap model, HttpServletRequest request) throws Exception {
    model.clear();

    UserDetails userDetails = ((UserDetails) request.getSession().getAttribute("user"));
    String attendance = request.getParameter("attendance");
    String punchInDateValue = request.getParameter("punchInTime");
    String punchOutDateValue = request.getParameter("punchOutTime");
    String dateValue = request.getParameter("date");
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
    String remark = request.getParameter("remark");

    EmployeeAttendance et = new EmployeeAttendance();
    et.setAttendance(Attendance.valueOf(attendance).getName());
    et.setDate(date);
    et.setPunchInTime(punchInDateValue);
    et.setPunchOutTime(punchOutDateValue);
    et.setRemark(remark);
    et.setUserId(userDetails.getId());

    timesheetService.saveEmployeeAttendance(et);
    model.put("success", "your record submitted successfully");

    List<EmployeeAttendance> attendances = timesheetService.getEmployeeAttendanceofUser(userDetails.getId());
    List<EmpAttendance> empAttendances = new ArrayList<>();

    for (EmployeeAttendance employeeAttendance : attendances) {

      EmpAttendance empat = new EmpAttendance();
      empat.setAttendance(employeeAttendance.getAttendance());
      empat.setDate(DateSupport.convertDateToString(employeeAttendance.getDate(), DateSupport.DEFAULT_DATE_FORMAT));
      empat.setLoggedIn(employeeAttendance.getPunchInTime());
      empat.setLoggedOut(employeeAttendance.getPunchOutTime());
      empat.setRemark(employeeAttendance.getRemark());
      empAttendances.add(empat);
    }
    model.put("attendances", empAttendances);

    return "myAttendance";
  }

  @PostMapping(value = "/addTask")
  public String addTask(ModelMap model, HttpServletRequest request) {
    model.clear();

    String code = request.getParameter("code");
    String name = request.getParameter("name");
    String description = request.getParameter("description");

    Task task = new Task();
    task.setCode(code);
    task.setDescription(description);
    task.setName(name);

    timesheetService.saveTask(task);
    List<Task> tasks = timesheetService.getAllTasks();
    model.put("tasks", tasks);
    model.put("success", "your record submitted successfully");
    return "viewTask";
  }

  @PostMapping(value = "/addClient")
  public String addClient(ModelMap model, HttpServletRequest request) {
    model.clear();

    String code = request.getParameter("code");
    String name = request.getParameter("name");
    String description = request.getParameter("description");

    Client client = new Client();
    client.setCode(code);
    client.setDescription(description);
    client.setName(name);

    timesheetService.saveClient(client);
    List<Client> clients = timesheetService.getAllClients();
    model.put("clients", clients);
    model.put("success", "your record submitted successfully");
    return "viewClient";
  }

  @PostMapping(value = "/generateReport")
  public String generateReport(ModelMap model, HttpServletRequest request) {
    model.clear();
    String emailIds = request.getParameter("emailIds");
    
    //list emails

    model.put("success", "Report is sent to following Email Ids: " + emailIds);
    return "message";
  }

  @PostMapping(value = "/addProject")
  public String addProject(ModelMap model, HttpServletRequest request) {
    model.clear();

    String code = request.getParameter("code");
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    String clientSupported = request.getParameter("clientSupported");

    Project project = new Project();
    project.setCode(code);
    project.setDescription(description);
    project.setName(name);
    project.setClientSupported(Boolean.parseBoolean(clientSupported));

    timesheetService.saveProject(project);
    List<Project> projects = timesheetService.getAllProjects();
    model.put("projects", projects);
    model.put("success", "your record submitted successfully");
    return "viewProject";
  }

  @PostMapping("/signup")
  public String addUser(ModelMap model, HttpServletRequest request) throws Exception {
    model.clear();

    String name = request.getParameter("fullName");
    String mobileNumber = request.getParameter("mobileNo");
    String addressText = request.getParameter("address");
    String pincode = request.getParameter("pincode");
    String birthDate = request.getParameter("birthDate");
    System.out.println(birthDate);
    Date bdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
    String emailId = request.getParameter("emailId");
    String password = request.getParameter("password");
    String state = request.getParameter("state");
    String empId = request.getParameter("empId");
    String confirmPassword = request.getParameter("cnfPassword");

    UserDetails userDetail = new UserDetails();
    PersonalDetails person = new PersonalDetails();
    Address address = new Address();

    address.setAddressText(addressText);
    address.setCity("Kelwara");
    address.setCountry("India");
    address.setAddressType("presentAddress");
    address.setPincode(Integer.parseInt(pincode));
    address.setDistrict("Baran");
    address.setState(state);

    person.setName(name);
    person.setEmpId(empId);
    person.setBirthDate(bdate);
    person.setPresentAddress(address);
    person.setPermanentAddress(address);
    person.setEmailId(emailId);
    person.setMobNumber(Long.parseLong(mobileNumber));
    userDetail.setEmailId(emailId);
    if (password.equals(confirmPassword))
      userDetail.setPassword(password);
    userDetail.setPersonalDetails(person);
    userDetail.setRoleCode(UserType.NORMAL_USER.getCode());

    EmailData data = new EmailData();
    String a[] = { emailId };
    data.setTo(a);
    data.setSubject("Email Verification OTP From Agritech");
    data.setTemplate("Your agritech account OTP is" + Utility.generateOTP());
    emailService.sendEmail(data);

    timesheetService.saveUserDetails(userDetail);
    return "validateOtp";
  }

  @GetMapping("/validateOtp")
  public String otpValidation(ModelMap model, HttpServletRequest request) {
    model.clear();
    String otp = request.getParameter("otp");

    if (!otp.equals("12345")) {
      model.put("error", "Invalid otp!");
      return "validateOtp";
    }
    model.put("success", "OTP verified successfully");
    return "login";
  }

  @GetMapping("/myTimesheet")
  public String getMytimesheets(ModelMap model, HttpServletRequest request) {
    model.clear();
    UserDetails UserDetails = ((UserDetails) request.getSession().getAttribute("user"));
    if (UserDetails != null) {
      List<EmployeeTimesheet> empTimesheets = timesheetService.getEmployeeTimesheetofUser(UserDetails.getId());
      List<EmpHours> ehours = new ArrayList<>();
      for (EmployeeTimesheet employeeTimesheet : empTimesheets) {
        EmpHours e = new EmpHours();
        e.setClient(timesheetService.getClient(employeeTimesheet.getClientId()).getName());
        e.setDate(DateSupport.convertDateToString(employeeTimesheet.getDate(), DateSupport.DEFAULT_DATE_FORMAT));
        e.setDescription(employeeTimesheet.getDescription());
        e.setDuration(employeeTimesheet.getHours());
        e.setIssueTrackingId(employeeTimesheet.getIssueTrackingId());
        e.setProject(timesheetService.getProject(employeeTimesheet.getProjectId()).getName());
        e.setTask(timesheetService.getTask(employeeTimesheet.getTaskId()).getName());
        ehours.add(e);
      }

      model.put("logHours", ehours);
      return "myTimesheet";
    } else {
      model.put("error", "user not logged in!");
      return "login";
    }

  }

  @GetMapping("/myAttendance")
  public String myAttendance(ModelMap model, HttpServletRequest request) {
    model.clear();
    UserDetails UserDetails = ((UserDetails) request.getSession().getAttribute("user"));
    if (UserDetails != null) {
      List<EmployeeAttendance> attendances = timesheetService.getEmployeeAttendanceofUser(UserDetails.getId());
      List<EmpAttendance> empAttendances = new ArrayList<>();

      for (EmployeeAttendance employeeAttendance : attendances) {

        EmpAttendance empat = new EmpAttendance();
        empat.setAttendance(employeeAttendance.getAttendance());
        empat.setDate(DateSupport.convertDateToString(employeeAttendance.getDate(), DateSupport.DEFAULT_DATE_FORMAT));
        empat.setLoggedIn(employeeAttendance.getPunchInTime());
        empat.setLoggedOut(employeeAttendance.getPunchOutTime());
        empat.setRemark(employeeAttendance.getRemark());
        empAttendances.add(empat);
      }
      model.put("attendances", empAttendances);
      return "myAttendance";
    } else {
      model.put("error", "user not logged in!");
      return "login";
    }

  }

  /*
   * @GetMapping("/searchResultsGrid") public String searchResults(ModelMap model,
   * HttpServletRequest request) { model.clear(); long specificationId =
   * Long.parseLong(request.getParameter("specificationId")); String state =
   * request.getParameter("state"); if (state != null && !state.isEmpty()) {
   * model.put("resources",
   * timesheetService.getCommodityAdBySpecificationIdAndAddressState(
   * specificationId, state)); } else { int pincode =
   * Integer.parseInt(request.getParameter("pincode")); model.put("resources",
   * timesheetService.getCommodityAdBySpecificationIdAndAddressPincode(
   * specificationId, pincode)); } return "commodityAdList"; }
   * 
   * @PostMapping("/addResource") public String addResource(ModelMap model,
   * HttpServletRequest request) throws Exception { model.clear(); if
   * (!isUserLoggedIn(request)) { List<ResourceSpecification> specificationList =
   * timesheetService
   * .getResourceSpecificationByType(ResourceType.IMPLEMENT.getType());
   * model.put("resourceSpecifications", specificationList); model.put("error",
   * "You must login to create an Ad here"); model.put("title", "Error: ");
   * model.put("states", States.getStateMap()); return "index"; }
   * 
   * MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)
   * request; MultipartFile imageFile = null; Iterator<String> iterator =
   * multipartRequest.getFileNames();
   * 
   * while (iterator.hasNext()) { String key = (String) iterator.next(); imageFile
   * = multipartRequest.getFile(key); }
   * 
   * UserDetails user = (UserDetails) request.getSession().getAttribute("user");
   * Date date = new Date(); long specificationId =
   * Long.parseLong(request.getParameter("specificationId"));
   * ResourceSpecification specification =
   * timesheetService.getResourceSpecification(specificationId); Resource resource
   * = new Resource(); resource.setOwner(user.getPerson());
   * resource.setAdStatus("available"); resource.setAdType("sell"); String url =
   * cloudinaryService.uploadImage(imageFile, "staticresource");
   * resource.setResourceImageUrl(url); resource.setLastUpdatedDate(date);
   * resource.setCreatedDate(date); resource.setSpecificationId(specificationId);
   * setAttributeValues(request, specification, resource);
   * timesheetService.saveResource(resource);
   * 
   * model.put("success", "Your ad has been created and published successfully!");
   * return "message"; }
   * 
   * @PostMapping("/addCommodityAd") public String addCommodityAd(ModelMap model,
   * HttpServletRequest request) throws Exception { model.clear();
   * 
   * if (!isUserLoggedIn(request)) { List<ResourceSpecification> specificationList
   * = timesheetService
   * .getResourceSpecificationByType(ResourceType.COMMODITY.getType());
   * model.put("resourceSpecifications", specificationList); model.put("error",
   * "You must login to create an Ad here"); model.put("title", "Error: ");
   * model.put("states", States.getStateMap()); return "index"; }
   * 
   * MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)
   * request; MultipartFile imageFile = null; Iterator<String> iterator =
   * multipartRequest.getFileNames();
   * 
   * while (iterator.hasNext()) { String key = (String) iterator.next(); imageFile
   * = multipartRequest.getFile(key); }
   * 
   * UserDetails user = (UserDetails) request.getSession().getAttribute("user");
   * Date date = new Date(); long specificationId =
   * Long.parseLong(request.getParameter("specificationId")); String title =
   * request.getParameter("title"); String description =
   * request.getParameter("description"); String variety =
   * request.getParameter("variety"); String productionState =
   * request.getParameter("productionState"); long price =
   * Long.parseLong(request.getParameter("price")); int quantity =
   * Integer.parseInt(request.getParameter("quantity")); int productionYear =
   * Integer.parseInt(request.getParameter("productionYear"));
   * 
   * ResourceSpecification specification =
   * timesheetService.getResourceSpecification(specificationId);
   * 
   * CommodityAd ad = new CommodityAd(); ad.setTitle(title);
   * ad.setDescription(description); ad.setQuantity(quantity);
   * ad.setSellingPrice(price); ad.setVarietyName(variety);
   * ad.setProductionState(productionState); ad.setProductionYear(productionYear);
   * ad.setOwner(user.getPerson()); ad.setAdStatus("available"); String url =
   * cloudinaryService.uploadImage(imageFile, "staticresource");
   * ad.setAdImageUrl(url); ad.setLastUpdatedDate(date); ad.setCreatedDate(date);
   * ad.setSpecificationId(specificationId); setAdAttributeValues(request,
   * specification, ad); timesheetService.saveCommodityAd(ad);
   * 
   * model.put("ad", ad); model.put("attributeMap", getAttributeValueAsMap(ad));
   * model.put("success", "Your ad has been created and published successfully!");
   * model.put("title", "Success!"); return "viewResource"; }
   * 
   * @GetMapping("/viewAdDeatils") public String viewAdDeatils(ModelMap
   * model, @RequestParam(name = "adId", required = true) long adId) { CommodityAd
   * ad = timesheetService.getCommodityAd(adId); model.put("ad", ad);
   * model.put("attributeMap", getAttributeValueAsMap(ad)); return "viewResource";
   * }
   * 
   * @GetMapping("/contactSeller") public String contactSeller(ModelMap model,
   * HttpServletRequest request) { model.clear(); CommodityAd ad = null;
   * LeadConversation conv = null; if (request.getParameter("conversationId") !=
   * null) { long id = Long.parseLong(request.getParameter("conversationId"));
   * conv = timesheetService.getLeadConversation(id); ad = conv.getCommodityAd();
   * } else if (request.getParameter("adId") != null) { long resourceId =
   * Long.parseLong(request.getParameter("adId")); ad =
   * timesheetService.getCommodityAd(resourceId); if
   * (getUserFromRequest(request).getId() == ad.getOwner().getId()) {
   * model.put("error", "owner can not be a buyer"); return "contactSeller"; }
   * conv = timesheetService.getLeadConversationByAdAndBuyer(ad,
   * getUserFromRequest(request)); if (conv == null) { conv = new
   * LeadConversation(); conv.setBuyer(getUserFromRequest(request));
   * conv.setCommodityAd(ad); conv.setSellerId(ad.getOwner().getId());
   * timesheetService.saveLeadConversation(conv); } model.put("conversationId",
   * conv.getId()); }
   * 
   * model.put("ad", ad); model.put("messages",
   * ResponseConverter.convertToMessageResponse(conv,
   * getUserFromRequest(request))); return "contactSeller"; }
   * 
   * @PostMapping("/sendMessage") public String submitResponse(ModelMap model,
   * HttpServletRequest request) { model.clear(); Person user =
   * getUserFromRequest(request); String message =
   * request.getParameter("message"); long conversationId =
   * Long.parseLong(request.getParameter("conversationId"));
   * 
   * LeadConversation conv = timesheetService.getLeadConversation(conversationId);
   * List<ResourceLeadMessage> messages = null; if (conv.getMessages() == null)
   * messages = new ArrayList<>(); else messages = conv.getMessages();
   * 
   * if (Validation.isNotEmpty(message)) { ResourceLeadMessage conversationMessage
   * = new ResourceLeadMessage(); if (user.getId() ==
   * conv.getCommodityAd().getOwner().getId())
   * conversationMessage.setBuyerMessage(false); else
   * conversationMessage.setBuyerMessage(true);
   * conversationMessage.setReciever(conv.getCommodityAd().getOwner());
   * conversationMessage.setMessage(message);
   * conversationMessage.setCreatedDate(new Date());
   * conversationMessage.setConversation(conv);
   * conversationMessage.setSender(user); messages.add(conversationMessage);
   * conv.setMessages(messages); timesheetService.saveLeadConversation(conv);
   * model.put("ad", conv.getCommodityAd()); model.put("conversationId",
   * conv.getId()); model.put("messages",
   * ResponseConverter.convertToMessageResponse(conv,
   * getUserFromRequest(request))); } else model.put("error",
   * "Please fill all Mandatory fields.");
   * 
   * return "contactSeller"; }
   */

  private boolean isUserLoggedIn(HttpServletRequest request) {
    return request.getSession().getAttribute("user") != null;
  }

  private PersonalDetails getUserFromRequest(HttpServletRequest request) {
    if (isUserLoggedIn(request))
      return ((UserDetails) request.getSession().getAttribute("user")).getPersonalDetails();
    else
      return null;
  }

  private void generateReport(Map<String, List<EmployeeTimesheet>> data) {

    Workbook wb = new HSSFWorkbook();

    // An output stream accepts output bytes and sends them to sink.
    OutputStream fileOut;
    try {
      fileOut = new FileOutputStream("Geeks.xlsx");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // Creating Sheets using sheet object
    Sheet sheet1 = wb.createSheet("Array");
    Sheet sheet2 = wb.createSheet("String");
    Sheet sheet3 = wb.createSheet("LinkedList");
    Sheet sheet4 = wb.createSheet("Tree");
    Sheet sheet5 = wb.createSheet("Dynamic Programing");
    Sheet sheet6 = wb.createSheet("Puzzles");

    System.out.println("Sheets Has been Created successfully");

    //wb.write(fileOut);

  }
}
