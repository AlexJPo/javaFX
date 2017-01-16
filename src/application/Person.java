package application;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	private SimpleStringProperty fio;
	private SimpleStringProperty phone;
	
	public Person(String fio, String phone) {
		this.fio = new SimpleStringProperty(fio);
		this.phone = new SimpleStringProperty(phone);
	}
	
	public String getFio() { return this.fio.get(); }
	public void setFio(String fio) { this.fio.set(fio); }
	
	public String getPhone() { return this.phone.get(); }
	public void setPhone(String phone) { this.phone.set(phone); }
	
	public SimpleStringProperty getFioProperty() { return this.fio; }
	public SimpleStringProperty getPhoneProperty() { return this.phone; }
	
	@Override
	public String toString() {
		return "Person: FIO = " + this.fio + ", Pnone number = " + this.phone;
	}
}
