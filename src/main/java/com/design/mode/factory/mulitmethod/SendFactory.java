package com.design.mode.factory.mulitmethod;

import com.design.mode.factory.common.ISender;
import com.design.mode.factory.common.MailSender;
import com.design.mode.factory.common.SmsSender;

/**
 * The type Send factory.
 */
public class SendFactory {

	/**
	 * Produce sms sender.
	 *
	 * @return the sender
	 */
	public ISender produceSMS(){
		return new SmsSender();
	}

	/**
	 * Produce email sender.
	 *
	 * @return the sender
	 */
	public ISender produceEmail(){
		return new MailSender();
	}

}
