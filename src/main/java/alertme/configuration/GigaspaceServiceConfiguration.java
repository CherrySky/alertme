package alertme.configuration;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.openspaces.core.transaction.manager.DistributedJiniTxManagerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class GigaspaceServiceConfiguration {

	private static final String LOCAL_SPACE_URL = "/./alertmeZone1Space1?cluster_schema=partitioned-sync2backup&total_members=1,1&id=1";

	@Bean
	public GigaSpace space() throws Exception {
		UrlSpaceConfigurer spaceConfigurer = new UrlSpaceConfigurer(LOCAL_SPACE_URL);
		PlatformTransactionManager ptm = new DistributedJiniTxManagerConfigurer().transactionManager();
		GigaSpace space = new GigaSpaceConfigurer(spaceConfigurer).transactionManager(ptm).gigaSpace();
		System.out.println("space hash: " + space.hashCode());
		return space;
	}

}
