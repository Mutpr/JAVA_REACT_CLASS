package week2_0405_contactMVC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactManager {
	private Contact[] contactList = new Contact[100];
	private int index = 0;

	public ContactManager() {
		super();
	}

	public void addContactList(Contact contact) {
		this.contactList[index++] = contact;
	}

	public Contact[] getContactList() {
		return contactList;
	}

	public Contact getContactListAsIndex(int index) {
		return contactList[index];
	}

	public Contact[] deleteContactList(int index) {
		Contact[] contactList = getContactList();
		List<Contact> newContactList = new ArrayList<>(Arrays.asList(contactList));
		newContactList.remove(index);
		contactList = newContactList.toArray(new Contact[0]);
		for (int i = 0; i < contactList.length; i++) {
			System.out.println(contactList[i]);
		}
		return contactList;
	}

	public Contact[] deleteContactListAsArray(int index, id) {
		Contact[] contactList = getContactList();
		Contact[] newContactList1 = Arrays.copyOfRange(contactList, 0, index);
		Contact[] newContactList2 = Arrays.copyOfRange(contactList, index, contactList.length);
		Contact[] newContactList = new Contact[(newContactList1.length) + (newContactList2.length)];
		System.arraycopy(newContactList1, 0, newContactList, 0, newContactList1.length);
		System.arraycopy(newContactList2, 0, newContactList, newContactList1.length, newContactList2.length);
		for (int i = 0; i < newContactList.length; i++) {
			System.out.println(newContactList[i]);
		}
		return newContactList;
	}

	public int returnIndex() {
		return index;
	}
	
	public void updateContactList(Contact contact) {
		this.contactList[index] = contact;
	}
}
