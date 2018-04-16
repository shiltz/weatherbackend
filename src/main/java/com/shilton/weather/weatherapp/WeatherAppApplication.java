package com.shilton.weather.weatherapp;

import com.shilton.weather.weatherapp.config.StandaloneConfig;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

@SpringBootApplication
@EnableConfigurationProperties(value = {StandaloneConfig.class})
@EnableCaching
public class WeatherAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppApplication.class, args);
        CacheManager manager = CacheManager.getCacheManager(null);
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ManagementService.registerMBeans(manager, mBeanServer, false, false, false,
                true);
    }
}
