package com.stockmarket;

import java.util.List;

import com.stockmarket.entity.PaginationPo;
import com.stockmarket.entity.SharePo;
import com.wteamfly.superW.core.dao.SuperDaoProxy;
import com.wteamfly.superW.core.entity.po.UserPo;

/**
 * 
 * @author DZY
 *
 */
public class AnalyseShareByMapSet {

	public static void main(String[] args) {
		SuperDaoProxy dao = SuperDaoProxy.getInstance();
		UserPo currentUser = new UserPo();
		currentUser.setUserId(1L);
		SharePo sPoForQuery = new SharePo();

		try {
			List<SharePo> list = (List<SharePo>) dao.queryList(sPoForQuery);
			for (int i = 1; i <= 7; i++) {
				PaginationPo page = new PaginationPo();
				page.setIndexPageNum(i);
				page.setSize(500);
				page.setTotalCount(Long.parseLong(String.valueOf(list.size())));
				InsertMapThead insertMapThead = new InsertMapThead(page, list);
				insertMapThead.start();
			}
			


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
