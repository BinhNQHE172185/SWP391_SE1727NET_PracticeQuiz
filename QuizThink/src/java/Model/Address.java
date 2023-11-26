/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class Address {
    private int address_id;
    private String street_address;
    private int district_id;
    private int account_id;

    public Address() {
    }

    public Address(int address_id, String street_address, int district_id, int account_id) {
        this.address_id = address_id;
        this.street_address = street_address;
        this.district_id = district_id;
        this.account_id = account_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Address{" + "address_id=" + address_id + ", street_address=" + street_address + ", district_id=" + district_id + ", account_id=" + account_id + '}';
    }
    
    
}
