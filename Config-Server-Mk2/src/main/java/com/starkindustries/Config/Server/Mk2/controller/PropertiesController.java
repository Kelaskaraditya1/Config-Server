package com.starkindustries.Config.Server.Mk2.controller;

import ch.qos.logback.core.status.InfoStatus;
import com.starkindustries.Config.Server.Mk2.dto.request.PropertyRequest;
import com.starkindustries.Config.Server.Mk2.enums.Profiles;
import com.starkindustries.Config.Server.Mk2.keys.Keys;
import com.starkindustries.Config.Server.Mk2.model.Properties;
import com.starkindustries.Config.Server.Mk2.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/properties")
public class PropertiesController {

    @Autowired
    public PropertyService propertyService;

    @PostMapping("/add-property")
    public ResponseEntity<?> addProperty(@RequestBody PropertyRequest propertyRequest){

        Map<String, Object> response = new HashMap<>();

        response.put(Keys.TIME_STAMP, Instant.now());

        if(propertyRequest!=null){

            Properties properties = this.propertyService.addProperty(propertyRequest);

            if(properties!=null){
                response.put(Keys.STATUS, HttpStatus.OK.value());
                response.put(Keys.MESSAGE,"Property added Successfully!!");
                response.put(Keys.BODY,properties);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put(Keys.STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.put(Keys.MESSAGE,"Failed to add Property!!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }else{
            response.put(Keys.STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put(Keys.MESSAGE,"Request Body is null!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @GetMapping("/all-properties")
    public ResponseEntity<?> getAllProperties(){
        Map<String,Object> response = new HashMap<>();
        response.put(Keys.TIME_STAMP,Instant.now());

        List<Properties> propertiesList = this.propertyService.getAllProperties();

        if(!propertiesList.isEmpty()){
            response.put(Keys.STATUS,HttpStatus.OK.value());
            response.put(Keys.MESSAGE,"Properties fetched!!");
            response.put(Keys.BODY,propertiesList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put(Keys.STATUS,HttpStatus.OK.value());
            response.put(Keys.MESSAGE,"Properties list is empty!!");
            response.put(Keys.BODY,propertiesList);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("/get-properties/{profile}")
    public ResponseEntity<?> getPropertiesByProfile(@PathVariable("profile") String profile){

        Map<String,Object> response = new HashMap<>();
        response.put(Keys.TIME_STAMP, Instant.now());

        if(profile!=null && !profile.isEmpty()){

            List<Properties> propertiesList = this.propertyService.findPropertiesByProfile(Profiles.valueOf(profile));
            if(!propertiesList.isEmpty()){
                response.put(Keys.STATUS,HttpStatus.OK.value());
                response.put(Keys.MESSAGE,"Properties fetched !!");
                response.put(Keys.BODY,propertiesList);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put(Keys.STATUS,HttpStatus.OK.value());
                response.put(Keys.MESSAGE,"Properties list is empty!!");
                response.put(Keys.BODY,propertiesList);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }else{
            response.put(Keys.STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put(Keys.MESSAGE,"profile is null!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
