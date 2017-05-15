package com.stockmarket.entity;
// Generated 2017-5-10 17:05:43 by Hibernate Tools 4.3.1.Final

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
@Table(name = "t_share")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SharePo extends BasePersistentObject {

	private Long shareid;
	private String companyname;
	private String companyshort;
	private String sharecode;
	private String sharename;
	private Double todaybeginprice;
	private Double yesterdaycloseprice;
	private Double nowprice;
	private Double highprice;
	private Double lowprice;

	public SharePo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shareid", nullable = false)
	public Long getShareid() {
		return shareid;
	}

	@Column(name = "sharecode")
	public String getSharecode() {
		return sharecode;
	}

	@Column(name = "sharename")
	public String getSharename() {
		return sharename;
	}

	@Column(name = "todaybeginprice")
	public Double getTodaybeginprice() {
		return todaybeginprice;
	}

	@Column(name = "yesterdaycloseprice")
	public Double getYesterdaycloseprice() {
		return yesterdaycloseprice;
	}

	@Column(name = "nowprice")
	public Double getNowprice() {
		return nowprice;
	}

	@Column(name = "highprice")
	public Double getHighprice() {
		return highprice;
	}

	@Column(name = "lowprice")
	public Double getLowprice() {
		return lowprice;
	}

	@Column(name = "companyname")
	public String getCompanyname() {
		return companyname;
	}

	@Column(name = "companyshort")
	public String getCompanyshort() {
		return companyshort;
	}

	public void setShareid(Long shareid) {
		this.shareid = shareid;
	}

	public void setSharecode(String sharecode) {
		this.sharecode = sharecode;
	}

	public void setSharename(String sharename) {
		this.sharename = sharename;
	}

	public void setTodaybeginprice(Double todaybeginprice) {
		this.todaybeginprice = todaybeginprice;
	}

	public void setYesterdaycloseprice(Double yesterdaycloseprice) {
		this.yesterdaycloseprice = yesterdaycloseprice;
	}

	public void setNowprice(Double nowprice) {
		this.nowprice = nowprice;
	}

	public void setHighprice(Double highprice) {
		this.highprice = highprice;
	}

	public void setLowprice(Double lowprice) {
		this.lowprice = lowprice;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public void setCompanyshort(String companyshort) {
		this.companyshort = companyshort;
	}

}
