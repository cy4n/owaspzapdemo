# demo application for OWASP ZAP scans

this is a bogus application for training purposes and you should not run it in production.

it produces rest APIs that can be scanned by ZAP to learn how to find security issues and work with zap. 

developed by @indyarni, one of my best (former) colleagues!

## run locally
```bash
./mvnw spring-boot:run
```

produces openAPI-compatible api doc on localhost:8080/v2/api-docs that you can feed into ZAP api scanner
