package com.github.yulichang.config;

import com.baomidou.mybatisplus.core.metadata.MPJTableInfoHelper;
import com.baomidou.mybatisplus.core.metadata.MPJTableMapperHelper;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * 关系映射配置
 *
 * @author yulichang
 * @since 1.2.0
 */
public class MappingConfig implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        TableInfoHelper.getTableInfos().forEach(i ->
                MPJTableInfoHelper.initTableInfo(i.getEntityType(), MPJTableMapperHelper.get(i.getEntityType())));
    }
}