package com.issamdrmas.visitor;

import com.issamdrmas.model.Application;
import com.issamdrmas.model.Enterprise;
import com.issamdrmas.model.User;

public interface Visitor {
	int visit(Enterprise enterprise);
	int visit(Application application);
	int visit(User user);

}
