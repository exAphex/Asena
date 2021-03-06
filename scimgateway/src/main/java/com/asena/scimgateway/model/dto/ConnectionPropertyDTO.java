package com.asena.scimgateway.model.dto;

import com.asena.scimgateway.model.ConnectionProperty;
import com.asena.scimgateway.model.ConnectionProperty.ConnectionPropertyType;

public class ConnectionPropertyDTO {
    private long id;
    private String key;
    private String value;
    private String description;
    private boolean encrypted;
    private ConnectionPropertyType type;

    public static ConnectionPropertyDTO toDTO(ConnectionProperty cp) {
        ConnectionPropertyDTO cpDTO = new ConnectionPropertyDTO();

        if (cp == null) {
            return null;
        }
        
        cpDTO.setId(cp.getId());
        cpDTO.setKey(cp.getKey());
        cpDTO.setValue(cp.getValue());
        cpDTO.setDescription(cp.getDescription());
        cpDTO.setEncrypted(cp.isEncrypted());
        cpDTO.setType(cp.getType());
        return cpDTO;
    }

    public ConnectionProperty fromDTO() {
        ConnectionProperty cp = new ConnectionProperty();
        cp.setId(getId());
        cp.setKey(getKey());
        cp.setValue(getValue());
        cp.setDescription(getDescription());
        cp.setEncrypted(isEncrypted());
        cp.setType(getType());
        return cp;
    }

    public long getId() {
        return id;
    }

    public ConnectionPropertyType getType() {
        return type;
    }

    public void setType(ConnectionPropertyType type) {
        this.type = type;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean isEncrypted) {
        this.encrypted = isEncrypted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}