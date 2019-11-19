package de.synyx.zapdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VulnerableController {

    private static final Logger LOG = LoggerFactory.getLogger(VulnerableController.class);

    @GetMapping(path = "/foo")
    public String foo() {
        LOG.info("received GET request");
        throw new IllegalArgumentException();
        //return "hallo";
    }

    @PostMapping(path = "/bar")
    public void bar() {
        LOG.info("received POST request");
    }
}
