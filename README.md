# Threading workshop project    
This is a simple project to demonstrate the use of threading in Java.
To run your gatling load tests go to you intellij terminal and run the following command:
```bash 
mvn gatling:test
```

### ✅ Option 1: `Servlet Async` + `Virtual Threads`

## Free Tomcat thread, delegate to a virtual thread.
![img_3.png](img_3.png)

✅ Option 2: `DeferredResult` + `CompletableFuture`

Clean async chaining with virtual thread support.
![img.png](img.png)

✅ Option 3: Use `HttpServer.create()` (Reactor Netty)
![img_1.png](img_1.png)
![img_2.png](img_2.png)

✅ Option 4: Switch to WebFlux