/*
 * package com.wu.controller;
 * 
 * import javax.xml.bind.JAXBElement;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.ws.server.endpoint.annotation.PayloadRoot; import
 * org.springframework.ws.server.endpoint.annotation.RequestPayload; import
 * org.springframework.ws.server.endpoint.annotation.ResponsePayload;
 * 
 * import com.wu.service.play.MobileService; import
 * com.wu.solargalaxyservice.galaxy.AddMobileRequest; import
 * com.wu.solargalaxyservice.galaxy.GetMobileByNameOrWithoutNameResponse; import
 * com.wu.solargalaxyservice.galaxy.ObjectFactory;
 * 
 * @CrossOrigin("*")
 * 
 * @RestController
 * 
 * @RequestMapping("/wu") public class MobileController {
 * 
 * @Autowired
 * 
 * @Qualifier("mobileService") private MobileService mobileService;
 * 
 * @PostMapping(value = "/insert/{request}") public boolean
 * saveMobile(@RequestBody AddMobileRequest request){
 * 
 * return mobileService.saveMobile(request).getValue();
 * 
 * }
 * 
 * 
 * @GetMapping(value = "/load") public GetMobileByNameOrWithoutNameResponse
 * getMobileByNameOrWithoutName(@RequestParam(value = "name",required = false)
 * String name){
 * 
 * return mobileService.getMobileByNameOrWithoutName(name);
 * 
 * }
 * 
 * }
 */