@RestController
class HelloWorld {
    @RequestMapping("/hello")
    String hello() {
        return "Hello World!"
    }
}
