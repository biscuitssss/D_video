package com.qfedu.service;

import com.qfedu.entity.Admin;

public interface AdminService {
    public Admin login(String username, String password);
//修改密码
    public void updatePass(Admin admin);
}
