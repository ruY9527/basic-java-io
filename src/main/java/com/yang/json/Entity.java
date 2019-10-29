package com.yang.json;

import lombok.Data;

/**
 * 对象
 *
 * @Author: Mu_Yi
 * @Date: 2019/10/29 23:50
 * @Version 1.0
 * @qq: 1411091515
 */

@Data
public class Entity {

    private Integer id;
    private String name;
    private Object value;

    public Entity() {}
    public Entity(Integer id, Object value) { this.id = id; this.value = value; }
    public Entity(Integer id, String name) { this.id = id; this.name = name; }
    public Entity(String name) { this.name = name; }

}
