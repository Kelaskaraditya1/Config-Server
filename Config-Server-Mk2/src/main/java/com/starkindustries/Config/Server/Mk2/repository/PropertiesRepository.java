package com.starkindustries.Config.Server.Mk2.repository;

import com.starkindustries.Config.Server.Mk2.enums.Profiles;
import com.starkindustries.Config.Server.Mk2.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,Long> {

    public List<Properties> findByProfile(Profiles profile);

}
