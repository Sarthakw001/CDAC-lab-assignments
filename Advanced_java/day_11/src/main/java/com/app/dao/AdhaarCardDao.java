package com.app.dao;

import com.app.pojos.AdhaarCard;

public interface AdhaarCardDao {
	String assignEmpAdhaarCard(Long empId, AdhaarCard card);
}
