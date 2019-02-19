package com.cloud.provider.controller.rest;

import com.cloud.provider.rabbit.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping(value = "/V1.0")
public class MsgSendController {

    @Autowired
    private MsgProducer msgProducer;

    @RequestMapping(value = "/simpleModeSend", method = RequestMethod.GET)
    public String simpleModeSend(String message){
        String uuid = UUID.randomUUID().toString();
        if (message == null) { message = "前台无输入"; }
        int i = 0;
        while (i< 500) {
            try {
                Thread.sleep(100);
                msgProducer.simpleModeSend(uuid,message+"  i: " + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return uuid;
    }

    @RequestMapping(value = "/fanoutModeSend", method = RequestMethod.GET)
    public String fanoutModeSend(String message){
        String uuid = UUID.randomUUID().toString();
        if (message == null) { message = "前台无输入"; }
        int i = 0;
        while (i< 500) {
            try {
                Thread.sleep(100);
                msgProducer.fanoutModeSend(uuid,message+"  i: " + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return uuid;
    }

    @RequestMapping(value = "/directModeSend", method = RequestMethod.GET)
    public String directModeSend(String message){
        String uuid = UUID.randomUUID().toString();
        if (message == null) { message = "前台无输入"; }
        int i = 0;
        while (i< 500) {
            try {
                Thread.sleep(100);
                msgProducer.directModeSend(uuid,message+"  i: " + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return uuid;
    }

    @RequestMapping(value = "/topicModesend1", method = RequestMethod.GET)
    public String topicModesend1(String message){
        String uuid = UUID.randomUUID().toString();
        if (message == null) { message = "前台无输入"; }
        int i = 0;
        while (i< 500) {
            try {
                Thread.sleep(100);
                msgProducer.topicModesend1(uuid,message+"  i: " + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return uuid;
    }

    @RequestMapping(value = "/topicModesend2", method = RequestMethod.GET)
    public String topicModesend2(String message){
        String uuid = UUID.randomUUID().toString();
        if (message == null) { message = "前台无输入"; }
        int i = 0;
        while (i< 500) {
            try {
                Thread.sleep(100);
                msgProducer.topicModesend2(uuid,message+"  i: " + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return uuid;
    }
}
