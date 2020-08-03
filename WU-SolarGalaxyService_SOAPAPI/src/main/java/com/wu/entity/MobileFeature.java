package com.wu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TBL_MOBILE_FEATURE")
public class MobileFeature{
    //for working with hibernate we must be need to take id for entity class always otherwise during data operation we face the issue.
	@Id
	@Column(name="FEATURE_ID")
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private Long featureId;
	@Column(name="RAM")
	private Long   ram;
	@Column(name="ROM")
	private Long   rom;
	@Column(name="EXTENDABLEROM")
	private Long   extendableRom;
	@Column(name="DISPLAYSIZE")
	private double displaySize;
	@Column(name="FRONTENDCAMERA")
	private int    frontEndCamera;
	@Column(name="BACKENDCAMERA")
	private int    backEndCamera;
	@Column(name="BATTARYPOWER")
	private Long   battaryPower;
	@Column(name="PROCESSOR")
	private String processor ;
	
	@OneToOne(targetEntity = Mobile.class,cascade = CascadeType.ALL,
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "unid",referencedColumnName = "product_mobile_id")
	private Mobile parent;
	
	public MobileFeature() {
		
	}

	public MobileFeature(Long featureId,Long ram, Long rom, Long extendableRom, double displaySize, int frontEndCamera,
			int backEndCamera, Long battaryPower, String processor,Mobile parent) {
		
		this.featureId = featureId;
		this.ram = ram;
		this.rom = rom;
		this.extendableRom = extendableRom;
		this.displaySize = displaySize;
		this.frontEndCamera = frontEndCamera;
		this.backEndCamera = backEndCamera;
		this.battaryPower = battaryPower;
		this.processor = processor;
		this.parent   = parent;
	}
	
	public Long getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}

	public Long getRam() {
		return ram;
	}

	public void setRam(Long ram) {
		this.ram = ram;
	}

	public Long getRom() {
		return rom;
	}

	public void setRom(Long rom) {
		this.rom = rom;
	}

	public Long getExtendableRom() {
		return extendableRom;
	}

	public void setExtendableRom(Long extendableRom) {
		this.extendableRom = extendableRom;
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}

	public int getFrontEndCamera() {
		return frontEndCamera;
	}

	public void setFrontEndCamera(int frontEndCamera) {
		this.frontEndCamera = frontEndCamera;
	}

	public int getBackEndCamera() {
		return backEndCamera;
	}

	public void setBackEndCamera(int backEndCamera) {
		this.backEndCamera = backEndCamera;
	}

	public Long getBattaryPower() {
		return battaryPower;
	}

	public void setBattaryPower(Long battaryPower) {
		this.battaryPower = battaryPower;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
	public Mobile getMobile() {
		return parent;
	}

	public void setMobile(Mobile mobile) {
		this.parent = mobile;
	}

	@Override
	public String toString() {
		return "MobileFeature [ram=" + ram + ", rom=" + rom + ", extendableRom=" + extendableRom + ", displaySize="
				+ displaySize + ", frontEndCamera=" + frontEndCamera + ", backEndCamera=" + backEndCamera
				+ ", battaryPower=" + battaryPower + ", processor=" + processor + "]";
	}
	
}
