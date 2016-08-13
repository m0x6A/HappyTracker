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
public class PackageEventList {

	private ArrayList<PackageEvent> packageEventList;

	public PackageEventList() {
		packageEventList = new ArrayList<PackageEvent>();
	}

	/**
	 * @return the packageEventList
	 */
	public ArrayList<PackageEvent> getPackageEventList() {
		return packageEventList;
	}

	/**
	 * @param packageEventList the packageEventList to set
	 */
	public void setPackageEventList(ArrayList<PackageEvent> packageEventList) {
		this.packageEventList = packageEventList;
	}

	public void addPackageEvent(PackageEvent p) {
		packageEventList.add(p);
	}

	public void removePackageEvent(int index) {
		packageEventList.remove(index);
	}

	public int packageEventListSize() {
		return packageEventList.size();
	}

	public PackageEvent getPackageEvent(int i) {
		return packageEventList.get(i);
	}

}
