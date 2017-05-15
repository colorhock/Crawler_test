package com.stockmarket.entity;
// Generated 2017-5-14 2:39:34 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.wteamfly.superW.core.entity.po.BasePersistentObject;

/**
 * 
 * @author DZY
 *
 */
@Entity
@Table(name = "t_shareweight")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ShareweightPo extends BasePersistentObject {

	private Long shareweightid;
	private Long shareid;
	private Long othershareid;
	private Long weight;
	private Long changedirection;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shareweightid", nullable = false)
	public Long getShareweightid() {
		return shareweightid;
	}

	@Column(name = "shareid")
	public Long getShareid() {
		return shareid;
	}

	@Column(name = "othershareid")
	public Long getOthershareid() {
		return othershareid;
	}

	@Column(name = "weight")
	public Long getWeight() {
		return weight;
	}

	@Column(name = "changedirection")
	public Long getChangedirection() {
		return changedirection;
	}

	
	public void setShareweightid(Long shareweightid) {
		this.shareweightid = shareweightid;
	}


	public void setShareid(Long shareid) {
		this.shareid = shareid;
	}

	public void setOthershareid(Long othershareid) {
		this.othershareid = othershareid;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public void setChangedirection(Long changedirection) {
		this.changedirection = changedirection;
	}

}
