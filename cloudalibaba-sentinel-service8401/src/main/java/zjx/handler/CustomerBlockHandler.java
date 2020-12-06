package zjx.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static Object handleException(BlockException b){
        return "handleException1";
    }

    public static Object handleException2(BlockException b){
        return "handleException2";
    }
}
