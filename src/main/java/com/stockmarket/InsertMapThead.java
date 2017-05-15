package com.stockmarket;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.stockmarket.entity.PaginationPo;
import com.stockmarket.entity.SharePo;
import com.stockmarket.entity.ShareweightPo;
import com.wteamfly.superW.core.helper.JPAHelper;

public class InsertMapThead extends Thread {

	private PaginationPo page = new PaginationPo();
	List<SharePo> list = new ArrayList<>();

	public InsertMapThead(PaginationPo page, List<SharePo> list) {
		this.page = page;
		this.list = list;
	}

	@Override
	public void run() {
		int beginindex = (page.getIndexPageNum() - 1) * page.getSize();
		if (beginindex <= list.size()) {
			for (int i = beginindex; i < page.getSize(); i++) {
				if (i <= list.size()) {
					SharePo sharePo = list.get(i);
					EntityManager em = JPAHelper.getEntityManagerFactory().createEntityManager();
					CriteriaBuilder cb = em.getCriteriaBuilder();
					CriteriaQuery<Long> cqForWeight = cb.createQuery(Long.class);
					Root<ShareweightPo> rootForShareweight = cqForWeight.from(ShareweightPo.class);
					em.getTransaction().begin();
					int countForP = 0;
					for (SharePo share2Po : list) {
						if (!sharePo.getShareid().equals(share2Po.getShareid())) {
							cqForWeight.where(cb.equal(rootForShareweight.get("shareid"), sharePo.getShareid()),
									cb.equal(rootForShareweight.get("shareid"), share2Po.getShareid()));
							cqForWeight.multiselect(cb.countDistinct(rootForShareweight.get("shareweightid")));
							Long count = (Long) em.createQuery(cqForWeight).getSingleResult();
							if (count == 0) {
								ShareweightPo shareweightPo = new ShareweightPo();
								shareweightPo.setShareid(sharePo.getShareid());
								shareweightPo.setOthershareid(share2Po.getShareid());
								shareweightPo.setChangedirection(0L);
								shareweightPo.setWeight(0L);
								shareweightPo.setCreatorId(1L);
								em.persist(shareweightPo);
								countForP++;
							}
						}
						if (countForP % 1000 == 0) {
							em.flush();
							em.clear();
						}
					}
					em.getTransaction().commit();
					em.close();
				}
			}
		}

	}

}
