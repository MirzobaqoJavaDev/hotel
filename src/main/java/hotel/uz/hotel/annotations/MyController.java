package hotel.uz.hotel.annotations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/fast-method")
    @MeasureExecutionTime
    public String fastMethod(){
        return "fast method example";
    }

    @GetMapping("/slow-method")
    @MeasureExecutionTime
    public String slowMethod() throws InterruptedException {
        Thread.sleep(3000);
        return "slow method example";
    }
}
