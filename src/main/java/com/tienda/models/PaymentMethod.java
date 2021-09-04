package com.tienda.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString), Root.class); */
@Entity
//@Table(name="TB_PAYMENTMETHOD")
public class PaymentMethod implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String payment_type_id;
	private String status;
	private String secure_thumbnail;
	private String thumbnail;
	private String deferred_capture;
	private List<Setting> settings;
	private List<String> additional_info_needed;
	private int min_allowed_amount;
	private int max_allowed_amount;
	private int accreditation_time;
	private List<Object> financial_institutions;
	private List<String> processing_modes;
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMethod other = (PaymentMethod) obj;
		return Objects.equals(id, other.id);
	}

	public static class CardNumber{
	    public String validation;
	    public int length;
	}

	public static class Bin{
	    public String pattern;
	    public String installments_pattern;
	    public Object exclusion_pattern;
	}

	public static class SecurityCode{
	    public int length;
	    public String card_location;
	    public String mode;
	}

	public static class Setting{
	    public CardNumber card_number;
	    public Bin bin;
	    public SecurityCode security_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayment_type_id() {
		return payment_type_id;
	}

	public void setPayment_type_id(String payment_type_id) {
		this.payment_type_id = payment_type_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecure_thumbnail() {
		return secure_thumbnail;
	}

	public void setSecure_thumbnail(String secure_thumbnail) {
		this.secure_thumbnail = secure_thumbnail;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDeferred_capture() {
		return deferred_capture;
	}

	public void setDeferred_capture(String deferred_capture) {
		this.deferred_capture = deferred_capture;
	}

	public List<Setting> getSettings() {
		return settings;
	}

	public void setSettings(List<Setting> settings) {
		this.settings = settings;
	}

	public List<String> getAdditional_info_needed() {
		return additional_info_needed;
	}

	public void setAdditional_info_needed(List<String> additional_info_needed) {
		this.additional_info_needed = additional_info_needed;
	}

	public int getMin_allowed_amount() {
		return min_allowed_amount;
	}

	public void setMin_allowed_amount(int min_allowed_amount) {
		this.min_allowed_amount = min_allowed_amount;
	}

	public int getMax_allowed_amount() {
		return max_allowed_amount;
	}

	public void setMax_allowed_amount(int max_allowed_amount) {
		this.max_allowed_amount = max_allowed_amount;
	}

	public int getAccreditation_time() {
		return accreditation_time;
	}

	public void setAccreditation_time(int accreditation_time) {
		this.accreditation_time = accreditation_time;
	}

	public List<Object> getFinancial_institutions() {
		return financial_institutions;
	}

	public void setFinancial_institutions(List<Object> financial_institutions) {
		this.financial_institutions = financial_institutions;
	}

	public List<String> getProcessing_modes() {
		return processing_modes;
	}

	public void setProcessing_modes(List<String> processing_modes) {
		this.processing_modes = processing_modes;
	}


	

}
