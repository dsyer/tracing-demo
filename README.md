Spring Boot modifies the logger format to contain application name, trace and span ids.

```
$ curl -H "TraceParent: 00-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01" localhost:8080
Hello World
```

logs:

```
2023-12-15T11:17:33.962Z DEBUG 2135673 --- [demo] [nio-8080-exec-3] [4bf92f3577b34da6a3ce929d0e0e4736-68a712d2681cdba8] o.s.web.servlet.DispatcherServlet        : GET "/", parameters={}
2023-12-15T11:17:33.963Z DEBUG 2135673 --- [demo] [nio-8080-exec-3] [4bf92f3577b34da6a3ce929d0e0e4736-68a712d2681cdba8] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to com.example.demo.DemoController#hello()
2023-12-15T11:17:33.963Z DEBUG 2135673 --- [demo] [nio-8080-exec-3] [4bf92f3577b34da6a3ce929d0e0e4736-68a712d2681cdba8] m.m.a.RequestResponseBodyMethodProcessor : Using 'text/plain', given [*/*] and supported [text/plain, */*, application/json, application/*+json]
2023-12-15T11:17:33.963Z DEBUG 2135673 --- [demo] [nio-8080-exec-3] [4bf92f3577b34da6a3ce929d0e0e4736-68a712d2681cdba8] m.m.a.RequestResponseBodyMethodProcessor : Writing ["Hello World"]
2023-12-15T11:17:33.964Z DEBUG 2135673 --- [demo] [nio-8080-exec-3] [4bf92f3577b34da6a3ce929d0e0e4736-68a712d2681cdba8] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
```

(See [otel docs](https://www.w3.org/TR/trace-context/#examples-of-http-traceparent-headers) for syntax of the header.)