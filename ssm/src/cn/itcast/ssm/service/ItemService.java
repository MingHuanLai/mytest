package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.Item;

public interface ItemService {
     //查询商品列表
	  List<Item> queryItemList();
	 //根据商品id查询商品信息
	  Item queryItemById(Integer id);
	 //实现商品数据修改,保存数据库
	  void updateItem(Item item);
}
