package com.yang.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assert;
import org.springframework.util.CollectionUtils;

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
        // getManyParams();
        // returnMany();
        returnRange();
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

    public static void returnMany(){
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity("Gavin"));
        entities.add(new Entity("Peter"));
        entities.add(new Entity("Zero"));

        List<Entity> result =(List<Entity>) JSONPath.eval(entities,"[1,2]");
        if(!CollectionUtils.isEmpty(result) && result.size() == 2){
            System.out.println(result.get(0).getName());
            System.out.println(result.get(1).getName());
        }
    }

    public static void returnRange(){
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity("Gavin"));
        entities.add(new Entity("Peter"));
        entities.add(new Entity("Zero"));

        List<Entity> result =(List<Entity>) JSONPath.eval(entities,"[0:2]");
        if(!CollectionUtils.isEmpty(result) && result.size() == 3){
            System.out.println(result.get(0).getName());
            System.out.println(result.get(1).getName());
            System.out.println(result.get(2).getName());
        }

    }

}

