package t_tok03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	ItemTarget itemTarget = (ItemTarget)context.getBean("itemTarget");
	itemTarget.selectItem();
	itemTarget.buyItem();
	itemTarget.buyItems();
	
	System.out.println();
	
	GoodsTarget goodsTarget = (GoodsTarget)context.getBean("goodsTarget");
	goodsTarget.buyGoods();
}
}
