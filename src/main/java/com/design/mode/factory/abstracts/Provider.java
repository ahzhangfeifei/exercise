package com.design.mode.factory.abstracts;

import com.design.mode.factory.common.ISender;

/**
 * The interface Provider.
 */
public interface Provider {

	/**
	 * Produce sender.
	 *
	 * @return the sender
	 */
	public ISender produce();
	
}
