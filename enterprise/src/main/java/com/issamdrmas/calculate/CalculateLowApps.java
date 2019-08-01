package com.issamdrmas.calculate;

import com.issamdrmas.enums.Criticality;
import com.issamdrmas.model.Application;
import com.issamdrmas.model.Enterprise;
import com.issamdrmas.model.User;
import com.issamdrmas.visitor.Visitor;

public class CalculateLowApps implements Visitor {
	
	private int Value = 0;

	@Override
	public int visit(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int visit(Application application) {
		if (application.getCriticality() == Criticality.LOW) {
			Value++;
		}
		return Value;
	}

	@Override
	public int visit(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getValue() {
		return Value;
	}

}
