package edu.nuaa.wwn.ad.index.creative;

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
 * Time: 13:23
 */
@Slf4j
@Component
public class CreativeIndex implements IndexAware<Long, CreativeObject> {

    private static final Map<Long, CreativeObject> objectMap;

    static {
        objectMap = new ConcurrentHashMap<>();
    }

    @Override
    public CreativeObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, CreativeObject value) {
        log.info("CreativeIndex, before add: {}", objectMap);
        objectMap.put(key, value);
        log.info("CreativeIndex, after add: {}", objectMap);
    }

    @Override
    public void update(Long key, CreativeObject value) {
        log.info("CreativeIndex, before update: {}", objectMap);
        CreativeObject oldObject = objectMap.get(key);
        if (oldObject == null) {
            objectMap.put(key, value);
        } else {
            oldObject.update(value);
        }
        log.info("CreativeIndex, after update: {}", objectMap);
    }

    @Override
    public void delete(Long key, CreativeObject value) {
        log.info("CreativeIndex, before delete: {}", objectMap);
        objectMap.remove(key);
        log.info("CreativeIndex, after delete: {}", objectMap);
    }
}
