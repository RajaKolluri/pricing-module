package org.hareram.springboot.pricemodule.dao;

import java.util.List;

import org.hareram.springboot.pricemodule.entity.Inventory;

public interface IInventoryDAO {

	List<Inventory> retrieveInventorydataByFilterText(String filterText);
}
