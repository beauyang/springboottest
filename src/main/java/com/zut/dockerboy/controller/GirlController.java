package com.zut.dockerboy.controller;

import com.zut.dockerboy.domain.Girl;
import com.zut.dockerboy.domain.Result;
import com.zut.dockerboy.properties.GirlRepository;
import com.zut.dockerboy.service.GirlService;
import com.zut.dockerboy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 增加
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(1);
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return ResultUtil.success(girlRepository.save(girl));
    }
    /**
     * 查询
     */
    @GetMapping(value = "/girls/{id}")
    public Result getGirl(@PathVariable("id") Integer id) {

        return ResultUtil.success(girlRepository.findOne(id));
    }

    /**
     * 更新
     */
    @PutMapping(value = "/girls/{id}")
    public Result updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 删除
     */

    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {

        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生列表
     *
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
    /**
     * 验证事务
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }


}
