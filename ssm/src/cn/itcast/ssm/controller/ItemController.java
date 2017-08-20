package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Item;
import cn.itcast.ssm.po.ItemVO;
import cn.itcast.ssm.service.ItemService;


@Controller
public class ItemController {
	//加入测试
	//注入商品  ItemService接口
	@Autowired
	private ItemService itemService;
	@RequestMapping("/queryItem.do")
    public ModelAndView queryItem(ItemVO itemVO){
    	//1.创建ModelAndView 对象
		ModelAndView mav=new ModelAndView();
		//使用ItemService查询数据库,替换静态商品数据
		List<Item> list = this.itemService.queryItemList();
		//设置响应的模型数据
		mav.addObject("list", list);
		mav.setViewName("item/itemList");
		return mav;
    }
	//根据商品id查询商品
	//request参数:用于接收请求的商品id参数,springmvc在执行这个方法的时候会传递request对象
/*	@RequestMapping("/queryItemById.do")
	public ModelAndView queryItemById(HttpServletRequest  request){
		//获取商品id参数
		String id =request.getParameter("id");
		//2.调用service方法查询商品
		Item item = this.itemService.queryItemById(Integer.parseInt(id));
	    //3.创建modelandview对象
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("item/editItem");
	 return mav;
	}*/
	
	/*@RequestMapping("/queryItemById.do")
	public String queryItemById(Model model,HttpServletRequest request){
		//1.获取商品的id参数
		String id = request.getParameter("id");
		//2.调用service方法查询商品
		Item item = this.itemService.queryItemById(Integer.parseInt(id));
		model.addAttribute("item", item);
		return "item/editItem";
	}
	*/
	@RequestMapping("/queryItemById.do")
	public String queryItemById(Model model,Integer id){
		   //1.调用 service方法查询商品
		Item item = this.itemService.queryItemById(id);
		model.addAttribute("item", item);
		return "item/editItem";
	}
	//修改商品,保存数据库
	//使用商品pojo 接收请求的商品参数数据,pojo属性的名称与请求参数的名称一致
	@RequestMapping("/updateItem.do")
	public String updateItem(Item item){
		try{
		 this.itemService.updateItem(item);
		}catch(Exception e){
		 return "common/failure";
		}
		return "common/success";
	}
	
}
