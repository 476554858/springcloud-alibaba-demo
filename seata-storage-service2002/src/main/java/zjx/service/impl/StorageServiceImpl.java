package zjx.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjx.domain.CommonResult;
import zjx.domain.Storage;
import zjx.mapper.StorageMapper;
import zjx.service.StorageService;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    public CommonResult decreaseStorage( Long productId, Integer count){
        Storage storage = new Storage();
        storage.setProductId(productId);
        storage = storageMapper.selectOne(storage);

        storage.setUsed(storage.getUsed() + count);
        storage.setResidue(storage.getResidue() - count);
        storageMapper.updateById(storage);

        return CommonResult.success();
    }
}
