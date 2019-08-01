package com.issamdrmas.config;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.issamdrmas.dao.EnterpriseRepository;
import com.issamdrmas.enums.Criticality;
import com.issamdrmas.enums.Language;
import com.issamdrmas.model.Application;
import com.issamdrmas.model.Enterprise;
import com.issamdrmas.model.User;

@Component
public class DBInit {
	@Autowired 
	private EnterpriseRepository enterpriseRepository;

	
	@PostConstruct
	@Transactional
	public void init() {
		
		User asmailUser = new User();
		asmailUser.setName("Asmail");
		
		User erikUser = new User();
		erikUser.setName("Erik");
		
		User jeaunelUser = new User();
		jeaunelUser.setName("Jeaune");
		
		User rachalUser = new User();
		rachalUser.setName("Rasha");
		
		    Application app1 = new Application( "App1", Criticality.LOW, Language.COBOL, asmailUser );
	        Application app2 = new Application( "App2", Criticality.LOW, Language.JAVA, asmailUser );
	        Application app3 = new Application( "App3", Criticality.MEDIUM, Language.PHP, erikUser );
	        Application app4 = new Application( "App4", Criticality.MEDIUM, Language.JAVA, jeaunelUser );
	        Application app5 = new Application( "App5", Criticality.LOW, Language.COBOL, asmailUser );
	        Application app6 = new Application( "App6", Criticality.MEDIUM, Language.COBOL, rachalUser );
	        Application app7 = new Application( "App7", Criticality.HIGH, Language.JAVA, erikUser );
	        Application app8 = new Application( "App8", Criticality.HIGH, Language.PHP, asmailUser );
	        Application app9 = new Application( "App9", Criticality.LOW, Language.COBOL, rachalUser );

	        Enterprise enterprise = new Enterprise();
	        enterprise.setName("BNP Enterprise ");
	        enterprise.addApplication(app1);
	        enterprise.addApplication(app2);
	        enterprise.addApplication(app3);
	        enterprise.addApplication(app4);
	        enterprise.addApplication(app5);
	        enterprise.addApplication(app6);
	        enterprise.addApplication(app7);
	        enterprise.addApplication(app8);
	        enterprise.addApplication(app9);
	        
	        enterpriseRepository.save(enterprise);
		
	}

}
