package cn.food.boot.mapper;

import cn.food.boot.po.ItemsCustom;
import cn.food.boot.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

}