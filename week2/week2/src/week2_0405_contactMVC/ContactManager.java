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

	public Contact[] deleteContactListAsArray(int index) {
	    Contact[] contactList = getContactList();
	    
	    // 삭제할 요소 이전의 요소들을 포함하는 새로운 배열 생성
	    Contact[] newContactList1 = Arrays.copyOfRange(contactList, 0, index);
	    // 삭제할 요소 이후의 요소들을 포함하는 새로운 배열 생성
	    Contact[] newContactList2 = Arrays.copyOfRange(contactList, index + 1, contactList.length);
	    
	    // 새로운 배열의 크기는 기존 배열보다 1 작아짐
	    Contact[] newContactList = new Contact[newContactList1.length + newContactList2.length];
	    
	    // 삭제된 요소 이전의 요소들을 새로운 배열에 복사
	    System.arraycopy(newContactList1, 0, newContactList, 0, newContactList1.length);
	    // 삭제된 요소 이후의 요소들을 새로운 배열에 복사
	    System.arraycopy(newContactList2, 0, newContactList, newContactList1.length, newContactList2.length);
	    
	    return newContactList;
	}

	public int returnIndex() {
		return index;
	}

	public Contact updateContactList(int index, String updatedName, String updatedContact) {
		contactList[index] = new Contact(index, updatedName, updatedContact);
		return contactList[index];
	}
}
