package com.yang.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/29 23:52
 * @Version 1.0
 * @qq: 1411091515
 */

@Slf4j
public class EntityJsonPathCaseOne {

    public static void main(String[] args) {
        // entityOneSimple();
        getManyParams();
    }

    private static void entityOneSimple(){
        Entity entity = new Entity(123, new Object());
        Object valueObject = JSONPath.eval(entity,"$.value");
        boolean contains = JSONPath.contains(entity, "$.value");
        boolean containsValue = JSONPath.containsValue(entity, "$.value", 123);
        boolean containsId = JSONPath.containsValue(entity, "$.id", 123);
        int size = JSONPath.size(entity, "$");
        int sizeTwo = JSONPath.size(new ArrayList<>(), "$");

        log.info(" contains ---> {} " , contains);
        log.info(" containsValue --> {} " , containsValue);
        log.info(" contains ---> {} ", contains);
        log.info(" size ---> {} ",size);
        log.info(" sizeTwo --> {} ", sizeTwo);
    }

    public static void getManyParams(){
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity("Gavin"));
        entities.add(new Entity("Peter"));

        JSONArray jsonArray = (JSONArray) JSONPath.eval(entities,"$.name");
        log.info("  jsonArray ---> {} " , jsonArray);
    }


}

