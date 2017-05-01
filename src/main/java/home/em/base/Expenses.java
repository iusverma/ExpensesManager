package home.em.base;

public class Expenses {
	Integer id;
	Long date;
	String details;
	Double expenditure;
	String additionalDetails;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Double getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(Double expenditure) {
		this.expenditure = expenditure;
	}
	public String getAdditionalDetails() {
		return additionalDetails;
	}
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
}
