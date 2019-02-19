package com.cloud.provider.dao;

import com.cloud.provider.modal.Menu;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Created with IntelliJ IDEA.
 * @Description: cloud-micro-service
 * @Author: luhk
 * @Date: 2019-01-02
 * @Time: 10:06 AM
 * @Version: 1.0
 */
public interface MenuRepository extends ElasticsearchRepository<Menu,String> {}
