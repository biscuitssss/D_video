package com.qfedu.dao;

import com.qfedu.entity.Admin;

public interface AdminDao {
//    登录
    public Admin findByName(String username);
//    修改密码
    public void updatePass(Admin admin);

}
