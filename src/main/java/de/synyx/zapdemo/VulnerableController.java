package de.synyx.zapdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class VulnerableController {

    private static final Logger LOG = LoggerFactory.getLogger(VulnerableController.class);

    @GetMapping(path = "/foo")
    public String foo(HttpServletRequest request) {
        LOG.info(String.format("GET %s", request.getRequestURI()));
        return "hallo";
    }

    @PostMapping(path = "/bar/{variable}")
    public ResponseEntity<StringResponse> bar( @PathVariable String variable,
                                              HttpServletRequest request) {
        LOG.info(String.format("POST %s - %s", request.getRequestURI(), variable));
        return new ResponseEntity<>(new StringResponse(variable), HttpStatus.OK);
    }

    @PostMapping(path = "/baz")
    public ResponseEntity<StringResponse> baz(@RequestBody BazDto body,
                                              HttpServletRequest request) {
        LOG.info(String.format("POST %s - %s", request.getRequestURI(), body));
        return new ResponseEntity<>(new StringResponse(body.toString()), HttpStatus.OK);
    }

    @GetMapping(path = "/broken")
    public String broken(HttpServletRequest request) {
        LOG.info(String.format("GET %s", request.getRequestURI()));
        throw new IllegalArgumentException();
    }
}
