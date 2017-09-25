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

import java.util.Arrays;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

import uk.ac.cardiff.utility.EqualsUtil;
import uk.ac.cardiff.utility.HashCodeUtil;
import uk.ac.cardiff.utility.StringUtils;

/**
 * The Class ShibbolethIdpAuthenticationEvent.
 * 
 * @author philsmart
 */

@Entity
@Table(name = "ShibIdpAuthEvent")
@DiscriminatorColumn(length = 100)
public class ShibbolethIdpAuthenticationEvent extends AuthenticationEvent {

	/** The request id. */
	private String requestId;

	/** The response binding. */
	private String responseBinding;

	/** The request binding. */
	private String requestBinding;

	/** The released attributes. */
	private String[] attributes;

	/**
	 * Instantiates a new shibboleth idp authentication event.
	 */
	public ShibbolethIdpAuthenticationEvent() {
		super();
	}

	/**
	 * New instance.
	 * 
	 * @return the shibboleth idp authentication event
	 */
	public static ShibbolethIdpAuthenticationEvent newInstance() {
		return new ShibbolethIdpAuthenticationEvent();
	}

	/**
	 * Copy constructor.
	 * 
	 * @param event
	 *            the event to copy
	 */
	protected ShibbolethIdpAuthenticationEvent(final ShibbolethIdpAuthenticationEvent event) {
		super(event);
		this.requestId = event.getRequestId();

		this.responseBinding = event.getResponseBinding();

		this.requestBinding = event.getRequestBinding();

		// shallow copy is OK here, as a new array is created with immutable
		// objects (String).
		this.attributes = event.getAttributes().clone();
	}

	/**
	 * Copy method. Alternative to clone. Returns a copied version of this
	 * event.
	 * 
	 * @return the shibboleth idp authentication event
	 */
	public ShibbolethIdpAuthenticationEvent copy() {
		return new ShibbolethIdpAuthenticationEvent(this);
	}

	/**
	 * Sets the response binding.
	 * 
	 * @param responseBinding
	 *            the new response binding
	 */
	public void setResponseBinding(final String responseBinding) {
		this.responseBinding = responseBinding;
	}

	/**
	 * Gets the response binding.
	 * 
	 * @return the response binding
	 */
	public String getResponseBinding() {
		return responseBinding;
	}

	/**
	 * Sets the request binding.
	 * 
	 * @param requestBinding
	 *            the new request binding
	 */
	public void setRequestBinding(final String requestBinding) {
		this.requestBinding = requestBinding;
	}

	/**
	 * Gets the request binding.
	 * 
	 * @return the request binding
	 */
	public String getRequestBinding() {
		return requestBinding;
	}

	/**
	 * Sets the released attributes.
	 * 
	 * @param releasedAttributes
	 *            the releasedAttributes to set
	 */
	public void setAttributes(final String[] releasedAttributes) {
		this.attributes = releasedAttributes;
	}

	/**
	 * Gets the released attributes.
	 * 
	 * @return the releasedAttributes
	 */
	public String[] getAttributes() {
		return attributes;
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
		final ShibbolethIdpAuthenticationEvent that = (ShibbolethIdpAuthenticationEvent) obj;
		final boolean areEqual = EqualsUtil.areEqual(this.getEventTimeMillis(), that.getEventTimeMillis())
				&& EqualsUtil.areEqual(this.getEventId(), that.getEventId())
				&& EqualsUtil.areEqual(this.getAuthenticationType(), that.getAuthenticationType())
				&& EqualsUtil.areEqual(this.getServiceHost(), that.getServiceHost())
				&& EqualsUtil.areEqual(this.getRequestId(), that.getRequestId())
				&& EqualsUtil.areEqual(this.getResponseBinding(), that.getResponseBinding())
				&& EqualsUtil.areEqual(this.getResourceHost(), that.getResourceHost())
				&& EqualsUtil.areEqual(this.getRequestBinding(), that.getRequestBinding())
				&& EqualsUtil.areEqual(this.getPrincipalName(), that.getPrincipalName())
				&& EqualsUtil.areEqual(this.getServiceId(), that.getServiceId())
				&& EqualsUtil.areEqual(this.getEventType(), that.getEventType())
				&& EqualsUtil.areEqual(this.getResourceId(), that.getResourceId())
				&& Arrays.equals(this.getAttributes(), that.getAttributes());

		return areEqual;
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

	/**
	 * create a unique hash, with as uniform a distribution as possible.
	 * 
	 * @return the int
	 */
	@Override
	public int hashCode() {
		int hash = HashCodeUtil.SEED;

		hash = HashCodeUtil.hash(hash, getEventTimeMillis());
		hash = HashCodeUtil.hash(hash, getAuthenticationType());
		hash = HashCodeUtil.hash(hash, getEventId());
		hash = HashCodeUtil.hash(hash, getServiceHost());
		hash = HashCodeUtil.hash(hash, getRequestId());
		hash = HashCodeUtil.hash(hash, getResponseBinding());
		hash = HashCodeUtil.hash(hash, getResourceHost());
		hash = HashCodeUtil.hash(hash, getAttributes());
		hash = HashCodeUtil.hash(hash, getRequestBinding());
		hash = HashCodeUtil.hash(hash, getPrincipalName());
		hash = HashCodeUtil.hash(hash, getEventType());
		hash = HashCodeUtil.hash(hash, getServiceId());
		hash = HashCodeUtil.hash(hash, getResourceId());
		return hash;

	}

	/**
	 * Sets the request id.
	 * 
	 * @param requestId
	 *            the new request id
	 */
	public void setRequestId(final String requestId) {
		this.requestId = requestId;
	}

	/**
	 * Gets the request id.
	 * 
	 * @return the request id
	 */
	public String getRequestId() {
		return requestId;
	}

}
