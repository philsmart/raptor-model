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
package uk.ac.cardiff.model.event.auxiliary;

import javax.persistence.Embeddable;

import uk.ac.cardiff.model.event.AuthenticationEvent;
import uk.ac.cardiff.model.event.Event;
import uk.ac.cardiff.utility.StringUtils;

/**
 * <p>
 * A {@link PrincipalInformation} instance can be attached to an
 * {@link AuthenticationEvent} during attribute expansion. This contains
 * additional information relating to the
 * {@link AuthenticationEvent#getPrincipalName()} of the event.
 * </p>
 * 
 * <p>
 * It is embedded in the same table as {@link Event} during persistence.
 * </p>
 *
 */
@Embeddable
public class PrincipalInformation {

	/** The name of the school or department this principal is a member of */
	private String school;

	/**
	 * The affiliation this principal has with their current school or department
	 */
	private String affiliation;

	/**
	 * Default constructor
	 * 
	 */
	public PrincipalInformation() {

	}

	/**
	 * Copy constructor
	 * 
	 * @param principalInformation
	 */
	public PrincipalInformation(final PrincipalInformation principalInformation) {
		this.school = principalInformation.getSchool();
		this.affiliation = principalInformation.getAffiliation();
	}

	/**
	 * @param school
	 *            the school to set
	 */
	public void setSchool(final String school) {
		this.school = school;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param affiliation
	 *            the affiliation to set
	 */
	public void setAffiliation(final String affiliation) {
		this.affiliation = affiliation;
	}

	/**
	 * @return the affiliation
	 */
	public String getAffiliation() {
		return affiliation;
	}

	@Override
	public String toString() {
		return StringUtils.buildToString(this);
	}

}
