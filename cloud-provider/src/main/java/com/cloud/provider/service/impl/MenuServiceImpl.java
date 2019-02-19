package com.cloud.provider.service.impl;

import com.cloud.provider.dao.MenuRepository;
import com.cloud.provider.modal.Menu;
import com.cloud.provider.service.MenuService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu queryMenuById(int menuId) throws Exception{
        //按标题进行搜索
        QueryBuilder builder = new MatchQueryBuilder("id", menuId);
        System.out.println("查询的语句:"+builder);
        Iterator<Menu> searchResult = menuRepository.search(builder).iterator();
        List<Menu> list=new ArrayList<>();
        while (searchResult.hasNext()) {
            list.add(searchResult.next());
        }
        return list.get(0);
    }

}
