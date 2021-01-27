package com.asena.scimgateway.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "remotesystems")
public class RemoteSystem {

    @Id
    private String id;

    @Column(unique = true)
    @NotBlank(message = "System name is mandatory")
    private String name;
    private String description;
    private boolean active;

    @Transient
    private Set<Attribute> attributes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attribute> writeMappings;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attribute> readMappings;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ConnectionProperty> properties;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceuser_id", referencedColumnName = "id")
    private User serviceUser;

    @NotBlank(message = "System type is mandatory")
    private String type;

    public RemoteSystem() {
    }

    public Set<Attribute> getReadMappings() {
        return readMappings;
    }

    public void setReadMappings(Set<Attribute> readMappings) {
        this.readMappings = readMappings;
    }

    public User getServiceUser() {
        return serviceUser;
    }

    public void setServiceUser(User serviceUser) {
        this.serviceUser = serviceUser;
    }

    public Set<Attribute> getWriteMappings() {
        return writeMappings;
    }

    public void setWriteMappings(Set<Attribute> writeMappings) {
        this.writeMappings = writeMappings;
    }

    public RemoteSystem addProperty(ConnectionProperty cp) {
        if (this.properties == null) {
            this.properties = new HashSet<>();
        }

        if (cp != null) {
            properties.add(cp);
        }
        return this;
    }

    public RemoteSystem addAttribute(Attribute a) {
        if (this.attributes == null) {
            this.attributes = new HashSet<>();
        }

        if (a != null) {
            attributes.add(a);
        }
        return this;
    }

    public RemoteSystem addWriteMapping(Attribute a) {
        if (this.writeMappings == null) {
            this.writeMappings = new HashSet<>();
        }

        if ((a != null) && (!isWriteMappingDuplicate(a))){
            writeMappings.add(a);
        }
        return this;
    }

    public RemoteSystem addReadMapping(Attribute a) {
        if (this.readMappings == null) {
            this.readMappings = new HashSet<>();
        }

        if ((a != null) && (!isReadMappingDuplicate(a))){
            readMappings.add(a);
        }
        return this;
    }

    private boolean isWriteMappingDuplicate(Attribute attr) {
        if ((attr == null) || (attr.getDestination() == null)) {
            return false;
        }

        if (this.writeMappings == null) {
            return false;
        }

        for (Attribute a : this.writeMappings) {
            if (attr.getDestination().equals(a.getDestination())) {
                return true;
            }
        }

        return false;
    }

    private boolean isReadMappingDuplicate(Attribute attr) {
        if ((attr == null) || (attr.getDestination() == null)) {
            return false;
        }

        if (this.readMappings == null) {
            return false;
        }

        for (Attribute a : this.readMappings) {
            if (attr.getDestination().equals(a.getDestination())) {
                return true;
            }
        }

        return false;
    }

    public void deleteWriteMapping(Attribute a) {
        writeMappings.remove(a);
    }

    public void deleteReadMapping(Attribute a) {
        readMappings.remove(a);
    }

    public void deleteProperty(ConnectionProperty cp) {
        properties.remove(cp);
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<ConnectionProperty> getProperties() {
        return properties;
    }

    public void setProperties(Set<ConnectionProperty> properties) {
        this.properties = properties;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}