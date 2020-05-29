package com.dzy.spring;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色
 *
 * @author douzy
 * @date 2020-05-27.
 */
@Getter
@Setter
public class SystemRole {

    private String id;
    private String name;
    private String code;

    @Override
    public String toString(){
        return "id="+id+",code="+code+",name="+name;
    }
}
