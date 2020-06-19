/*
 * package com.app.agritech.controller;
 * 
 * import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.app.agritech.dto.UserProfile; import
 * com.app.agritech.entity.Address; import com.app.agritech.entity.CommodityAd;
 * import com.app.agritech.entity.LeadConversation; import
 * com.app.agritech.entity.Person; import com.app.agritech.entity.UserDetails;
 * import com.app.agritech.service.TimesheetService;
 * 
 * @Controller public class MyAccountController {
 * 
 * @Autowired TimesheetService agritechService;
 * 
 * @GetMapping("/myProfile") public String getProfile(ModelMap model,
 * HttpServletRequest request) { UserDetails user = (UserDetails)
 * request.getSession().getAttribute("user"); Person person = user.getPerson();
 * UserProfile profile = new UserProfile(); profile.setName(person.getName());
 * profile.setAltMobileNumber(person.getAltMobNumber());
 * profile.setMobNumber(person.getMobNumber());
 * profile.setAddress(person.getAddress());
 * profile.setEmailId(person.getEmailId()); model.put("userProfile", profile);
 * return "myProfile"; }
 * 
 * @PostMapping("/saveProfile") public String
 * updateProfile(@ModelAttribute("userProfile") UserProfile userProfile,
 * ModelMap model, HttpServletRequest request) { if (userProfile == null)
 * userProfile = new UserProfile(); UserDetails user = (UserDetails)
 * request.getSession().getAttribute("user"); Person person = user.getPerson();
 * Address address = person.getAddress();
 * address.setAddressText(userProfile.getAddress().getAddressText());
 * person.setAddress(address); person.setName(userProfile.getName());
 * person.setAltMobNumber(userProfile.getAltMobileNumber());
 * person.setMobNumber(userProfile.getMobNumber());
 * person.setEmailId(userProfile.getEmailId());
 * agritechService.saveProfile(person); model.put("userProfile", userProfile);
 * model.put("success", "Your profile saved successfully"); model.put("title",
 * "Success: "); return "myProfile"; }
 * 
 * @GetMapping("/myAds") public String getAds(ModelMap model, HttpServletRequest
 * request) { UserDetails user = (UserDetails)
 * request.getSession().getAttribute("user"); List<CommodityAd> myAdList =
 * agritechService.getCommodityAdsByUser(user.getPerson()); model.put("myAds",
 * myAdList); return "myAds"; }
 * 
 * @GetMapping("/myMessageLeads") public String getMessageLeads(ModelMap model,
 * HttpServletRequest request) { UserDetails user = (UserDetails)
 * request.getSession().getAttribute("user"); List<LeadConversation>
 * myConversations =
 * agritechService.getLeadConversationsByUser(user.getPerson());
 * model.put("conversations", myConversations); return "myMessages"; }
 * 
 * @GetMapping("/deleteAd") public String deleteAd(ModelMap model,
 * HttpServletRequest request,
 * 
 * @RequestParam(required = true, name = "adId") long adId) { UserDetails user =
 * (UserDetails) request.getSession().getAttribute("user"); CommodityAd myAd =
 * agritechService.getCommodityAd(adId); if (user != null &&
 * myAd.getOwner().getId() == user.getPerson().getId()) {
 * agritechService.deleteCommodityAd(adId); List<CommodityAd> myAdList =
 * agritechService.getCommodityAdsByUser(user.getPerson()); model.put("myAds",
 * myAdList); model.put("success", "Your ad is deleted successfully.");
 * model.put("title", "Success: "); } else { model.put("error",
 * "You are not authorized to delete this Ad"); model.put("title", "Error: "); }
 * return "myAds"; }
 * 
 * @GetMapping("/myAccountSettings") public String getAccountSettings() { return
 * "myAccountSettings"; }
 * 
 * }
 */