package org.hareram.springboot.pricemodule.controller;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.hareram.springboot.pricemodule.dao.IInventoryDAO;
import org.hareram.springboot.pricemodule.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pricesheet")
@CrossOrigin(origins="http://localhost:4200")
public class PricingController {
	@Autowired
	private IInventoryDAO inventoryDao;

	@RequestMapping(value = "/{itemType}", method = RequestMethod.GET)
	@ResponseBody
	public ConcurrentMap<String, List<Inventory>> getItemPrices(@PathVariable("itemType") String itemType) {
		
		List<Inventory> result = inventoryDao.retrieveInventorydataByFilterText(itemType);
		
		/*List<PriceSheetItem> items = new ArrayList<>();
		PriceSheetItem item = new PriceSheetItem();
		item.setBrandName("Pegion");
		item.setItemPrice("110");
		item.setItemType("LED");
		items.add(item);*/
		
		Comparator<Inventory> dispOrderComparator = Comparator.comparingInt(Inventory::getItemDispOrder);
		Comparator<Inventory> brandNameComparator = Comparator.comparingInt(Inventory::getBrandDispOrder);
				//.thenComparing(dispOrderComparator);
		ConcurrentMap<String, List<Inventory>> groupingData
						= result.parallelStream()
						.collect(Collectors.groupingByConcurrent(Inventory::getBrandName));
		
		groupingData.entrySet().forEach(entry -> {entry.getValue().sort(dispOrderComparator);});
		
		return groupingData;
	}

	public IInventoryDAO getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(IInventoryDAO inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
}
