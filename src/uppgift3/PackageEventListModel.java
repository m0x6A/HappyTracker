/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift3;

import javax.swing.AbstractListModel;

/**
 *
 * @author xdr
 */
public class PackageEventListModel extends AbstractListModel {

	private PackageEventList packageEventList;

	@Override
	public int getSize() {
		return packageEventList.packageEventListSize();
	}

	@Override
	public Object getElementAt(int i) {
		PackageEvent p = packageEventList.getPackageEvent(i);
		String eventString = p.getDate() + "\n " + p.getDescription();
		return eventString;
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
		this.fireContentsChanged(this, 0, packageEventList.packageEventListSize() - 1);
	}

}
