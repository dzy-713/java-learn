package com.dzy.spring;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统用户对象
 *
 * @author douzy
 * @date 2020-05-27.
 */
@Getter
@Setter
public class SystemUser {

    private String id;
    private String name;
    private String password;

    @Override
    public String toString(){
        return "id="+id+",name="+name+",password="+password;
    }
}
