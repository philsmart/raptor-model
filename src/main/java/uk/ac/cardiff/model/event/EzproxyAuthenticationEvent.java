/**
 * Copyright (C) 2010 Cardiff University, Wales <smartp@cf.ac.uk>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 */
package uk.ac.cardiff.model.event;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

import uk.ac.cardiff.utility.EqualsUtil;
import uk.ac.cardiff.utility.HashCodeUtil;
import uk.ac.cardiff.utility.StringUtils;

/**
 * The Class EzproxyAuthenticationEvent.
 * 
 * @author philsmart
 */
@Entity
@Table(name = "EzproxyAuthEvent")
@DiscriminatorColumn(length = 100)
public class EzproxyAuthenticationEvent extends AuthenticationEvent {

	/** The requester ip. */
	private String requesterIp;

	/**
	 * Instantiates a new ezproxy authentication event.
	 */
	public EzproxyAuthenticationEvent() {
		super();
	}

	/**
	 * Instantiates a new ezproxy authentication event.
	 * 
	 * @param event
	 *            the event
	 */
	protected EzproxyAuthenticationEvent(final EzproxyAuthenticationEvent event) {
		super(event);
		this.requesterIp = event.getRequesterIp();
	}

	/**
	 * Copy method. Alternative to clone.
	 * 
	 * @return the ezproxy authentication event
	 */
	public EzproxyAuthenticationEvent copy() {
		return new EzproxyAuthenticationEvent(this);
	}

	/**
	 * Sets the requester ip.
	 * 
	 * @param requesterIp
	 *            the new requester ip
	 */
	public void setRequesterIp(final String requesterIp) {
		this.requesterIp = requesterIp;
	}

	/**
	 * Gets the requester ip.
	 * 
	 * @return the requester ip
	 */
	public String getRequesterIp() {
		return requesterIp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uk.ac.cardiff.model.event.Event#toString()
	 */
	@Override
	public String toString() {
		return StringUtils.buildToString(this);
	}

	/**
	 * create a unique hash, with as uniform a distribution as possible.
	 * 
	 * @return the int
	 */
	@Override
	public int hashCode() {
		int hash = HashCodeUtil.SEED;

		hash = HashCodeUtil.hash(hash, getEventTimeMillis());
		hash = HashCodeUtil.hash(hash, getEventId());
		hash = HashCodeUtil.hash(hash, getAuthenticationType());
		hash = HashCodeUtil.hash(hash, getServiceHost());
		hash = HashCodeUtil.hash(hash, getRequesterIp());
		hash = HashCodeUtil.hash(hash, getResourceHost());
		hash = HashCodeUtil.hash(hash, getPrincipalName());
		hash = HashCodeUtil.hash(hash, getEventType());
		hash = HashCodeUtil.hash(hash, getServiceId());
		hash = HashCodeUtil.hash(hash, getResourceId());

		return hash;

	}

	/**
	 * For hibernate, so the hashcode can be persisted.
	 * 
	 * @return the hash code
	 */
	public int getHashCode() {
		return hashCode();
	}

	/**
	 * For hibernate, does nothing as the hascode is computed on the fly from
	 * the <code>hashCode</code> method.
	 * 
	 * @param hashCode
	 *            the new hash code
	 */
	public void setHashCode(final int hashCode) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		final EzproxyAuthenticationEvent that = (EzproxyAuthenticationEvent) obj;
		final boolean areEqual = EqualsUtil.areEqual(this.getEventTimeMillis(), that.getEventTimeMillis())
				&& EqualsUtil.areEqual(this.getEventId(), that.getEventId())
				&& EqualsUtil.areEqual(this.getAuthenticationType(), that.getAuthenticationType())
				&& EqualsUtil.areEqual(this.getServiceHost(), that.getServiceHost())
				&& EqualsUtil.areEqual(this.getRequesterIp(), that.getRequesterIp())
				&& EqualsUtil.areEqual(this.getResourceHost(), that.getResourceHost())
				&& EqualsUtil.areEqual(this.getServiceId(), that.getServiceId())
				&& EqualsUtil.areEqual(this.getEventType(), that.getEventType())
				&& EqualsUtil.areEqual(this.getResourceId(), that.getResourceId())
				&& EqualsUtil.areEqual(this.getPrincipalName(), that.getPrincipalName());

		return areEqual;
	}

}
