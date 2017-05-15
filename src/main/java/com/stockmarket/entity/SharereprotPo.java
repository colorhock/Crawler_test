package com.stockmarket.entity;
// Generated 2017-5-10 17:05:43 by Hibernate Tools 4.3.1.Final

import java.util.Date;

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
@Table(name = "t_sharereprot")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SharereprotPo extends BasePersistentObject {

	private Long sharereprotid;
	private Long shareid;
	private String sharecode;
	private String sharename;
	private Double todaybeginprice;
	private Double yesterdaycloseprice;
	private Double nowprice;
	private Double highprice;
	private Double lowprice;
	private Double buyprice;
	private Double saleprice;
	private Integer dealnum;
	private Double dealmoney;
	private Double buyone1;
	private Double buyone2;
	private Double buytwo1;
	private Double buytwo2;
	private Double buythree1;
	private Double buythree2;
	private Double buyfour1;
	private Double buyfour2;
	private Double buyfive1;
	private Double buyfive2;
	private Date thedate;
	private String thetime;

	public SharereprotPo() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sharereprotid", nullable = false)
	public Long getSharereprotid() {
		return sharereprotid;
	}

	@Column(name = "shareid")
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
	@Column(name = "buyprice")
	public Double getBuyprice() {
		return buyprice;
	}
	@Column(name = "saleprice")
	public Double getSaleprice() {
		return saleprice;
	}
	@Column(name = "dealnum")
	public Integer getDealnum() {
		return dealnum;
	}
	@Column(name = "dealmoney")
	public Double getDealmoney() {
		return dealmoney;
	}
	@Column(name = "buyone1")
	public Double getBuyone1() {
		return buyone1;
	}
	@Column(name = "buyone2")
	public Double getBuyone2() {
		return buyone2;
	}
	@Column(name = "buytwo1")
	public Double getBuytwo1() {
		return buytwo1;
	}
	@Column(name = "buytwo2")
	public Double getBuytwo2() {
		return buytwo2;
	}
	@Column(name = "buythree1")
	public Double getBuythree1() {
		return buythree1;
	}
	@Column(name = "buythree2")
	public Double getBuythree2() {
		return buythree2;
	}
	@Column(name = "buyfour1")
	public Double getBuyfour1() {
		return buyfour1;
	}
	@Column(name = "buyfour2")
	public Double getBuyfour2() {
		return buyfour2;
	}
	@Column(name = "buyfive1")
	public Double getBuyfive1() {
		return buyfive1;
	}
	@Column(name = "buyfive2")
	public Double getBuyfive2() {
		return buyfive2;
	}
	@Column(name = "thedate")
	public Date getThedate() {
		return thedate;
	}
	@Column(name = "thetime")
	public String getThetime() {
		return thetime;
	}

	public void setSharereprotid(Long sharereprotid) {
		this.sharereprotid = sharereprotid;
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

	public void setBuyprice(Double buyprice) {
		this.buyprice = buyprice;
	}

	public void setSaleprice(Double saleprice) {
		this.saleprice = saleprice;
	}

	public void setDealnum(Integer dealnum) {
		this.dealnum = dealnum;
	}

	public void setDealmoney(Double dealmoney) {
		this.dealmoney = dealmoney;
	}

	public void setBuyone1(Double buyone1) {
		this.buyone1 = buyone1;
	}

	public void setBuyone2(Double buyone2) {
		this.buyone2 = buyone2;
	}

	public void setBuytwo1(Double buytwo1) {
		this.buytwo1 = buytwo1;
	}

	public void setBuytwo2(Double buytwo2) {
		this.buytwo2 = buytwo2;
	}

	public void setBuythree1(Double buythree1) {
		this.buythree1 = buythree1;
	}

	public void setBuythree2(Double buythree2) {
		this.buythree2 = buythree2;
	}

	public void setBuyfour1(Double buyfour1) {
		this.buyfour1 = buyfour1;
	}

	public void setBuyfour2(Double buyfour2) {
		this.buyfour2 = buyfour2;
	}

	public void setBuyfive1(Double buyfive1) {
		this.buyfive1 = buyfive1;
	}

	public void setBuyfive2(Double buyfive2) {
		this.buyfive2 = buyfive2;
	}

	public void setThedate(Date thedate) {
		this.thedate = thedate;
	}

	public void setThetime(String thetime) {
		this.thetime = thetime;
	}

}
