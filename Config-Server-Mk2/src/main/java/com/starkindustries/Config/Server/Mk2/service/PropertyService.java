package com.starkindustries.Config.Server.Mk2.service;

import com.starkindustries.Config.Server.Mk2.dto.request.PropertyRequest;
import com.starkindustries.Config.Server.Mk2.dto.response.PropertyResponse;
import com.starkindustries.Config.Server.Mk2.enums.Profiles;
import com.starkindustries.Config.Server.Mk2.model.Properties;
import com.starkindustries.Config.Server.Mk2.repository.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    public PropertiesRepository propertiesRepository;

    public Properties addProperty(PropertyRequest propertyRequest){

        Properties properties = Properties.builder()
                .application(propertyRequest.getApplication())
                .profile(Profiles.valueOf(propertyRequest.getProfile()))
                .label(propertyRequest.getLabel())
                .propKey(propertyRequest.getPropKey())
                .propValue(propertyRequest.getPropValue())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        return this.propertiesRepository.save(properties);

    }

    public List<Properties> getAllProperties(){

        List<Properties> propertiesList = this.propertiesRepository.findAll();
        if(!propertiesList.isEmpty())
            return propertiesList;
        return new ArrayList<Properties>(Collections.emptyList());
    }

    public List<Properties> findPropertiesByProfile(Profiles profile){

        List<Properties> propertiesList = this.propertiesRepository.findByProfile(profile);
        if(!propertiesList.isEmpty())
            return propertiesList;
        return new ArrayList<Properties>(Collections.emptyList());
    }




}
