package com.zju.edas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hsf/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return helloService.echo(str);
    }
}
