package com.youzan.dts.console.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CanalInstanceManageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        return instanceManageByPost(model);
    }

    @RequestMapping(value = "/instanceManage", method = RequestMethod.GET)
    public String instanceManage(Model model) {
        return instanceManageByPost(model);
    }

    @RequestMapping(value = "/instanceManage", method = RequestMethod.POST)
    public String instanceManageByPost(Model model) {
        return "instanceManage";
    }


}
