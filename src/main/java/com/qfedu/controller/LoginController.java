package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.utils.StrUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

@Controller
@RequestMapping("admin")
@ResponseBody
public class LoginController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login.do")

    //使用注解修饰方法上的参数, 第二种写法
    public JsonResult login (@NotEmpty String username, @Size(min=1, max = 8) String password, HttpSession session) {
        JsonResult jsonResult = null;
        try{
            Admin admin = adminService.login(username, password);
            session.setAttribute(StrUtils.LOGIN_USER, admin);

            jsonResult = new JsonResult(1,null);
        } catch (Exception e) {
            jsonResult = new JsonResult(0,null);
        }
        return jsonResult;
    }

    public JsonResult updatePass(Admin admin) {
        adminService.updatePass(admin);
        JsonResult jsonResult = new JsonResult();
        return jsonResult;
    }
}
