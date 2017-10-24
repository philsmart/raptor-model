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

package uk.ac.cardiff.model.event;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import uk.ac.cardiff.model.event.auxiliary.PrincipalInformation;

/**
 * <p>
 * Specialisation of an {@link Event}, that represents an authentication message
 * at an instant in time.
 * </p>
 * 
 * <p>
 * Can not be instantiated directly.
 * </p>
 * 
 * @author philsmart
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AuthenticationEvent extends Event {

	/** The authentication type. */
	private String authenticationType;

	/**
	 * The name of the identity that participated in this event. For example
	 * username.
	 */
	private String principalName;

	/**
	 * This is fixed to a principal expansion. Not used in Hash or Equality methods
	 */
	@Embedded
	private PrincipalInformation principalInformation;

	/**
	 * Instantiates a new authentication event.
	 */
	public AuthenticationEvent() {
		super();
	}

	/**
	 * Copy constructor.
	 *
	 * @param event
	 *            the event
	 */
	protected AuthenticationEvent(final AuthenticationEvent event) {
		super(event);
		this.authenticationType = event.getAuthenticationType();
		this.principalName = event.getPrincipalName();
		if (event.getPrincipalInformation() != null) {
			this.principalInformation = new PrincipalInformation(event.getPrincipalInformation());
		}

	}

	/**
	 * Sets the principal name.
	 *
	 * @param principal
	 *            the new principal name
	 */
	public void setPrincipalName(final String principal) {
		this.principalName = principal;
	}

	/**
	 * Gets the principal name.
	 *
	 * @return the principal name
	 */
	public String getPrincipalName() {
		return principalName;
	}

	/**
	 * Sets the authentication type.
	 *
	 * @param authenticationType
	 *            the new authentication type
	 */
	public void setAuthenticationType(final String authenticationType) {
		this.authenticationType = authenticationType;
	}

	/**
	 * Gets the authentication type.
	 *
	 * @return the authentication type
	 */
	public String getAuthenticationType() {
		return authenticationType;
	}

	/**
	 * Sets the principal information.
	 *
	 * @param principalInformation
	 *            the principalInformation to set
	 */
	public void setPrincipalInformation(final PrincipalInformation principalInformation) {
		this.principalInformation = principalInformation;
	}

	/**
	 * Gets the principal information.
	 *
	 * @return the principalInformation
	 */
	public PrincipalInformation getPrincipalInformation() {
		return principalInformation;
	}

}
