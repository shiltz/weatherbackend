package com.shilton.weather.weatherapp.cache.ehcache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventAdapter extends CacheEventListenerAdapter {

    private Logger logger = LoggerFactory.getLogger(CacheEventAdapter.class);

    @Override
    public void notifyElementPut(Ehcache ehcache, Element element){
        logger.info("Putting in cache: {}, {}", ehcache.getName(), element.getObjectKey().toString());
    }

    @Override
    public void notifyElementEvicted(Ehcache ehcache, Element element){
        logger.info("Evicted in cache: {}, {}", ehcache.getName(), element.getObjectKey().toString());
    }

    @Override
    public void notifyElementExpired(Ehcache ehcache, Element element){
        logger.info("Expired in cache: {}, {}", ehcache.getName(), element.getObjectKey().toString());
    }

    @Override
    public void notifyElementRemoved(Ehcache ehcache, Element element){
        logger.info("Removed from cache: {}, {}", ehcache.getName(), element.getObjectKey().toString());
    }
}
