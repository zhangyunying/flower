package com.flower.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.flower.entity.Address;
import com.flower.entity.Service;
import com.flower.entity.User;
import com.flower.enums.LoginType;
import com.flower.reponse.Result;
import com.flower.service.AddressService;
import com.flower.service.UserService;
import com.flower.util.TokenUtil;
import com.flower.vo.LoginVo;
import com.flower.vo.RegisterVo;
import com.flower.vo.ServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;


    @RequestMapping("/list")
    public String list() {
        List<Address> addressList = addressService.list();
        return Result.OK.data(addressList);
    }

    @RequestMapping("/addAddress")
    public String addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
        return Result.OK.data(address);
    }
}
