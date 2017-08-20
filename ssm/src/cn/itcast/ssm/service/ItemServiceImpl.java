package cn.itcast.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.ssm.mapper.ItemMapper;
import cn.itcast.ssm.po.Item;
@Service
public class ItemServiceImpl implements ItemService {
   
	//注入商品mapper接口
	@Autowired
	private ItemMapper itemMapper;
	public List<Item> queryItemList() {
		List<Item> list = itemMapper.selectByExample(null);
		return list;
	}
	public Item queryItemById(Integer id) {
		Item item =this.itemMapper.selectByPrimaryKey(id);
		return item;
	}
	
	public void updateItem(Item item) {
		this.itemMapper.updateByPrimaryKeySelective(item);
		
	}

}
