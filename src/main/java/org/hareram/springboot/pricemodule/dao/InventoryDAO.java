package org.hareram.springboot.pricemodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hareram.springboot.pricemodule.entity.Inventory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InventoryDAO implements IInventoryDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> retrieveInventorydataByFilterText(String filterText) {
		StringBuffer hql = new StringBuffer()
				//.append("select hsnCode, itemCode, item_desc, item_type, quantity, wholesale_price, brand_name, brand_disp_order, item_disp_order")
				.append(" from Inventory group by itemType, itemDesc, brandName ")
				.append(" having itemType like ? ")
				.append(" order by itemDispOrder asc, brandDispOrder asc");
				//.append("from Inventory ");
		
		List<Inventory> list = entityManager.createQuery(hql.toString()).setParameter(1, filterText).getResultList();
		System.out.println(list.size());
		
		return list;
	}

}
