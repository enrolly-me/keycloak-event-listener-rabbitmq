package com.github.aznamier.keycloak.event.provider;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.keycloak.events.admin.AdminEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = Id.CLASS)
final class AdminEventData extends AdminEvent implements Serializable {
	public static AdminEventData create(AdminEvent adminEvent) {
		AdminEventData data = new AdminEventData();
		data.setId(adminEvent.getId());
		data.setAuthDetails(adminEvent.getAuthDetails());
		data.setError(adminEvent.getError());
		data.setOperationType(adminEvent.getOperationType());
		data.setRealmId(adminEvent.getRealmId());
		data.setRepresentation(adminEvent.getRepresentation());
		data.setResourcePath(adminEvent.getResourcePath());
		data.setResourceType(adminEvent.getResourceType());
		data.setResourceTypeAsString(adminEvent.getResourceTypeAsString());
		data.setTime(adminEvent.getTime());
		return data;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@JsonTypeInfo(use = Id.CLASS)
public class EventAdminNotificationMqMsg implements Serializable  {
	private static final long serialVersionUID = -7367949289101799624L;

	private String pattern;

	private AdminEventData data;

	/**
	 * Returns the pattern of the event.
	 *
	 * @return
	 */
	public String getPattern() {
			return pattern;
	}

	public void setPattern(String pattern) {
			this.pattern = pattern;
	}

	/**
	 * Returns the data of the event.
	 *
	 * @return
	 */
	public AdminEventData getData() {
			return data;
	}

	public void setData(AdminEventData data) {
			this.data = data;
	}

	public static EventAdminNotificationMqMsg create(AdminEvent adminEvent) {
		EventAdminNotificationMqMsg msg = new EventAdminNotificationMqMsg();

		msg.setData(AdminEventData.create(adminEvent));

		return msg;
	}


}
