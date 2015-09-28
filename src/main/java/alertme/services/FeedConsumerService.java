package alertme.services;

import org.openspaces.core.GigaSpace;

public class FeedConsumerService {

	private GigaSpace space;

	public FeedConsumerService(GigaSpace space) {
		this.space = space;
	}

	public GigaSpace getSpace() {
		return space;
	}

}
