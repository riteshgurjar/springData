package com.ge.predix.dbaccess;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ge.predix.model.Client;
import com.ge.predix.model.LocoSummary;
import com.ge.predix.model.Test;
import com.ge.predix.repository.ClientRepository;
import com.ge.predix.repository.TestRepository;
import com.ge.predix.repository.LocoSummaryRepository;

@SpringBootApplication
@EntityScan(basePackages = { "com.ge.predix.model" }) 
@EnableJpaRepositories(basePackages = { "com.ge.predix.repository" })

public class SpringBootDbDataProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDbDataProjectApplication.class, args);
	}
}

@Controller
@RestController
class WebController {
    @Autowired
    ClientRepository repository;
    
    @Autowired
    TestRepository testRepository;
    
    @Autowired
    RESTClient restClient;
    
    @Autowired
    LocoSummaryRepository locoSummaryRepository;
    
    @Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }
    
       
    @RequestMapping("/readRest")
    public String readRest(){
        return restClient.getLocoSum().toString();
    }
    
    @RequestMapping("/findbyname")
    public String findByName(@RequestParam("name") String name){
        String result = "<html>";
         
        for(Client cust: repository.findByName(name)){
            result = cust.getName().toString();
        }       
        return result;
    }
    
    
    
    @RequestMapping("/findall")
    public String findAll(){
        System.out.println("in find all");
        String result = "<html>";
         
        for(Client cust : repository.findAll()){
            result += "<div>" + cust.getName().toString() + "</div>";
            System.out.println("result :::"+result);
        }
         System.out.println("done ");
        return result + "</html>";
    }
    
    @CrossOrigin(origins = "https://rg-predix-seed-polymer.run.aws-usw02-pr.ice.predix.io")
    @RequestMapping("/findallTest")
    public String findAllTest(){
        System.out.println("in find test all");
        String result = "<html>";
        JSONArray finalLocoArray = new JSONArray();
        
        for(LocoSummary lcr : locoSummaryRepository.findAll()){
            JSONArray locoRecord = new JSONArray();
            //convert date to epoch
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            Date date = null;
            try
            {
                date = df.parse(lcr.getFailDate().toString());
            }
            catch (ParseException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            long failDateEpoch = date.getTime();
            System.out.println(failDateEpoch);
            
            locoRecord.put(failDateEpoch);
            locoRecord.put(lcr.getFailCount());
            finalLocoArray.put(locoRecord);
            System.out.println("finalLocoArray :::"+finalLocoArray.length());
        }
         System.out.println("done adding loco data ");
        return finalLocoArray.toString();
         
         
         /*JSONArray joa = new JSONArray();
         JSONArray ja = new JSONArray();
         ja.put(6);     
         ja.put(2);
         JSONArray ja2 = new JSONArray();
         ja2.put(3);     
         ja2.put(5);
         
         JSONArray ja3 = new JSONArray();
         ja3.put(7);     
         ja3.put(1);
         
         joa.put(ja);
         joa.put(ja2);
         joa.put(ja3);
         System.out.println("data::"+joa.toString());
         //return new ResponseEntity<JSONArray>(joa, HttpStatus.OK);
         return joa.toString();*/
         
         
        
    }
}
