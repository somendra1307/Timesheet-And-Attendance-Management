/*
 * package com.app.agritech.controller;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.app.agritech.entity.Client; import
 * com.app.agritech.entity.ResourceSpecification; import
 * com.app.agritech.service.TimesheetService;
 * 
 * 
 * @Controller public class SarvikaAdminController {
 * 
 * @Autowired TimesheetService agritechService;
 * 
 * @GetMapping("/addResSpec") public String greeting(@RequestParam(name =
 * "name", required = false, defaultValue = "World") String name, Model model) {
 * return "addResSpec"; }
 * 
 * @GetMapping("/addAttrSpec") public String greetingSd(@RequestParam(name =
 * "name", required = false, defaultValue = "World") String name, Model model) {
 * return "addAttrSpec"; }
 * 
 * @GetMapping("/manageAccount") public String manageAccount(ModelMap model,
 * HttpServletRequest request) { return "manageAccount"; }
 * 
 * @PostMapping("/addResourceSpecification") public String
 * addResourceSpecification(ModelMap model, HttpServletRequest request) throws
 * Exception { model.clear(); ResourceSpecification specification = new
 * ResourceSpecification();
 * specification.setDisplayName(request.getParameter("displayName"));
 * specification.setImageUrl("images/" + request.getParameter("name") + ".jpg");
 * specification.setName(request.getParameter("name"));
 * specification.setType(request.getParameter("type"));
 * specification.setUrnPrefix(request.getParameter("urnPrefix"));
 * agritechService.saveResourceSpecification(specification);
 * model.put("success_msg", "Resource Specification added successfully!");
 * return "success"; }
 * 
 * @PostMapping("/addAttributeSpecification") public String
 * addAttributeSpecification(ModelMap model, HttpServletRequest request) throws
 * Exception { model.clear(); Client attr = new Client();
 * 
 * attr.setCodedValueSetId(Long.parseLong(request.getParameter("codedValueSetId"
 * )));
 * attr.setCreatable(Boolean.parseBoolean(request.getParameter("creatable")));
 * attr.setDescription(request.getParameter("description"));
 * attr.setDisplayName(request.getParameter("displayName"));
 * attr.setDisplayOrder(Integer.parseInt(request.getParameter("displayOrder")));
 * attr.setMandatory(Boolean.parseBoolean(request.getParameter("mandatory")));
 * attr.setMaxLength(Integer.parseInt(request.getParameter("maxLength")));
 * attr.setName(request.getParameter("name"));
 * attr.setSearchable(Boolean.parseBoolean(request.getParameter("searchable")));
 * attr.setSpecification(agritechService.getResourceSpecification(Long.parseLong
 * (request.getParameter("specification"))));
 * attr.setToolTipText(request.getParameter("toolTipText"));
 * attr.setUiTypeCode(request.getParameter("uiTypeCode"));
 * attr.setUpdatable(Boolean.parseBoolean(request.getParameter("updatable")));
 * attr.setValueType(request.getParameter("valueType"));
 * 
 * agritechService.saveAttributeSpecification(attr); model.put("success_msg",
 * "Attribute Specification added successfully!"); return "success"; }
 * 
 * }
 */