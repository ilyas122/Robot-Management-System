package cmpe.cloudcomputing.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmpe.cloudcomputing.response.BusinessRegister;
import cmpe.cloudcomputing.response.DateAccount;
import cmpe.cloudcomputing.response.KeyValueType;
import cmpe.cloudcomputing.robot.entity.Businessowner;
import cmpe.cloudcomputing.robot.service.BusinessownerService;

@RestController
public class BusinessownerController {
	
	
	@Autowired
	BusinessownerService boService;

    @PostMapping("/business/register")
    public Businessowner register(@RequestBody BusinessRegister request){
    	return boService.register(request);
    }
    
    @PostMapping("/business/totalcounttype")
    //@ResponseBody
    public KeyValueType getTotalCountType(@RequestBody DateAccount date){
    	return boService.getTotalCountType(date);
    }
    
   @PostMapping("/business/getinvoice")
  //@ResponseBody
    public KeyValueType getInvoice(@RequestBody DateAccount date){
    	return boService.getInvoice(date);
    }
   
   //PayInvoice()

}
