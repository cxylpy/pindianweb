package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.AddressDao;
import com.pindian.lonphy.domain.Address;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class AddressService implements Service{
	private AddressDao aDao = BaseFactory.getInstance(AddressDao.class);
	public Address findAddressById(Integer id) {
		return aDao.findById(Address.class, id);
	}
	public List<Address> findUserAddresses(String userid) {
		return aDao.findByCondition(Address.class, " uid = '"+userid+"'");
	}
	public void add(Address address) {
		aDao.saveNewEntity(address);
	}
	public void update(Address address) {
		aDao.update(Address.class, address.getId(), address);
	}
	public void delete(Address address) {
		aDao.delete(Address.class,address.getId());
	}
}
