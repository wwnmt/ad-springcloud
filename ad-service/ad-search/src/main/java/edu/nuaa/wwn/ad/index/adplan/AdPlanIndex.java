package edu.nuaa.wwn.ad.index.adplan;

import edu.nuaa.wwn.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 12:18
 */
@Slf4j
@Component
public class AdPlanIndex implements IndexAware<Long, AdPlanObject> {

    private static final Map<Long, AdPlanObject> objectMap;

    static {
        objectMap = new ConcurrentHashMap<>();
    }

    @Override
    public AdPlanObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdPlanObject value) {
        log.info("before add: {}", objectMap);
        objectMap.put(key, value);
        log.info("after add: {}", objectMap);
    }

    @Override
    public void update(Long key, AdPlanObject value) {
        log.info("before update: {}", objectMap);
        AdPlanObject oldObject = objectMap.get(key);
        if (oldObject == null) {
            objectMap.put(key, value);
        } else {
            oldObject.update(value);
        }
        log.info("after update: {}", objectMap);
    }

    @Override
    public void delete(Long key, AdPlanObject value) {
        log.info("before delete: {}", objectMap);
        objectMap.remove(key);
        log.info("after delete: {}", objectMap);
    }
}
