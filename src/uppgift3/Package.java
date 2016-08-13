/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift3;

import java.util.ArrayList;

/**
 *
 * @author xdr
 */
public class Package {

	private int id;
	private String sender;
	private String receiver;
	private int weight;
	private PackageEventList packageEventList;

	/**
	 * @return the responseCode
	 */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the receiver
	 */
	public String getReciver() {
		return getReceiver();
	}

	/**
	 * @param reciver the receiver to set
	 */
	public void setReceiver(String reciver) {
		this.receiver = reciver;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the packageEvents
	 */
	@Override
	public String toString() {
		String packageString = "Sender: " + getSender() + "\n" + "Receiver: " + getReceiver() + "\n" + "Weight: " + getWeight() + " kg";
		return packageString;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @return the packageEventList
	 */
	public PackageEventList getPackageEventList() {
		return packageEventList;
	}

	/**
	 * @param packageEventList the packageEventList to set
	 */
	public void setPackageEventList(PackageEventList packageEventList) {
		this.packageEventList = packageEventList;
	}

	/**
	 * @param packageEventList the packageEventList to set
	 */
}
