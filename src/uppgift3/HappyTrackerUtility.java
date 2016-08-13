/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author xdr
 */
public class HappyTrackerUtility {

	public static PackageList getPackageInfo(int trackingNr) {
		PackageList myPackageList = new PackageList();

		URL url = null;
		try {
			url = new URL("http://www8.informatik.umu.se/ParcelTrack/parceltrack?id=" + trackingNr);
		} catch (MalformedURLException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document doc = null;
		try {
			doc = dbf.newDocumentBuilder().parse(url.openStream());
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		}

		NodeList packageList = doc.getElementsByTagName("parcel");

		for (int i = 0; i < packageList.getLength(); i++) {
			Package p = new Package();
			myPackageList.addPackage(p);

			Element packageElement = (Element) packageList.item(i);

			NodeList idList = packageElement.getElementsByTagName("id");
			String idStr = idList.item(0).getFirstChild().getNodeValue();
			int id = Integer.parseInt(idStr);
			p.setId(id);

			NodeList senderList = packageElement.getElementsByTagName("sender");
			String sender = senderList.item(0).getFirstChild().getNodeValue();
			p.setSender(sender);

			NodeList receiverList = packageElement.getElementsByTagName("receiver");
			String receiver = receiverList.item(0).getFirstChild().getNodeValue();
			p.setReceiver(receiver);

			NodeList weightList = packageElement.getElementsByTagName("weight");
			String weightStr = weightList.item(0).getFirstChild().getNodeValue();
			int weight = Integer.parseInt(weightStr);
			p.setWeight(weight);

			NodeList packageEventsList = packageElement.getElementsByTagName("events");

			for (int j = 0; packageEventsList.getLength() > j; j++) {
				Element packageEventsElement = (Element) packageEventsList.item(j);
				NodeList packageEventList = packageEventsElement.getElementsByTagName("event");
				PackageEventList pel = new PackageEventList();
				for (int k = 0; packageEventList.getLength() > k; k++) {
					PackageEvent pe = new PackageEvent();
					Element packageEventElement = (Element) packageEventList.item(k);
					ArrayList<String> packageEventArrayList = new ArrayList();
					NodeList packageEventDescriptionList = packageEventElement.getElementsByTagName("description");
					String description = packageEventDescriptionList.item(0).getFirstChild().getNodeValue();
					pe.setDescription(description);
					NodeList packageEventDateList = packageEventElement.getElementsByTagName("date");
					String date = packageEventDateList.item(0).getFirstChild().getNodeValue();
					pe.setDate(date);
					pel.addPackageEvent(pe);
					p.setPackageEventList(pel);

				}
			}

		}
		return myPackageList;
	}

	public static int getPackageResponseCode(int trackingNr) {
		PackageList myPackageList = new PackageList();

		URL url = null;
		try {
			url = new URL("http://www8.informatik.umu.se/ParcelTrack/parceltrack?id=" + trackingNr);
		} catch (MalformedURLException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document doc = null;
		try {
			doc = dbf.newDocumentBuilder().parse(url.openStream());
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(HappyTrackerUtility.class.getName()).log(Level.SEVERE, null, ex);
		}

		NodeList packageList = doc.getElementsByTagName("parcel");
		int responseCode = -1;
		for (int i = 0; i < packageList.getLength(); i++) {

			Element packageElement = (Element) packageList.item(i);

			NodeList responseCodeList = packageElement.getElementsByTagName("responsecode");

			String responseCodeStr = responseCodeList.item(0).getFirstChild().getNodeValue();
			responseCode = Integer.parseInt(responseCodeStr);

		}
		return responseCode;
	}

	public static Package getPackage(int packageId) {
		PackageList myPackageList = getPackageInfo(packageId);
		for (int i = 0; myPackageList.packageListSize() > i; i++) {
			if (myPackageList.getPackage(i).getId() == packageId) {
				return myPackageList.getPackage(i);
			}
		}
		return null;
	}

}
