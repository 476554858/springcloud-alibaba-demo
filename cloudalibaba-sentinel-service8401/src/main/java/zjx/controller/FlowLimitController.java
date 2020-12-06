package zjx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    //测试限流用
    @GetMapping(value = "testA")
    public String tsetA(){
        try {
            TimeUnit.MILLISECONDS.sleep(800l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-----testA";
    }

    //测试限流用
    @GetMapping(value = "testB")
    public String tsetB(){
        System.out.println(Thread.currentThread().getName() + "===============");
        return "-----testB";
    }

    //测试降级用和异常比例
    @GetMapping(value = "testD")
    public String testD(){
        try {
//            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int age = 10/0;
        return "-----testD";
    }

    //测试降级用和异常数
    @GetMapping(value = "testE")
    public String testE(){
        int age = 10/0;
        return "-----testE";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){

        return "---------------------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        System.out.println("p1=" + p1 + ",p2=" + p2);
        return "-------------deal_testHotKey";
    }
}
