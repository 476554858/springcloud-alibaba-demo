package zjx.service;

import zjx.domain.CommonResult;

public interface StorageService {

    CommonResult decreaseStorage( Long productId, Integer count);
}
