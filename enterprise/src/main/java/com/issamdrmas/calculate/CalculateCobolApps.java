package com.issamdrmas.calculate;

import com.issamdrmas.enums.Language;
import com.issamdrmas.model.Application;
import com.issamdrmas.model.Enterprise;
import com.issamdrmas.model.User;
import com.issamdrmas.visitor.Visitor;

public class CalculateCobolApps implements Visitor {
	
	private int Value = 0;

	@Override
	public int visit(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int visit(Application application) {
		if (application.getLanguage() == Language.COBOL) {
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
