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
class PackageList {

	private ArrayList<Package> packageList;

	public PackageList() {
		packageList = new ArrayList<>();
	}

	/**
	 * @return the packageList
	 */
	public ArrayList<Package> getPackageList() {
		return packageList;
	}

	/**
	 * @param packageList the packageList to set
	 */
	public void setPackageList(ArrayList<Package> packageList) {
		this.packageList = packageList;
	}

	public void addPackage(Package p) {
		packageList.add(p);
	}

	public int packageListSize() {
		return packageList.size();
	}
	public Package getPackage(int i)
	{
		return packageList.get(i);
	}
}
