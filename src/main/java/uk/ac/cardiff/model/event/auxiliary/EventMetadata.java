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
package uk.ac.cardiff.model.event.auxiliary;

import javax.persistence.Embeddable;

import uk.ac.cardiff.model.event.Event;

/**
 * <p>
 * Metadata about the {@link Event} message. Relates to the Raptor service that
 * harvested the event and the organisation that belongs to.
 * </p>
 *
 */
@Embeddable
public class EventMetadata {

	/**
	 * The entityId of the Raptor service the associated
	 * {@link uk.ac.cardiff.model.event.Event} applies to.
	 */
	private String raptorEntityId;

	/**
	 * The hostname of the service the {@link uk.ac.cardiff.model.event.Event}
	 * belongs to.
	 */
	private String serviceName;

	/**
	 * The name of the organisation that generated the associated
	 * {@link uk.ac.cardiff.model.event.Event}.
	 */
	private String organisationName;

	/**
	 * 
	 * 
	 * /**
	 * 
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(final String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param organisationName
	 *            the organisationName to set
	 */
	public void setOrganisationName(final String organisationName) {
		this.organisationName = organisationName;
	}

	/**
	 * @return the organisationName
	 */
	public String getOrganisationName() {
		return organisationName;
	}

	@Override
	public String toString() {
		return "EventMetadata [entityId=" + raptorEntityId + ", serviceName=" + serviceName + ", organisationName="
				+ organisationName + "]";
	}

	/**
	 * @return the raptorEntityId
	 */
	public String getRaptorEntityId() {
		return raptorEntityId;
	}

	/**
	 * @param raptorEntityId
	 *            the raptorEntityId to set
	 */
	public void setRaptorEntityId(final String raptorEntityId) {
		this.raptorEntityId = raptorEntityId;
	}

}
