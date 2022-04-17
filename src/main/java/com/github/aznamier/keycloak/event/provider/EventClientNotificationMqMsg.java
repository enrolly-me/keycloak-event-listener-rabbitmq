package com.github.aznamier.keycloak.event.provider;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.keycloak.events.Event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = Id.CLASS)
final class EventData extends Event implements Serializable {
	public static EventData create(Event event) {
		EventData data = new EventData();
		data.setClientId(event.getClientId());
		data.setDetails(event.getDetails());
		data.setError(event.getError());
		data.setIpAddress(event.getIpAddress());
		data.setRealmId(event.getRealmId());
		data.setSessionId(event.getSessionId());
		data.setTime(event.getTime());
		data.setType(event.getType());
		data.setUserId(event.getUserId());
		return data;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@JsonTypeInfo(use = Id.CLASS)
public class EventClientNotificationMqMsg implements Serializable {
	private static final long serialVersionUID = -2192461924304841222L;

	private String pattern;

	private EventData data;

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
	public EventData getData() {
			return data;
	}

	public void setData(EventData data) {
			this.data = data;
	}

	public static EventClientNotificationMqMsg create(Event event) {
		EventClientNotificationMqMsg msg = new EventClientNotificationMqMsg();

		msg.setData(EventData.create(event));

		return msg;
	}


}
