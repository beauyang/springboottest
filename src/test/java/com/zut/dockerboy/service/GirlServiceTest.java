package com.zut.dockerboy.service;

import com.zut.dockerboy.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void insertTwo() throws Exception {

    }

    @Test
    public void getAge() throws Exception {
    }

    @Test
    public void findOne() throws Exception {
        Girl girl = girlService.findOne(20);
        Assert.assertEquals(new Integer(15), girl.getAge());
    }

}